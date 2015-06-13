package com.goku9616.eternalovemod.combact;

import com.goku9616.eternalovemod.EternaLoveMod;
import com.goku9616.eternalovemod.utilities.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class KiriaAxe extends ItemAxe{

	 public KiriaAxe(){
		  super(EternaLoveMod.ELMaterial);
		  this.setUnlocalizedName("KiriaAxe");
		  this.setTextureName(References.MODID+":Axe");
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
					ItemStack.addEnchantment(Enchantment.enchantmentsList[i], 10);
				}catch(Exception ex){}
		}
}