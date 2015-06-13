package com.goku9616.eternalovemod.items;

import com.goku9616.eternalovemod.EternaLoveMod;
import com.goku9616.eternalovemod.utilities.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class EmeraldCore extends Item{

	 public EmeraldCore(){
		  this.setUnlocalizedName("EmeraldCore");
		  this.setTextureName(References.MODID+":EmeraldCore");
	 }
	 @Override
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IIconRegister iconRegister) {
	 	 this.itemIcon = iconRegister.registerIcon(References.MODID+":"+this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	 }
}