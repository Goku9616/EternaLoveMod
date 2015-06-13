package com.goku9616.eternalovemod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.goku9616.eternalovemod.utilities.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EternaLoveBlock extends Block {
	public EternaLoveBlock(Material material) {
		  super(material);
		  this.setBlockName("EternaLoveBlock");
		  this.setBlockTextureName(References.MODID+":EternaLoveBlock");
		  this.setHardness(5f);
		  this.setHarvestLevel("pickaxe", 5);
		 }
		@SideOnly(Side.CLIENT)
		public void registerIcons(IIconRegister iconRegister) {
			 this.blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
		}
}
