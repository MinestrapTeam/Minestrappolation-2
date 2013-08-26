package sobiohazardous.minestrappolation.extraores.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemEHoe extends ItemHoe
{
    private String texture;
	
	
	public ItemEHoe(int par1, String texture, EnumToolMaterial par2EnumToolMaterial)
	{
        super(par1, par2EnumToolMaterial);
        this.texture = "Minestrappolation:" + texture;
        this.setCreativeTab(null);
    }
	
	public void registerIcons(IconRegister iconRegister)
    {
             itemIcon = iconRegister.registerIcon(texture);
    }
}
