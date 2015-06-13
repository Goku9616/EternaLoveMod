package com.goku9616.eternalovemod.entity;

import java.util.Random;

import com.goku9616.eternalovemod.EternaLoveMod;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class GiangingilloTradeHandler implements IVillageTradeHandler{

	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
		recipeList.add(new MerchantRecipe(new ItemStack(EternaLoveMod.elSocks, 10), new ItemStack(EternaLoveMod.kiriaSocks, 10), new ItemStack(Items.emerald, 1)));
		
	}
}
