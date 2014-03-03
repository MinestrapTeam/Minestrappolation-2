package sobiohazardous.minestrappolation.extrafoods.block;

import java.util.Random;

import sobiohazardous.minestrappolation.extrafoods.ExtraFoods;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class EFBlock extends Block
{
	private String btexture;
	
	public EFBlock(int id, Material material, String texture)
	{
		super(id, material);
		this.btexture = "crazyfoods:" + texture;
		this.setCreativeTab(ExtraFoods.tabBlocks);
	}
	
	public void registerIcons(IconRegister ir)
	{
		blockIcon = ir.registerIcon(btexture);
	}
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID == ExtraFoods.oreSalt.blockID ? ExtraFoods.salt.itemID : this.blockID;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return this.blockID == ExtraFoods.oreSalt.blockID ? 2 + par1Random.nextInt(5) : 1;
    }
}
