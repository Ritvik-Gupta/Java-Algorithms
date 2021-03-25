package services.Random;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.ranges.RangeException;

public final class Random {
   private static Collection<Character> possibleTokens = new ArrayList<>();

   static {
      for (int pos = 0; pos < 26; ++pos)
         possibleTokens.add((char) (pos + 97));
      possibleTokens.add(' ');
   }

   public static <T> T choose(Collection<T> args) {
      int randomPos = (int) Math.floor(Math.random() * args.size()), pos = 0;
      for (T elm : args) {
         if (pos == randomPos)
            return elm;
         ++pos;
      }
      throw new RangeException((short) -1, "Cannot resolve a Random Element for Empty Collection");
   }

   public static <T> T choose(T[] args) {
      int size = args.length;
      if (size == 0)
         throw new RangeException((short) -1, "Cannot resolve a Random Element for Empty Array");
      int randomPos = (int) Math.floor(Math.random() * size);
      return (randomPos == size) ? args[size - 1] : args[randomPos];
   }

   public static double range(double start, double end) {
      double a = Math.min(start, end), b = Math.max(start, end);
      return a + Math.random() * (b - a);
   }

   public static int rangeInt(int start, int end) {
      return (int) Math.floor(Random.range(start, end));
   }

   public static String word(int start, int end, Collection<Character> allowedChars) {
      int size = Random.rangeInt(start, end);
      String word = "";
      for (int pos = 0; pos < size; ++pos)
         word += Random.choose(allowedChars);
      return word;
   }

   public static String word(int start, int end) {
      return Random.word(start, end, Random.possibleTokens);
   }
}
