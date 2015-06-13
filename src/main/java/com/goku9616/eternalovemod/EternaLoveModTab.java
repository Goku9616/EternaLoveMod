package com.goku9616.eternalovemod;

import com.goku9616.eternalovemod.utilities.References;
import com.goku9616.eternalovemod.EternaLoveMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


public class EternaLoveModTab extends CreativeTabs{
	 public EternaLoveModTab(int pos, String name) {
		  super(pos, name);
		}

	@Override
	public Item getTabIconItem() {
		return EternaLoveMod.symbol;
	}
}
