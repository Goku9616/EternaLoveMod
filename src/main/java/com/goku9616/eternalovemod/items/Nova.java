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

public class Nova extends Item{
	public Nova(){
		  this.setUnlocalizedName("Nova");
		  this.setTextureName(References.MODID+":Nova");
	 }
	 @Override
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IIconRegister iconRegister) {
	 	 this.itemIcon = iconRegister.registerIcon(References.MODID+":"+this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	 }
	 @Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World world, EntityPlayer player) {
		 for (int x = (int) (player.posX-8); x <= player.posX + 8; x++)
			for (int y = (int) (player.posY -8); y <= player.posY + 8; y++)
				for (int z = (int) (player.posZ -8); z <= player.posZ + 8; z++){
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
		return super.onItemRightClick(p_77659_1_, world, player);
	}
}
