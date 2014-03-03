package sobiohazardous.minestrappolation.extramobdrops.handler;

import java.util.EnumSet;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import sobiohazardous.minestrappolation.extramobdrops.lib.EMDItemManager;
import sobiohazardous.minestrappolation.extramobdrops.tileentity.ModelHangGlider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ClientTickHandler implements ITickHandler
{
    private final EnumSet<TickType> ticksToGet;
    
    /*
     * This Tick Handler will fire for whatever TickType's you construct and register it with.
     */
    public ClientTickHandler(EnumSet<TickType> ticksToGet)
    {
        this.ticksToGet = ticksToGet;
    }

    /*
     * I suggest putting all your tick Logic in EITHER of these, but staying in one
     */
    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData)
    {    	
    	if(Minecraft.getMinecraft().theWorld != null)
    	{                      
    		worldTick(Minecraft.getMinecraft(), Minecraft.getMinecraft().theWorld);
    	}
    }

    public void worldTick(Minecraft mc, WorldClient world)
    {
    	 for(int i = 0; i < world.playerEntities.size(); i++)
         {
                 EntityPlayer player = (EntityPlayer)world.playerEntities.get(i);
                 if(player.inventory.getCurrentItem() != EMDItemManager.hangGlider.getContainerItemStack(null))
         		 {	
         			GL11.glPushMatrix();
         			ModelHangGlider m = new ModelHangGlider();		
         			Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("minestrappolation:textures/misc/HangGlider.png"));
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
    
    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData)
    {   	
    }

    @Override
    public EnumSet<TickType> ticks()
    {
        return ticksToGet;
    }

    @Override
    public String getLabel()
    {
        return "ExtraMobDropsClientTick";
    }

}
