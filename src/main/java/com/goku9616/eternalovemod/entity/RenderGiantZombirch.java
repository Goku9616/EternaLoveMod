package com.goku9616.eternalovemod.entity;

import com.goku9616.eternalovemod.utilities.References;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderGiantZombie;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGiantZombirch extends RenderGiantZombie {

private static final ResourceLocation textureLocation = new ResourceLocation(References.MODID + ":" + "textures/models/Zombirch.png");

	public RenderGiantZombirch(ModelZombie mainModel) {
		super(mainModel, 10, 10);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity){
		return textureLocation;
	}
}