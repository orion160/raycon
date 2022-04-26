package edu.raycon.renderer.raytracing;

import edu.raycon.util.Ray;
import edu.raycon.util.Vec3;

public class Sphere implements Hittable {
  private final Vec3 center;
  private double radius;

  public Sphere() {
    this.center = new Vec3();
    this.radius = 0.0;
  }

  public Sphere(Vec3 center, double radius) {
    this.center = center;
    this.radius = radius;
  }

  public Vec3 getCenter() {
    return center;
  }

  public double getRadius() {
    return radius;
  }

  @Override
  public boolean hit(Ray r, double t_min, double t_max, HitRecord rec) {
    var oc = Vec3.minus(r.getOrigin(), center);
    var a = r.getDirection().lengthSquared();
    var halfB = Vec3.dot(oc, r.getDirection());
    var c = oc.lengthSquared() - (radius * radius);

    var discriminant = (halfB * halfB) - (a * c);

    if (discriminant < 0) {
      return false;
    }

    var sqrtd = Math.sqrt(discriminant);

    // Find the nearest root that lies in the acceptable range.
    var root = (-halfB - sqrtd) / a;
    if (root < t_min || t_max < root) {
      root = (-halfB + sqrtd) / a;
      if (root < t_min || t_max < root) {
        return false;
      }
    }

    rec.t = root;
    rec.p = r.at(rec.t);
    var outwardNormal = Vec3.minus(rec.p, center).divide(radius);
    rec.setFaceNormal(r, outwardNormal);

    return true;
  }
}
