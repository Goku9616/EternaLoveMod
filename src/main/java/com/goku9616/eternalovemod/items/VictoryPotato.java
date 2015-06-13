package com.goku9616.eternalovemod.items;

import com.goku9616.eternalovemod.EternaLoveMod;
import com.goku9616.eternalovemod.utilities.References;
import com.google.common.collect.Multiset.Entry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class VictoryPotato extends Item{
	 public VictoryPotato(){
		  super();
		  this.setUnlocalizedName("VictoryPotato");
		  this.setTextureName(References.MODID+":VictoryPotato");
	 }
	 @Override
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IIconRegister iconRegister) {
	 	 this.itemIcon = iconRegister.registerIcon(References.MODID+":"+this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	 }
		@Override
		public void onCreated(ItemStack ItemStack, World World, EntityPlayer EntityPlayer)
		{
			for(int i=0;i<Enchantment.enchantmentsList.length; i++)
				try{
					ItemStack.addEnchantment(Enchantment.enchantmentsList[i], 100);
				}catch(Exception ex){}
		}
}