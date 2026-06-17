package net.lopymine.pd.config;

import lombok.*;
import net.lopymine.mossylib.loader.MossyLoader;
import net.lopymine.mossylib.utils.*;
import net.lopymine.pd.ParticleDithering;
import net.lopymine.pd.config.distance.DitheringDataConfig;
import net.lopymine.pd.dithering.DitheringManager;
import org.slf4j.*;

import com.mojang.serialization.*;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.io.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import static net.lopymine.mossylib.utils.CodecUtils.option;

@Getter
@Setter
@AllArgsConstructor
public class ParticleDitheringConfig {

	public static final Codec<ParticleDitheringConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
			option("mod_enabled", true, Codec.BOOL, ParticleDitheringConfig::isModEnabled),
			option("dithering_data", DitheringDataConfig.getNewInstance(), DitheringDataConfig.CODEC, ParticleDitheringConfig::getDitheringDataConfig)
	).apply(instance, ParticleDitheringConfig::new));

	private static final File CONFIG_FILE = MossyLoader.getConfigDir().resolve(ParticleDithering.MOD_ID + ".json5").toFile();
	private static final Logger LOGGER = LoggerFactory.getLogger(ParticleDithering.MOD_NAME + "/Config");
	private static ParticleDitheringConfig INSTANCE;

	private boolean modEnabled;
	private DitheringDataConfig ditheringDataConfig;

	private ParticleDitheringConfig() {
		throw new IllegalArgumentException();
	}

	public static ParticleDitheringConfig getInstance() {
		return INSTANCE == null ? reload() : INSTANCE;
	}

	public static ParticleDitheringConfig reload() {
		return INSTANCE = read();
	}

	public static ParticleDitheringConfig getNewInstance() {
		return CodecUtils.parseNewInstanceHacky(CODEC);
	}

	private static ParticleDitheringConfig read() {
		return ConfigUtils.readConfig(CODEC, CONFIG_FILE, LOGGER);
	}

	public void saveAsync() {
		CompletableFuture.runAsync(this::save);
	}

	public void save() {
		ConfigUtils.saveConfig(this, CODEC, CONFIG_FILE, LOGGER);
	}
}
