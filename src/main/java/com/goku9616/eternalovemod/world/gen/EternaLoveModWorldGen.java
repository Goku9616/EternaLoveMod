package com.goku9616.eternalovemod.world.gen;

import java.util.Random;

import com.goku9616.eternalovemod.EternaLoveMod;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenDoublePlant;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenReed;
import cpw.mods.fml.common.IWorldGenerator;

public class EternaLoveModWorldGen implements IWorldGenerator{
    public static World w;
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
    	w=world;
    	switch(world.provider.dimensionId){
    	/*case -1: // nether
    	    generateInNether(world, random, chunkX*16, chunkZ*16);
    	    break;*/
    	case 0: // overworld
    	        generateInOverworldMinable(world, random, chunkX*16, chunkZ*16, EternaLoveMod.elOre);
    	        generateInOverworldMinable(world, random, chunkX*16, chunkZ*16, EternaLoveMod.kiriaOre);
    	        break;
    	/*case 1: // end
    	    generateInEnd(world, random, chunkX*16, chunkZ*16);
    	    break;*/
    	}
    }
    private void generateInOverworldMinable(World world, Random random, int x, int z, Block block) {
        // Genera il testBlock
        for (int i = 0; i < 15; i++){// 15 = rarita'
            int chunkX = x + random.nextInt(16);
            int chunkY = random.nextInt(256);
            int chunkZ = z + random.nextInt(16);
            // 10 = numero di blocchi per "nodo"
            (new WorldGenMinable(block, random.nextInt(5)+1)).generate(world, random, chunkX, chunkY, chunkZ);
        }
    }
}
