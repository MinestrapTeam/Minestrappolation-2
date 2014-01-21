package clashsoft.cslib.minecraft.item.metatools;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemMetaHoe extends ItemMetaTool
{
	protected EnumToolMaterial	theToolMaterial;
	
	public ItemMetaHoe(int par1, EnumToolMaterial par2EnumToolMaterial, String[] names, String[] icons, int[] colors)
	{
		super(par1, 0F, par2EnumToolMaterial, new Block[] {}, names, icons, colors);
		this.theToolMaterial = par2EnumToolMaterial;
		this.maxStackSize = 1;
		this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	
	/**
	 * Callback for item usage. If the item does something special on right
	 * clicking, he will have one of those. Return True if something happen and
	 * false if it don't. This is for ITEMS, not BLOCKS
	 */
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
		{
			return false;
		}
		else
		{
			UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);
			if (MinecraftForge.EVENT_BUS.post(event))
			{
				return false;
			}
			
			if (event.getResult() == Result.ALLOW)
			{
				par1ItemStack.damageItem(1, par2EntityPlayer);
				return true;
			}
			
			int i1 = par3World.getBlockId(par4, par5, par6);
			boolean air = par3World.isAirBlock(par4, par5 + 1, par6);
			
			if (par7 != 0 && air && (i1 == Block.grass.blockID || i1 == Block.dirt.blockID))
			{
				Block block = Block.tilledField;
				par3World.playSoundEffect(par4 + 0.5F, par5 + 0.5F, par6 + 0.5F, block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
				
				if (par3World.isRemote)
				{
					return true;
				}
				else
				{
					par3World.setBlock(par4, par5, par6, block.blockID);
					par1ItemStack.damageItem(1, par2EntityPlayer);
					return true;
				}
			}
			else
			{
				return false;
			}
		}
	}
}
