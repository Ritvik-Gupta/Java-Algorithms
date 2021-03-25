package test;

import java.util.function.Consumer;

public class BaseTest {
   protected static int providerNumArgs = 20;
   
   protected static void providerRunIterations(Consumer<Integer> provider) {
      for (int argPos = 0; argPos < providerNumArgs; ++argPos)
         provider.accept(argPos);
   }
}
