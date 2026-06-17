package net.lopymine.pd;

import net.lopymine.mossylib.logger.MossyLogger;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;

public class ParticleDithering {

	public static final String MOD_NAME = /*$ mod_name*/ "Particle Dithering";
	public static final String MOD_ID = /*$ mod_id*/ "particle_dithering";
	public static final MossyLogger LOGGER = new MossyLogger(MOD_NAME);

	public static void onInitialize() {
		LOGGER.info("{} Initialized", MOD_NAME);
	}
}