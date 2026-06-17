package net.lopymine.pd.entrypoint;

//? if fabric {
import net.lopymine.pd.ParticleDithering;
import net.fabricmc.api.ModInitializer;

public class CommonEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		ParticleDithering.onInitialize();
	}
}

//?} elif neoforge {

/*import net.neoforged.fml.common.Mod;
import net.lopymine.ed.ParticleDithering;

@Mod(ParticleDithering.MOD_ID)
public class CommonEntrypoint {

	public CommonEntrypoint() {
		ParticleDithering.onInitialize();
	}

}

*///?}

