package com.goku9616.eternalovemod.items;

import com.goku9616.eternalovemod.utilities.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class SuperNova extends Item{
	public SuperNova(){
		  this.setUnlocalizedName("SuperNova");
		  this.setTextureName(References.MODID+":SuperNova");
	 }
	 @Override
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IIconRegister iconRegister) {
	 	 this.itemIcon = iconRegister.registerIcon(References.MODID+":"+this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	 }
	 @Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World world, EntityPlayer player) {
		 world.createExplosion(player, player.posX, player.posY, player.posZ, 500, true);
		 for (int x = (int) (player.posX-16); x <= player.posX + 16; x++)
			for (int y = (int) (player.posY -16); y <= player.posY + 16; y++)
				for (int z = (int) (player.posZ -16); z <= player.posZ + 16; z++){
					if (world.getBlock(x, y, z) == Blocks.air || world.getBlock(x, y, z) == Blocks.snow_layer)
						if(world.getBlock(x, y-1, z) != Blocks.air)
							world.setBlock(x, y, z, Blocks.fire);
					if(world.getBlock(x,y,z)==Blocks.grass || world.getBlock(x,y,z)==Blocks.mycelium || world.getBlock(x,y,z)==Blocks.farmland)
						world.setBlock(x,y,z, Blocks.dirt);
					else{
						if(world.getBlock(x,y,z)==Blocks.water || world.getBlock(x,y,z)==Blocks.ice || world.getBlock(x,y,z)==Blocks.packed_ice || world.getBlock(x,y,z)==Blocks.snow)
							world.setBlock(x,y,z, Blocks.obsidian);
						else if(world.getBlock(x,y,z)==Blocks.sand)
							world.setBlock(x,y,z, Blocks.glass);
						else if(world.getBlock(x,y,z)==Blocks.cobblestone)
							world.setBlock(x,y,z, Blocks.stone);
						else if(world.getBlock(x,y,z)==Blocks.gravel || world.getBlock(x,y,z)==Blocks.mossy_cobblestone)
							world.setBlock(x,y,z, Blocks.cobblestone);
						else if(world.getBlock(x,y,z)==Blocks.clay)
							world.setBlock(x,y,z, Blocks.hardened_clay);
						}
				}
		p_77659_1_.stackSize--;
		player.setHealth(0);
		return super.onItemRightClick(p_77659_1_, world, player);
	}
}
