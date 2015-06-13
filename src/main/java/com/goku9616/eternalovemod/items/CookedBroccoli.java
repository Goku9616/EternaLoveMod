package com.goku9616.eternalovemod.items;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;

import com.goku9616.eternalovemod.EternaLoveMod;
import com.goku9616.eternalovemod.utilities.References;

public class CookedBroccoli extends ItemFood
{

    public CookedBroccoli() 
    {
        super(4, 1F, false);
        setUnlocalizedName("CookedBroccoli");
        this.setTextureName(References.MODID+":CookedBroccoli");
    }
}