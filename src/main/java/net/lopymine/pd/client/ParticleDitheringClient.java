package net.lopymine.pd.client;

import net.lopymine.pd.ParticleDithering;
import net.lopymine.pd.dithering.DitheringManager;
import net.lopymine.mossylib.logger.MossyLogger;

public class ParticleDitheringClient {

	public static final MossyLogger LOGGER = ParticleDithering.LOGGER.extend("Client");

	public static void onInitializeClient() {
		LOGGER.info("{} Client Initialized", ParticleDithering.MOD_NAME);
		DitheringManager.register();
	}
}
