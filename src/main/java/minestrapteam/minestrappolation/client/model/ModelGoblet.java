package minestrapteam.minestrappolation.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;

public class ModelGoblet extends ModelBase
{
	private ModelRenderer	base;
	private ModelRenderer	stem;
	private ModelRenderer	cupBase;
	private ModelRenderer	cupBase1;
	private ModelRenderer	cupBase2;
	private ModelRenderer	cupBase3;
	private ModelRenderer	cupBase4;
	private ModelRenderer	side1;
	private ModelRenderer	side2;
	private ModelRenderer	side3;
	private ModelRenderer	side4;
	private ModelRenderer	liquid;
	
	public ModelGoblet()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		
		this.base = new ModelRenderer(this, 0, 0);
		this.base.addBox(0F, 0F, 0F, 4, 1, 4);
		this.base.setRotationPoint(-2F, 23F, -2F);
		this.base.setTextureSize(64, 32);
		this.base.mirror = true;
		this.setRotation(this.base, 0F, 0F, 0F);
		
		this.stem = new ModelRenderer(this, 16, 0);
		this.stem.addBox(0F, 0F, 0F, 2, 4, 2);
		this.stem.setRotationPoint(-1F, 19F, -1F);
		this.stem.setTextureSize(64, 32);
		this.stem.mirror = true;
		this.setRotation(this.stem, 0F, 0F, 0F);
		
		this.cupBase = new ModelRenderer(this, 0, 0);
		this.cupBase.addBox(0F, 0F, 0F, 4, 1, 4);
		this.cupBase.setRotationPoint(-2F, 18F, -2F);
		this.cupBase.setTextureSize(64, 32);
		this.cupBase.mirror = true;
		this.setRotation(this.cupBase, 0F, 0F, 0F);
		
		this.cupBase1 = new ModelRenderer(this, 0, 5);
		this.cupBase1.addBox(0F, 0F, 0F, 4, 1, 2);
		this.cupBase1.setRotationPoint(-2F, 17F, 1F);
		this.cupBase1.setTextureSize(64, 32);
		this.cupBase1.mirror = true;
		this.setRotation(this.cupBase1, 0F, 0F, 0F);
		
		this.cupBase2 = new ModelRenderer(this, 0, 5);
		this.cupBase2.addBox(0F, 0F, 0F, 4, 1, 2);
		this.cupBase2.setRotationPoint(-2F, 17F, -3F);
		this.cupBase2.setTextureSize(64, 32);
		this.cupBase2.mirror = true;
		this.setRotation(this.cupBase2, 0F, 0F, 0F);
		
		this.cupBase3 = new ModelRenderer(this, 0, 8);
		this.cupBase3.addBox(0F, 0F, 0F, 2, 1, 4);
		this.cupBase3.setRotationPoint(-3F, 17F, -2F);
		this.cupBase3.setTextureSize(64, 32);
		this.cupBase3.mirror = true;
		this.setRotation(this.cupBase3, 0F, 0F, 0F);
		
		this.cupBase4 = new ModelRenderer(this, 0, 8);
		this.cupBase4.addBox(0F, 0F, 0F, 2, 1, 4);
		this.cupBase4.setRotationPoint(1F, 17F, -2F);
		this.cupBase4.setTextureSize(64, 32);
		this.cupBase4.mirror = true;
		this.setRotation(this.cupBase4, 0F, 0F, 0F);
		
		this.side1 = new ModelRenderer(this, 24, 0);
		this.side1.addBox(0F, 0F, 0F, 4, 4, 1);
		this.side1.setRotationPoint(-2F, 13F, 2F);
		this.side1.setTextureSize(64, 32);
		this.side1.mirror = true;
		this.setRotation(this.side1, 0F, 0F, 0F);
		
		this.side2 = new ModelRenderer(this, 34, 0);
		this.side2.addBox(0F, 0F, 0F, 4, 4, 1);
		this.side2.setRotationPoint(-2F, 13F, -3F);
		this.side2.setTextureSize(64, 32);
		this.side2.mirror = true;
		this.setRotation(this.side2, 0F, 0F, 0F);
		
		this.side3 = new ModelRenderer(this, 24, 5);
		this.side3.addBox(0F, 0F, 0F, 1, 4, 4);
		this.side3.setRotationPoint(-3F, 13F, -2F);
		this.side3.setTextureSize(64, 32);
		this.side3.mirror = true;
		this.setRotation(this.side3, 0F, 0F, 0F);
		
		this.side4 = new ModelRenderer(this, 34, 5);
		this.side4.addBox(0F, 0F, 0F, 1, 4, 4);
		this.side4.setRotationPoint(2F, 13F, -2F);
		this.side4.setTextureSize(64, 32);
		this.side4.mirror = true;
		this.setRotation(this.side4, 0F, 0F, 0F);
		
		this.liquid = new ModelRenderer(this, 48, 27);
		this.liquid.addBox(0F, 0F, 0F, 4, 0, 4);
		this.liquid.setRotationPoint(-2F, 14F, -2F);
		this.liquid.setTextureSize(64, 32);
		this.liquid.mirror = true;
		this.setRotation(this.liquid, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.render(f5, 0xFFFFFF);
	}
	
	public void render(float f, int color)
	{
		this.base.render(f);
		this.stem.render(f);
		this.cupBase.render(f);
		this.cupBase1.render(f);
		this.cupBase2.render(f);
		this.cupBase3.render(f);
		this.cupBase4.render(f);
		this.side1.render(f);
		this.side2.render(f);
		this.side3.render(f);
		this.side4.render(f);
		
		Tessellator.instance.setColorOpaque_I(color);
		this.liquid.render(f);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
