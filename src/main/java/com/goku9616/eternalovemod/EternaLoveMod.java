package com.goku9616.eternalovemod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.crafting.RecipesCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageCreationHandler;

import com.goku9616.eternalovemod.armor.ElArmor;
import com.goku9616.eternalovemod.armor.KiriaArmor;
import com.goku9616.eternalovemod.biome.BiomeRegistry;
import com.goku9616.eternalovemod.blocks.BroccoliBlock;
import com.goku9616.eternalovemod.blocks.ElOre;
import com.goku9616.eternalovemod.blocks.EternaLoveBlock;
import com.goku9616.eternalovemod.blocks.WetFence_planted;
import com.goku9616.eternalovemod.blocks.KiriaOre;
import com.goku9616.eternalovemod.combact.ElAxe;
import com.goku9616.eternalovemod.combact.ElBow;
import com.goku9616.eternalovemod.combact.ElHoe;
import com.goku9616.eternalovemod.combact.ElPickaxe;
import com.goku9616.eternalovemod.combact.ElShovel;
import com.goku9616.eternalovemod.combact.ElSword;
import com.goku9616.eternalovemod.combact.KiriaAxe;
import com.goku9616.eternalovemod.combact.KiriaBow;
import com.goku9616.eternalovemod.combact.KiriaHoe;
import com.goku9616.eternalovemod.combact.KiriaPickaxe;
import com.goku9616.eternalovemod.combact.KiriaShovel;
import com.goku9616.eternalovemod.combact.KiriaSword;
import com.goku9616.eternalovemod.combact.LaggyBlade;
import com.goku9616.eternalovemod.entity.Fantozza;
import com.goku9616.eternalovemod.entity.GiangingilloTradeHandler;
import com.goku9616.eternalovemod.entity.GiantZombirch;
import com.goku9616.eternalovemod.entity.HEXEVIL;
import com.goku9616.eternalovemod.entity.KIRIAIR;
import com.goku9616.eternalovemod.entity.Tiziano;
import com.goku9616.eternalovemod.entity.Tuziano;
import com.goku9616.eternalovemod.entity.Zombirch;
import com.goku9616.eternalovemod.items.BibiTheMouse;
import com.goku9616.eternalovemod.items.BoltThrower;
import com.goku9616.eternalovemod.items.Broccoli;
import com.goku9616.eternalovemod.items.ConcertTicket;
import com.goku9616.eternalovemod.items.CookedBroccoli;
import com.goku9616.eternalovemod.items.ElIngot;
import com.goku9616.eternalovemod.items.ElSocks;
import com.goku9616.eternalovemod.items.ElTp;
import com.goku9616.eternalovemod.items.EmeraldCluster;
import com.goku9616.eternalovemod.items.EmeraldCore;
import com.goku9616.eternalovemod.items.KiriaSocks;
import com.goku9616.eternalovemod.items.KiriaTp;
import com.goku9616.eternalovemod.items.Microphone;
import com.goku9616.eternalovemod.items.Nova;
import com.goku9616.eternalovemod.items.SuperNova;
import com.goku9616.eternalovemod.items.KiriaIngot;
import com.goku9616.eternalovemod.items.ObsidianStick;
import com.goku9616.eternalovemod.items.SandwichToiletPaper;
import com.goku9616.eternalovemod.items.Symbol;
import com.goku9616.eternalovemod.items.Toothpick;
import com.goku9616.eternalovemod.items.VictoryPotato;
import com.goku9616.eternalovemod.items.WetFence;
import com.goku9616.eternalovemod.proxy.CommonProxy;
import com.goku9616.eternalovemod.utilities.References;
import com.goku9616.eternalovemod.world.gen.EternaLoveModWorldGen;
import com.mojang.authlib.GameProfile;
import com.sun.prism.paint.Color;

@Mod(modid = References.MODID, name = References.MOD_NAME, version = References.VERSION)
public class EternaLoveMod{
	
