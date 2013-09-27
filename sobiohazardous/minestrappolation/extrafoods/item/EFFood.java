package sobiohazardous.minestrappolation.extrafoods.item;

import sobiohazardous.minestrappolation.extrafoods.ExtraFoods;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EFFood extends ItemFood
{
	private String texture;
	
    public EFFood(int id, String texture, int healAmount, float saturation, boolean wolffood)
    {
        super(id, healAmount, saturation, wolffood);
        this.setCreativeTab(ExtraFoods.tabFoods);
        this.texture = "crazyfoods:" + texture;
    }
    
    public EFFood(int id, String texture, int healAmount, float saturation)
    {
        super(id, healAmount, saturation, false);
        this.setCreativeTab(ExtraFoods.tabFoods);
        this.texture = "crazyfoods:" + texture;
    }
    
    public void registerIcons(IconRegister iconRegister)
	{
	         itemIcon = iconRegister.registerIcon(texture);
	}
}
