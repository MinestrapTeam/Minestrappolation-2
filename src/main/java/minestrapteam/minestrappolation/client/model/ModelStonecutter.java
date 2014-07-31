package minestrapteam.minestrappolation.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelStonecutter extends ModelBase
{
	private ModelRenderer	blade1;
	private ModelRenderer	blade2;
	private ModelRenderer	blade3;
	private ModelRenderer	blade4;
	private ModelRenderer	blade5;
	private ModelRenderer	blade6;
	private ModelRenderer	blade7;
	private ModelRenderer	blade8;
	private ModelRenderer	blade9;
	private ModelRenderer	blade10;
	private ModelRenderer	blade11;
	private ModelRenderer	blade12;
	private ModelRenderer	blade13;
	
	public ModelStonecutter()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
		
		this.blade1 = new ModelRenderer(this, 0, 0);
		this.blade1.addBox(0F, 0F, 0F, 2, 1, 1);
		this.blade1.setRotationPoint(-2F, 8F, 4F);
		this.blade1.setTextureSize(64, 64);
		this.blade1.mirror = true;
		this.setRotation(this.blade1, 0F, 0F, 0F);
		this.blade2 = new ModelRenderer(this, 0, 3);
		this.blade2.addBox(0F, 0F, 0F, 5, 1, 1);
		this.blade2.setRotationPoint(-2F, 8F, 3F);
		this.blade2.setTextureSize(64, 64);
		this.blade2.mirror = true;
		this.setRotation(this.blade2, 0F, 0F, 0F);
		this.blade3 = new ModelRenderer(this, 0, 6);
		this.blade3.addBox(0F, 0F, 0F, 4, 1, 1);
		this.blade3.setRotationPoint(-2F, 8F, 2F);
		this.blade3.setTextureSize(64, 64);
		this.blade3.mirror = true;
		this.setRotation(this.blade3, 0F, 0F, 0F);
		this.blade4 = new ModelRenderer(this, 0, 31);
		this.blade4.addBox(0F, 0F, 0F, 9, 1, 1);
		this.blade4.setRotationPoint(-4F, 8F, 1F);
		this.blade4.setTextureSize(64, 64);
		this.blade4.mirror = true;
		this.setRotation(this.blade4, 0F, 0F, 0F);
		this.blade5 = new ModelRenderer(this, 6, 0);
		this.blade5.addBox(0F, 0F, 0F, 1, 1, 1);
		this.blade5.setRotationPoint(-4F, 8F, 2F);
		this.blade5.setTextureSize(64, 64);
		this.blade5.mirror = true;
		this.setRotation(this.blade5, 0F, 0F, 0F);
		this.blade6 = new ModelRenderer(this, 0, 9);
		this.blade6.addBox(0F, 0F, 0F, 4, 1, 1);
		this.blade6.setRotationPoint(1F, 8F, 0F);
		this.blade6.setTextureSize(64, 64);
		this.blade6.mirror = true;
		this.setRotation(this.blade6, 0F, 0F, 0F);
		this.blade7 = new ModelRenderer(this, 0, 34);
		this.blade7.addBox(0F, 0F, 0F, 3, 1, 1);
		this.blade7.setRotationPoint(-4F, 8F, 0F);
		this.blade7.setTextureSize(64, 64);
		this.blade7.mirror = true;
		this.setRotation(this.blade7, 0F, 0F, 0F);
		this.blade8 = new ModelRenderer(this, 0, 12);
		this.blade8.addBox(0F, 0F, 0F, 4, 1, 1);
		this.blade8.setRotationPoint(-5F, 8F, -1F);
		this.blade8.setTextureSize(64, 64);
		this.blade8.mirror = true;
		this.setRotation(this.blade8, 0F, 0F, 0F);
		this.blade9 = new ModelRenderer(this, 10, 0);
		this.blade9.addBox(0F, 0F, 0F, 2, 1, 1);
		this.blade9.setRotationPoint(1F, 8F, -1F);
		this.blade9.setTextureSize(64, 64);
		this.blade9.mirror = true;
		this.setRotation(this.blade9, 0F, 0F, 0F);
		this.blade10 = new ModelRenderer(this, 20, 31);
		this.blade10.addBox(0F, 0F, 0F, 9, 1, 1);
		this.blade10.setRotationPoint(-5F, 8F, -2F);
		this.blade10.setTextureSize(64, 64);
		this.blade10.mirror = true;
		this.setRotation(this.blade10, 0F, 0F, 0F);
		this.blade11 = new ModelRenderer(this, 8, 34);
		this.blade11.addBox(0F, 0F, 0F, 6, 1, 1);
		this.blade11.setRotationPoint(-2F, 8F, -3F);
		this.blade11.setTextureSize(64, 64);
		this.blade11.mirror = true;
		this.setRotation(this.blade11, 0F, 0F, 0F);
		this.blade12 = new ModelRenderer(this, 22, 34);
		this.blade12.addBox(0F, 0F, 0F, 5, 1, 1);
		this.blade12.setRotationPoint(-3F, 8F, -4F);
		this.blade12.setTextureSize(64, 64);
		this.blade12.mirror = true;
		this.setRotation(this.blade12, 0F, 0F, 0F);
		this.blade13 = new ModelRenderer(this, 10, 6);
		this.blade13.addBox(0F, 0F, 0F, 2, 1, 1);
		this.blade13.setRotationPoint(0F, 8F, -5F);
		this.blade13.setTextureSize(64, 64);
		this.blade13.mirror = true;
		this.setRotation(this.blade13, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.blade1.render(f5);
		this.blade2.render(f5);
		this.blade3.render(f5);
		this.blade4.render(f5);
		this.blade5.render(f5);
		this.blade6.render(f5);
		this.blade7.render(f5);
		this.blade8.render(f5);
		this.blade9.render(f5);
		this.blade10.render(f5);
		this.blade11.render(f5);
		this.blade12.render(f5);
		this.blade13.render(f5);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
