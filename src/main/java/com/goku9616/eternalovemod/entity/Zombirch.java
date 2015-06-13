package com.goku9616.eternalovemod.entity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class Zombirch extends EntityZombie {
	public Zombirch(World par1World) {
		super(par1World);
		setCustomNameTag("Zombirch");
	    setAlwaysRenderNameTag(true);
	}
}
