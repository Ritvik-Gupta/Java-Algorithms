package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import services.ErrorHandler.Handler;
import services.Random.Random;
import src.Trie.Trie;

public final class TrieTest extends BaseTest {
   private Trie<Double> trie;

   @BeforeEach
   public void beforeEach() {
      System.out.print("Before Each\n");
      this.trie = new Trie<>();
   }

   public static ArrayList<Arguments> fetchProvider() {
      final ArrayList<Arguments> stream = new ArrayList<>();
      providerRunIterations(__ -> {
         int totalEntries = Random.rangeInt(10, 100);
         HashMap<String, Double> entries = new HashMap<>();
         for (int pos = 0; pos < totalEntries; ++pos)
            entries.put(Random.word(5, 50), Random.range(-10, 10));
         stream.add(Arguments.of(entries, Random.choose(entries.keySet())));
      });
      return stream;
   }

   @ParameterizedTest
   @DisplayName("Trie should have inserted values")
   @MethodSource("fetchProvider")
   public void fetch(HashMap<String, Double> entries, String availableEntry) {
      entries.forEach(Handler.uncheck(this.trie::insert));

      entries.forEach(Handler.uncheck((key, value) -> {
         Assertions.assertEquals(this.trie.fetch(key), value);
      }));
      Assertions.assertThrows(Exception.class, () -> this.trie.insert(availableEntry, 1.0));
   }

   public static ArrayList<Arguments> partialSearchProvider() {
      final ArrayList<Arguments> stream = new ArrayList<>();
      providerRunIterations(__ -> {
         int totalEntries = Random.rangeInt(10, 100);
         List<Character> allowedChars = List.of('a', 'b', 'c', 'd');

         HashMap<String, Double> entries = new HashMap<>();
         for (int pos = 0; pos < totalEntries; ++pos)
            entries.put(Random.word(5, 10, allowedChars), Random.range(0, 2));

         String keyword = Random.word(2, 4, allowedChars);
         HashMap<String, Double> expectedEntries = new HashMap<>();
         entries.forEach(Handler.uncheck((key, value) -> {
            if (key.startsWith(keyword))
               expectedEntries.put(key, value);
         }));

         stream.add(Arguments.of(entries, keyword, expectedEntries));
      });
      return stream;
   }

   @ParameterizedTest
   @DisplayName("Trie should return correct Partial Result for Search")
   @MethodSource("partialSearchProvider")
   public void partialSearch(HashMap<String, Double> entries, String keyword, HashMap<String, Double> expectedEntries) {
      entries.forEach(Handler.uncheck(this.trie::insert));

      Assertions.assertEquals(entries, this.trie.partialSearch(""));
      Assertions.assertEquals(expectedEntries, this.trie.partialSearch(keyword));
   }
}
