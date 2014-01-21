package sobiohazardous.minestrappolation.api;

import java.util.Random;

import sobiohazardous.minestrappolation.api.brewing.client.gui.GuiBrewingStand2;
import sobiohazardous.minestrappolation.api.brewing.entity.EntityPotion2;
import sobiohazardous.minestrappolation.api.brewing.entity.RenderPotion2;
import sobiohazardous.minestrappolation.api.brewing.item.ItemPotion2;
import sobiohazardous.minestrappolation.api.brewing.tileentity.TileEntityBrewingStand2;
import sobiohazardous.minestrappolation.api.lib.MAPIConfig;
import sobiohazardous.minestrappolation.api.tileentity.RendererStonecutter;
import sobiohazardous.minestrappolation.api.tileentity.TileEntityStonecutter;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.TextureObject;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy
{
public static int	splashpotioncolor;
	
	@Override
	public void registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityPotion2.class, new RenderPotion2());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStonecutter.class, new RendererStonecutter());
		this.addDevCapes();
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == MAPIConfig.brewingStand2ID)
			return new GuiBrewingStand2(player.inventory, (TileEntityBrewingStand2) world.getBlockTileEntity(x, y, z));
		return null;
	}
	
	@Override
	public void playSplashEffect(World world, double x, double y, double z, int color, boolean isInstant)
	{
		RenderGlobal renderGlobal = Minecraft.getMinecraft().renderGlobal;
		
		Random random = world.rand;
		String crackParticleName = "iconcrack_" + Minestrappolation.potion2.itemID;
		
		double distance;
		float colorMultiplier;
		double velocityX;
		double velocityY;
		double velocityZ;
		double velocityMultiplier;
		
		for (int i = 0; i < 8; ++i)
		{
			renderGlobal.spawnParticle(crackParticleName, x, y, z, random.nextGaussian() * 0.15D, random.nextDouble() * 0.2D, random.nextGaussian() * 0.15D);
		}
		
		float r = (color >> 16 & 255) / 255.0F;
		float g = (color >> 8 & 255) / 255.0F;
		float b = (color >> 0 & 255) / 255.0F;
		String particleName = isInstant ? "instanceSpell" : "spell";
		
		for (int i = 0; i < 100; ++i)
		{
			velocityMultiplier = random.nextDouble() * 4.0D;
			distance = random.nextDouble() * Math.PI * 2.0D;
			velocityX = Math.cos(distance) * velocityMultiplier;
			velocityY = 0.01D + random.nextDouble() * 0.5D;
			velocityZ = Math.sin(distance) * velocityMultiplier;
			EntityFX entityfx = renderGlobal.doSpawnParticle(particleName, x + velocityX * 0.1D, y + 0.3D, z + velocityZ * 0.1D, velocityX, velocityY, velocityZ);
			
			if (entityfx != null)
			{
				colorMultiplier = 0.75F + random.nextFloat() * 0.25F;
				entityfx.setRBGColorF(r * colorMultiplier, g * colorMultiplier, b * colorMultiplier);
				entityfx.multiplyVelocity((float) velocityMultiplier);
			}
		}
	}
	
	public static void addDevCapes() 
	{
		String capeURL = "https://raw.github.com/SoBiohazardous/Minestrappolation-Recode/master/cape_dev.png";
		String[] devs = {"SoBiohazardous", "Delocuro", "triplg3", "thewerty1124"};

		ThreadDownloadImageData image = new ThreadDownloadImageData(capeURL, null, null);

		for (String username : devs) 
		{

			Minecraft.getMinecraft().renderEngine.loadTexture(new ResourceLocation("cloaks/" + username), (TextureObject) image);
		}
	}
}
