package sobiohazardous.minestrappolation.extrafoods.handler;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class EFSoundHandler
{
    @ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try 
        {
            event.manager.soundPoolSounds.addSound("crazyfoods:cakemanliving.wav");
            event.manager.soundPoolSounds.addSound("crazyfoods:cakemanhurt.wav");       
        
        } 
        catch (Exception e)
        {
            System.err.println("CrazyFoods: Failed to register one or more sounds.");
        }
    }
}