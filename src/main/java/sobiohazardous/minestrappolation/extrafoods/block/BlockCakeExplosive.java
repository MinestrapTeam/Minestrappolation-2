package sobiohazardous.minestrappolation.extrafoods.block;

import sobiohazardous.minestrappolation.extrafoods.entity.EntityExplosiveCake;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockCakeExplosive extends EFCake
{
	@SideOnly(Side.CLIENT)
    private Icon cakeTopIcon;
    @SideOnly(Side.CLIENT)
    private Icon cakeBottomIcon;
    @SideOnly(Side.CLIENT)
    private Icon field_94382_c;
    
	public BlockCakeExplosive(int par1, Item item)
	{
		super(par1, "", "", "", "", item, 0);

	}
	
	protected void eatCakeSlice(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
    {
		if(!par1World.isRemote)
		{
			EntityExplosiveCake entitytntprimed = new EntityExplosiveCake(par1World, (double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F), par5EntityPlayer);
			par1World.spawnEntityInWorld(entitytntprimed);
			par1World.playSoundAtEntity(entitytntprimed, "random.fuse", 1.0F, 1.0F);
        
			int l = par1World.getBlockMetadata(par2, par3, par4) + 1;
			par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
		}
    }
	
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("cake_side");
        this.field_94382_c = par1IconRegister.registerIcon("cake_inner");
        this.cakeTopIcon = par1IconRegister.registerIcon("cake_top");
        this.cakeBottomIcon = par1IconRegister.registerIcon("cake_bottom");
    }
	
	public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.cakeTopIcon : (par1 == 0 ? this.cakeBottomIcon : (par2 > 0 && par1 == 4 ? this.field_94382_c : this.blockIcon));
    }
	
}
