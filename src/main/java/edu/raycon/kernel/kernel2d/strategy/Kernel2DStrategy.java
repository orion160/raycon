package edu.raycon.kernel.kernel2d.strategy;

import edu.raycon.kernel.KernelStrategy;
import edu.raycon.kernel.kernel2d.Kernel2D;
import edu.raycon.kernel.kernel2d.Kernel2DInvocation;

import java.util.concurrent.ExecutorService;

public class Kernel2DStrategy implements KernelStrategy<Kernel2D> {

  @Override
  public void launch(Kernel2D kernel, ExecutorService executorService) {
    for (int i = kernel.getStartRowIndex(); i < kernel.getEndRowIndex(); i++) {
      for (int j = kernel.getStartColumnIndex(); j < kernel.getEndColumnIndex(); j++) {
        var invocation = new Kernel2DInvocation(kernel, i, j);
        executorService.submit(invocation);
      }
    }
  }
}
