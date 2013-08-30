package sobiohazardous.minestrappolation.api.item;

import java.util.List;

import sobiohazardous.minestrappolation.extradecor.lib.EDConfig;

import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class MItemTool extends ItemTool
{
    private Block[] blocksEffectiveAgainst;

    /** The material this tool is made from. */
    protected EnumToolMaterial toolMaterial;
    
    protected MItemTool(int par1, float par2, EnumToolMaterial par3ExtracraftToolMaterial, Block par4ArrayOfBlock[])
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
    
    
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 0x11940;
    }
    
	public void registerIcons(IconRegister r)
	{
		itemIcon = r.registerIcon("minestrappolation:" + this.getUnlocalizedName().substring(5));
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
		if(EDConfig.showDur == true){
			 par3List.add(EnumChatFormatting.GREEN+"Durability: "+EnumChatFormatting.RED+Integer.toString(getMaxDamage()-par1ItemStack.getItemDamage()+1)+"/"+Integer.toString(getMaxDamage()+1));
		}
		 
		
    }
}
