package edu.raycon.kernel.kernel2d;

import edu.raycon.kernel.Kernel;

public class Kernel2D<P, R> extends Kernel<P, R> {

  private final int startRowIndex;

  private final int endRowIndex;

  private final int startColumnIndex;

  private final int endColumnIndex;

  public Kernel2D(
      TaskData2D<P, R> taskData2D,
      int startRowIndex,
      int endRowIndex,
      int startColumnIndex,
      int endColumnIndex) {
    super(taskData2D);
    this.startRowIndex = startRowIndex;
    this.endRowIndex = endRowIndex;
    this.startColumnIndex = startColumnIndex;
    this.endColumnIndex = endColumnIndex;
  }

  public void run(int i, int j) {
    task.run(i, j, input, callback);
  }

  public int getStartRowIndex() {
    return startRowIndex;
  }

  public int getEndRowIndex() {
    return endRowIndex;
  }

  public int getStartColumnIndex() {
    return startColumnIndex;
  }

  public int getEndColumnIndex() {
    return endColumnIndex;
  }
}
