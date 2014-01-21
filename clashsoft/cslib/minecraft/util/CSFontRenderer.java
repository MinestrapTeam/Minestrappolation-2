package clashsoft.cslib.minecraft.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.Bidi;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.ReloadableResourceManager;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class CSFontRenderer extends FontRenderer
{
	private static final ResourceLocation[]	field_111274_c		= new ResourceLocation[256];
	
	public static final CSFontRenderer		instance			= new CSFontRenderer(Minecraft.getMinecraft().gameSettings, new ResourceLocation("textures/font/ascii.png"), Minecraft.getMinecraft().renderEngine, false);
	static
	{
		((ReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(instance);
		
		if (Minecraft.getMinecraft().gameSettings.language != null)
		{
			instance.setUnicodeFlag(Minecraft.getMinecraft().getLanguageManager().isCurrentLocaleUnicode());
			instance.setBidiFlag(Minecraft.getMinecraft().getLanguageManager().isCurrentLanguageBidirectional());
		}
	}
	
	/** Array of width of all the characters in default.png */
	private final int[]						charWidth			= new int[256];
	
	/** the height in pixels of default text */
	public int								FONT_HEIGHT			= 9;
	public Random							fontRandom			= new Random();
	
	/**
	 * Array of the start/end column (in upper/lower nibble) for every glyph in
	 * the /font directory.
	 */
	private final byte[]					glyphWidth			= new byte[65536];
	
	/**
	 * Array of RGB triplets defining the 16 standard chat colors followed by 16
	 * darker version of the same colors for drop shadows.
	 */
	public int[]							colorCode			= new int[32];
	private final ResourceLocation			locationFontTexture;
	
	/** Current X coordinate at which to draw the next character. */
	private float							posX;
	
	/** Current Y coordinate at which to draw the next character. */
	private float							posY;
	
	/**
	 * If true, strings should be rendered with Unicode fonts instead of the
	 * default.png font
	 */
	private boolean							unicodeFlag;
	
	/**
	 * If true, the Unicode Bidirectional Algorithm should be run before
	 * rendering any string.
	 */
	private boolean							bidiFlag;
	
	/** Used to specify new red value for the current color. */
	private float							red;
	
	/** Used to specify new blue value for the current color. */
	private float							blue;
	
	/** Used to specify new green value for the current color. */
	private float							green;
	
	/** Used to specify new alpha value for the current color. */
	private float							alpha;
	
	/** Text color of the currently rendering string. */
	private int								textColor;
	
	/** Set if the "k" style (random) is active in currently rendering string */
	private boolean							randomStyle			= false;
	
	/** Set if the "l" style (bold) is active in currently rendering string */
	private boolean							boldStyle			= false;
	
	/** Set if the "o" style (italic) is active in currently rendering string */
	private boolean							italicStyle			= false;
	
	/**
	 * Set if the "n" style (underlined) is active in currently rendering string
	 */
	private boolean							underlineStyle		= false;
	
	/**
	 * Set if the "m" style (strikethrough) is active in currently rendering
	 * string
	 */
	private boolean							strikethroughStyle	= false;
	
	private TextureManager					renderEngine;
	
	public CSFontRenderer(GameSettings gameSettings, ResourceLocation fontTexture, TextureManager textureManager, boolean unicode)
	{
		super(gameSettings, fontTexture, textureManager, unicode);
		this.locationFontTexture = fontTexture;
		this.renderEngine = textureManager;
		this.unicodeFlag = unicode;
		textureManager.bindTexture(this.locationFontTexture);
		
		for (int i = 0; i < 32; ++i)
		{
			int j = (i >> 3 & 1) * 85;
			int k = (i >> 2 & 1) * 170 + j;
			int l = (i >> 1 & 1) * 170 + j;
			int i1 = (i >> 0 & 1) * 170 + j;
			
			if (i == 6)
			{
				k += 85;
			}
			
			if (gameSettings.anaglyph)
			{
				int j1 = (k * 30 + l * 59 + i1 * 11) / 100;
				int k1 = (k * 30 + l * 70) / 100;
				int l1 = (k * 30 + i1 * 70) / 100;
				k = j1;
				l = k1;
				i1 = l1;
			}
			
			if (i >= 16)
			{
				k /= 4;
				l /= 4;
				i1 /= 4;
			}
			
			this.colorCode[i] = (k & 255) << 16 | (l & 255) << 8 | i1 & 255;
		}
		
		this.readGlyphSizes();
	}
	
	@Override
	public void onResourceManagerReload(ResourceManager resourceManager)
	{
		this.readFontTexture();
	}
	
	private void readFontTexture()
	{
		BufferedImage bufferedimage;
		
		try
		{
			bufferedimage = ImageIO.read(Minecraft.getMinecraft().getResourceManager().getResource(this.locationFontTexture).getInputStream());
		}
		catch (IOException ioexception)
		{
			throw new RuntimeException(ioexception);
		}
		
		int i = bufferedimage.getWidth();
		int j = bufferedimage.getHeight();
		int[] aint = new int[i * j];
		bufferedimage.getRGB(0, 0, i, j, aint, 0, i);
		int k = j / 16;
		int l = i / 16;
		byte b0 = 1;
		float f = 8.0F / l;
		int i1 = 0;
		
		while (i1 < 256)
		{
			int j1 = i1 % 16;
			int k1 = i1 / 16;
			
			if (i1 == 32)
			{
				this.charWidth[i1] = 3 + b0;
			}
			
			int l1 = l - 1;
			
			while (true)
			{
				if (l1 >= 0)
				{
					int i2 = j1 * l + l1;
					boolean flag = true;
					
					for (int j2 = 0; j2 < k && flag; ++j2)
					{
						int k2 = (k1 * l + j2) * i;
						
						if ((aint[i2 + k2] >> 24 & 255) != 0)
						{
							flag = false;
						}
					}
					
					if (flag)
					{
						--l1;
						continue;
					}
				}
				
				++l1;
				this.charWidth[i1] = (int) (0.5D + l1 * f) + b0;
				++i1;
				break;
			}
		}
	}
	
	private void readGlyphSizes()
	{
		try
		{
			InputStream inputstream = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("font/glyph_sizes.bin")).getInputStream();
			inputstream.read(this.glyphWidth);
		}
		catch (IOException ioexception)
		{
			throw new RuntimeException(ioexception);
		}
	}
	
	public static CSFontRenderer getFontRenderer()
	{
		return instance;
	}
	
	/**
	 * Pick how to render a single character and return the width used.
	 */
	private float renderCharAtPos(int i, char c, boolean italic)
	{
		return c == 32 ? 4.0F : (i > 0 && !this.unicodeFlag ? this.renderDefaultChar(i + 32, italic) : this.renderUnicodeChar(c, italic));
	}
	
	/**
	 * Render a single character with the default.png font at current
	 * (posX,posY) location...
	 */
	private float renderDefaultChar(int i, boolean italic)
	{
		float scale = 2F;
		float f = i % 16 * 8;
		float f1 = i / 16 * 8;
		float f2 = (italic ? 1.0F : 0.0F);
		// Bind texture
		Minecraft.getMinecraft().renderEngine.bindTexture(this.locationFontTexture);
		float f3 = (this.charWidth[i] - 0.01F);
		
		GL11.glBegin(GL11.GL_TRIANGLE_STRIP);
		GL11.glTexCoord2f((f / 128.0F), (f1 / 128.0F));
		GL11.glVertex3f(this.posX + f2, this.posY, 0.0F);
		GL11.glTexCoord2f((f / 128.0F), ((f1 + 7.99F) / 128.0F));
		GL11.glVertex3f(this.posX - f2, this.posY + 7.99F, 0.0F);
		GL11.glTexCoord2f(((f + f3) / 128.0F), (f1 / 128.0F));
		GL11.glVertex3f(this.posX + f3 + f2, this.posY, 0.0F);
		GL11.glTexCoord2f(((f + f3) / 128.0F), ((f1 + 7.99F) / 128.0F));
		GL11.glVertex3f((this.posX + f3 - f2), this.posY + 7.99F, 0.0F);
		GL11.glEnd();
		
		return this.charWidth[i];
	}
	
	/**
	 * Load one of the /font/glyph_XX.png into a new GL texture and store the
	 * texture ID in glyphTextureName array.
	 */
	private void loadGlyphTexture(int i)
	{
		this.renderEngine.bindTexture(this.func_111271_a(i));
	}
	
	private ResourceLocation func_111271_a(int i)
	{
		if (field_111274_c[i] == null)
		{
			field_111274_c[i] = new ResourceLocation(String.format("textures/font/unicode_page_%02x.png", new Object[] { Integer.valueOf(i) }));
		}
		
		return field_111274_c[i];
	}
	
	/**
	 * Render a single Unicode character at current (posX,posY) location using
	 * one of the /font/glyph_XX.png files...
	 */
	private float renderUnicodeChar(char c, boolean italic)
	{
		if (this.glyphWidth[c] == 0)
		{
			return 0.0F;
		}
		else
		{
			int i = c / 256;
			this.loadGlyphTexture(i);
			int j = this.glyphWidth[c] >>> 4;
			int k = this.glyphWidth[c] & 15;
			float f = j;
			float f1 = k + 1;
			float f2 = c % 16 * 16 + f;
			float f3 = (c & 255) / 16 * 16;
			float f4 = f1 - f - 0.02F;
			float f5 = italic ? 1.0F : 0.0F;
			GL11.glBegin(GL11.GL_TRIANGLE_STRIP);
			GL11.glTexCoord2f(f2 / 256.0F, f3 / 256.0F);
			GL11.glVertex3f(this.posX + f5, this.posY, 0.0F);
			GL11.glTexCoord2f(f2 / 256.0F, (f3 + 15.98F) / 256.0F);
			GL11.glVertex3f(this.posX - f5, this.posY + 7.99F, 0.0F);
			GL11.glTexCoord2f((f2 + f4) / 256.0F, f3 / 256.0F);
			GL11.glVertex3f(this.posX + f4 / 2.0F + f5, this.posY, 0.0F);
			GL11.glTexCoord2f((f2 + f4) / 256.0F, (f3 + 15.98F) / 256.0F);
			GL11.glVertex3f(this.posX + f4 / 2.0F - f5, this.posY + 7.99F, 0.0F);
			GL11.glEnd();
			return (f1 - f) / 2.0F + 1.0F;
		}
	}
	
	@Override
	/**
	 * Draws the specified string with a shadow.
	 */
	public int drawStringWithShadow(String string, int x, int y, int color)
	{
		return this.drawString(string, x, y, color, true);
	}
	
	@Override
	/**
	 * Draws the specified string.
	 */
	public int drawString(String string, int x, int y, int color)
	{
		return this.drawString(string, x, y, color, false);
	}
	
	@Override
	/**
	 * Draws the specified string. Args: string, x, y, color, dropShadow
	 */
	public int drawString(String string, int x, int y, int color, boolean shadow)
	{
		this.resetStyles();
		
		if (this.bidiFlag)
		{
			string = this.bidiReorder(string);
		}
		
		int l;
		
		if (shadow)
		{
			l = this.renderString(string, x + 1, y + 1, color, true);
			l = Math.max(l, this.renderString(string, x, y, color, false));
		}
		else
		{
			l = this.renderString(string, x, y, color, false);
		}
		
		return l;
	}
	
	/**
	 * Apply Unicode Bidirectional Algorithm to string and return a new possibly
	 * reordered string for visual rendering.
	 */
	private String bidiReorder(String string)
	{
		if (string != null && Bidi.requiresBidi(string.toCharArray(), 0, string.length()))
		{
			Bidi bidi = new Bidi(string, -2);
			byte[] abyte = new byte[bidi.getRunCount()];
			String[] astring = new String[abyte.length];
			int i;
			
			for (int j = 0; j < abyte.length; ++j)
			{
				int k = bidi.getRunStart(j);
				i = bidi.getRunLimit(j);
				int l = bidi.getRunLevel(j);
				String s1 = string.substring(k, i);
				abyte[j] = (byte) l;
				astring[j] = s1;
			}
			
			String[] astring1 = astring.clone();
			Bidi.reorderVisually(abyte, 0, astring, 0, abyte.length);
			StringBuilder stringbuilder = new StringBuilder();
			i = 0;
			
			while (i < astring.length)
			{
				byte b0 = abyte[i];
				int i1 = 0;
				
				while (true)
				{
					if (i1 < astring1.length)
					{
						if (!astring1[i1].equals(astring[i]))
						{
							++i1;
							continue;
						}
						
						b0 = abyte[i1];
					}
					
					if ((b0 & 1) == 0)
					{
						stringbuilder.append(astring[i]);
					}
					else
					{
						for (i1 = astring[i].length() - 1; i1 >= 0; --i1)
						{
							char c0 = astring[i].charAt(i1);
							
							if (c0 == 40)
							{
								c0 = 41;
							}
							else if (c0 == 41)
							{
								c0 = 40;
							}
							
							stringbuilder.append(c0);
						}
					}
					
					++i;
					break;
				}
			}
			
			return stringbuilder.toString();
		}
		else
		{
			return string;
		}
	}
	
	/**
	 * Reset all style flag fields in the class to false; called at the start of
	 * string rendering
	 */
	private void resetStyles()
	{
		this.red = this.green = this.blue = this.alpha = 1F;
		this.randomStyle = false;
		this.boldStyle = false;
		this.italicStyle = false;
		this.underlineStyle = false;
		this.strikethroughStyle = false;
	}
	
	public void setColor_I(int color)
	{
		this.setColor_F(((color >> 16) & 255) / 255F, ((color >> 8) & 255) / 255F, ((color >> 0) & 255) / 255F);
	}
	
	public void setColor_F(float r, float g, float b)
	{
		this.red = r;
		this.green = g;
		this.blue = b;
	}
	
	public void setColor_S(String color)
	{
		try
		{
			if (color.startsWith("0x"))
				this.setColor_I(Integer.parseInt(color.substring(2), 16));
			else if (color.contains(";"))
			{
				float r = 1F;
				float g = 1F;
				float b = 1F;
				
				String[] split = color.split(";");
				
				if (split.length >= 1)
					r = Float.parseFloat(split[0]);
				if (split.length >= 2)
					g = Float.parseFloat(split[1]);
				if (split.length >= 3)
					b = Float.parseFloat(split[2]);
				
				this.setColor_F(r, g, b);
			}
			else
				this.setColor_I(Integer.parseInt(color));
		}
		catch (NumberFormatException ex)
		{
		}
	}
	
	protected void updateColor(boolean shadow)
	{
		if (shadow)
			GL11.glColor4f(red / 4, green / 4, blue / 4, alpha);
		else
			GL11.glColor4f(red, green, blue, alpha);
	}
	
	/**
	 * Render a single line string at the current (posX,posY) and update posX
	 */
	private void renderStringAtPos(String text, boolean shadow)
	{	
		for (int i = 0; i < text.length(); ++i)
		{
			char c = text.charAt(i);
			int j;
			int k;
			
			if (c == '\u00A7' && i + 1 < text.length())
			{
				char c1 = text.charAt(i + 1);
				
				if (c1 == 'k') // Obfuscated
					this.randomStyle = !this.randomStyle;
				else if (c1 == 'l') // Bold
					this.boldStyle = !this.boldStyle;
				else if (c1 == 'm') // Strikethrough
					this.strikethroughStyle = !this.strikethroughStyle;
				else if (c1 == 'n') // Underline
					this.underlineStyle = !this.underlineStyle;
				else if (c1 == 'o') // Italic
					this.italicStyle = !this.italicStyle;
				else if (c1 == 'r') // Reset
				{
					this.resetStyles();
					this.updateColor(shadow);
				}
				else if (c1 == 'C') // Color
				{
					int i2 = text.indexOf('[', i + 2);
					int i3 = text.indexOf(']', i + 3);
					if (i2 != -1 && i3 != -1)
					{
						String s1 = text.substring(i2 + 1, i3);
						this.setColor_S(s1);
						this.updateColor(shadow);
						i = i3;
						continue;
					}
				}
				else
				{
					int i1 = "0123456789abcdef".indexOf(Character.toLowerCase(c1));
					this.setColor_I(this.colorCode[i1]);
					this.updateColor(shadow);
				}
				
				i++;
				continue;
			}
			else
			{
				j = ChatAllowedCharacters.allowedCharacters.indexOf(c);
				
				if (this.randomStyle && j > 0)
				{
					do
					{
						k = this.fontRandom.nextInt(ChatAllowedCharacters.allowedCharacters.length());
					}
					while (this.charWidth[j + 32] != this.charWidth[k + 32]);
					
					j = k;
				}
				
				float f = this.unicodeFlag ? 0.5F : 1.0F;
				boolean flag1 = (j <= 0 || this.unicodeFlag) && shadow;
				
				if (flag1)
				{
					this.posX -= f;
					this.posY -= f;
				}
				
				float f1 = this.renderCharAtPos(j, c, this.italicStyle);
				
				if (flag1)
				{
					this.posX += f;
					this.posY += f;
				}
				
				if (this.boldStyle)
				{
					this.posX += f;
					
					if (flag1)
					{
						this.posX -= f;
						this.posY -= f;
					}
					
					this.renderCharAtPos(j, c, this.italicStyle);
					this.posX -= f;
					
					if (flag1)
					{
						this.posX += f;
						this.posY += f;
					}
					
					++f1;
				}
				
				Tessellator tessellator;
				
				if (this.strikethroughStyle)
				{
					tessellator = Tessellator.instance;
					GL11.glDisable(GL11.GL_TEXTURE_2D);
					tessellator.startDrawingQuads();
					tessellator.addVertex(this.posX, this.posY + this.FONT_HEIGHT / 2, 0.0D);
					tessellator.addVertex(this.posX + f1, this.posY + this.FONT_HEIGHT / 2, 0.0D);
					tessellator.addVertex(this.posX + f1, this.posY + this.FONT_HEIGHT / 2 - 1.0F, 0.0D);
					tessellator.addVertex(this.posX, this.posY + this.FONT_HEIGHT / 2 - 1.0F, 0.0D);
					tessellator.draw();
					GL11.glEnable(GL11.GL_TEXTURE_2D);
				}
				
				if (this.underlineStyle)
				{
					tessellator = Tessellator.instance;
					GL11.glDisable(GL11.GL_TEXTURE_2D);
					tessellator.startDrawingQuads();
					int l = this.underlineStyle ? -1 : 0;
					tessellator.addVertex(this.posX + l, this.posY + this.FONT_HEIGHT, 0.0D);
					tessellator.addVertex(this.posX + f1, this.posY + this.FONT_HEIGHT, 0.0D);
					tessellator.addVertex(this.posX + f1, this.posY + this.FONT_HEIGHT - 1.0F, 0.0D);
					tessellator.addVertex(this.posX + l, this.posY + this.FONT_HEIGHT - 1.0F, 0.0D);
					tessellator.draw();
					GL11.glEnable(GL11.GL_TEXTURE_2D);
				}
				
				this.posX += ((int) f1);
			}
		}
	}
	
	/**
	 * Render string either left or right aligned depending on bidiFlag
	 */
	private int renderStringAligned(String string, int x, int y, int off, int color, boolean shadow)
	{
		if (this.bidiFlag)
		{
			string = this.bidiReorder(string);
			int i1 = this.getStringWidth(string);
			x = x + off - i1;
		}
		
		return this.renderString(string, x, y, color, shadow);
	}
	
	/**
	 * Render single line string by setting GL color, current (posX,posY), and
	 * calling renderStringAtPos()
	 */
	private int renderString(String string, int x, int y, int color, boolean shadow)
	{
		if (string == null)
		{
			return 0;
		}
		else
		{
			if ((color & -67108864) == 0)
			{
				color |= -16777216;
			}
			
			if (shadow)
			{
				color = (color & 16579836) >> 2 | color & -16777216;
			}
			
			this.red = (color >> 16 & 255) / 255.0F;
			this.blue = (color >> 8 & 255) / 255.0F;
			this.green = (color & 255) / 255.0F;
			this.alpha = (color >> 24 & 255) / 255.0F;
			GL11.glColor4f(this.red, this.blue, this.green, this.alpha);
			this.posX = x;
			this.posY = y;
			this.renderStringAtPos(string, shadow);
			return (int) this.posX;
		}
	}
	
	/**
	 * Returns the width of this string. Equivalent of
	 * FontMetrics.stringWidth(String s).
	 */
	@Override
	public int getStringWidth(String string)
	{
		if (string == null)
		{
			return 0;
		}
		else
		{
			int i = 0;
			boolean flag = false;
			
			for (int j = 0; j < string.length(); ++j)
			{
				char c0 = string.charAt(j);
				int k = this.getCharWidth(c0);
				
				if (c0 == '\u00a7' || c0 == '@')
				{
					if (j + 2 < string.length() && string.charAt(j + 1) == 'C' && string.charAt(j + 2) == '[')
					{
						j = string.indexOf(']', j + 2);
						continue;
					}
				}
				
				if (k < 0 && j < string.length() - 1)
				{
					++j;
					c0 = string.charAt(j);
					
					if (c0 != 108 && c0 != 76)
					{
						if (c0 == 114 || c0 == 82)
						{
							flag = false;
						}
					}
					else
					{
						flag = true;
					}
					
					k = 0;
				}
				
				i += k;
				
				if (flag)
				{
					++i;
				}
			}
			
			return i;
		}
	}
	
	/**
	 * Returns the width of this character as rendered.
	 */
	@Override
	public int getCharWidth(char c)
	{
		if (c == 167)
		{
			return -1;
		}
		else if (c == 32)
		{
			return 4;
		}
		else
		{
			int i = ChatAllowedCharacters.allowedCharacters.indexOf(c);
			
			if (i >= 0 && !this.unicodeFlag)
			{
				return this.charWidth[i + 32];
			}
			else if (this.glyphWidth[c] != 0)
			{
				int j = this.glyphWidth[c] >>> 4;
				int k = this.glyphWidth[c] & 15;
				
				if (k > 7)
				{
					k = 15;
					j = 0;
				}
				
				++k;
				return (k - j) / 2 + 1;
			}
			else
			{
				return 0;
			}
		}
	}
	
	/**
	 * Trims a string to fit a specified Width.
	 */
	@Override
	public String trimStringToWidth(String string, int width)
	{
		return this.trimStringToWidth(string, width, false);
	}
	
	/**
	 * Trims a string to a specified width, and will reverse it if par3 is set.
	 */
	@Override
	public String trimStringToWidth(String string, int width, boolean reverse)
	{
		StringBuilder stringbuilder = new StringBuilder();
		int j = 0;
		int k = reverse ? string.length() - 1 : 0;
		int l = reverse ? -1 : 1;
		boolean flag1 = false;
		boolean flag2 = false;
		
		for (int i1 = k; i1 >= 0 && i1 < string.length() && j < width; i1 += l)
		{
			char c0 = string.charAt(i1);
			int j1 = this.getCharWidth(c0);
			
			if (flag1)
			{
				flag1 = false;
				
				if (c0 != 108 && c0 != 76)
				{
					if (c0 == 114 || c0 == 82)
					{
						flag2 = false;
					}
				}
				else
				{
					flag2 = true;
				}
			}
			else if (j1 < 0)
			{
				flag1 = true;
			}
			else
			{
				j += j1;
				
				if (flag2)
				{
					++j;
				}
			}
			
			if (j > width)
			{
				break;
			}
			
			if (reverse)
			{
				stringbuilder.insert(0, c0);
			}
			else
			{
				stringbuilder.append(c0);
			}
		}
		
		return stringbuilder.toString();
	}
	
	/**
	 * Remove all newline characters from the end of the string
	 */
	private String trimStringNewline(String string)
	{
		while (string != null && string.endsWith("\n"))
		{
			string = string.substring(0, string.length() - 1);
		}
		
		return string;
	}
	
	/**
	 * Splits and draws a String with wordwrap (maximum length is parameter k)
	 */
	@Override
	public void drawSplitString(String string, int x, int y, int width, int color)
	{
		this.resetStyles();
		this.textColor = color;
		string = this.trimStringNewline(string);
		this.renderSplitString(string, x, y, width, false);
	}
	
	/**
	 * Perform actual work of rendering a multi-line string with wordwrap and
	 * with darker drop shadow color if flag is set
	 */
	private void renderSplitString(String string, int x, int y, int width, boolean shadow)
	{
		List list = this.listFormattedStringToWidth(string, width);
		
		for (Iterator iterator = list.iterator(); iterator.hasNext(); y += this.FONT_HEIGHT)
		{
			String s1 = (String) iterator.next();
			this.renderStringAligned(s1, x, y, width, this.textColor, shadow);
		}
	}
	
	/**
	 * Returns the width of the wordwrapped String (maximum length is parameter
	 * k)
	 */
	@Override
	public int splitStringWidth(String string, int width)
	{
		return this.FONT_HEIGHT * this.listFormattedStringToWidth(string, width).size();
	}
	
	/**
	 * Set unicodeFlag controlling whether strings should be rendered with
	 * Unicode fonts instead of the default.png font.
	 */
	@Override
	public void setUnicodeFlag(boolean unicodeFlag)
	{
		this.unicodeFlag = unicodeFlag;
	}
	
	/**
	 * Get unicodeFlag controlling whether strings should be rendered with
	 * Unicode fonts instead of the default.png font.
	 */
	@Override
	public boolean getUnicodeFlag()
	{
		return this.unicodeFlag;
	}
	
	/**
	 * Set bidiFlag to control if the Unicode Bidirectional Algorithm should be
	 * run before rendering any string.
	 */
	@Override
	public void setBidiFlag(boolean bidiFlag)
	{
		this.bidiFlag = bidiFlag;
	}
	
	/**
	 * Breaks a string into a list of pieces that will fit a specified width.
	 */
	@Override
	public List listFormattedStringToWidth(String string, int width)
	{
		return Arrays.asList(this.wrapFormattedStringToWidth(string, width).split("\n"));
	}
	
	/**
	 * Inserts newline and formatting into a string to wrap it within the
	 * specified width.
	 */
	public String wrapFormattedStringToWidth(String string, int width)
	{
		int j = this.sizeStringToWidth(string, width);
		
		if (string.length() <= j)
		{
			return string;
		}
		else
		{
			String s1 = string.substring(0, j);
			char c0 = string.charAt(j);
			boolean flag = c0 == 32 || c0 == 10;
			String s2 = getFormatFromString(s1) + string.substring(j + (flag ? 1 : 0));
			return s1 + "\n" + this.wrapFormattedStringToWidth(s2, width);
		}
	}
	
	/**
	 * Determines how many characters from the string will fit into the
	 * specified width.
	 */
	private int sizeStringToWidth(String string, int width)
	{
		int j = string.length();
		int k = 0;
		int l = 0;
		int i1 = -1;
		
		for (boolean flag = false; l < j; ++l)
		{
			char c0 = string.charAt(l);
			
			switch (c0)
			{
			case 10:
				--l;
				break;
			case 167:
				if (l < j - 1)
				{
					++l;
					char c1 = string.charAt(l);
					
					if (c1 != 108 && c1 != 76)
					{
						if (c1 == 114 || c1 == 82 || isFormatColor(c1))
						{
							flag = false;
						}
					}
					else
					{
						flag = true;
					}
				}
				
				break;
			case 32:
				i1 = l;
			default:
				k += this.getCharWidth(c0);
				
				if (flag)
				{
					++k;
				}
			}
			
			if (c0 == 10)
			{
				++l;
				i1 = l;
				break;
			}
			
			if (k > width)
			{
				break;
			}
		}
		
		return l != j && i1 != -1 && i1 < l ? i1 : l;
	}
	
	/**
	 * Checks if the char code is a hexadecimal character, used to set colour.
	 */
	private static boolean isFormatColor(char c)
	{
		return c >= 48 && c <= 57 || c >= 97 && c <= 102 || c >= 65 && c <= 70;
	}
	
	/**
	 * Checks if the char code is O-K...lLrRk-o... used to set special
	 * formatting.
	 */
	private static boolean isFormatSpecial(char c)
	{
		return c >= 107 && c <= 111 || c >= 75 && c <= 79 || c == 114 || c == 82 || c == 'C';
	}
	
	/**
	 * Digests a string for nonprinting formatting characters then returns a
	 * string containing only that formatting.
	 */
	private static String getFormatFromString(String string)
	{
		String s1 = "";
		int i = -1;
		int j = string.length();
		
		while ((i = string.indexOf(167, i + 1)) != -1)
		{
			if (i < j - 1)
			{
				char c0 = string.charAt(i + 1);
				
				if (isFormatColor(c0))
				{
					s1 = "\u00a7" + c0;
				}
				else if (isFormatSpecial(c0))
				{
					s1 = s1 + "\u00a7" + c0;
				}
			}
		}
		
		return s1;
	}
	
	/**
	 * Get bidiFlag that controls if the Unicode Bidirectional Algorithm should
	 * be run before rendering any string
	 */
	@Override
	public boolean getBidiFlag()
	{
		return this.bidiFlag;
	}
}
