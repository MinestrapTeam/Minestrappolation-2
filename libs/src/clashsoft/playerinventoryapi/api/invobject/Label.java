package clashsoft.playerinventoryapi.api.invobject;

import net.minecraft.client.Minecraft;

public class Label implements IInventoryObject
{
	public String	text;
	public int		x;
	public int		y;
	public int		color;
	
	public Label(String s, int x, int y)
	{
		this(s, x, y, 4210752);
	}
	
	public Label(String s, int x, int y, int color)
	{
		this.text = s;
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	@Override
	public void render(int width, int height)
	{
		Minecraft.getMinecraft().fontRenderer.drawString(this.text, this.x, this.y, this.color);
	}
}
