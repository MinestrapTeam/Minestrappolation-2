package minestrapteam.minestrappolation.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHangGlider extends ModelBase
{
	// fields
	ModelRenderer	Mainstrut;
	ModelRenderer	Sidestrut1;
	ModelRenderer	Sidestrut2;
	ModelRenderer	Bottomstrut;
	ModelRenderer	Handlebar;
	ModelRenderer	WingA;
	ModelRenderer	WingB;
	ModelRenderer	WingC;
	ModelRenderer	WingD;
	ModelRenderer	WingE;
	ModelRenderer	WingF;
	ModelRenderer	WingG;
	ModelRenderer	WingH;
	ModelRenderer	WingI;
	ModelRenderer	WingJ;
	ModelRenderer	WingK;
	ModelRenderer	WingL;
	ModelRenderer	WingM;
	ModelRenderer	WingN;
	ModelRenderer	WingO;
	ModelRenderer	WingP;
	
	public ModelHangGlider()
	{
		this.textureWidth = 128;
		this.textureHeight = 64;
		
		this.Mainstrut = new ModelRenderer(this, 36, 3);
		this.Mainstrut.addBox(0F, 0F, 0F, 4, 4, 32);
		this.Mainstrut.setRotationPoint(-2F, -12F, -8F);
		this.Mainstrut.setTextureSize(128, 64);
		this.Mainstrut.mirror = true;
		this.setRotation(this.Mainstrut, 0F, 0F, 0F);
		this.Sidestrut1 = new ModelRenderer(this, 0, 0);
		this.Sidestrut1.addBox(0F, 0F, -30F, 3, 3, 30);
		this.Sidestrut1.setRotationPoint(-2F, -11.5F, 24F);
		this.Sidestrut1.setTextureSize(128, 64);
		this.Sidestrut1.mirror = true;
		this.setRotation(this.Sidestrut1, 0F, 0.5235988F, 0F);
		this.Sidestrut2 = new ModelRenderer(this, 0, 0);
		this.Sidestrut2.addBox(-3F, 0F, -30F, 3, 3, 30);
		this.Sidestrut2.setRotationPoint(2F, -11.5F, 24F);
		this.Sidestrut2.setTextureSize(128, 64);
		this.Sidestrut2.mirror = true;
		this.setRotation(this.Sidestrut2, 0F, -0.5235988F, 0F);
		this.Bottomstrut = new ModelRenderer(this, 38, 0);
		this.Bottomstrut.addBox(-1F, -2F, -12F, 2, 2, 12);
		this.Bottomstrut.setRotationPoint(0F, -8F, 24F);
		this.Bottomstrut.setTextureSize(128, 64);
		this.Bottomstrut.mirror = true;
		this.setRotation(this.Bottomstrut, 1.047198F, 0F, 0F);
		this.Handlebar = new ModelRenderer(this, 44, 16);
		this.Handlebar.addBox(-5F, -1.5F, -11.5F, 10, 1, 1);
		this.Handlebar.setRotationPoint(0F, -8F, 24F);
		this.Handlebar.setTextureSize(128, 64);
		this.Handlebar.mirror = true;
		this.setRotation(this.Handlebar, 1.047198F, 0F, 0F);
		this.WingA = new ModelRenderer(this, 0, 0);
		this.WingA.addBox(0F, 0F, 0F, 8, 1, 2);
		this.WingA.setRotationPoint(-4F, -11F, 18F);
		this.WingA.setTextureSize(128, 64);
		this.WingA.mirror = true;
		this.setRotation(this.WingA, 0F, 0F, 0F);
		this.WingB = new ModelRenderer(this, 0, 3);
		this.WingB.addBox(0F, 0F, 0F, 10, 1, 2);
		this.WingB.setRotationPoint(-5F, -11F, 16F);
		this.WingB.setTextureSize(128, 64);
		this.WingB.mirror = true;
		this.setRotation(this.WingB, 0F, 0F, 0F);
		this.WingC = new ModelRenderer(this, 0, 6);
		this.WingC.addBox(0F, 0F, 0F, 12, 1, 2);
		this.WingC.setRotationPoint(-6F, -11F, 14F);
		this.WingC.setTextureSize(128, 64);
		this.WingC.mirror = true;
		this.setRotation(this.WingC, 0F, 0F, 0F);
		this.WingD = new ModelRenderer(this, 0, 33);
		this.WingD.addBox(0F, 0F, 0F, 14, 1, 2);
		this.WingD.setRotationPoint(-7F, -11F, 12F);
		this.WingD.setTextureSize(128, 64);
		this.WingD.mirror = true;
		this.setRotation(this.WingD, 0F, 0F, 0F);
		this.WingE = new ModelRenderer(this, 0, 36);
		this.WingE.addBox(0F, 0F, 0F, 16, 1, 2);
		this.WingE.setRotationPoint(-8F, -11F, 10F);
		this.WingE.setTextureSize(128, 64);
		this.WingE.mirror = true;
		this.setRotation(this.WingE, 0F, 0F, 0F);
		this.WingF = new ModelRenderer(this, 0, 39);
		this.WingF.addBox(0F, 0F, 0F, 18, 1, 2);
		this.WingF.setRotationPoint(-9F, -11F, 8F);
		this.WingF.setTextureSize(128, 64);
		this.WingF.mirror = true;
		this.setRotation(this.WingF, 0F, 0F, 0F);
		this.WingG = new ModelRenderer(this, 0, 42);
		this.WingG.addBox(0F, 0F, 0F, 20, 1, 2);
		this.WingG.setRotationPoint(-10F, -11F, 6F);
		this.WingG.setTextureSize(128, 64);
		this.WingG.mirror = true;
		this.setRotation(this.WingG, 0F, 0F, 0F);
		this.WingH = new ModelRenderer(this, 0, 45);
		this.WingH.addBox(0F, 0F, 0F, 22, 1, 2);
		this.WingH.setRotationPoint(-11F, -11F, 4F);
		this.WingH.setTextureSize(128, 64);
		this.WingH.mirror = true;
		this.setRotation(this.WingH, 0F, 0F, 0F);
		this.WingI = new ModelRenderer(this, 0, 48);
		this.WingI.addBox(0F, 0F, 0F, 24, 1, 2);
		this.WingI.setRotationPoint(-12F, -11F, 2F);
		this.WingI.setTextureSize(128, 64);
		this.WingI.mirror = true;
		this.setRotation(this.WingI, 0F, 0F, 0F);
		this.WingJ = new ModelRenderer(this, 0, 51);
		this.WingJ.addBox(0F, 0F, 0F, 26, 1, 2);
		this.WingJ.setRotationPoint(-13F, -11F, 0F);
		this.WingJ.setTextureSize(128, 64);
		this.WingJ.mirror = true;
		this.setRotation(this.WingJ, 0F, 0F, 0F);
		this.WingK = new ModelRenderer(this, 0, 54);
		this.WingK.addBox(0F, 0F, 0F, 28, 1, 2);
		this.WingK.setRotationPoint(-14F, -11F, -2F);
		this.WingK.setTextureSize(128, 64);
		this.WingK.mirror = true;
		this.setRotation(this.WingK, 0F, 0F, 0F);
		this.WingL = new ModelRenderer(this, 62, 39);
		this.WingL.addBox(0F, 0F, 0F, 22, 1, 1);
		this.WingL.setRotationPoint(-11F, -11F, -3F);
		this.WingL.setTextureSize(128, 64);
		this.WingL.mirror = true;
		this.setRotation(this.WingL, 0F, 0F, 0F);
		this.WingM = new ModelRenderer(this, 74, 41);
		this.WingM.addBox(0F, 0F, 0F, 16, 1, 1);
		this.WingM.setRotationPoint(-8F, -11F, -4F);
		this.WingM.setTextureSize(128, 64);
		this.WingM.mirror = true;
		this.setRotation(this.WingM, 0F, 0F, 0F);
		this.WingN = new ModelRenderer(this, 82, 43);
		this.WingN.addBox(0F, 0F, 0F, 12, 1, 1);
		this.WingN.setRotationPoint(-6F, -11F, -5F);
		this.WingN.setTextureSize(128, 64);
		this.WingN.mirror = true;
		this.setRotation(this.WingN, 0F, 0F, 0F);
		this.WingO = new ModelRenderer(this, 90, 45);
		this.WingO.addBox(0F, 0F, 0F, 8, 1, 1);
		this.WingO.setRotationPoint(-4F, -11F, -6F);
		this.WingO.setTextureSize(128, 64);
		this.WingO.mirror = true;
		this.setRotation(this.WingO, 0F, 0F, 0F);
		this.WingP = new ModelRenderer(this, 94, 47);
		this.WingP.addBox(0F, 0F, 0F, 6, 1, 1);
		this.WingP.setRotationPoint(-3F, -11F, -7F);
		this.WingP.setTextureSize(128, 64);
		this.WingP.mirror = true;
		this.setRotation(this.WingP, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.render(f5);
	}
	
	public void render(float f5)
	{
		this.Mainstrut.render(f5);
		this.Sidestrut1.render(f5);
		this.Sidestrut2.render(f5);
		this.Bottomstrut.render(f5);
		this.Handlebar.render(f5);
		this.WingA.render(f5);
		this.WingB.render(f5);
		this.WingC.render(f5);
		this.WingD.render(f5);
		this.WingE.render(f5);
		this.WingF.render(f5);
		this.WingG.render(f5);
		this.WingH.render(f5);
		this.WingI.render(f5);
		this.WingJ.render(f5);
		this.WingK.render(f5);
		this.WingL.render(f5);
		this.WingM.render(f5);
		this.WingN.render(f5);
		this.WingO.render(f5);
		this.WingP.render(f5);
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
