package sobiohazardous.minestrappolation.extramobdrops.handler;

import org.lwjgl.opengl.GL11;

import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDItemManager;
import sobiohazardous.minestrappolation.extramobdrops.tileentity.ModelHangGlider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class EMDRenderTickHandler
{
	//****NOTE: REGISTERED ON WITH FML EVENT BUS
	
	/** Stores an instance of Minecraft for easy access */
	private Minecraft mc;

	public EMDRenderTickHandler(Minecraft mc)
	{
		this.mc = mc;
	}

	@SubscribeEvent
	public void onRenderTick(RenderTickEvent event)
	{
		/*
		if (event.phase == Phase.START)
		{
			WorldClient world = mc.theWorld;
			
				EntityPlayer player = mc.thePlayer;
	            if(player.inventory.getCurrentItem() != EMDItemManager.hangGlider.getContainerItem(null))
	            {	
	            	GL11.glPushMatrix();
	         		ModelHangGlider m = new ModelHangGlider();		
	         		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(MAssetManager.getEMDTexture("textures/misc/hangGlider.png")));
	         		int tick = 0;
	         		tick++;
	         		float rotateYaw = EMDEventHandler.interpolateRotation(player.prevRotationYaw, player.rotationYaw, tick);
	         		GL11.glRotatef(rotateYaw, 0, -1, 0);
	         		GL11.glRotatef(180F, 0, 0, 1);
	         		GL11.glTranslatef(0, 0, -0.5F);				
	         		m.render(0.0625F);
	         		GL11.glPopMatrix();		
	         	}		
	         
		}
		*/
	}
}
