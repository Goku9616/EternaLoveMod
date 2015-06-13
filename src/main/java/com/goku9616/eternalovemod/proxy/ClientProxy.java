package com.goku9616.eternalovemod.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.client.model.ModelOcelot;
import net.minecraft.client.model.ModelSheep1;
import net.minecraft.client.model.ModelSheep2;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderZombie;

import com.goku9616.eternalovemod.entity.Fantozza;
import com.goku9616.eternalovemod.entity.GiantZombirch;
import com.goku9616.eternalovemod.entity.HEXEVIL;
import com.goku9616.eternalovemod.entity.KIRIAIR;
import com.goku9616.eternalovemod.entity.RenderFantozza;
import com.goku9616.eternalovemod.entity.RenderGiantZombirch;
import com.goku9616.eternalovemod.entity.RenderHEXEVIL;
import com.goku9616.eternalovemod.entity.RenderKIRIAIR;
import com.goku9616.eternalovemod.entity.RenderTiziano;
import com.goku9616.eternalovemod.entity.RenderTuziano;
import com.goku9616.eternalovemod.entity.RenderZombirch;
import com.goku9616.eternalovemod.entity.Tiziano;
import com.goku9616.eternalovemod.entity.Tuziano;
import com.goku9616.eternalovemod.entity.Zombirch;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(Fantozza.class, new RenderFantozza(new ModelSheep2(), new ModelSheep1(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(HEXEVIL.class, new RenderHEXEVIL());
		RenderingRegistry.registerEntityRenderingHandler(KIRIAIR.class, new RenderKIRIAIR());
		RenderingRegistry.registerEntityRenderingHandler(Zombirch.class, new RenderZombirch());
		RenderingRegistry.registerEntityRenderingHandler(GiantZombirch.class, new RenderGiantZombirch(new ModelZombie()));
		RenderingRegistry.registerEntityRenderingHandler(Tiziano.class, new RenderTiziano());
		RenderingRegistry.registerEntityRenderingHandler(Tuziano.class, new RenderTuziano());
	}
}
