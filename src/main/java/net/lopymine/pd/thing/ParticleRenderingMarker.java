package net.lopymine.pd.thing;

import lombok.*;
import net.lopymine.dl.thing.RenderingMarker;

@Setter
@Getter
public class ParticleRenderingMarker {

	public static final ThreadLocal<RenderingMarker> RENDERING_PARTICLE = ThreadLocal.withInitial(RenderingMarker::new);

	private boolean enabled;

}
