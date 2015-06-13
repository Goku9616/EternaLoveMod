package com.goku9616.eternalovemod.entity;

import com.goku9616.eternalovemod.utilities.References;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderKIRIAIR extends RenderBiped {

private static final ResourceLocation textureLocation = new ResourceLocation(References.MODID + ":" + "textures/models/KIRIAIR.png");

	public RenderKIRIAIR() {
		super(new ModelBiped(), 0,5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity){
		return textureLocation;
	}
}