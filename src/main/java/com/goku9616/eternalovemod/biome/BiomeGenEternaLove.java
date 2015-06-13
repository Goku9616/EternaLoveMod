package com.goku9616.eternalovemod.biome;

import com.goku9616.eternalovemod.EternaLoveMod;
import com.goku9616.eternalovemod.entity.Fantozza;
import com.goku9616.eternalovemod.entity.HEXEVIL;
import com.goku9616.eternalovemod.entity.KIRIAIR;
import com.goku9616.eternalovemod.entity.Tiziano;
import com.goku9616.eternalovemod.entity.Tuziano;

import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenEternaLove extends BiomeGenBase{

	public BiomeGenEternaLove(int id){
		super(id);
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 5, 2, 10));
		this.spawnableCreatureList.add(new SpawnListEntry(HEXEVIL.class, 5, 2, 10));
		this.spawnableCreatureList.add(new SpawnListEntry(KIRIAIR.class, 5, 2, 10));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityVillager.class, 5, 2, 10));
		this.spawnableCreatureList.add(new SpawnListEntry(Tiziano.class, 5, 2, 10));
		this.spawnableCreatureList.add(new SpawnListEntry(Tuziano.class, 5, 2, 10));
		this.spawnableCreatureList.add(new SpawnListEntry(Fantozza.class, 5, 2, 10));
		this.theBiomeDecorator.treesPerChunk = 5;
		this.theBiomeDecorator.grassPerChunk = 2;
		this.theBiomeDecorator.bigMushroomsPerChunk = 2;
		
		
		this.topBlock = Blocks.grass;
		this.fillerBlock = EternaLoveMod.eternaLoveBlock;
		
	}
	
}