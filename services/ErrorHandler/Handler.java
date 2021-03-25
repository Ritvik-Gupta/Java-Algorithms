package services.ErrorHandler;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public interface Handler {
   static <T, U, E extends Throwable> BiConsumer<T, U> uncheck(HandleBiConsumer<T, U, E> func) {
      return HandleBiConsumer.check(func);
   }

   static <T, E extends Throwable> Consumer<T> uncheck(HandleConsumer<T, E> func) {
      return HandleConsumer.check(func);
   }

   static <T, R, E extends Throwable> Function<T, R> uncheck(HandleFunction<T, R, E> func) {
      return HandleFunction.check(func);
   }
}
