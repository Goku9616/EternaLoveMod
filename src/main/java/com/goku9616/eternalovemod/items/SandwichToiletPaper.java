package com.goku9616.eternalovemod.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

import com.goku9616.eternalovemod.utilities.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SandwichToiletPaper extends ItemFood {
	 public SandwichToiletPaper(){
		  super(12, 6F, false);
		  this.setUnlocalizedName("SandwichToiletPaper");
		  this.setTextureName(References.MODID+":SandwichToiletPaper");
		  setPotionEffect(Potion.hunger.id, 60, 1, 1F);
	 }
	 @Override
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IIconRegister iconRegister) {
	 	 this.itemIcon = iconRegister.registerIcon(References.MODID+":"+this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	 }
}
