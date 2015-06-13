package com.goku9616.eternalovemod.combact;

import java.io.Console;

import com.goku9616.eternalovemod.EternaLoveMod;
import com.goku9616.eternalovemod.utilities.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class LaggyBlade extends ItemSword{

	 public LaggyBlade(){
		  super(EternaLoveMod.ELMaterial);
		  this.setUnlocalizedName("LaggyBlade");
		  this.setTextureName(References.MODID+":LaggyBlade");
	 }
	 @Override
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IIconRegister iconRegister) {
	 	 this.itemIcon = iconRegister.registerIcon(References.MODID+":"+this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	 }
		@Override
		public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
			for(int i=0; i<10000; i++)
				System.out.println("ETERNALOVE");
			return super.onLeftClickEntity(stack, player, entity);
		}
		
}