package net.lopymine.pd.entrypoint;

//? if fabric {

import net.fabricmc.api.ClientModInitializer;
import net.lopymine.pd.client.ParticleDitheringClient;

public class ClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ParticleDitheringClient.onInitializeClient();
	}
}

//?} elif neoforge {
/*import java.util.*;
import net.lopymine.pd.ParticleDithering;
import net.lopymine.pd.client.ParticleDitheringClient;
import net.lopymine.pd.modmenu.ModMenuIntegration;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(value = ParticleDithering.MOD_ID, dist = Dist.CLIENT)
public class ClientEntrypoint {

	public ClientEntrypoint(ModContainer container) {
		ParticleDitheringClient.onInitializeClient();
		ModMenuIntegration integration = new ModMenuIntegration();
		integration.register(container);
	}

}

*///?}
