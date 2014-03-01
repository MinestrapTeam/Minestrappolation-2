package sobiohazardous.minestrappolation.api.item;

import java.util.List;

import sobiohazardous.minestrappolation.api.lib.MAPIConfig;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.src.*;
import net.minecraft.util.EnumChatFormatting;

public class MItemPickaxe extends ItemPickaxe
{
    public MItemPickaxe(ToolMaterial par2EnumToolMaterial)
    {
        super(par2EnumToolMaterial);
        this.setCreativeTab(null);
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    //can harvest
    @Override
    public boolean func_150897_b(Block par1Block)
    {
        return par1Block == Block.getBlockFromName("obsidian")? this.toolMaterial.getHarvestLevel() == 3 : super.func_150897_b(par1Block);
    }
    
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
		if(MAPIConfig.showDur == true)
		{
			 par3List.add(EnumChatFormatting.GREEN+"Durability: "+EnumChatFormatting.RED+Integer.toString(getMaxDamage()-par1ItemStack.getItemDamage()+1)+"/"+Integer.toString(getMaxDamage()+1));
		}		
    }
}
