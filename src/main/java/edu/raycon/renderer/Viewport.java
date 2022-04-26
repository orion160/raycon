package edu.raycon.renderer;

public class Viewport {

  private final double height;

  private final double width;

  private final double aspectRatio;

  private final double focalLength;

  public Viewport(double height, double aspectRatio, double focalLength) {
    this.height = height;
    this.width = height * aspectRatio;
    this.aspectRatio = aspectRatio;
    this.focalLength = focalLength;
  }

  public double getHeight() {
    return height;
  }

  public double getWidth() {
    return width;
  }

  public double getAspectRatio() {
    return aspectRatio;
  }

  public double getFocalLength() {
    return focalLength;
  }
}
