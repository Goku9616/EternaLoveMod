package com.goku9616.eternalovemod;

import scala.Console;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import net.minecraftforge.oredict.OreDictionary;

import com.goku9616.eternalovemod.biome.EternaLoveGenLayerBiome;
import com.goku9616.eternalovemod.entity.GiantZombirch;
import com.goku9616.eternalovemod.entity.HEXEVIL;
import com.goku9616.eternalovemod.entity.KIRIAIR;
import com.goku9616.eternalovemod.entity.Tiziano;
import com.goku9616.eternalovemod.entity.Tuziano;
import com.goku9616.eternalovemod.entity.Zombirch;
import com.goku9616.eternalovemod.world.gen.EternaLoveModWorldGen;
import com.google.common.eventbus.Subscribe;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
public class EternaLoveModEventHandler {
	@SubscribeEvent
	public void onLivingFallEvent(LivingFallEvent event)
	{
		if (event.distance>3F)
			if (event.entity != null && event.entity instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)event.entity;
				if(player.inventory.armorInventory[0]!=null && (player.inventory.armorInventory[0].getItem() == EternaLoveMod.elBoots ||player.inventory.armorInventory[0].getItem() == EternaLoveMod.kiriaBoots)){
					event.setCanceled(true);
				}
			}
	}
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(LivingDropsEvent event)
	{
	    if (event.entity instanceof Tiziano)
	    {
	        event.drops.clear();
	        ItemStack itemStackToDrop = new ItemStack(EternaLoveMod.concertTicket, 1);
	        event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemStackToDrop));
	        itemStackToDrop = new ItemStack(EternaLoveMod.microphone, 1);
	        event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemStackToDrop));
	    }
	    else if(event.entity instanceof Tuziano)
	    {
	    	event.drops.clear();
	        ItemStack itemStackToDrop = new ItemStack(EternaLoveMod.concertTicket, 1);
	        event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemStackToDrop));
	    }
	    else if(event.entity instanceof HEXEVIL)
	    {
	    	event.drops.clear();
	        ItemStack itemStackToDrop = new ItemStack(EternaLoveMod.elSocks, 1);
	        event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemStackToDrop));
	    }
	    else if(event.entity instanceof KIRIAIR)
	    {
	    	event.drops.clear();
	        ItemStack itemStackToDrop = new ItemStack(EternaLoveMod.kiriaSocks, 1);
	        event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemStackToDrop));
	    }
	    else if(event.entity instanceof Zombirch)
	    {
	    	event.drops.clear();
	        ItemStack itemStackToDrop = new ItemStack(Block.getBlockById(17), 1, 2);
	        event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemStackToDrop));
	    }
	    else if(event.entity instanceof GiantZombirch)
	    {
	    	event.drops.clear();
	        ItemStack itemStackToDrop = new ItemStack(Block.getBlockById(17), 64, 2);
	        event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemStackToDrop));
	    }
	} 
	
	@SubscribeEvent
	public void onInitBiomeGenerators(WorldTypeEvent.InitBiomeGens event)
	{
		event.newBiomeGens = EternaLoveGenLayerBiome.initializeAllBiomeGenerators(event.seed, event.worldType);
	}
}
