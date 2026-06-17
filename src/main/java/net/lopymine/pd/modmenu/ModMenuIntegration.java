package net.lopymine.pd.modmenu;

import net.lopymine.mossylib.modmenu.AbstractModMenuIntegration;
import net.lopymine.pd.ParticleDithering;
import net.lopymine.pd.yacl.YACLConfigurationScreen;
import net.minecraft.client.gui.screens.Screen;

public class ModMenuIntegration extends AbstractModMenuIntegration {

	@Override
	protected String getModId() {
		return ParticleDithering.MOD_ID;
	}

	@Override
	protected Screen createConfigScreen(Screen screen) {
		return YACLConfigurationScreen.createScreen(screen);
	}
}
