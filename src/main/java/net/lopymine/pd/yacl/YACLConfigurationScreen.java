package net.lopymine.pd.yacl;

import lombok.experimental.ExtensionMethod;
import net.lopymine.pd.yacl.category.*;
import net.lopymine.mossylib.yacl.api.SimpleYACLScreen;
import net.lopymine.mossylib.yacl.extension.SimpleOptionExtension;
import net.lopymine.pd.ParticleDithering;
import net.lopymine.pd.config.ParticleDitheringConfig;
import net.minecraft.client.gui.screens.Screen;

@ExtensionMethod(SimpleOptionExtension.class)
public class YACLConfigurationScreen {

	private YACLConfigurationScreen() {
		throw new IllegalStateException("Screen class");
	}

	public static Screen createScreen(Screen parent) {
		ParticleDitheringConfig defConfig = ParticleDitheringConfig.getNewInstance();
		ParticleDitheringConfig config = ParticleDitheringConfig.getInstance();

		return SimpleYACLScreen.startBuilder(ParticleDithering.MOD_ID, parent, config::save)
				.categories(GeneralCategory.get(defConfig, config))
				.build();
	}
}


