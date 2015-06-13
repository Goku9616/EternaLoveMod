package com.goku9616.eternalovemod.entity;

import com.goku9616.eternalovemod.EternaLoveMod;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class KIRIAIR extends EntityLiving {
	public KIRIAIR(World world) {
		super(world);
		setCustomNameTag("KIRIAIR");
	    setAlwaysRenderNameTag(true);
	}
}
