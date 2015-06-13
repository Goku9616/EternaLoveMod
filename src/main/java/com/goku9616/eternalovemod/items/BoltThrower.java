package com.goku9616.eternalovemod.items;

import com.goku9616.eternalovemod.EternaLoveMod;
import com.goku9616.eternalovemod.utilities.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class BoltThrower extends Item{

	 public BoltThrower(){
		  this.setUnlocalizedName("BoltThrower");
		  this.setTextureName(References.MODID+":BoltThrower");
	 }
	 @Override
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IIconRegister iconRegister) {
	 	 this.itemIcon = iconRegister.registerIcon(References.MODID+":"+this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	 }
	 @Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player,
			Entity entity) {
		 player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 10, 1));
	     Entity lightning;
	     for(int i=0; i<10; i++){
	    	 lightning = new EntityLightningBolt(player.worldObj, (double)entity.posX, (double)entity.posY, (double)entity.posZ);
	    	 player.worldObj.spawnEntityInWorld(lightning);
	     }
		 return super.onLeftClickEntity(stack, player, entity);
	}
	 @Override
	public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z,
			EntityPlayer player) {
		 player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 10, 1));
	     Entity lightning;
	     for(int i=0; i<10; i++){
	    	 lightning = new EntityLightningBolt(player.worldObj, (double)X, (double)Y, (double)Z);
	    	 player.worldObj.spawnEntityInWorld(lightning);
	     }
		 return super.onBlockStartBreak(itemstack, X, Y, Z, player);
	 }
}