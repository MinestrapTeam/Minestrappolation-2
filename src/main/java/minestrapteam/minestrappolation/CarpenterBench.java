// Date: 8/2/2014 4:41:33 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.minecraft.src;

public class ModelCarpenter Bench extends ModelBase
{
  //fields
    ModelRenderer Top;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer SideBack;
    ModelRenderer SideLeft;
    ModelRenderer SideRight;
    ModelRenderer Drawr;
    ModelRenderer Handle1;
    ModelRenderer Handle2;
    ModelRenderer HandleBar;
    ModelRenderer SawHandle1;
    ModelRenderer SawHandle2;
    ModelRenderer SawHandle3;
    ModelRenderer SawBlade1;
    ModelRenderer SawBlade2;
    ModelRenderer SawBlade3;
    ModelRenderer AxeBlade1;
    ModelRenderer AxeBlade2;
    ModelRenderer AxeHandle;
  
  public ModelCarpenter Bench()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Top = new ModelRenderer(this, 0, 0);
      Top.addBox(0F, 0F, 0F, 16, 4, 16);
      Top.setRotationPoint(-8F, 8F, -8F);
      Top.setTextureSize(128, 64);
      Top.mirror = true;
      setRotation(Top, 0F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 64, 0);
      Leg1.addBox(0F, 0F, 0F, 3, 12, 3);
      Leg1.setRotationPoint(-7F, 12F, -7F);
      Leg1.setTextureSize(128, 64);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 76, 0);
      Leg2.addBox(0F, 0F, 0F, 3, 12, 3);
      Leg2.setRotationPoint(4F, 12F, -7F);
      Leg2.setTextureSize(128, 64);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg3 = new ModelRenderer(this, 88, 0);
      Leg3.addBox(0F, 0F, 0F, 3, 12, 3);
      Leg3.setRotationPoint(-7F, 12F, 4F);
      Leg3.setTextureSize(128, 64);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      Leg4 = new ModelRenderer(this, 100, 0);
      Leg4.addBox(0F, 0F, 0F, 3, 12, 3);
      Leg4.setRotationPoint(4F, 12F, 4F);
      Leg4.setTextureSize(128, 64);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      SideBack = new ModelRenderer(this, 0, 20);
      SideBack.addBox(0F, 0F, 0F, 8, 8, 1);
      SideBack.setRotationPoint(-4F, 12F, 5F);
      SideBack.setTextureSize(128, 64);
      SideBack.mirror = true;
      setRotation(SideBack, 0F, 0F, 0F);
      SideLeft = new ModelRenderer(this, 18, 20);
      SideLeft.addBox(0F, 0F, 0F, 1, 8, 8);
      SideLeft.setRotationPoint(-6F, 12F, -4F);
      SideLeft.setTextureSize(128, 64);
      SideLeft.mirror = true;
      setRotation(SideLeft, 0F, 0F, 0F);
      SideRight = new ModelRenderer(this, 36, 20);
      SideRight.addBox(0F, 0F, 0F, 1, 8, 8);
      SideRight.setRotationPoint(5F, 12F, -4F);
      SideRight.setTextureSize(128, 64);
      SideRight.mirror = true;
      setRotation(SideRight, 0F, 0F, 0F);
      Drawr = new ModelRenderer(this, 64, 15);
      Drawr.addBox(0F, 0F, 0F, 10, 5, 10);
      Drawr.setRotationPoint(-5F, 12F, -5F);
      Drawr.setTextureSize(128, 64);
      Drawr.mirror = true;
      setRotation(Drawr, 0F, 0F, 0F);
      Handle1 = new ModelRenderer(this, 0, 30);
      Handle1.addBox(0F, 0F, 0F, 1, 1, 1);
      Handle1.setRotationPoint(-2F, 14F, -6F);
      Handle1.setTextureSize(128, 64);
      Handle1.mirror = true;
      setRotation(Handle1, 0F, 0F, 0F);
      Handle2 = new ModelRenderer(this, 0, 30);
      Handle2.addBox(0F, 0F, 0F, 1, 1, 1);
      Handle2.setRotationPoint(1F, 14F, -6F);
      Handle2.setTextureSize(128, 64);
      Handle2.mirror = true;
      setRotation(Handle2, 0F, 0F, 0F);
      HandleBar = new ModelRenderer(this, 0, 32);
      HandleBar.addBox(0F, 0F, 0F, 4, 1, 1);
      HandleBar.setRotationPoint(-2F, 14F, -7F);
      HandleBar.setTextureSize(128, 64);
      HandleBar.mirror = true;
      setRotation(HandleBar, 0F, 0F, 0F);
      SawHandle1 = new ModelRenderer(this, 55, 21);
      SawHandle1.addBox(0F, 0F, 0F, 1, 1, 3);
      SawHandle1.setRotationPoint(6F, 13F, -1F);
      SawHandle1.setTextureSize(128, 64);
      SawHandle1.mirror = true;
      setRotation(SawHandle1, 0F, 0F, 0F);
      SawHandle2 = new ModelRenderer(this, 55, 25);
      SawHandle2.addBox(0F, 0F, 0F, 1, 1, 1);
      SawHandle2.setRotationPoint(6F, 14F, -1F);
      SawHandle2.setTextureSize(128, 64);
      SawHandle2.mirror = true;
      setRotation(SawHandle2, 0F, 0F, 0F);
      SawHandle3 = new ModelRenderer(this, 55, 25);
      SawHandle3.addBox(0F, 0F, 0F, 1, 1, 1);
      SawHandle3.setRotationPoint(6F, 14F, 1F);
      SawHandle3.setTextureSize(128, 64);
      SawHandle3.mirror = true;
      setRotation(SawHandle3, 0F, 0F, 0F);
      SawBlade1 = new ModelRenderer(this, 55, 27);
      SawBlade1.addBox(0F, 0F, 0F, 1, 3, 3);
      SawBlade1.setRotationPoint(6F, 15F, -1F);
      SawBlade1.setTextureSize(128, 64);
      SawBlade1.mirror = true;
      setRotation(SawBlade1, 0F, 0F, 0F);
      SawBlade2 = new ModelRenderer(this, 55, 33);
      SawBlade2.addBox(0F, 0F, 0F, 1, 2, 2);
      SawBlade2.setRotationPoint(6F, 18F, 0F);
      SawBlade2.setTextureSize(128, 64);
      SawBlade2.mirror = true;
      setRotation(SawBlade2, 0F, 0F, 0F);
      SawBlade3 = new ModelRenderer(this, 55, 37);
      SawBlade3.addBox(0F, 0F, 0F, 1, 2, 1);
      SawBlade3.setRotationPoint(6F, 20F, 1F);
      SawBlade3.setTextureSize(128, 64);
      SawBlade3.mirror = true;
      setRotation(SawBlade3, 0F, 0F, 0F);
      AxeBlade1 = new ModelRenderer(this, 0, 35);
      AxeBlade1.addBox(0F, 0F, 0F, 1, 1, 2);
      AxeBlade1.setRotationPoint(-7F, 17F, 0F);
      AxeBlade1.setTextureSize(128, 64);
      AxeBlade1.mirror = true;
      setRotation(AxeBlade1, 0F, 0F, 0F);
      AxeBlade2 = new ModelRenderer(this, 0, 38);
      AxeBlade2.addBox(0F, 0F, 0F, 1, 3, 1);
      AxeBlade2.setRotationPoint(-7F, 16F, -1F);
      AxeBlade2.setTextureSize(128, 64);
      AxeBlade2.mirror = true;
      setRotation(AxeBlade2, 0F, 0F, 0F);
      AxeHandle = new ModelRenderer(this, 0, 42);
      AxeHandle.addBox(0F, 0F, 0F, 1, 4, 1);
      AxeHandle.setRotationPoint(-7F, 13F, 0F);
      AxeHandle.setTextureSize(128, 64);
      AxeHandle.mirror = true;
      setRotation(AxeHandle, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Top.render(f5);
    Leg1.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
    Leg4.render(f5);
    SideBack.render(f5);
    SideLeft.render(f5);
    SideRight.render(f5);
    Drawr.render(f5);
    Handle1.render(f5);
    Handle2.render(f5);
    HandleBar.render(f5);
    SawHandle1.render(f5);
    SawHandle2.render(f5);
    SawHandle3.render(f5);
    SawBlade1.render(f5);
    SawBlade2.render(f5);
    SawBlade3.render(f5);
    AxeBlade1.render(f5);
    AxeBlade2.render(f5);
    AxeHandle.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}
