package com.goku9616.eternalovemod.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class BiomeRegistry {
	
	public static void mainRegsitry(){
		initializeBiome();
		registerBiome();
	}
	
	public static BiomeGenBase biomeEternaLove;
	
	public static void initializeBiome(){
		
		biomeEternaLove = new BiomeGenEternaLove(137).setBiomeName("EternaLove").setTemperatureRainfall(1.2F, 0.9F);
		
	}
	
	public static void registerBiome(){
		BiomeDictionary.registerBiomeType(biomeEternaLove, Type.FOREST);
		BiomeManager.addSpawnBiome(biomeEternaLove);
		
	}
}