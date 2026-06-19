package net.lopymine.pd.mixin;

import net.lopymine.dl.dithering.DitheringData;
import net.lopymine.dl.dithering.vanilla.VanillaDitheringDataBuffer;
import net.lopymine.pd.config.ParticleDitheringConfig;
import net.lopymine.pd.dithering.DitheringManager;
import net.lopymine.pd.thing.ParticleRenderingMarker;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.feature.ParticleFeatureRenderer;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;

@Mixin(ParticleFeatureRenderer.class)
public class ParticlesRenderStateMixin {

	@Unique @Nullable private DitheringData backup;
	@Unique private boolean restore;

	@Inject(at = @At("HEAD"), method = "render")
	private void markParticle1(SubmitNodeCollection nodeCollection, boolean translucent, CallbackInfo ci) {
		if (nodeCollection.getParticleGroupRenderers().isEmpty()) {
			return;
		}
		this.restore = false;
		ParticleRenderingMarker.RENDERING_PARTICLE.get().setEnabled(true);
		if (ParticleDitheringConfig.getInstance().isModEnabled()) {
			this.backup = DitheringData.CURRENT_DITHERING_DATA.get();
			this.restore = true;
			DitheringManager.updateBuffer();
		}
	}

	@Inject(at = @At("RETURN"), method = "render")
	private void markParticle2(SubmitNodeCollection nodeCollection, boolean translucent, CallbackInfo ci) {
		if (nodeCollection.getParticleGroupRenderers().isEmpty()) {
			return;
		}
		ParticleRenderingMarker.RENDERING_PARTICLE.get().setEnabled(false);
		if (this.restore) {
			this.restore = false;
			DitheringData.CURRENT_DITHERING_DATA.set(this.backup);
			if (this.backup != null) {
				VanillaDitheringDataBuffer.update(this.backup);
			}
		}
	}
}
