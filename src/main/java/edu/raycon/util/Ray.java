package edu.raycon.util;

public class Ray {
  private final Vec3 origin;
  private final Vec3 direction;

  public Ray() {
    this.origin = new Vec3();
    this.direction = new Vec3();
  }

  public Ray(Vec3 origin, Vec3 direction) {
    this.origin = origin;
    this.direction = direction;
  }

  public Vec3 at(double t) {
    return Vec3.plus(getOrigin(), Vec3.times(getDirection(), t));
  }

  public Vec3 getOrigin() {
    return origin;
  }

  public Vec3 getDirection() {
    return direction;
  }
}
