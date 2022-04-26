package edu.raycon.connector;

import edu.raycon.renderer.RendererConfiguration;

public interface IRendererBuilder<T> {
  T build(RendererConfiguration config);
}
