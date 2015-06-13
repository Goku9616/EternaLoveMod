package com.goku9616.eternalovemod.entity;

import com.goku9616.eternalovemod.utilities.References;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderZombirch extends RenderZombie {

private static final ResourceLocation textureLocation = new ResourceLocation(References.MODID + ":" + "textures/models/Zombirch.png");

	public RenderZombirch() {
		super();
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity){
		return textureLocation;
	}
}