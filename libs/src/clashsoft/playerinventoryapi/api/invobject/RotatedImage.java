package clashsoft.playerinventoryapi.api.invobject;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class RotatedImage extends RotatableObject
{
	public ResourceLocation	image;
	public int				x, y, u, v, width, height;
	
	public RotatedImage(ResourceLocation resource, int x, int y, int width, int height)
	{
		this(resource, x, y, 0, 0, width, height);
	}
	
	public RotatedImage(ResourceLocation resource, int x, int y, int u, int v, int width, int height)
	{
		this.image = resource;
		this.x = x;
		this.y = y;
		this.u = u;
		this.v = v;
		this.width = width;
		this.height = height;
	}
	
	public RotatedImage setRotation(float rotation)
	{
		this.rotation = rotation;
		return this;
	}
	
	@Override
	public void renderRotated(int width, int height)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(this.image);
		Image.gui.drawTexturedModalRect(0, 0, this.u, this.v, this.width, this.width);
	}
	
	@Override
	public int getX()
	{
		return this.x;
	}
	
	@Override
	public int getY()
	{
		return this.y;
	}
	
	@Override
	public int getWidth()
	{
		return this.width;
	}
	
	@Override
	public int getHeight()
	{
		return this.height;
	}
}
