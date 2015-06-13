package com.goku9616.eternalovemod.entity;

import com.goku9616.eternalovemod.utilities.References;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHEXEVIL extends RenderBiped {

private static final ResourceLocation textureLocation = new ResourceLocation(References.MODID + ":" + "textures/models/HEXEVIL.png");

	public RenderHEXEVIL() {
		super(new ModelBiped(), 0,5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity){
		return textureLocation;
	}
}