package com.goku9616.eternalovemod.items;

import com.goku9616.eternalovemod.EternaLoveMod;
import com.goku9616.eternalovemod.utilities.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class ElTp extends Item{

	 public ElTp(){
		  this.setUnlocalizedName("ElTp");
		  this.setTextureName(References.MODID+":ElTp");
	 }
	 @Override
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IIconRegister iconRegister) {
	 	 this.itemIcon = iconRegister.registerIcon(References.MODID+":"+this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	 }
	 @Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
		 MinecraftServer.getServer().getCommandManager().executeCommand(p_77659_3_, "tp HEXEVIL");
		return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
	}
}