package com.goku9616.eternalovemod.items;

import net.minecraft.init.Blocks;

import com.goku9616.eternalovemod.EternaLoveMod;
import com.goku9616.eternalovemod.utilities.References;

public class Broccoli extends RecipeItemSeedFood 
{

    public Broccoli() 
    {
        super(6, 2F, EternaLoveMod.broccoliBlock, Blocks.farmland);
        setUnlocalizedName("Broccoli");
        this.setTextureName(References.MODID+":Broccoli");
    }
}