package edu.raycon.kernel.kernel2d;

import edu.raycon.kernel.KernelExecutor;
import edu.raycon.kernel.KernelStrategy;

import java.util.concurrent.ExecutorService;

public class Kernel2DExecutor implements KernelExecutor<Kernel2D> {
  private final ExecutorService executorService;

  private final KernelStrategy<Kernel2D> strategy;

  public Kernel2DExecutor(ExecutorService executorService, KernelStrategy<Kernel2D> strategy) {
    this.executorService = executorService;
    this.strategy = strategy;
  }

  @Override
  public void execute(Kernel2D kernel) {
    strategy.launch(kernel, executorService);
  }

  @Override
  public void shutdown() {
    executorService.shutdown();
  }
}
