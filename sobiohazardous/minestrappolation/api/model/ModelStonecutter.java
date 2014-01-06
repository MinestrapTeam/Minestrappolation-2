package sobiohazardous.minestrappolation.api.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStonecutter extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer BladeA;
    ModelRenderer BladeB;
    ModelRenderer BladeC;
    ModelRenderer BladeD;
    ModelRenderer BladeE;
    ModelRenderer BladeF;
    ModelRenderer BladeG;
    ModelRenderer BladeH;
    ModelRenderer BladeI;
    ModelRenderer BladeJ;
    ModelRenderer BladeK;
    ModelRenderer BladeL;
    ModelRenderer BladeM;
  
  public ModelStonecutter()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(0F, 0F, 0F, 16, 15, 16);
      Base.setRotationPoint(-8F, 9F, -8F);
      Base.setTextureSize(64, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      BladeA = new ModelRenderer(this, 0, 0);
      BladeA.addBox(0F, 0F, 0F, 2, 2, 1);
      BladeA.setRotationPoint(-2F, 8F, 4F);
      BladeA.setTextureSize(64, 64);
      BladeA.mirror = true;
      setRotation(BladeA, 0F, 0F, 0F);
      BladeB = new ModelRenderer(this, 0, 3);
      BladeB.addBox(0F, 0F, 0F, 5, 2, 1);
      BladeB.setRotationPoint(-2F, 8F, 3F);
      BladeB.setTextureSize(64, 64);
      BladeB.mirror = true;
      setRotation(BladeB, 0F, 0F, 0F);
      BladeC = new ModelRenderer(this, 0, 6);
      BladeC.addBox(0F, 0F, 0F, 4, 2, 1);
      BladeC.setRotationPoint(-2F, 8F, 2F);
      BladeC.setTextureSize(64, 64);
      BladeC.mirror = true;
      setRotation(BladeC, 0F, 0F, 0F);
      BladeD = new ModelRenderer(this, 0, 31);
      BladeD.addBox(0F, 0F, 0F, 9, 2, 1);
      BladeD.setRotationPoint(-4F, 8F, 1F);
      BladeD.setTextureSize(64, 64);
      BladeD.mirror = true;
      setRotation(BladeD, 0F, 0F, 0F);
      BladeE = new ModelRenderer(this, 6, 0);
      BladeE.addBox(0F, 0F, 0F, 1, 2, 1);
      BladeE.setRotationPoint(-4F, 8F, 2F);
      BladeE.setTextureSize(64, 64);
      BladeE.mirror = true;
      setRotation(BladeE, 0F, 0F, 0F);
      BladeF = new ModelRenderer(this, 0, 9);
      BladeF.addBox(0F, 0F, 0F, 4, 2, 1);
      BladeF.setRotationPoint(1F, 8F, 0F);
      BladeF.setTextureSize(64, 64);
      BladeF.mirror = true;
      setRotation(BladeF, 0F, 0F, 0F);
      BladeG = new ModelRenderer(this, 0, 34);
      BladeG.addBox(0F, 0F, 0F, 3, 2, 1);
      BladeG.setRotationPoint(-4F, 8F, 0F);
      BladeG.setTextureSize(64, 64);
      BladeG.mirror = true;
      setRotation(BladeG, 0F, 0F, 0F);
      BladeH = new ModelRenderer(this, 0, 12);
      BladeH.addBox(0F, 0F, 0F, 4, 2, 1);
      BladeH.setRotationPoint(-5F, 8F, -1F);
      BladeH.setTextureSize(64, 64);
      BladeH.mirror = true;
      setRotation(BladeH, 0F, 0F, 0F);
      BladeI = new ModelRenderer(this, 10, 0);
      BladeI.addBox(0F, 0F, 0F, 2, 2, 1);
      BladeI.setRotationPoint(1F, 8F, -1F);
      BladeI.setTextureSize(64, 64);
      BladeI.mirror = true;
      setRotation(BladeI, 0F, 0F, 0F);
      BladeJ = new ModelRenderer(this, 20, 31);
      BladeJ.addBox(0F, 0F, 0F, 9, 2, 1);
      BladeJ.setRotationPoint(-5F, 8F, -2F);
      BladeJ.setTextureSize(64, 64);
      BladeJ.mirror = true;
      setRotation(BladeJ, 0F, 0F, 0F);
      BladeK = new ModelRenderer(this, 8, 34);
      BladeK.addBox(0F, 0F, 0F, 6, 2, 1);
      BladeK.setRotationPoint(-2F, 8F, -3F);
      BladeK.setTextureSize(64, 64);
      BladeK.mirror = true;
      setRotation(BladeK, 0F, 0F, 0F);
      BladeL = new ModelRenderer(this, 22, 34);
      BladeL.addBox(0F, 0F, 0F, 5, 2, 1);
      BladeL.setRotationPoint(-3F, 8F, -4F);
      BladeL.setTextureSize(64, 64);
      BladeL.mirror = true;
      setRotation(BladeL, 0F, 0F, 0F);
      BladeM = new ModelRenderer(this, 10, 6);
      BladeM.addBox(0F, 0F, 0F, 2, 2, 1);
      BladeM.setRotationPoint(0F, 8F, -5F);
      BladeM.setTextureSize(64, 64);
      BladeM.mirror = true;
      setRotation(BladeM, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base.render(f5);
    BladeA.render(f5);
    BladeB.render(f5);
    BladeC.render(f5);
    BladeD.render(f5);
    BladeE.render(f5);
    BladeF.render(f5);
    BladeG.render(f5);
    BladeH.render(f5);
    BladeI.render(f5);
    BladeJ.render(f5);
    BladeK.render(f5);
    BladeL.render(f5);
    BladeM.render(f5);
  }
  
  public void render(float f5)
  {    
	 Base.render(f5);
	 BladeA.render(f5);
	 BladeB.render(f5);
	 BladeC.render(f5);
	 BladeD.render(f5);
	 BladeE.render(f5);
	 BladeF.render(f5);
	 BladeG.render(f5);
	 BladeH.render(f5);
	 BladeI.render(f5);
	 BladeJ.render(f5);
	 BladeK.render(f5);
	 BladeL.render(f5);
	 BladeM.render(f5);
  }

  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
