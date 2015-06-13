package com.goku9616.eternalovemod.combact;

import com.goku9616.eternalovemod.EternaLoveMod;
import com.goku9616.eternalovemod.utilities.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ElBow extends ItemBow{

	 private IIcon[] iconArray;
	public ElBow(){
		  super();
		  this.setUnlocalizedName("ElBow");
		  this.setMaxDamage(1024);
		  this.setTextureName(References.MODID+":ElBow");
	 }
	 @Override
		public void onPlayerStoppedUsing(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_) {
			super.onPlayerStoppedUsing(p_77615_1_, p_77615_2_, p_77615_3_, p_77615_4_);
			p_77615_1_.setItemDamage(0);
		}
		@Override
	    @SideOnly(Side.CLIENT)
		 public void registerIcons(IIconRegister par1IconRegister)
		   {
		       this.itemIcon = par1IconRegister.registerIcon(References.MODID+":"+(this.getUnlocalizedName().substring(5)) + "_standby");
		       this.iconArray = new IIcon[bowPullIconNameArray.length];

		       for (int i = 0; i < this.iconArray.length; ++i)
		       {
		    	   this.iconArray[i] = par1IconRegister.registerIcon(References.MODID+":"+(this.getUnlocalizedName().substring(5)) + "_" + bowPullIconNameArray[i]);
		       }
		   }
		 @Override
	    @SideOnly(Side.CLIENT)
	    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
	        if (usingItem == null) { return itemIcon; }
	        int ticksInUse = stack.getMaxItemUseDuration() - useRemaining;

	        if (ticksInUse > 18) {
	            return iconArray[2];
	        } 
	        else if (ticksInUse > 14) {
	            return iconArray[1];
	        } 
	        else if (ticksInUse > 0) {
	            return iconArray[0];
	        } 
	        else {
	            return itemIcon;
	        }
	    }
		 @Override
		 public int getItemEnchantability()
		 {
		     return 0;
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