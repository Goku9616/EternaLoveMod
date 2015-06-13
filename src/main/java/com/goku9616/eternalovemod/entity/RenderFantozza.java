package com.goku9616.eternalovemod.entity;

import com.goku9616.eternalovemod.utilities.References;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelSheep1;
import net.minecraft.client.model.ModelSheep2;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderFantozza extends RenderSheep {

private static final ResourceLocation textureLocation = new ResourceLocation(References.MODID + ":" + "textures/models/sheep.png");
	public RenderFantozza(ModelSheep2 model, ModelSheep1 model1, float shadowSize) {
		super(model, model1, shadowSize);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity){
		return textureLocation;
	}
}
	