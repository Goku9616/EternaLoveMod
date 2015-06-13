package com.goku9616.eternalovemod.biome;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiome;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class WorldTypeEternaLove extends WorldType{
	
	public WorldTypeEternaLove(int par1, String name){
		super(name);
	}
	
	
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer)
    {
        GenLayer ret = new EternaLoveGenLayerBiome(200L, parentLayer, this);
        ret = GenLayerZoom.magnify(1000L, ret, 2);
        ret = new GenLayerBiomeEdge(1000L, ret);
        return ret;
    }

}