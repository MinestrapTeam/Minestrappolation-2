package sobiohazardous.mods.minestrappolation.extradecor.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGoblet extends ModelBase
{
	// fields
	ModelRenderer	Base;
	ModelRenderer	Stem;
	ModelRenderer	CupBase;
	ModelRenderer	CupSubBaseA;
	ModelRenderer	CupSubBaseB;
	ModelRenderer	CupSubBaseC;
	ModelRenderer	CupSubBaseD;
	ModelRenderer	Side1;
	ModelRenderer	Side2;
	ModelRenderer	Side3;
	ModelRenderer	Side4;
	ModelRenderer	Liquid;
	
	public ModelGoblet()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		
		this.Base = new ModelRenderer(this, 0, 0);
		this.Base.addBox(0F, 0F, 0F, 4, 1, 4);
		this.Base.setRotationPoint(-2F, 23F, -2F);
		this.Base.setTextureSize(64, 32);
		this.Base.mirror = true;
		this.setRotation(this.Base, 0F, 0F, 0F);
		this.Stem = new ModelRenderer(this, 16, 0);
		this.Stem.addBox(0F, 0F, 0F, 2, 4, 2);
		this.Stem.setRotationPoint(-1F, 19F, -1F);
		this.Stem.setTextureSize(64, 32);
		this.Stem.mirror = true;
		this.setRotation(this.Stem, 0F, 0F, 0F);
		this.CupBase = new ModelRenderer(this, 0, 0);
		this.CupBase.addBox(0F, 0F, 0F, 4, 1, 4);
		this.CupBase.setRotationPoint(-2F, 18F, -2F);
		this.CupBase.setTextureSize(64, 32);
		this.CupBase.mirror = true;
		this.setRotation(this.CupBase, 0F, 0F, 0F);
		this.CupSubBaseA = new ModelRenderer(this, 0, 5);
		this.CupSubBaseA.addBox(0F, 0F, 0F, 4, 1, 2);
		this.CupSubBaseA.setRotationPoint(-2F, 17F, 1F);
		this.CupSubBaseA.setTextureSize(64, 32);
		this.CupSubBaseA.mirror = true;
		this.setRotation(this.CupSubBaseA, 0F, 0F, 0F);
		this.CupSubBaseB = new ModelRenderer(this, 0, 5);
		this.CupSubBaseB.addBox(0F, 0F, 0F, 4, 1, 2);
		this.CupSubBaseB.setRotationPoint(-2F, 17F, -3F);
		this.CupSubBaseB.setTextureSize(64, 32);
		this.CupSubBaseB.mirror = true;
		this.setRotation(this.CupSubBaseB, 0F, 0F, 0F);
		this.CupSubBaseC = new ModelRenderer(this, 0, 8);
		this.CupSubBaseC.addBox(0F, 0F, 0F, 2, 1, 4);
		this.CupSubBaseC.setRotationPoint(-3F, 17F, -2F);
		this.CupSubBaseC.setTextureSize(64, 32);
		this.CupSubBaseC.mirror = true;
		this.setRotation(this.CupSubBaseC, 0F, 0F, 0F);
		this.CupSubBaseD = new ModelRenderer(this, 0, 8);
		this.CupSubBaseD.addBox(0F, 0F, 0F, 2, 1, 4);
		this.CupSubBaseD.setRotationPoint(1F, 17F, -2F);
		this.CupSubBaseD.setTextureSize(64, 32);
		this.CupSubBaseD.mirror = true;
		this.setRotation(this.CupSubBaseD, 0F, 0F, 0F);
		this.Side1 = new ModelRenderer(this, 24, 0);
		this.Side1.addBox(0F, 0F, 0F, 4, 4, 1);
		this.Side1.setRotationPoint(-2F, 13F, 2F);
		this.Side1.setTextureSize(64, 32);
		this.Side1.mirror = true;
		this.setRotation(this.Side1, 0F, 0F, 0F);
		this.Side2 = new ModelRenderer(this, 34, 0);
		this.Side2.addBox(0F, 0F, 0F, 4, 4, 1);
		this.Side2.setRotationPoint(-2F, 13F, -3F);
		this.Side2.setTextureSize(64, 32);
		this.Side2.mirror = true;
		this.setRotation(this.Side2, 0F, 0F, 0F);
		this.Side3 = new ModelRenderer(this, 24, 5);
		this.Side3.addBox(0F, 0F, 0F, 1, 4, 4);
		this.Side3.setRotationPoint(-3F, 13F, -2F);
		this.Side3.setTextureSize(64, 32);
		this.Side3.mirror = true;
		this.setRotation(this.Side3, 0F, 0F, 0F);
		this.Side4 = new ModelRenderer(this, 34, 5);
		this.Side4.addBox(0F, 0F, 0F, 1, 4, 4);
		this.Side4.setRotationPoint(2F, 13F, -2F);
		this.Side4.setTextureSize(64, 32);
		this.Side4.mirror = true;
		this.setRotation(this.Side4, 0F, 0F, 0F);
		this.Liquid = new ModelRenderer(this, 48, 27);
		this.Liquid.addBox(0F, 0F, 0F, 4, 0, 4);
		this.Liquid.setRotationPoint(-2F, 14F, -2F);
		this.Liquid.setTextureSize(64, 32);
		this.Liquid.mirror = true;
		this.setRotation(this.Liquid, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Base.render(f5);
		this.Stem.render(f5);
		this.CupBase.render(f5);
		this.CupSubBaseA.render(f5);
		this.CupSubBaseB.render(f5);
		this.CupSubBaseC.render(f5);
		this.CupSubBaseD.render(f5);
		this.Side1.render(f5);
		this.Side2.render(f5);
		this.Side3.render(f5);
		this.Side4.render(f5);
		this.Liquid.render(f5);
	}
	
	public void renderModel(float f)
	{
		this.Base.render(f);
		this.Stem.render(f);
		this.CupBase.render(f);
		this.CupSubBaseA.render(f);
		this.CupSubBaseB.render(f);
		this.CupSubBaseC.render(f);
		this.CupSubBaseD.render(f);
		this.Side1.render(f);
		this.Side2.render(f);
		this.Side3.render(f);
		this.Side4.render(f);
		this.Liquid.render(f);
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
