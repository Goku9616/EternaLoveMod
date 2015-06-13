package com.goku9616.eternalovemod.entity;

import com.goku9616.eternalovemod.EternaLoveMod;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class HEXEVIL extends EntityLiving {
	public HEXEVIL(World world) {
		super(world);
		setCustomNameTag("HEXEVIL");
	    setAlwaysRenderNameTag(true);
	}
}