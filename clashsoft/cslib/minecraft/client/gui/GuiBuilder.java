package clashsoft.cslib.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class GuiBuilder extends Gui
{
	public static final ResourceLocation	slots							= new ResourceLocation("cslib", "textures/gui/container/slots.png");
	public static final ResourceLocation	progress						= new ResourceLocation("cslib", "textures/gui/container/progress.png");
	public static final ResourceLocation	window							= new ResourceLocation("cslib", "textures/gui/container/window.png");
	public static final ResourceLocation	widgets							= new ResourceLocation("cslib", "textures/gui/container/widgets.png");
	
	public static final GuiBuilder			global							= new GuiBuilder(null);
	
	public static int						hoveringFrameDefaultColor		= 0x5000FF;
	public static int						hoveringFrameBackgroundColor	= 0x10000F;
	public static int						hoveringFrameAlpha				= 0x0000B0;
	
	public final Gui						gui;
	public final Minecraft					mc;
	
	public int								width;
	public int								height;
	
	public GuiBuilder(Gui gui)
	{
		this.gui = gui;
		this.mc = Minecraft.getMinecraft();
	}
	
	public void bind(ResourceLocation resourceLocation)
	{
		this.mc.renderEngine.bindTexture(resourceLocation);
	}
	
	public void drawFrame(int x, int y, int width, int height)
	{
		bind(window);
		drawFrame_(x, y, width, height);
	}
	
	public void drawFrame_(int x, int y, int width, int height)
	{
		boolean flag1 = width > 176;
		boolean flag2 = height > 166;
		
		int i = width - 4;
		int j = height - 4;
		int k = flag1 ? 172 : i;
		int l = flag2 ? 162 : j;
		
		this.drawTexturedModalRect(x, y, 0, 0, k, l);
		this.drawTexturedModalRect(x + i, y, 172, 0, 4, l);
		this.drawTexturedModalRect(x, y + j, 0, 162, k, 4);
		this.drawTexturedModalRect(x + i, y + j, 172, 162, 4, 4);
		
		if (flag1)
		{
			int x1 = x + 172;
			int k1 = i - 172;
			this.drawTexturedModalRect(x1, y, 4, 0, k1, l);
			this.drawTexturedModalRect(x1, y + j, 4, 162, k1, 4);
		}
		if (flag2)
		{
			int y1 = y + 162;
			int l1 = j - 162;
			this.drawTexturedModalRect(x, y1, 0, 4, k, l1);
			this.drawTexturedModalRect(x + i, y1, 172, 4, 4, l1);
			
			if (flag1)
			{
				this.drawTexturedModalRect(x + 172, y1, 4, 4, i - 172, l1);
			}
		}
	}
	
	public void drawPlayerBackgroundL(int x, int y)
	{
		drawWidget(x, y, 0, 0, 54, 72);
	}
	
	public void drawPlayerBackgroundS(int x, int y)
	{
		drawWidget(x, y, 54, 0, 34, 45);
	}
	
	public void drawWidget(int x, int y, int u, int v, int width, int height)
	{
		bind(widgets);
		drawWidget_(x, y, u, v, width, height);
	}
	
	public void drawWidget_(int x, int y, int u, int v, int width, int height)
	{
		this.drawTexturedModalRect(x, y, u, v, width, height);
	}
	
	public void drawSlots(int[] x, int[] y)
	{
		this.bind(slots);
		for (int i = 0; i < x.length; i++)
		{
			this.drawSlot_(x[i], y[i], 0, false);
		}
	}
	
	public void drawSlots(int[] x, int[] y, int[] type)
	{
		this.bind(slots);
		for (int i = 0; i < x.length; i++)
		{
			this.drawSlot_(x[i], y[i], type[i], false);
		}
	}
	
	public void drawSlots(int[] x, int[] y, int[] type, boolean[] locked)
	{
		this.bind(slots);
		for (int i = 0; i < x.length; i++)
		{
			this.drawSlot_(x[i], y[i], type[i], locked[i]);
		}
	}
	
	public void drawSlot(int x, int y)
	{
		this.drawSlot(x, y, 0);
	}
	
	public void drawSlot(int x, int y, int type)
	{
		this.drawSlot(x, y, type, false);
	}
	
	public void drawSlot(int x, int y, int type, boolean locked)
	{
		this.bind(slots);
		this.drawSlot_(x - 4, y - 4, type, locked);
	}
	
	public void drawSlot_(int x, int y, int type, boolean locked)
	{
		this.drawTexturedModalRect(x, y, type * 32, locked ? 32 : 0, 32, 32);
	}
	
	public void drawHoveringFrame(int x, int y, int width, int height)
	{
		this.drawHoveringFrame(x, y, width, height, hoveringFrameDefaultColor);
	}
	
	public void drawHoveringFrame(int x, int y, int width, int height, int color)
	{
		this.drawHoveringFrame(x, y, width, height, color, hoveringFrameBackgroundColor, hoveringFrameAlpha);
	}
	
	public void drawHoveringFrame(int x, int y, int width, int height, int color, int bg, int alpha)
	{
		if (width < 2 || height < 2)
		{
			return;
		}
		
		color = color & 0xFFFFFF;
		bg = bg & 0xFFFFFF;
		alpha = (alpha & 0xFF) << 24;
		
		int bgAlpha = bg | alpha;
		int colorAlpha = color | alpha;
		int colorGradient = (color & 0xFEFEFE) >> 1 | alpha;
		
		// Render gray rects
		drawRect(x + 1, y, x + width - 1, y + 1, bgAlpha);
		drawRect(x + 1, y + height - 1, x + width - 1, y + height, bgAlpha);
		drawRect(x + 2, y + 2, x + width - 2, y + height - 2, bgAlpha);
		drawRect(x, y + 1, x + 1, y + height - 1, bgAlpha);
		drawRect(x + width - 1, y + 1, x + width, y + height - 1, bgAlpha);
		
		// Render colored rects
		drawGradientRect(x + 1, y + 2, x + 2, y + height - 2, colorAlpha, colorGradient);
		drawGradientRect(x + width - 2, y + 2, x + width - 1, y + height - 2, colorAlpha, colorGradient);
		drawRect(x + 1, y + 1, x + width - 1, y + 2, colorAlpha);
		drawRect(x + 1, y + height - 2, x + width - 1, y + height - 1, colorGradient);
	}
}
