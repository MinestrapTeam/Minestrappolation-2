package minestrapteam.minestrappolation.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSawmill extends ModelBase
{
	private ModelRenderer	top;
	private ModelRenderer	leg1;
	private ModelRenderer	leg2;
	private ModelRenderer	leg3;
	private ModelRenderer	leg4;
	private ModelRenderer	sideBack;
	private ModelRenderer	sideLeft;
	private ModelRenderer	sideRight;
	private ModelRenderer	drawr;
	private ModelRenderer	handle1;
	private ModelRenderer	handle2;
	private ModelRenderer	handleBar;
	private ModelRenderer	sawHandle1;
	private ModelRenderer	sawHandle2;
	private ModelRenderer	sawHandle3;
	private ModelRenderer	sawBlade1;
	private ModelRenderer	sawBlade2;
	private ModelRenderer	sawBlade3;
	private ModelRenderer	axeBlade1;
	private ModelRenderer	axeBlade2;
	private ModelRenderer	axeHandle;
	
	public ModelSawmill()
	{
		this.textureWidth = 128;
		this.textureHeight = 64;
		
		this.top = new ModelRenderer(this, 0, 0);
		this.top.addBox(0F, 0F, 0F, 16, 4, 16);
		this.top.setRotationPoint(-8F, 8F, -8F);
		this.top.setTextureSize(128, 64);
		this.top.mirror = true;
		this.setRotation(this.top, 0F, 0F, 0F);
		this.leg1 = new ModelRenderer(this, 64, 0);
		this.leg1.addBox(0F, 0F, 0F, 3, 12, 3);
		this.leg1.setRotationPoint(-7F, 12F, -7F);
		this.leg1.setTextureSize(128, 64);
		this.leg1.mirror = true;
		this.setRotation(this.leg1, 0F, 0F, 0F);
		this.leg2 = new ModelRenderer(this, 76, 0);
		this.leg2.addBox(0F, 0F, 0F, 3, 12, 3);
		this.leg2.setRotationPoint(4F, 12F, -7F);
		this.leg2.setTextureSize(128, 64);
		this.leg2.mirror = true;
		this.setRotation(this.leg2, 0F, 0F, 0F);
		this.leg3 = new ModelRenderer(this, 88, 0);
		this.leg3.addBox(0F, 0F, 0F, 3, 12, 3);
		this.leg3.setRotationPoint(-7F, 12F, 4F);
		this.leg3.setTextureSize(128, 64);
		this.leg3.mirror = true;
		this.setRotation(this.leg3, 0F, 0F, 0F);
		this.leg4 = new ModelRenderer(this, 100, 0);
		this.leg4.addBox(0F, 0F, 0F, 3, 12, 3);
		this.leg4.setRotationPoint(4F, 12F, 4F);
		this.leg4.setTextureSize(128, 64);
		this.leg4.mirror = true;
		this.setRotation(this.leg4, 0F, 0F, 0F);
		this.sideBack = new ModelRenderer(this, 0, 20);
		this.sideBack.addBox(0F, 0F, 0F, 8, 8, 1);
		this.sideBack.setRotationPoint(-4F, 12F, 5F);
		this.sideBack.setTextureSize(128, 64);
		this.sideBack.mirror = true;
		this.setRotation(this.sideBack, 0F, 0F, 0F);
		this.sideLeft = new ModelRenderer(this, 18, 20);
		this.sideLeft.addBox(0F, 0F, 0F, 1, 8, 8);
		this.sideLeft.setRotationPoint(-6F, 12F, -4F);
		this.sideLeft.setTextureSize(128, 64);
		this.sideLeft.mirror = true;
		this.setRotation(this.sideLeft, 0F, 0F, 0F);
		this.sideRight = new ModelRenderer(this, 36, 20);
		this.sideRight.addBox(0F, 0F, 0F, 1, 8, 8);
		this.sideRight.setRotationPoint(5F, 12F, -4F);
		this.sideRight.setTextureSize(128, 64);
		this.sideRight.mirror = true;
		this.setRotation(this.sideRight, 0F, 0F, 0F);
		this.drawr = new ModelRenderer(this, 64, 15);
		this.drawr.addBox(0F, 0F, 0F, 10, 5, 10);
		this.drawr.setRotationPoint(-5F, 12F, -5F);
		this.drawr.setTextureSize(128, 64);
		this.drawr.mirror = true;
		this.setRotation(this.drawr, 0F, 0F, 0F);
		this.handle1 = new ModelRenderer(this, 0, 30);
		this.handle1.addBox(0F, 0F, 0F, 1, 1, 1);
		this.handle1.setRotationPoint(-2F, 14F, -6F);
		this.handle1.setTextureSize(128, 64);
		this.handle1.mirror = true;
		this.setRotation(this.handle1, 0F, 0F, 0F);
		this.handle2 = new ModelRenderer(this, 0, 30);
		this.handle2.addBox(0F, 0F, 0F, 1, 1, 1);
		this.handle2.setRotationPoint(1F, 14F, -6F);
		this.handle2.setTextureSize(128, 64);
		this.handle2.mirror = true;
		this.setRotation(this.handle2, 0F, 0F, 0F);
		this.handleBar = new ModelRenderer(this, 0, 32);
		this.handleBar.addBox(0F, 0F, 0F, 4, 1, 1);
		this.handleBar.setRotationPoint(-2F, 14F, -7F);
		this.handleBar.setTextureSize(128, 64);
		this.handleBar.mirror = true;
		this.setRotation(this.handleBar, 0F, 0F, 0F);
		this.sawHandle1 = new ModelRenderer(this, 55, 21);
		this.sawHandle1.addBox(0F, 0F, 0F, 1, 1, 3);
		this.sawHandle1.setRotationPoint(6F, 13F, -1F);
		this.sawHandle1.setTextureSize(128, 64);
		this.sawHandle1.mirror = true;
		this.setRotation(this.sawHandle1, 0F, 0F, 0F);
		this.sawHandle2 = new ModelRenderer(this, 55, 25);
		this.sawHandle2.addBox(0F, 0F, 0F, 1, 1, 1);
		this.sawHandle2.setRotationPoint(6F, 14F, -1F);
		this.sawHandle2.setTextureSize(128, 64);
		this.sawHandle2.mirror = true;
		this.setRotation(this.sawHandle2, 0F, 0F, 0F);
		this.sawHandle3 = new ModelRenderer(this, 55, 25);
		this.sawHandle3.addBox(0F, 0F, 0F, 1, 1, 1);
		this.sawHandle3.setRotationPoint(6F, 14F, 1F);
		this.sawHandle3.setTextureSize(128, 64);
		this.sawHandle3.mirror = true;
		this.setRotation(this.sawHandle3, 0F, 0F, 0F);
		this.sawBlade1 = new ModelRenderer(this, 55, 27);
		this.sawBlade1.addBox(0F, 0F, 0F, 1, 3, 3);
		this.sawBlade1.setRotationPoint(6F, 15F, -1F);
		this.sawBlade1.setTextureSize(128, 64);
		this.sawBlade1.mirror = true;
		this.setRotation(this.sawBlade1, 0F, 0F, 0F);
		this.sawBlade2 = new ModelRenderer(this, 55, 33);
		this.sawBlade2.addBox(0F, 0F, 0F, 1, 2, 2);
		this.sawBlade2.setRotationPoint(6F, 18F, 0F);
		this.sawBlade2.setTextureSize(128, 64);
		this.sawBlade2.mirror = true;
		this.setRotation(this.sawBlade2, 0F, 0F, 0F);
		this.sawBlade3 = new ModelRenderer(this, 55, 37);
		this.sawBlade3.addBox(0F, 0F, 0F, 1, 2, 1);
		this.sawBlade3.setRotationPoint(6F, 20F, 1F);
		this.sawBlade3.setTextureSize(128, 64);
		this.sawBlade3.mirror = true;
		this.setRotation(this.sawBlade3, 0F, 0F, 0F);
		this.axeBlade1 = new ModelRenderer(this, 0, 35);
		this.axeBlade1.addBox(0F, 0F, 0F, 1, 1, 2);
		this.axeBlade1.setRotationPoint(-7F, 17F, 0F);
		this.axeBlade1.setTextureSize(128, 64);
		this.axeBlade1.mirror = true;
		this.setRotation(this.axeBlade1, 0F, 0F, 0F);
		this.axeBlade2 = new ModelRenderer(this, 0, 38);
		this.axeBlade2.addBox(0F, 0F, 0F, 1, 3, 1);
		this.axeBlade2.setRotationPoint(-7F, 16F, -1F);
		this.axeBlade2.setTextureSize(128, 64);
		this.axeBlade2.mirror = true;
		this.setRotation(this.axeBlade2, 0F, 0F, 0F);
		this.axeHandle = new ModelRenderer(this, 0, 42);
		this.axeHandle.addBox(0F, 0F, 0F, 1, 4, 1);
		this.axeHandle.setRotationPoint(-7F, 13F, 0F);
		this.axeHandle.setTextureSize(128, 64);
		this.axeHandle.mirror = true;
		this.setRotation(this.axeHandle, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.top.render(f5);
		this.leg1.render(f5);
		this.leg2.render(f5);
		this.leg3.render(f5);
		this.leg4.render(f5);
		this.sideBack.render(f5);
		this.sideLeft.render(f5);
		this.sideRight.render(f5);
		this.drawr.render(f5);
		this.handle1.render(f5);
		this.handle2.render(f5);
		this.handleBar.render(f5);
		this.sawHandle1.render(f5);
		this.sawHandle2.render(f5);
		this.sawHandle3.render(f5);
		this.sawBlade1.render(f5);
		this.sawBlade2.render(f5);
		this.sawBlade3.render(f5);
		this.axeBlade1.render(f5);
		this.axeBlade2.render(f5);
		this.axeHandle.render(f5);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
