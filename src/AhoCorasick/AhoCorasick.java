package src.AhoCorasick;

import static java.util.Map.entry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import services.ErrorHandler.Handler;
import src.Trie.ITrieInsert;
import src.Trie.Trie;

public final class AhoCorasick<T> implements ITrieInsert<T> {
   private final Node<T> root;
   private boolean isLocked;

   public AhoCorasick() {
      this.root = new Node<>();
      this.root.parent = entry(' ', this.root);
      this.isLocked = false;
   }
   
   private static class Node<T> {
      private T value;
      private boolean hasComputedDictionary;
      private Entry<Character, Node<T>> parent;
      private Node<T> failureLink;
      private Node<T> dictionaryLink;
      private final HashMap<Character, Node<T>> children;
      private final HashMap<Character, Node<T>> transitions;

      private Node() {
         this.value = null;
         this.hasComputedDictionary = false;
         this.parent = null;
         this.failureLink = null;
         this.dictionaryLink = null;
         this.children = new HashMap<>();
         this.transitions = new HashMap<>();
      }

      private Node<T> setChild(Character token, Node<T> childNode) {
         this.children.put(token, childNode);
         childNode.parent = entry(token, this);
         return childNode;
      }
   }

   public static <T> AhoCorasick<T> clone(AhoCorasick<T> prevTrie) throws Exception {
      AhoCorasick<T> trie = new AhoCorasick<>();
      var entryQueue = new LinkedList<>(List.of(entry("", prevTrie.root)));

      while (entryQueue.size() > 0) {
         var currentEntry = entryQueue.removeFirst();
         String currentKey = currentEntry.getKey();
         Node<T> currentNode = currentEntry.getValue();

         currentNode.children.forEach((token, node) -> {
            entryQueue.addLast(entry(currentKey + token, node));
         });

         if (currentNode.value != null)
            trie.insert(currentKey, currentNode.value);
      }
      return trie;
   }

   public static <T> AhoCorasick<T> clone(Trie<T> prevTrie) {
      AhoCorasick<T> trie = new AhoCorasick<>();
      prevTrie.entryMap().forEach(Handler.uncheck((key, value) -> trie.insert(key, value)));
      return trie;
   }

   public Trie<T> getTrie() throws Exception {
      Trie<T> trie = new Trie<>();
      var entryQueue = new LinkedList<>(List.of(entry("", this.root)));

      while (entryQueue.size() > 0) {
         var currentEntry = entryQueue.removeFirst();
         String currentKey = currentEntry.getKey();
         Node<T> currentNode = currentEntry.getValue();

         currentNode.children.forEach((token, node) -> {
            entryQueue.addLast(entry(currentKey + token, node));
         });

         if (currentNode.value != null)
            trie.insert(currentKey, currentNode.value);
      }
      return trie;
   }

   public void insert(String key, T value) throws Exception {
      if (this.isLocked == true)
         throw new Exception("Aho Corasick Trie is Locked :: Insert Operation Denied");

      Node<T> node = this.root;
      for (int pos = 0; pos < key.length(); ++pos) {
         char token = key.charAt(pos);
         boolean hasToken = false;
         for (var childEntry : node.children.entrySet())
            if (childEntry.getKey() == token) {
               node = childEntry.getValue();
               hasToken = true;
               break;
            }
         if (hasToken == false)
            node = node.setChild(token, new Node<>());
      }

      if (node.value != null)
         throw new Exception("Key already present in the Trie :: Insert Operation Failed");
      node.value = value;
   }

   private Node<T> getDictionaryLink(Node<T> node) {
      if (node.hasComputedDictionary == false) {
         node.hasComputedDictionary = true;
         Node<T> failureNode = this.getFailureLink(node);
         node.dictionaryLink = failureNode.value != null 
            ? failureNode
            : failureNode == this.root 
               ? null
               : this.getDictionaryLink(failureNode);
      }
      return node.dictionaryLink;
   }

   private Node<T> getFailureLink(Node<T> node) {
      if (node.failureLink == null) {
         Node<T> parentNode = node.parent.getValue();
         node.failureLink = parentNode == this.root
            ? this.root
            : this.getTransition(this.getFailureLink(parentNode), node.parent.getKey());
      }
      return node.failureLink;
   }

   private Node<T> getTransition(Node<T> node, Character token) {
      if (node.transitions.get(token) == null) {
         Node<T> childNode = node.children.get(token);
         node.transitions.put(
            token, 
            childNode != null ? childNode : node == this.root 
               ? this.root 
               : this.getTransition(this.getFailureLink(node), token)
         );
      }
      return node.transitions.get(token);
   }

   public void computeLinks() {
      LinkedList<Node<T>> nodeQueue = new LinkedList<>();
      nodeQueue.addFirst(this.root);

      while (nodeQueue.size() > 0) {
         Node<T> currentNode = nodeQueue.removeFirst();
         currentNode.children.forEach((__, node) -> nodeQueue.addLast(node));
         this.getDictionaryLink(currentNode);
      }
      this.isLocked = true;
   }

   public HashSet<T> match(String matchStr) {
      HashSet<T> containedValues = new HashSet<>();
      Node<T> node = this.root;
      int pos = 0;

      while (pos < matchStr.length()) {
         char token = matchStr.charAt(pos);
         Node<T> childNode = node.children.get(token);

         if (childNode != null || node == this.root)
            ++pos;
         node = childNode != null ? childNode : node.failureLink;

         if (node.value != null) {
            containedValues.add(node.value);
            if (node.dictionaryLink != null)
               containedValues.add(node.dictionaryLink.value);
         }
      }
      return containedValues;
   }
}
