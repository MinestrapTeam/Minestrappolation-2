package sobiohazardous.minestrappolation.extrafoods.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class CakePotionEffect extends EFCake
{
	private Potion effect;
	/**
	 * Length in seconds
	 */
	private int length;
	private int strength;
	
	public CakePotionEffect(int par1, String side, String top, String bottom, String inner, Item item, int healamt, Potion effect, int length, int strength)
	{
		super(par1, side, top, bottom, inner, item, healamt);
		this.length = length;
		this.strength = strength;
		this.effect = effect;
	}
	
	protected void eatCakeSlice(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
    {
        if (par5EntityPlayer.canEat(false))
        {
            par5EntityPlayer.getFoodStats().addStats(2, 0.1F);
            par5EntityPlayer.addPotionEffect(new PotionEffect(effect.id, length * 20, strength));
            int l = par1World.getBlockMetadata(par2, par3, par4) + 1;

            if (l >= 6)
            {
                par1World.setBlockToAir(par2, par3, par4);
            }
            else
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
            }
        }
    }
}
