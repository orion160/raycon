package edu.raycon.renderer.raytracing;

import edu.raycon.util.Ray;

import java.util.ArrayList;
import java.util.List;

public class HittableList implements Hittable {
  private final List<Hittable> objects = new ArrayList<>();

  public HittableList() {}

  public HittableList(Hittable object) {}

  public void clear() {
    objects.clear();
  }

  public void add(Hittable object) {
    objects.add(object);
  }

  @Override
  public boolean hit(Ray r, double t_min, double t_max, HitRecord rec) {
    HitRecord tempRec = new HitRecord();
    boolean hitAnything = false;
    var closestSoFar = t_max;

    for (final var object : objects) {
      if (object.hit(r, t_min, closestSoFar, tempRec)) {
        hitAnything = true;
        closestSoFar = tempRec.t;
        rec.set(tempRec);
      }
    }

    return hitAnything;
  }
}
