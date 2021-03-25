package services.ErrorHandler;

import java.util.function.BiConsumer;

@FunctionalInterface
public interface HandleBiConsumer<T, U, E extends Throwable> {
   void accept(T key, U value) throws E;

   static <T, U, E extends Throwable> BiConsumer<T, U> check(HandleBiConsumer<T, U, E> biConsumer) {
      return (key, value) -> {
         try {
            biConsumer.accept(key, value);
         } catch (Throwable err) {
            throw new RuntimeException(err);
         }
      };
   }
}