	@Instance(References.MODID)
	public static EternaLoveMod instance;
	@SidedProxy(clientSide="com.goku9616.eternalovemod.proxy.ClientProxy", serverSide="com.goku9616.eternalovemod.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static ArmorMaterial ELArmorMaterial = new EnumHelper().addArmorMaterial("ELArmorMaterial", 0, new int[]{6, 16, 12, 6}, 100);
	public static ToolMaterial ELMaterial = new EnumHelper().addToolMaterial("ELMaterial", Integer.MAX_VALUE, 0, 20.0f, 16.0f, 100);
	public static Item symbol=new Symbol();
	public static EternaLoveModTab ELTab=new EternaLoveModTab(CreativeTabs.getNextID(), "EternaLoveMod");
	public static Block elOre = new ElOre(Material.rock).setCreativeTab(ELTab);
	public static Block kiriaOre = new KiriaOre(Material.rock).setCreativeTab(ELTab);
	public static Block wetFence_planted = new WetFence_planted().setCreativeTab((CreativeTabs)null);
	public static Block eternaLoveBlock = new EternaLoveBlock(Material.rock).setCreativeTab(ELTab);
	public static Block broccoliBlock = new BroccoliBlock().setCreativeTab((CreativeTabs)null);
	public static Item elIngot=new ElIngot().setCreativeTab(ELTab);
	public static Item kiriaIngot=new KiriaIngot().setCreativeTab(ELTab);
	public static Item elAxe=new ElAxe().setCreativeTab(ELTab);
	public static Item kiriaAxe=new KiriaAxe().setCreativeTab(ELTab);
	public static Item elPickaxe=new ElPickaxe().setCreativeTab(ELTab);
	public static Item kiriaPickaxe=new KiriaPickaxe().setCreativeTab(ELTab);
	public static Item elHoe=new ElHoe().setCreativeTab(ELTab);
	public static Item kiriaHoe=new KiriaHoe().setCreativeTab(ELTab);
	public static Item elShovel=new ElShovel().setCreativeTab(ELTab);
	public static Item kiriaShovel=new KiriaShovel().setCreativeTab(ELTab);
	public static Item elSword=new ElSword().setCreativeTab(ELTab);
	public static Item kiriaSword=new KiriaSword().setCreativeTab(ELTab);
	public static Item elBow=new ElBow().setCreativeTab(ELTab);
	public static Item kiriaBow=new KiriaBow().setCreativeTab(ELTab);
	public static Item obsidianStick=new ObsidianStick().setCreativeTab(ELTab);
	public static Item emeraldCore=new EmeraldCore().setCreativeTab(ELTab);
	public static Item emeraldCluster=new EmeraldCluster().setCreativeTab(ELTab);
	public static Item elHelmet = new ElArmor("ElHelmet", ELArmorMaterial, 0).setCreativeTab(ELTab);
	public static Item elChestplate = new ElArmor("ElChestplate", ELArmorMaterial, 1).setCreativeTab(ELTab);
	public static Item elLeggins = new ElArmor("ElLeggins", ELArmorMaterial, 2).setCreativeTab(ELTab);
	public static Item elBoots = new ElArmor("ElBoots", ELArmorMaterial, 3).setCreativeTab(ELTab);
	public static Item kiriaHelmet = new KiriaArmor("KiriaHelmet", ELArmorMaterial, 0).setCreativeTab(ELTab);
	public static Item kiriaChestplate = new KiriaArmor("KiriaChestplate", ELArmorMaterial, 1).setCreativeTab(ELTab);
	public static Item kiriaLeggins = new KiriaArmor("KiriaLeggins", ELArmorMaterial, 2).setCreativeTab(ELTab);
	public static Item kiriaBoots = new KiriaArmor("KiriaBoots", ELArmorMaterial, 3).setCreativeTab(ELTab);
	public static Item wetFence = new WetFence(wetFence_planted).setCreativeTab(ELTab);
	public static Item sandwichToiletPaper = new SandwichToiletPaper().setCreativeTab(ELTab);
	public static Item toothpick = new Toothpick().setCreativeTab(ELTab);
	public static Item superNova = new SuperNova().setCreativeTab(ELTab);
	public static Item nova = new Nova().setCreativeTab(ELTab);
	public static Item elSocks = new ElSocks().setCreativeTab(ELTab);
	public static Item kiriaSocks = new KiriaSocks().setCreativeTab(ELTab);
	public static Item victoryPotato = new VictoryPotato().setCreativeTab(ELTab);
	public static Item elTp = new ElTp().setCreativeTab(ELTab);
	public static Item kiriaTp = new KiriaTp().setCreativeTab(ELTab);
	public static Item concertTicket = new ConcertTicket().setCreativeTab(ELTab);
	public static Item microphone = new Microphone().setCreativeTab(ELTab);
	public static Item bibiTheMouse = new BibiTheMouse().setCreativeTab(ELTab);
	public static Item laggyBlade = new LaggyBlade().setCreativeTab(ELTab);
	public static Item boltThrower = new BoltThrower().setCreativeTab(ELTab);
	public static Item broccoli = new Broccoli().setCreativeTab(ELTab);
	public static Item cookedBroccoli = new CookedBroccoli().setCreativeTab(ELTab);
	
	public static EternaLoveModWorldGen worldGen= new EternaLoveModWorldGen();

	public EternaLoveMod()
	{
		MinecraftForge.addGrassSeed(new ItemStack(broccoli), 1);
	}
	
    @EventHandler
    public void preinit(FMLPreInitializationEvent event){    	
    	GameRegistry.registerBlock(elOre, "ElOre");
    	GameRegistry.registerBlock(kiriaOre, "KiriaOre");
    	GameRegistry.registerBlock(eternaLoveBlock, "EternaLoveBlock");
    	GameRegistry.registerBlock(broccoliBlock, "BroccoliBlock");
    	GameRegistry.registerBlock(wetFence_planted, "WetFencePlanted");
    	GameRegistry.registerItem(symbol, "symbol");
    	GameRegistry.registerItem(obsidianStick, "ObsidianStick");
    	GameRegistry.registerItem(emeraldCluster, "EmeraldCluster");
    	GameRegistry.registerItem(emeraldCore, "EmeraldCore");
      	GameRegistry.registerItem(elIngot, "ElIngot");
    	GameRegistry.registerItem(kiriaIngot, "KiriaIngot");
    	GameRegistry.registerItem(elAxe, "ElAxe");
    	GameRegistry.registerItem(kiriaAxe, "KiriaAxe");
    	GameRegistry.registerItem(elPickaxe, "ElPickaxe");
    	GameRegistry.registerItem(kiriaPickaxe, "KiriaPickaxe");
    	GameRegistry.registerItem(elHoe, "ElHoe");
    	GameRegistry.registerItem(kiriaHoe, "KiriaHoe");
    	GameRegistry.registerItem(elShovel, "ElShovel");
    	GameRegistry.registerItem(kiriaShovel, "KiriaShovel");
    	GameRegistry.registerItem(elSword, "ElSword");
    	GameRegistry.registerItem(kiriaSword, "KiriaSword");
    	GameRegistry.registerItem(elBow, "ElBow");
    	GameRegistry.registerItem(kiriaBow, "KiriaBow");
    	GameRegistry.registerItem(elHelmet, "ElHelmet"); //0 for helmet
    	GameRegistry.registerItem(elChestplate, "ElChestplate"); // 1 for chestplate
    	GameRegistry.registerItem(elLeggins, "ElLeggins"); // 2 for leggings
    	GameRegistry.registerItem(elBoots, "ElBoots"); // 3 for boots
    	GameRegistry.registerItem(kiriaHelmet, "KiriaHelmet"); //0 for helmet
    	GameRegistry.registerItem(kiriaChestplate, "KiriaChestplate"); // 1 for chestplate
    	GameRegistry.registerItem(kiriaLeggins, "KiriaLeggins"); // 2 for leggings
    	GameRegistry.registerItem(kiriaBoots, "KiriaBoots"); // 3 for boots
    	GameRegistry.registerItem(wetFence, "WetFence");
    	GameRegistry.registerItem(sandwichToiletPaper, "SandwichToiletPaper");
    	GameRegistry.registerItem(toothpick, "Toothpick");
    	GameRegistry.registerItem(nova, "Nova");
    	GameRegistry.registerItem(superNova, "SuperNova");
    	GameRegistry.registerItem(elSocks, "ElSocks");
    	GameRegistry.registerItem(kiriaSocks, "KiriaSocks");
    	GameRegistry.registerItem(victoryPotato, "VictoryPotato");
    	GameRegistry.registerItem(elTp, "ElTp");
    	GameRegistry.registerItem(kiriaTp, "KiriaTp");
    	GameRegistry.registerItem(concertTicket, "ConcertTicket");
    	GameRegistry.registerItem(microphone, "Microphone");
    	GameRegistry.registerItem(bibiTheMouse, "BibiTheMouse");
    	GameRegistry.registerItem(laggyBlade, "LaggyBlade");
    	GameRegistry.registerItem(boltThrower, "BoltThrower");
    	GameRegistry.registerItem(broccoli, "Broccoli");
    	GameRegistry.registerItem(cookedBroccoli, "CookedBroccoli");
    	
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(obsidianStick),   "a  ", "a  ", "   ", 'a', Blocks.obsidian));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(emeraldCluster),   "aaa", "aba", "aaa", 'a', Items.emerald, 'b', Items.nether_star));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(elSword),   " d ", " d ", "abc", 'a', obsidianStick, 'b', emeraldCore, 'c', Items.diamond_sword, 'd', elIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kiriaSword),   " d ", " d ", "abc", 'a', obsidianStick, 'b', emeraldCore, 'c', Items.diamond_sword, 'd', kiriaIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(elAxe),   "db ", "dc ", " a ", 'a', obsidianStick, 'b', emeraldCore, 'c', Items.diamond_axe, 'd', elIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kiriaAxe),      "db ", "dc ", " a ", 'a', obsidianStick, 'b', emeraldCore, 'c', Items.diamond_axe, 'd', kiriaIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(elPickaxe),   "dbd", " c ", " a ", 'a', obsidianStick, 'b', emeraldCore, 'c', Items.diamond_pickaxe, 'd', elIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kiriaPickaxe),   "dbd", " c ", " a ", 'a', obsidianStick, 'b', emeraldCore, 'c', Items.diamond_pickaxe, 'd', kiriaIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(elShovel),   " d ", "aba", " c ", 'a', obsidianStick, 'b', emeraldCore, 'c', Items.diamond_shovel, 'd', elIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kiriaShovel),   " d ", "aba", " c ", 'a', obsidianStick, 'b', emeraldCore, 'c', Items.diamond_shovel, 'd', kiriaIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(elHoe),   "db ", " c ", " a ", 'a', obsidianStick, 'b', emeraldCore, 'c', Items.diamond_hoe, 'd', elIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kiriaHoe),   "db ", " c ", " a ", 'a', obsidianStick, 'b', emeraldCore, 'c', Items.diamond_hoe, 'd', kiriaIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(elHelmet),   "dbd", "dcd", "   ", 'b', emeraldCore, 'c', Items.diamond_helmet, 'd', elIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(elChestplate),   "dbd", "dcd", "ddd", 'b', emeraldCore, 'c', Items.diamond_chestplate, 'd', elIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(elLeggins),   "dbd", "dcd", "d d", 'b', emeraldCore, 'c', Items.diamond_leggings, 'd', elIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(elBoots),   "dbd", "dcd", "a a",'a', Blocks.obsidian, 'b', emeraldCore, 'c', Items.diamond_boots, 'd', elIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kiriaHelmet),   "dbd", "dcd", "   ", 'b', emeraldCore, 'c', Items.diamond_helmet, 'd', kiriaIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kiriaChestplate),   "dbd", "dcd", "ddd", 'b', emeraldCore, 'c', Items.diamond_chestplate, 'd', kiriaIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kiriaLeggins),   "dbd", "dcd", "d d", 'b', emeraldCore, 'c', Items.diamond_leggings, 'd', kiriaIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kiriaBoots),   "dbd", "dcd", "a a",'a', Blocks.obsidian, 'b', emeraldCore, 'c', Items.diamond_boots, 'd', kiriaIngot));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(sandwichToiletPaper), " a ", " b ", " a ",'a', Items.bread, 'b', Items.paper));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(elBow), "ba ", "bdc", "ba ",'a', elIngot, 'b', obsidianStick, 'c', emeraldCore, 'd', Items.bow));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kiriaBow), "ba ", "bdc", "ba ",'a', kiriaIngot, 'b', obsidianStick, 'c', emeraldCore, 'd', Items.bow));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(toothpick), "b  ", " a ", "  b",'a', Items.emerald, 'b', Items.diamond));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(nova), "aaa", "aaa", "aaa",'a', Items.fire_charge));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(superNova), "aaa", "aba", "aaa",'a', nova, 'b', emeraldCore));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(elSocks), "aba", "a a", "   ",'a', Blocks.wool, 'b', new ItemStack(Items.dye, 1, 4)));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kiriaSocks), "aba", "a a", "   ",'a', Blocks.wool, 'b', new ItemStack(Items.dye, 1, 9)));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(elSocks), "a a", "a a", "   ",'a', new ItemStack(Blocks.wool, 1, 11)));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kiriaSocks), "a a", "a a", "   ",'a',  new ItemStack(Blocks.wool, 1, 6)));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(victoryPotato), "aaa", "aba", "aaa",'a', emeraldCore, 'b', Items.potato));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(elTp), "aaa", "aba", "aaa",'a', elIngot, 'b', new ItemStack(Items.skull, 1, 2)));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kiriaTp), "aaa", "aba", "aaa",'a', kiriaIngot, 'b',  new ItemStack(Items.skull, 1, 2)));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bibiTheMouse), "aaa", "aba", "aaa",'a', Items.potato, 'b',  Items.poisonous_potato));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(laggyBlade), " c ", " b ", " a ",'a', Items.stick, 'b',  Items.clock, 'c', Items.iron_sword));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(boltThrower), "a  ", "aaa", "  a",'a', emeraldCore));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(eternaLoveBlock), "bab", "aca", "bab", 'a', elIngot,'b',kiriaIngot,'c', emeraldCore));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(wetFence), "ba ", "   ", "   ", 'a', Items.water_bucket,'b', Blocks.fence));

    	OreDictionary.registerOre("ElOre", elOre);
    	OreDictionary.registerOre("KiriaOre", kiriaOre);
    	
    	GameRegistry.addSmelting(elOre, new ItemStack(elIngot, 1), 1000);
    	GameRegistry.addSmelting(kiriaOre, new ItemStack(kiriaIngot, 1), 1000);
    	GameRegistry.addSmelting(emeraldCluster, new ItemStack(emeraldCore, 1), 5000000);
    	GameRegistry.addSmelting(eternaLoveBlock, new ItemStack(emeraldCore, 1), 50000);
    	GameRegistry.addSmelting(broccoli, new ItemStack(cookedBroccoli, 1), 100);
    	GameRegistry.addSmelting(wetFence, new ItemStack(Blocks.fence, 1), 100);
    	
    	GameRegistry.registerWorldGenerator(worldGen, 1);
    	
    	registerEntity(Fantozza.class, "Fantozza");
    	EntityRegistry.addSpawn(Fantozza.class, 30, 1, 1, EnumCreatureType.creature, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.hell, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
    	registerEntity(HEXEVIL.class, "HEXEVIL");
    	EntityRegistry.addSpawn(HEXEVIL.class, 90, 1, 1, EnumCreatureType.creature, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.hell, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
    	registerEntity(KIRIAIR.class, "KIRIAIR");
    	EntityRegistry.addSpawn(KIRIAIR.class, 90, 1, 1, EnumCreatureType.creature, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.hell, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
    	registerEntity(Zombirch.class, "Zombirch");
    	EntityRegistry.addSpawn(Zombirch.class, 20, 1, 1, EnumCreatureType.monster, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.hell, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
    	registerEntity(GiantZombirch.class, "GiantZombirch");
    	EntityRegistry.addSpawn(GiantZombirch.class, 5, 1, 1, EnumCreatureType.monster, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.hell, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
    	registerEntity(Tiziano.class, "Tiziano");
    	EntityRegistry.addSpawn(Tiziano.class, 20, 1, 1, EnumCreatureType.creature, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.hell, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
    	registerEntity(Tuziano.class, "Tuziano");
    	EntityRegistry.addSpawn(Tuziano.class, 20, 1, 1, EnumCreatureType.creature, BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.hell, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
    	proxy.registerRenderers();
    	
    	//MinecraftForge.TERRAIN_GEN_BUS.register(BiomeRegistry.biomeEternaLove);	
    }

    @EventHandler
    public void init(FMLInitializationEvent event){
    	VillagerRegistry.instance().registerVillagerId(1000);
    	VillagerRegistry.instance().registerVillagerSkin(1000, new ResourceLocation(References.MODID + ":" + "textures/models/farmer.png"));
    	GiangingilloTradeHandler GiangingilloTrade=new GiangingilloTradeHandler();
    	VillagerRegistry.instance().registerVillageTradeHandler(1000, GiangingilloTrade);
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event){
    	MinecraftForge.EVENT_BUS.register(new EternaLoveModEventHandler());
    }
    
    public static void registerEntity(Class entityClass, String name)
    {
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		long seed = name.hashCode();
		Random rand = new Random(seed);
		int primaryColor = rand.nextInt() * 16777215;
		int secondaryColor = rand.nextInt() * 16777215;
		
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
		EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
    }
}