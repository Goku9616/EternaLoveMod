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
public class KiriaOre extends Block{

public KiriaOre(Material material) {
  super(material);
  this.setBlockName("KiriaOre");
  this.setBlockTextureName(References.MODID+":KiriaOre");
  this.setHardness(3f);
  this.setHarvestLevel("pickaxe", 3);
 }
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister iconRegister) {
	 this.blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
}
}
