package edu.raycon.renderer;

import edu.raycon.util.Ray;
import edu.raycon.util.Vec3;

public class Camera {
  private final Vec3 origin;
  private final Vec3 horizontal;
  private final Vec3 vertical;

  private final Vec3 upperLeftCorner;

  public Camera(Viewport viewport) {
    this.origin = new Vec3();
    this.horizontal = new Vec3(viewport.getWidth(), 0.0, 0.0);
    this.vertical = new Vec3(0.0, viewport.getHeight(), 0.0);

    upperLeftCorner = cameraToViewportUpperLeftEdge(viewport);
  }

  public Vec3 getOrigin() {
    return origin;
  }

  public Vec3 getHorizontal() {
    return horizontal;
  }

  public Vec3 getVertical() {
    return vertical;
  }

  private Vec3 cameraToViewportUpperLeftEdge(Viewport viewport) {
    var upperLeft =
        Vec3.minus(getOrigin(), Vec3.divide(getHorizontal(), 2))
            .plus(Vec3.divide(getVertical(), 2))
            .minus(new Vec3(0, 0, viewport.getFocalLength()));

    return upperLeft;
  }

  public Ray get_ray(double u, double v) {
    return new Ray(
        getOrigin(),
        Vec3.plus(upperLeftCorner, Vec3.times(getHorizontal(), u))
            .minus(Vec3.times(getVertical(), v))
            .minus(getOrigin()));
  }
}
