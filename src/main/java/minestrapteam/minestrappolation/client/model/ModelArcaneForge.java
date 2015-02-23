package minestrapteam.minestrappolation.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelArcaneForge extends ModelBase
{
	public ModelRenderer	pillar1;
	public ModelRenderer	pillar2;
	public ModelRenderer	pillar3;
	public ModelRenderer	pillar4;
	public ModelRenderer	pillar5;
	public ModelRenderer	pillar6;
	public ModelRenderer	pillar7;
	public ModelRenderer	pillar8;
	public ModelRenderer	gem1;
	public ModelRenderer	gem2;
	public ModelRenderer	gem3;
	public ModelRenderer	gem4;
	public ModelRenderer	gem5;
	public ModelRenderer	gem6;
	public ModelRenderer	gem7;
	public ModelRenderer	gem8;
	
	public ModelArcaneForge()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		
		this.pillar1 = new ModelRenderer(this, 0, 0);
		this.pillar1.addBox(0F, 0F, 0F, 2, 11, 2);
		this.pillar1.setRotationPoint(-8F, 13F, 6F);
		this.pillar1.setTextureSize(64, 32);
		this.pillar1.mirror = true;
		this.setRotation(this.pillar1, 0F, 0F, 0F);
		this.pillar2 = new ModelRenderer(this, 0, 0);
		this.pillar2.addBox(0F, 0F, 0F, 2, 11, 2);
		this.pillar2.setRotationPoint(6F, 13F, 6F);
		this.pillar2.setTextureSize(64, 32);
		this.pillar2.mirror = true;
		this.setRotation(this.pillar2, 0F, 0F, 0F);
		this.pillar3 = new ModelRenderer(this, 0, 0);
		this.pillar3.addBox(0F, 0F, 0F, 2, 11, 2);
		this.pillar3.setRotationPoint(6F, 13F, -8F);
		this.pillar3.setTextureSize(64, 32);
		this.pillar3.mirror = true;
		this.setRotation(this.pillar3, 0F, 0F, 0F);
		this.pillar4 = new ModelRenderer(this, 0, 0);
		this.pillar4.addBox(0F, 0F, 0F, 2, 11, 2);
		this.pillar4.setRotationPoint(-8F, 13F, -8F);
		this.pillar4.setTextureSize(64, 32);
		this.pillar4.mirror = true;
		this.setRotation(this.pillar4, 0F, 0F, 0F);
		this.pillar5 = new ModelRenderer(this, 0, 0);
		this.pillar5.addBox(0F, 0F, 0F, 2, 11, 2);
		this.pillar5.setRotationPoint(6F, 13F, -1F);
		this.pillar5.setTextureSize(64, 32);
		this.pillar5.mirror = true;
		this.setRotation(this.pillar5, 0F, 0F, 0F);
		this.pillar6 = new ModelRenderer(this, 0, 0);
		this.pillar6.addBox(0F, 0F, 0F, 2, 11, 2);
		this.pillar6.setRotationPoint(-1F, 13F, -8F);
		this.pillar6.setTextureSize(64, 32);
		this.pillar6.mirror = true;
		this.setRotation(this.pillar6, 0F, 0F, 0F);
		this.pillar7 = new ModelRenderer(this, 0, 0);
		this.pillar7.addBox(0F, 0F, 0F, 2, 11, 2);
		this.pillar7.setRotationPoint(-8F, 13F, -1F);
		this.pillar7.setTextureSize(64, 32);
		this.pillar7.mirror = true;
		this.setRotation(this.pillar7, 0F, 0F, 0F);
		this.pillar8 = new ModelRenderer(this, 0, 0);
		this.pillar8.addBox(0F, 0F, 0F, 2, 11, 2);
		this.pillar8.setRotationPoint(-1F, 13F, 6F);
		this.pillar8.setTextureSize(64, 32);
		this.pillar8.mirror = true;
		this.setRotation(this.pillar8, 0F, 0F, 0F);
		this.gem1 = new ModelRenderer(this, 42, 0);
		this.gem1.addBox(0F, 0F, -2F, 2, 2, 2);
		this.gem1.setRotationPoint(-7F, 9F, 7F);
		this.gem1.setTextureSize(64, 32);
		this.gem1.mirror = true;
		this.setRotation(this.gem1, 0.7853982F, 0.7853982F, 0.7853982F);
		this.gem2 = new ModelRenderer(this, 42, 4);
		this.gem2.addBox(0F, 0F, -2F, 2, 2, 2);
		this.gem2.setRotationPoint(7F, 9F, 7F);
		this.gem2.setTextureSize(64, 32);
		this.gem2.mirror = true;
		this.setRotation(this.gem2, 0.7853982F, 0.7853982F, 0.7853982F);
		this.gem3 = new ModelRenderer(this, 42, 8);
		this.gem3.addBox(0F, 0F, -2F, 2, 2, 2);
		this.gem3.setRotationPoint(7F, 9F, -7F);
		this.gem3.setTextureSize(64, 32);
		this.gem3.mirror = true;
		this.setRotation(this.gem3, 0.7853982F, 0.7853982F, 0.7853982F);
		this.gem4 = new ModelRenderer(this, 50, 0);
		this.gem4.addBox(0F, 0F, -2F, 2, 2, 2);
		this.gem4.setRotationPoint(-7F, 9F, -7F);
		this.gem4.setTextureSize(64, 32);
		this.gem4.mirror = true;
		this.setRotation(this.gem4, 0.7853982F, 0.7853982F, 0.7853982F);
		this.gem5 = new ModelRenderer(this, 50, 4);
		this.gem5.addBox(0F, 0F, -2F, 2, 2, 2);
		this.gem5.setRotationPoint(7F, 9F, 0F);
		this.gem5.setTextureSize(64, 32);
		this.gem5.mirror = true;
		this.setRotation(this.gem5, 0.7853982F, 0.7853982F, 0.7853982F);
		this.gem6 = new ModelRenderer(this, 50, 8);
		this.gem6.addBox(0F, 0F, -2F, 2, 2, 2);
		this.gem6.setRotationPoint(0F, 9F, -7F);
		this.gem6.setTextureSize(64, 32);
		this.gem6.mirror = true;
		this.setRotation(this.gem6, 0.7853982F, 0.7853982F, 0.7853982F);
		this.gem7 = new ModelRenderer(this, 0, 24);
		this.gem7.addBox(0F, 0F, -2F, 2, 2, 2);
		this.gem7.setRotationPoint(-7F, 9F, 0F);
		this.gem7.setTextureSize(64, 32);
		this.gem7.mirror = true;
		this.setRotation(this.gem7, 0.7853982F, 0.7853982F, 0.7853982F);
		this.gem8 = new ModelRenderer(this, 8, 24);
		this.gem8.addBox(0F, 0F, -2F, 2, 2, 2);
		this.gem8.setRotationPoint(0F, 9F, 7F);
		this.gem8.setTextureSize(64, 32);
		this.gem8.mirror = true;
		this.setRotation(this.gem8, 0.7853982F, 0.7853982F, 0.7853982F);
	}
	
	public void render(float f)
	{
		this.pillar1.render(f);
		this.pillar2.render(f);
		this.pillar3.render(f);
		this.pillar4.render(f);
		this.pillar5.render(f);
		this.pillar6.render(f);
		this.pillar7.render(f);
		this.pillar8.render(f);
		this.gem1.render(f);
		this.gem2.render(f);
		this.gem3.render(f);
		this.gem4.render(f);
		this.gem5.render(f);
		this.gem6.render(f);
		this.gem7.render(f);
		this.gem8.render(f);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
