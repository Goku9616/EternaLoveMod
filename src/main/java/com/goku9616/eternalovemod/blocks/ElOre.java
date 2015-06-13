package com.goku9616.eternalovemod.blocks;

import java.io.Console;

import com.goku9616.eternalovemod.EternaLoveMod;
import com.goku9616.eternalovemod.utilities.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.client.renderer.texture.IIconRegister; 
import net.minecraft.creativetab.CreativeTabs;
public class ElOre extends Block{

public ElOre(Material material) {
  super(material);
  this.setBlockName("ElOre");
  this.setBlockTextureName(References.MODID+":ElOre");
  this.setHardness(3f);
  this.setHarvestLevel("pickaxe", 3);
 }
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister iconRegister) {
	 this.blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
}
}
