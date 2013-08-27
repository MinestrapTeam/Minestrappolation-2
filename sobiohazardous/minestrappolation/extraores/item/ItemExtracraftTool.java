package sobiohazardous.minestrappolation.extraores.item;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;

public class ItemExtracraftTool extends ItemTool
{
    private Block[] blocksEffectiveAgainst;

    /** The material this tool is made from. */
    protected EnumToolMaterial toolMaterial;
    

    protected ItemExtracraftTool(int par1, float par2, EnumToolMaterial par3ExtracraftToolMaterial, Block par4ArrayOfBlock[])
    {
        super(par1, par2, par3ExtracraftToolMaterial, par4ArrayOfBlock);
        this.toolMaterial = par3ExtracraftToolMaterial;
        this.blocksEffectiveAgainst = par4ArrayOfBlock;
        this.maxStackSize = 1;
        this.setMaxDamage(par3ExtracraftToolMaterial.getMaxUses());
        this.efficiencyOnProperMaterial = par3ExtracraftToolMaterial.getEfficiencyOnProperMaterial();
        this.damageVsEntity = par2 + par3ExtracraftToolMaterial.getDamageVsEntity();
        this.setCreativeTab(null);
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        for (int var3 = 0; var3 < this.blocksEffectiveAgainst.length; ++var3)
        {
            if (this.blocksEffectiveAgainst[var3] == par2Block)
            {
                return this.efficiencyOnProperMaterial;
            }
        }

        return 1.0F;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLiving, EntityLivingBase par3EntityLiving)
    {
        if(toolMaterial == EOItemManager.toolMaterialTorite || toolMaterial == EOItemManager.toolMaterialBPTorite)
        	{
        	par1ItemStack.damageItem(1, par3EntityLiving);
        	return true;
        	}
        else
        {
        	par1ItemStack.damageItem(2, par3EntityLiving);
        	return true;
        }
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLiving)
    {
        if((double)Block.blocksList[par3].blockID != Block.bedrock.blockID)
        {
    	    if ((double)Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
            {
                par1ItemStack.damageItem(1, par7EntityLiving);
            }
        }
        else
        {
        	if(toolMaterial == EOItemManager.toolMaterialTitanium || toolMaterial == EOItemManager.toolMaterialBedrock || toolMaterial == EOItemManager.toolMaterialBPTitanium || toolMaterial == EOItemManager.toolMaterialBPBedrock)
        	{
        	    par1ItemStack.damageItem(4000, par7EntityLiving);
        	}
        	else
        	{
        		par1ItemStack.damageItem(1, par7EntityLiving);
        	}
        }
        return true;
    }
    
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	if (toolMaterial == EOItemManager.toolMaterialBlazium || toolMaterial == EOItemManager.toolMaterialBPBlazium)
    	{
    		if (par7 == 0)
    		{
            --par5;
    		}

    		if (par7 == 1)
    		{
    			++par5;
    		}

    		if (par7 == 2)
    		{
    			--par6;
    		}

    		if (par7 == 3)
    		{
    			++par6;
    		}
    		
    		if (par7 == 4)
    		{
    			--par4;
    		}

    		if (par7 == 5)
    		{
    			++par4;
    		}

    		if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
    		{
    			return false;
    		}
    		else
    		{
    			if (par3World.isAirBlock(par4, par5, par6))
    			{
    				par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
    				par3World.setBlock(par4, par5, par6, Block.fire.blockID);
    			}

    			par1ItemStack.damageItem(4, par2EntityPlayer);
    			return true;
    		}
    	}
    	/*else if(toolMaterial == ExtracraftToolMaterial.TORITE || toolMaterial == ExtracraftToolMaterial.BPTORITE)
    	{
    		par2EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
            return true;
    	}*/
    	else
    	{
    		return true;
    	}
    }
    
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 0x11940;
    }
    
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
    	if(toolMaterial == EOItemManager.toolMaterialTorite || toolMaterial == EOItemManager.toolMaterialBPTorite)
    	{
    		return EnumAction.block;
    	}
    	else
    		return null;
    }
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	if(toolMaterial == EOItemManager.toolMaterialTorite || toolMaterial == EOItemManager.toolMaterialBPTorite)
    	{
    		par3EntityPlayer.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
    	}
    	return par1ItemStack;
    }       
}
