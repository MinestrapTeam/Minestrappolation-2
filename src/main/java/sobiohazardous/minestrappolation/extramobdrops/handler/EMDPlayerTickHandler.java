package sobiohazardous.minestrappolation.extramobdrops.handler;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import sobiohazardous.minestrappolation.api.util.MAssetManager;
import sobiohazardous.minestrappolation.extramobdrops.lib.EMDItemManager;
import sobiohazardous.minestrappolation.extramobdrops.tileentity.ModelHangGlider;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class EMDPlayerTickHandler
{
    public static boolean gTentacleEffect = false;
    static int ticks = 0;
    static Random rand = new Random();
   	public static int gTime = 30 + rand.nextInt(150);
   	
   	@SubscribeEvent
	public void playerUpdate(PlayerTickEvent evt)
	{
   		EntityPlayer player = evt.player;
   		
		if(evt.phase == Phase.START)
		{
			if(gTentacleEffect)
	    	{
	    		ticks++;
	    		if(ticks == gTime*20)
	    		{
	    			gTentacleEffect = false;
	    			EntityPlayerMP playermp = (EntityPlayerMP)player;
	    			playermp.mcServer.getConfigurationManager().transferPlayerToDimension(playermp, 0);
	    		}
	    	}
	    	
	    	if(!gTentacleEffect)
	    	{
	    		ticks = 0;
	    	}
		}
		
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
}
