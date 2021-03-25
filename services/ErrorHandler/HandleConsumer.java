package services.ErrorHandler;

import java.util.function.Consumer;

@FunctionalInterface
public interface HandleConsumer<T, E extends Throwable> {
   void accept(T arg) throws E;

   static <T, E extends Throwable> Consumer<T> check(HandleConsumer<T, E> consumer) {
      return arg -> {
         try {
            consumer.accept(arg);
         } catch (Throwable err) {
            throw new RuntimeException(err);
         }
      };
   }
}
