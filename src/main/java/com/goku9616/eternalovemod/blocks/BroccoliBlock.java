package com.goku9616.eternalovemod.blocks;

import java.util.Random;

import com.goku9616.eternalovemod.EternaLoveMod;
import com.goku9616.eternalovemod.utilities.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BroccoliBlock extends RecipeBlockCrops
{

    public BroccoliBlock()
    {
        // Basic block setup
        setBlockName("broccoli");
        setBlockTextureName(References.MODID+":Broccoli_stage_0");
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(int parMetadata, int parFortune, Random parRand)
    {
        return (parMetadata/2);
    }

    @Override
    public Item getItemDropped(int parMetadata, Random parRand, int parFortune)  
    {
        return (EternaLoveMod.broccoli);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister parIIconRegister)
    {
          iIcon = new IIcon[maxGrowthStage+1];
          // seems that crops like to have 8 growth icons, but okay to repeat actual texture if you want
          // to make generic should loop to maxGrowthStage
          iIcon[0] = parIIconRegister.registerIcon(References.MODID+":Broccoli_stage_0");
          iIcon[1] = parIIconRegister.registerIcon(References.MODID+":Broccoli_stage_1");
          iIcon[2] = parIIconRegister.registerIcon(References.MODID+":Broccoli_stage_2");
          iIcon[3] = parIIconRegister.registerIcon(References.MODID+":Broccoli_stage_3");
          iIcon[4] = parIIconRegister.registerIcon(References.MODID+":Broccoli_stage_4");
    }
}