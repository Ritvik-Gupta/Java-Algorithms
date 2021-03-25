package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import services.ErrorHandler.Handler;
import services.Random.Random;
import src.AhoCorasick.AhoCorasick;

public final class AhoCorasickTest extends BaseTest {
   private AhoCorasick<String> trie;

   @BeforeEach
   public void beforeEach() {
      System.out.print("Before Each\n");
      this.trie = new AhoCorasick<>();
   }

   public static ArrayList<Arguments> matchEntriesProvider() {
      final ArrayList<Arguments> stream = new ArrayList<>();
      providerRunIterations(__ -> {
         HashSet<String> possibleKeys = new HashSet<>();
         for (int pos = 0; pos < Random.rangeInt(10, 100); ++pos)
            possibleKeys.add(Random.word(1, 100));
         String randomWord = Random.word(1000, 10000);
         stream.add(Arguments.of(possibleKeys, randomWord));
      });
      return stream;
   }

   @ParameterizedTest
   @DisplayName("Aho Corasick Trie should match Linear Search for Random Words")
   @MethodSource("matchEntriesProvider")
   public void matchEntries(Set<String> possibleKeys, String randomWord) throws Exception {
      possibleKeys.forEach(Handler.uncheck(entry -> {
         this.trie.insert(entry, entry);
         Assertions.assertThrows(Exception.class, () -> this.trie.insert(entry, entry));
      }));
      this.trie.computeLinks();
      Assertions.assertThrows(Exception.class, () -> this.trie.insert("x", "x"));

      HashSet<String> containedValues = new HashSet<>();
      possibleKeys.forEach(str -> {
         if (randomWord.contains(str))
            containedValues.add(str);
      });
      Assertions.assertEquals(containedValues, trie.match(randomWord));
   }
}
