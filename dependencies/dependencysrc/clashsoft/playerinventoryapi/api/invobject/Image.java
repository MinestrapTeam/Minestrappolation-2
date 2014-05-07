package clashsoft.playerinventoryapi.api.invobject;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class Image implements IInventoryObject
{
	@SideOnly(Side.CLIENT)
	protected static GuiScreen	gui	= new GuiScreen();
	
	public ResourceLocation		image;
	public int					x, y, u, v, width, height;
	
	public Image(ResourceLocation resource, int x, int y, int width, int height)
	{
		this(resource, x, y, 0, 0, width, height);
	}
	
	public Image(ResourceLocation resource, int x, int y, int u, int v, int width, int height)
	{
		this.image = resource;
		this.x = x;
		this.y = y;
		this.u = u;
		this.v = v;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void render(int width, int height)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(this.image);
		gui.drawTexturedModalRect(0, 0, this.u, this.v, this.width, this.height);
	}
}
