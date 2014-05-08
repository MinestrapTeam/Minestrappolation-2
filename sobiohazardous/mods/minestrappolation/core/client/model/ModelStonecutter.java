package sobiohazardous.mods.minestrappolation.core.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStonecutter extends ModelBase
{
	// fields
	ModelRenderer	Base;
	ModelRenderer	BladeA;
	ModelRenderer	BladeB;
	ModelRenderer	BladeC;
	ModelRenderer	BladeD;
	ModelRenderer	BladeE;
	ModelRenderer	BladeF;
	ModelRenderer	BladeG;
	ModelRenderer	BladeH;
	ModelRenderer	BladeI;
	ModelRenderer	BladeJ;
	ModelRenderer	BladeK;
	ModelRenderer	BladeL;
	ModelRenderer	BladeM;
	
	public ModelStonecutter()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
		
		this.Base = new ModelRenderer(this, 0, 0);
		this.Base.addBox(0F, 0F, 0F, 16, 15, 16);
		this.Base.setRotationPoint(-8F, 9F, -8F);
		this.Base.setTextureSize(64, 64);
		this.Base.mirror = true;
		this.setRotation(this.Base, 0F, 0F, 0F);
		this.BladeA = new ModelRenderer(this, 0, 0);
		this.BladeA.addBox(0F, 0F, 0F, 2, 1, 1);
		this.BladeA.setRotationPoint(-2F, 8F, 4F);
		this.BladeA.setTextureSize(64, 64);
		this.BladeA.mirror = true;
		this.setRotation(this.BladeA, 0F, 0F, 0F);
		this.BladeB = new ModelRenderer(this, 0, 3);
		this.BladeB.addBox(0F, 0F, 0F, 5, 1, 1);
		this.BladeB.setRotationPoint(-2F, 8F, 3F);
		this.BladeB.setTextureSize(64, 64);
		this.BladeB.mirror = true;
		this.setRotation(this.BladeB, 0F, 0F, 0F);
		this.BladeC = new ModelRenderer(this, 0, 6);
		this.BladeC.addBox(0F, 0F, 0F, 4, 1, 1);
		this.BladeC.setRotationPoint(-2F, 8F, 2F);
		this.BladeC.setTextureSize(64, 64);
		this.BladeC.mirror = true;
		this.setRotation(this.BladeC, 0F, 0F, 0F);
		this.BladeD = new ModelRenderer(this, 0, 31);
		this.BladeD.addBox(0F, 0F, 0F, 9, 1, 1);
		this.BladeD.setRotationPoint(-4F, 8F, 1F);
		this.BladeD.setTextureSize(64, 64);
		this.BladeD.mirror = true;
		this.setRotation(this.BladeD, 0F, 0F, 0F);
		this.BladeE = new ModelRenderer(this, 6, 0);
		this.BladeE.addBox(0F, 0F, 0F, 1, 1, 1);
		this.BladeE.setRotationPoint(-4F, 8F, 2F);
		this.BladeE.setTextureSize(64, 64);
		this.BladeE.mirror = true;
		this.setRotation(this.BladeE, 0F, 0F, 0F);
		this.BladeF = new ModelRenderer(this, 0, 9);
		this.BladeF.addBox(0F, 0F, 0F, 4, 1, 1);
		this.BladeF.setRotationPoint(1F, 8F, 0F);
		this.BladeF.setTextureSize(64, 64);
		this.BladeF.mirror = true;
		this.setRotation(this.BladeF, 0F, 0F, 0F);
		this.BladeG = new ModelRenderer(this, 0, 34);
		this.BladeG.addBox(0F, 0F, 0F, 3, 1, 1);
		this.BladeG.setRotationPoint(-4F, 8F, 0F);
		this.BladeG.setTextureSize(64, 64);
		this.BladeG.mirror = true;
		this.setRotation(this.BladeG, 0F, 0F, 0F);
		this.BladeH = new ModelRenderer(this, 0, 12);
		this.BladeH.addBox(0F, 0F, 0F, 4, 1, 1);
		this.BladeH.setRotationPoint(-5F, 8F, -1F);
		this.BladeH.setTextureSize(64, 64);
		this.BladeH.mirror = true;
		this.setRotation(this.BladeH, 0F, 0F, 0F);
		this.BladeI = new ModelRenderer(this, 10, 0);
		this.BladeI.addBox(0F, 0F, 0F, 2, 1, 1);
		this.BladeI.setRotationPoint(1F, 8F, -1F);
		this.BladeI.setTextureSize(64, 64);
		this.BladeI.mirror = true;
		this.setRotation(this.BladeI, 0F, 0F, 0F);
		this.BladeJ = new ModelRenderer(this, 20, 31);
		this.BladeJ.addBox(0F, 0F, 0F, 9, 1, 1);
		this.BladeJ.setRotationPoint(-5F, 8F, -2F);
		this.BladeJ.setTextureSize(64, 64);
		this.BladeJ.mirror = true;
		this.setRotation(this.BladeJ, 0F, 0F, 0F);
		this.BladeK = new ModelRenderer(this, 8, 34);
		this.BladeK.addBox(0F, 0F, 0F, 6, 1, 1);
		this.BladeK.setRotationPoint(-2F, 8F, -3F);
		this.BladeK.setTextureSize(64, 64);
		this.BladeK.mirror = true;
		this.setRotation(this.BladeK, 0F, 0F, 0F);
		this.BladeL = new ModelRenderer(this, 22, 34);
		this.BladeL.addBox(0F, 0F, 0F, 5, 1, 1);
		this.BladeL.setRotationPoint(-3F, 8F, -4F);
		this.BladeL.setTextureSize(64, 64);
		this.BladeL.mirror = true;
		this.setRotation(this.BladeL, 0F, 0F, 0F);
		this.BladeM = new ModelRenderer(this, 10, 6);
		this.BladeM.addBox(0F, 0F, 0F, 2, 1, 1);
		this.BladeM.setRotationPoint(0F, 8F, -5F);
		this.BladeM.setTextureSize(64, 64);
		this.BladeM.mirror = true;
		this.setRotation(this.BladeM, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Base.render(f5);
		this.BladeA.render(f5);
		this.BladeB.render(f5);
		this.BladeC.render(f5);
		this.BladeD.render(f5);
		this.BladeE.render(f5);
		this.BladeF.render(f5);
		this.BladeG.render(f5);
		this.BladeH.render(f5);
		this.BladeI.render(f5);
		this.BladeJ.render(f5);
		this.BladeK.render(f5);
		this.BladeL.render(f5);
		this.BladeM.render(f5);
	}
	
	public void render(float f5)
	{
		this.Base.render(f5);
		this.BladeA.render(f5);
		this.BladeB.render(f5);
		this.BladeC.render(f5);
		this.BladeD.render(f5);
		this.BladeE.render(f5);
		this.BladeF.render(f5);
		this.BladeG.render(f5);
		this.BladeH.render(f5);
		this.BladeI.render(f5);
		this.BladeJ.render(f5);
		this.BladeK.render(f5);
		this.BladeL.render(f5);
		this.BladeM.render(f5);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
	
}
