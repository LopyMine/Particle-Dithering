package net.lopymine.pd.mixin;

import net.lopymine.dl.thing.RenderingMarker;
import net.lopymine.pd.config.ParticleDitheringConfig;
import net.lopymine.pd.dithering.DitheringManager;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.feature.ParticleFeatureRenderer;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

@Mixin(ParticleFeatureRenderer.class)
public class ParticlesRenderStateMixin {

	@Inject(at = @At("HEAD"), method = "render")
	private void markParticle1(SubmitNodeCollection nodeCollection, boolean translucent, CallbackInfo ci) {
		boolean bl = ParticleDitheringConfig.getInstance().isModEnabled();
		RenderingMarker.DITHERING_ENABLED.get().setEnabled(bl);
		if (bl) {
			DitheringManager.updateBuffer();
		}
	}

	@Inject(at = @At("RETURN"), method = "render")
	private void markParticle2(SubmitNodeCollection nodeCollection, boolean translucent, CallbackInfo ci) {
		RenderingMarker.DITHERING_ENABLED.get().setEnabled(false);
	}

}
