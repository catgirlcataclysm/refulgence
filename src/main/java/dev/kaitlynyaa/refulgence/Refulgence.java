package dev.kaitlynyaa.refulgence;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import dev.kaitlynyaa.refulgence.common.block.jar;

public class Refulgence implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Refulgence");	

	public static final Block jar = new jar(QuiltBlockSettings.create()
		.sounds(BlockSoundGroup.BONE)
		.collidable(true)
		.opaque(false)
		.hardness(0.25f)
	);
		
	public static final Block glowstoneJar = new jar(QuiltBlockSettings.create()
		.sounds(BlockSoundGroup.BONE)
		.collidable(true)
		.opaque(false)
		.luminance(14)
		.hardness(0.25f)
	);

	public static final Block redstoneJar = new jar(QuiltBlockSettings.create()
		.sounds(BlockSoundGroup.BONE)
		.collidable(true)
		.opaque(false)
		.luminance(7)
		.hardness(0.25f)
	);

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Refulgence loading...");
		
		Registry.register(Registries.BLOCK, new Identifier(mod.metadata().id(), "jar"), jar);
    	Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "jar"), new BlockItem(jar, new QuiltItemSettings()
    		.maxCount(8)
    	));
    	ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL_BLOCKS).register(entries -> {
    		entries.addItem(jar.asItem());
    	});
    	BlockRenderLayerMap.put(RenderLayer.getCutout(), jar);
    	
        Registry.register(Registries.BLOCK, new Identifier(mod.metadata().id(), "glowstone_jar"), glowstoneJar);		
    	Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "glowstone_jar"), new BlockItem(glowstoneJar, new QuiltItemSettings()
    		.maxCount(1)
    	));
    	ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL_BLOCKS).register(entries -> {
    		entries.addItem(glowstoneJar.asItem());
    	});
    	BlockRenderLayerMap.put(RenderLayer.getCutout(), glowstoneJar);

		Registry.register(Registries.BLOCK, new Identifier(mod.metadata().id(), "redstone_jar"), redstoneJar);		
    	Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "redstone_jar"), new BlockItem(redstoneJar, new QuiltItemSettings()
    		.maxCount(1)
    	));
    	ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL_BLOCKS).register(entries -> {
    		entries.addItem(redstoneJar.asItem());
    	});
    	BlockRenderLayerMap.put(RenderLayer.getCutout(), redstoneJar);

		LOGGER.info("Refulgence loaded");
	}
}