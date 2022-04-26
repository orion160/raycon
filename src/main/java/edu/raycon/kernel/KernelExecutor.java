package edu.raycon.kernel;

public interface KernelExecutor<T> {
  void execute(T kernel);

  void shutdown();
}
