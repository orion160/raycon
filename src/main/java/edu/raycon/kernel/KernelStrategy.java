package edu.raycon.kernel;

import java.util.concurrent.ExecutorService;

@FunctionalInterface
public interface KernelStrategy<T extends Kernel> {
  void launch(T kernel, ExecutorService executorService);
}
