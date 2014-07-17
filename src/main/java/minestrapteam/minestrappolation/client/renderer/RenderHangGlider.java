package minestrapteam.minestrappolation.client.renderer;

import org.lwjgl.opengl.GL11;

import minestrapteam.mcore.util.MCAssetManager;
import minestrapteam.minestrappolation.client.model.ModelHangGlider;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class RenderHangGlider implements IItemRenderer
{
	public static ResourceLocation	texture	= MCAssetManager.getModelResource("hang_glider");
	public ModelHangGlider			model	= new ModelHangGlider();
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON;
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch (type)
		{
		case EQUIPPED_FIRST_PERSON:
			GL11.glPushMatrix();
			GL11.glScalef(1.75F, 1.75F, 1.75F);
			GL11.glTranslatef(0F, 0F, 0F);
			GL11.glRotatef(0, 0F, 1F, 0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			this.model.render(.0625F);
			GL11.glPopMatrix();
			break;
		case EQUIPPED:
			GL11.glPushMatrix();
			GL11.glScalef(1.75F, 1.75F, 1.75F);
			GL11.glTranslatef(.55F, -.4F, -.85F);
			GL11.glRotatef(100, 1F, 0F, 0F);
			GL11.glRotatef(190, 0F, 1F, 0F);
			GL11.glRotatef(15, 0F, 0F, 1F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			this.model.render(.0625F);
			GL11.glPopMatrix();
			break;
		default:
			break;
		}
	}
}
