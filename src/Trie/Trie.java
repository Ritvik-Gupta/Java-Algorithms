package src.Trie;

import static java.util.Map.entry;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Map.Entry;

public final class Trie<T> implements ITrieInsert<T> {
   private final Node<T> root;

   private static class Node<T> {
      private T value;
      private final HashMap<Character, Node<T>> kids;

      private Node() {
         this.value = null;
         this.kids = new HashMap<>();
      }
   }

   public Trie() {
      this.root = new Node<>();
   }

   public void insert(String key, T value) throws Exception {
      Node<T> node = this.root;
      for (int pos = 0; pos < key.length(); ++pos) {
         char token = key.charAt(pos);
         if (node.kids.containsKey(token))
            node = node.kids.get(token);
         else {
            Node<T> childNode = new Node<>();
            node.kids.put(token, childNode);
            node = childNode;
         }
      }
      if (node.value != null)
         throw new Exception("Key already present in the Trie :: Insert Operation Failed");
      node.value = value;
   }

   public T update(String key, T value) throws Exception {
      Node<T> node = this.root;
      for (int pos = 0; pos < key.length(); ++pos) {
         char token = key.charAt(pos);
         if (node.kids.containsKey(token))
            node = node.kids.get(token);
         else
            throw new Exception("Key not present in the Trie :: Update Operation Failed");
      }
      if (node.value == null)
         throw new Exception("Partial Key specified :: Update Operation Failed");
      T prevValue = node.value;
      node.value = value;
      return prevValue;
   }

   public T delete(String key) throws Exception {
      Stack<Entry<Character, Node<T>>> entryStack = new Stack<>();

      Node<T> node = this.root;
      for (int pos = 0; pos < key.length(); ++pos) {
         char token = key.charAt(pos);
         if (node.kids.containsKey(token)) {
            entryStack.push(entry(token, node));
            node = node.kids.get(token);
         } else
            throw new Exception("Key not present in the Trie :: Delete Operation Failed");
      }
      if (node.value == null)
         throw new Exception("Partial Key specified :: Delete Operation Failed");
      T value = node.value;
      node.value = null;

      while (entryStack.size() > 0) {
         var currentEntry = entryStack.pop();
         Character currentToken = currentEntry.getKey();
         Node<T> currentNode = currentEntry.getValue();

         Node<T> childNode = currentNode.kids.get(currentToken);
         if (childNode.kids.isEmpty() && childNode.value == null)
            currentNode.kids.remove(currentToken);
      }
      return value;
   }

   public T fetch(String key) throws Exception {
      Node<T> node = this.root;
      for (int pos = 0; pos < key.length(); ++pos) {
         char token = key.charAt(pos);
         if (node.kids.containsKey(token))
            node = node.kids.get(token);
         else
            throw new Exception("Key not present in the Trie :: Fetch Operation Failed");
      }
      return node.value;
   }

   public boolean search(String key) {
      try {
         return this.fetch(key) != null;
      } catch (Exception err) {
         return false;
      }
   }

   public HashMap<String, T> partialSearch(String key) {
      HashMap<String, T> possibleEntries = new HashMap<>();
      Node<T> node = this.root;
      for (int pos = 0; pos < key.length(); ++pos) {
         char token = key.charAt(pos);
         if (node.kids.containsKey(token))
            node = node.kids.get(token);
         else
            return possibleEntries;
      }

      var entryQueue = new LinkedList<>(List.of(entry(key, node)));
      while (entryQueue.size() > 0) {
         var currentEntry = entryQueue.removeFirst();
         String currentKey = currentEntry.getKey();
         Node<T> currentNode = currentEntry.getValue();

         currentNode.kids.forEach((childToken, childNode) -> {
            entryQueue.addLast(entry(currentKey + childToken, childNode));
         });

         if (currentNode.value != null)
            possibleEntries.put(currentKey, currentNode.value);
      }
      return possibleEntries;
   }

   public HashMap<String, T> entryMap() {
      return this.partialSearch("");
   }
}
