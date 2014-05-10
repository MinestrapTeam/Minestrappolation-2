package clashsoft.playerinventoryapi.api.invobject;

import net.minecraft.client.Minecraft;

public class RotatedLabel extends RotatableObject
{
	public String	text;
	public int		x;
	public int		y;
	public int		color;
	
	public RotatedLabel(String s, int x, int y)
	{
		this(s, x, y, 4210752);
	}
	
	public RotatedLabel(String s, int x, int y, int color)
	{
		this.text = s;
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public RotatedLabel setRotation(float rotation)
	{
		this.rotation = rotation;
		return this;
	}
	
	@Override
	public void renderRotated(int width, int height)
	{
		Minecraft.getMinecraft().fontRenderer.drawString(this.text, this.x, this.y, this.color);
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
		return Minecraft.getMinecraft().fontRenderer.getStringWidth(this.text);
	}
	
	@Override
	public int getHeight()
	{
		return Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT;
	}
}
