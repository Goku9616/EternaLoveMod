package com.goku9616.eternalovemod.entity;

import com.goku9616.eternalovemod.EternaLoveMod;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class Tiziano extends EntityIronGolem {
	public Tiziano(World par1World) {
		super(par1World);
		setCustomNameTag("Tiziano");
	    setAlwaysRenderNameTag(true);
	}	
}
