package sobiohazardous.minestrappolation.extradecor.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGoblet extends ModelBase
{
//fields
 ModelRenderer Base;
 ModelRenderer Stem;
 ModelRenderer CupBase;
 ModelRenderer CupSubBaseA;
 ModelRenderer CupSubBaseB;
 ModelRenderer CupSubBaseC;
 ModelRenderer CupSubBaseD;
 ModelRenderer Side1;
 ModelRenderer Side2;
 ModelRenderer Side3;
 ModelRenderer Side4;
 ModelRenderer Liquid;

public ModelGoblet()
{
 textureWidth = 64;
 textureHeight = 32;
 
   Base = new ModelRenderer(this, 0, 0);
   Base.addBox(0F, 0F, 0F, 4, 1, 4);
   Base.setRotationPoint(-2F, 23F, -2F);
   Base.setTextureSize(64, 32);
   Base.mirror = true;
   setRotation(Base, 0F, 0F, 0F);
   Stem = new ModelRenderer(this, 16, 0);
   Stem.addBox(0F, 0F, 0F, 2, 4, 2);
   Stem.setRotationPoint(-1F, 19F, -1F);
   Stem.setTextureSize(64, 32);
   Stem.mirror = true;
   setRotation(Stem, 0F, 0F, 0F);
   CupBase = new ModelRenderer(this, 0, 0);
   CupBase.addBox(0F, 0F, 0F, 4, 1, 4);
   CupBase.setRotationPoint(-2F, 18F, -2F);
   CupBase.setTextureSize(64, 32);
   CupBase.mirror = true;
   setRotation(CupBase, 0F, 0F, 0F);
   CupSubBaseA = new ModelRenderer(this, 0, 5);
   CupSubBaseA.addBox(0F, 0F, 0F, 4, 1, 2);
   CupSubBaseA.setRotationPoint(-2F, 17F, 1F);
   CupSubBaseA.setTextureSize(64, 32);
   CupSubBaseA.mirror = true;
   setRotation(CupSubBaseA, 0F, 0F, 0F);
   CupSubBaseB = new ModelRenderer(this, 0, 5);
   CupSubBaseB.addBox(0F, 0F, 0F, 4, 1, 2);
   CupSubBaseB.setRotationPoint(-2F, 17F, -3F);
   CupSubBaseB.setTextureSize(64, 32);
   CupSubBaseB.mirror = true;
   setRotation(CupSubBaseB, 0F, 0F, 0F);
   CupSubBaseC = new ModelRenderer(this, 0, 8);
   CupSubBaseC.addBox(0F, 0F, 0F, 2, 1, 4);
   CupSubBaseC.setRotationPoint(-3F, 17F, -2F);
   CupSubBaseC.setTextureSize(64, 32);
   CupSubBaseC.mirror = true;
   setRotation(CupSubBaseC, 0F, 0F, 0F);
   CupSubBaseD = new ModelRenderer(this, 0, 8);
   CupSubBaseD.addBox(0F, 0F, 0F, 2, 1, 4);
   CupSubBaseD.setRotationPoint(1F, 17F, -2F);
   CupSubBaseD.setTextureSize(64, 32);
   CupSubBaseD.mirror = true;
   setRotation(CupSubBaseD, 0F, 0F, 0F);
   Side1 = new ModelRenderer(this, 24, 0);
   Side1.addBox(0F, 0F, 0F, 4, 4, 1);
   Side1.setRotationPoint(-2F, 13F, 2F);
   Side1.setTextureSize(64, 32);
   Side1.mirror = true;
   setRotation(Side1, 0F, 0F, 0F);
   Side2 = new ModelRenderer(this, 34, 0);
   Side2.addBox(0F, 0F, 0F, 4, 4, 1);
   Side2.setRotationPoint(-2F, 13F, -3F);
   Side2.setTextureSize(64, 32);
   Side2.mirror = true;
   setRotation(Side2, 0F, 0F, 0F);
   Side3 = new ModelRenderer(this, 24, 5);
   Side3.addBox(0F, 0F, 0F, 1, 4, 4);
   Side3.setRotationPoint(-3F, 13F, -2F);
   Side3.setTextureSize(64, 32);
   Side3.mirror = true;
   setRotation(Side3, 0F, 0F, 0F);
   Side4 = new ModelRenderer(this, 34, 5);
   Side4.addBox(0F, 0F, 0F, 1, 4, 4);
   Side4.setRotationPoint(2F, 13F, -2F);
   Side4.setTextureSize(64, 32);
   Side4.mirror = true;
   setRotation(Side4, 0F, 0F, 0F);
   Liquid = new ModelRenderer(this, 48, 28);
   Liquid.addBox(0F, 0F, 0F, 4, 0, 4);
   Liquid.setRotationPoint(-2F, 14F, -2F);
   Liquid.setTextureSize(64, 32);
   Liquid.mirror = true;
   setRotation(Liquid, 0F, 0F, 0F);
}

public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
{
 super.render(entity, f, f1, f2, f3, f4, f5);
 setRotationAngles(f, f1, f2, f3, f4, f5, entity);
 Base.render(f5);
 Stem.render(f5);
 CupBase.render(f5);
 CupSubBaseA.render(f5);
 CupSubBaseB.render(f5);
 CupSubBaseC.render(f5);
 CupSubBaseD.render(f5);
 Side1.render(f5);
 Side2.render(f5);
 Side3.render(f5);
 Side4.render(f5);
 Liquid.render(f5);
}

public void renderModel(float f) {
	Base.render(f);
	 Stem.render(f);
	 CupBase.render(f);
	 CupSubBaseA.render(f);
	 CupSubBaseB.render(f);
	 CupSubBaseC.render(f);
	 CupSubBaseD.render(f);
	 Side1.render(f);
	 Side2.render(f);
	 Side3.render(f);
	 Side4.render(f);
	 Liquid.render(f);
}


private void setRotation(ModelRenderer model, float x, float y, float z)
{
 model.rotateAngleX = x;
 model.rotateAngleY = y;
 model.rotateAngleZ = z;
}

public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
{
 super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
}

}
