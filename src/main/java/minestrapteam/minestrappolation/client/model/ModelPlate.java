package minestrapteam.minestrappolation.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPlate extends ModelBase
{
	private ModelRenderer	base;
	private ModelRenderer	plate1;
	private ModelRenderer	plate2;
	private ModelRenderer	plate3;
	private ModelRenderer	plate4;
	private ModelRenderer	plate5;
	private ModelRenderer	plate6;
	private ModelRenderer	plate7;
	private ModelRenderer	plate8;
	private ModelRenderer	plate9;
	
	public ModelPlate()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		
		this.base = new ModelRenderer(this, 0, 0);
		this.base.addBox(0F, 0F, 0F, 8, 1, 8);
		this.base.setRotationPoint(-4F, 23F, -4F);
		this.base.setTextureSize(64, 32);
		this.base.mirror = true;
		this.setRotation(this.base, 0F, 0F, 0F);
		this.plate1 = new ModelRenderer(this, 0, 9);
		this.plate1.addBox(0F, 0F, 0F, 16, 1, 6);
		this.plate1.setRotationPoint(-8F, 22F, -3F);
		this.plate1.setTextureSize(64, 32);
		this.plate1.mirror = true;
		this.setRotation(this.plate1, 0F, 0F, 0F);
		this.plate2 = new ModelRenderer(this, 0, 16);
		this.plate2.addBox(0F, 0F, 0F, 14, 1, 2);
		this.plate2.setRotationPoint(-7F, 22F, 3F);
		this.plate2.setTextureSize(64, 32);
		this.plate2.mirror = true;
		this.setRotation(this.plate2, 0F, 0F, 0F);
		this.plate3 = new ModelRenderer(this, 0, 19);
		this.plate3.addBox(0F, 0F, 0F, 14, 1, 2);
		this.plate3.setRotationPoint(-7F, 22F, -5F);
		this.plate3.setTextureSize(64, 32);
		this.plate3.mirror = true;
		this.setRotation(this.plate3, 0F, 0F, 0F);
		this.plate4 = new ModelRenderer(this, 0, 22);
		this.plate4.addBox(0F, 0F, 0F, 12, 1, 1);
		this.plate4.setRotationPoint(-6F, 22F, 5F);
		this.plate4.setTextureSize(64, 32);
		this.plate4.mirror = true;
		this.setRotation(this.plate4, 0F, 0F, 0F);
		this.plate5 = new ModelRenderer(this, 0, 24);
		this.plate5.addBox(0F, 0F, 0F, 12, 1, 1);
		this.plate5.setRotationPoint(-6F, 22F, -6F);
		this.plate5.setTextureSize(64, 32);
		this.plate5.mirror = true;
		this.setRotation(this.plate5, 0F, 0F, 0F);
		this.plate6 = new ModelRenderer(this, 0, 26);
		this.plate6.addBox(0F, 0F, 0F, 10, 1, 1);
		this.plate6.setRotationPoint(-5F, 22F, 6F);
		this.plate6.setTextureSize(64, 32);
		this.plate6.mirror = true;
		this.setRotation(this.plate6, 0F, 0F, 0F);
		this.plate7 = new ModelRenderer(this, 0, 28);
		this.plate7.addBox(0F, 0F, 0F, 10, 1, 1);
		this.plate7.setRotationPoint(-5F, 22F, -7F);
		this.plate7.setTextureSize(64, 32);
		this.plate7.mirror = true;
		this.setRotation(this.plate7, 0F, 0F, 0F);
		this.plate8 = new ModelRenderer(this, 32, 0);
		this.plate8.addBox(0F, 0F, 0F, 6, 1, 1);
		this.plate8.setRotationPoint(-3F, 22F, 7F);
		this.plate8.setTextureSize(64, 32);
		this.plate8.mirror = true;
		this.setRotation(this.plate8, 0F, 0F, 0F);
		this.plate9 = new ModelRenderer(this, 32, 2);
		this.plate9.addBox(0F, 0F, 0F, 6, 1, 1);
		this.plate9.setRotationPoint(-3F, 22F, -8F);
		this.plate9.setTextureSize(64, 32);
		this.plate9.mirror = true;
		this.setRotation(this.plate9, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.render(f5);
	}
	
	public void render(float f)
	{
		this.base.render(f);
		this.plate1.render(f);
		this.plate2.render(f);
		this.plate3.render(f);
		this.plate4.render(f);
		this.plate5.render(f);
		this.plate6.render(f);
		this.plate7.render(f);
		this.plate8.render(f);
		this.plate9.render(f);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
