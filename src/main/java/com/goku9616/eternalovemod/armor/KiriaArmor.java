package com.goku9616.eternalovemod.armor;

import com.goku9616.eternalovemod.EternaLoveMod;
import com.goku9616.eternalovemod.utilities.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class KiriaArmor extends ItemArmor{

	public KiriaArmor(String unlocalizedName, ArmorMaterial material, int type) {
	    super(material, 0, type);
	    this.setUnlocalizedName(unlocalizedName);
	    this.setTextureName(References.MODID + ":" + unlocalizedName);
	}
	@Override
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IIconRegister iconRegister) {
	 	 this.itemIcon = iconRegister.registerIcon(References.MODID+":"+this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	 }
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
	    return References.MODID+":textures/armor/KiriaArmor_" + (this.armorType == 2 ? 2 : 1) + ".png";
	}
	@Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {	
			if (player.inventory.armorInventory[3]!= null && player.inventory.armorInventory[3].getItem() == EternaLoveMod.kiriaHelmet && player.inventory.armorInventory[2]!= null && player.inventory.armorInventory[2].getItem() == EternaLoveMod.kiriaChestplate && player.inventory.armorInventory[1]!= null && player.inventory.armorInventory[1].getItem() == EternaLoveMod.kiriaLeggins && player.inventory.armorInventory[0]!= null && player.inventory.armorInventory[0].getItem() == EternaLoveMod.kiriaBoots){
				if(!player.isPotionActive(Potion.jump.getId()) && !player.isPotionActive(Potion.moveSpeed.getId()) && !player.isPotionActive(Potion.fireResistance.getId()) && !player.isPotionActive(Potion.nightVision.getId()) && !player.isPotionActive(Potion.regeneration.getId())){
					player.addPotionEffect((new PotionEffect(Potion.regeneration.getId(), (int)Double.POSITIVE_INFINITY, 1)));
					player.addPotionEffect((new PotionEffect(Potion.jump.getId(), (int)Double.POSITIVE_INFINITY, 1)));
					player.addPotionEffect((new PotionEffect(Potion.nightVision.getId(), (int)Double.POSITIVE_INFINITY, 0)));
					player.addPotionEffect((new PotionEffect(Potion.fireResistance.getId(), (int)Double.POSITIVE_INFINITY, 0)));
					player.addPotionEffect((new PotionEffect(Potion.moveSpeed.getId(), (int)Double.POSITIVE_INFINITY, 1)));
					player.addPotionEffect((new PotionEffect(Potion.resistance.getId(), (int)Double.POSITIVE_INFINITY, 1)));
				}
			}
			else{
				player.removePotionEffectClient(Potion.regeneration.getId());
				player.removePotionEffectClient(Potion.fireResistance.getId());
				player.removePotionEffectClient(Potion.moveSpeed.getId());
				player.removePotionEffectClient(Potion.jump.getId());
				player.removePotionEffectClient(Potion.nightVision.getId());
				player.removePotionEffectClient(Potion.resistance.getId());
			}
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