package services.ErrorHandler;

import java.util.function.Function;

@FunctionalInterface
public interface HandleFunction<T, R, E extends Throwable> {
   R apply(T arg) throws E;

   static <T, R, E extends Throwable> Function<T, R> check(HandleFunction<T, R, E> func) {
      return arg -> {
         try {
            return func.apply(arg);
         } catch (Throwable err) {
            throw new RuntimeException(err);
         }
      };
   }
}
