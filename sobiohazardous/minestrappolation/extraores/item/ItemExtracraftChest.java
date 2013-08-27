package sobiohazardous.minestrappolation.extraores.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;

public class ItemExtracraftChest extends ItemArmor
{
	private String texture;
	public ItemExtracraftChest(int par1, String texture, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) 
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.texture = "Minestrappolation:" + texture;
		this.setCreativeTab(null);
	}
	
	public String getArmorTexture(ItemStack par1, Entity entity, int slot, int layer)
	{
		if(par1.itemID==EOItemManager.meuroditeHelmet.itemID||par1.itemID==EOItemManager.meuroditeChest.itemID||par1.itemID==EOItemManager.meuroditeBoots.itemID)
		{
			return "ExtraOres:armor/meurodite_1.png";
		}
		if(par1.itemID==EOItemManager.meuroditePants.itemID)
		{
			return "ExtraOres:armor/meurodite_2.png";
		}
		if(par1.itemID==EOItemManager.TitaniumHelmet.itemID||par1.itemID==EOItemManager.TitaniumChest.itemID||par1.itemID==EOItemManager.TitaniumBoots.itemID)
		{
			return "ExtraOres:armor/titanium_1.png";
		}
		if(par1.itemID==EOItemManager.TitaniumPants.itemID)
		{
			return "ExtraOres:armor/titanium_2.png";
		}
		if(par1.itemID==EOItemManager.ToriteHelmet.itemID||par1.itemID==EOItemManager.ToriteChest.itemID||par1.itemID==EOItemManager.ToriteBoots.itemID)
		{
			return "ExtraOres:armor/torite_1.png";
		}
		if(par1.itemID==EOItemManager.ToritePants.itemID)
		{
			return "ExtraOres:armor/torite_2.png";
		}
		if(par1.itemID==EOItemManager.BlaziumHelmet.itemID||par1.itemID==EOItemManager.BlaziumChest.itemID||par1.itemID==EOItemManager.BlaziumBoots.itemID)
		{
			return "ExtraOres:armor/fire_1.png";
		}
		if(par1.itemID==EOItemManager.BlaziumPants.itemID)
		{
			return "ExtraOres:armor/fire_2.png";
		}
		if(par1.itemID==EOItemManager.TinHelmet.itemID||par1.itemID==EOItemManager.TinChest.itemID||par1.itemID==EOItemManager.TinBoots.itemID)
		{
			return "ExtraOres:armor/tin_1.png";
		}
		if(par1.itemID==EOItemManager.TinPants.itemID)
		{
			return "ExtraOres:armor/tin_2.png";
		}
		if(par1.itemID==EOItemManager.BronzeHelmet.itemID||par1.itemID==EOItemManager.BronzeChest.itemID||par1.itemID==EOItemManager.BronzeBoots.itemID)
		{
			return "ExtraOres:armor/bronze_1.png";
		}
		if(par1.itemID==EOItemManager.BronzePants.itemID)
		{
			return "ExtraOres:armor/bronze_2.png";
		}
		if(par1.itemID==EOItemManager.SteelHelmet.itemID||par1.itemID==EOItemManager.SteelChest.itemID||par1.itemID==EOItemManager.SteelBoots.itemID)
		{
			return "ExtraOres:armor/steel_1.png";
		}
		if(par1.itemID==EOItemManager.SteelPants.itemID)
		{
			return "ExtraOres:armor/steel_2.png";
		}
		
		if(par1.itemID==EOItemManager.BPMeuroditeHelmet.itemID||par1.itemID==EOItemManager.BPMeuroditeChest.itemID||par1.itemID==EOItemManager.BPMeuroditeBoots.itemID)
		{
			return "ExtraOres:armor/meurodite_plated_1.png";
		}
		if(par1.itemID==EOItemManager.BPMeuroditePants.itemID)
		{
			return "ExtraOres:armor/meurodite_plated_2.png";
		}
		if(par1.itemID==EOItemManager.BPTitaniumHelmet.itemID||par1.itemID==EOItemManager.BPTitaniumChest.itemID||par1.itemID==EOItemManager.BPTitaniumBoots.itemID)
		{
			return "ExtraOres:armor/titanium_plated_1.png";
		}
		if(par1.itemID==EOItemManager.BPTitaniumPants.itemID)
		{
			return "ExtraOres:armor/titanium_plated_2.png";
		}
		if(par1.itemID==EOItemManager.BPToriteHelmet.itemID||par1.itemID==EOItemManager.BPToriteChest.itemID||par1.itemID==EOItemManager.BPToriteBoots.itemID)
		{
			return "ExtraOres:armor/torite_plated_1.png";
		}
		if(par1.itemID==EOItemManager.BPToritePants.itemID)
		{
			return "ExtraOres:armor/torite_plated_2.png";
		}
		if(par1.itemID==EOItemManager.BPBlaziumHelmet.itemID||par1.itemID==EOItemManager.BPBlaziumChest.itemID||par1.itemID==EOItemManager.BPBlaziumBoots.itemID)
		{
			return "ExtraOres:armor/fire_plated_1.png";
		}
		if(par1.itemID==EOItemManager.BPBlaziumPants.itemID)
		{
			return "ExtraOres:armor/fire_plated_2.png";
		}
		if(par1.itemID==EOItemManager.BPTinHelmet.itemID||par1.itemID==EOItemManager.BPTinChest.itemID||par1.itemID==EOItemManager.BPTinBoots.itemID)
		{
			return "ExtraOres:armor/tin_plated_1.png";
		}
		if(par1.itemID==EOItemManager.BPTinPants.itemID)
		{
			return "ExtraOres:armor/tin_plated_2.png";
		}
		if(par1.itemID==EOItemManager.BPSteelHelmet.itemID||par1.itemID==EOItemManager.BPSteelChest.itemID||par1.itemID==EOItemManager.BPSteelBoots.itemID)
		{
			return "ExtraOres:armor/steel_plated_1.png";
		}
		if(par1.itemID==EOItemManager.BPSteelPants.itemID)
		{
			return "ExtraOres:armor/steel_plated_2.png";
		}
		if(par1.itemID==EOItemManager.BPClothHelmet.itemID||par1.itemID==EOItemManager.BPClothChest.itemID||par1.itemID==EOItemManager.BPClothBoots.itemID)
		{
			return "ExtraOres:armor/cloth_plated_1.png";
		}
		if(par1.itemID==EOItemManager.BPClothPants.itemID)
		{
			return "ExtraOres:armor/cloth_plated_2.png";
		}
		if(par1.itemID==EOItemManager.BPChainHelmet.itemID||par1.itemID==EOItemManager.BPChainChest.itemID||par1.itemID==EOItemManager.BPChainBoots.itemID)
		{
			return "ExtraOres:armor/chain_plated_1.png";
		}
		if(par1.itemID==EOItemManager.BPChainPants.itemID)
		{
			return "ExtraOres:armor/chain_plated_2.png";
		}
		if(par1.itemID==EOItemManager.BPIronHelmet.itemID||par1.itemID==EOItemManager.BPIronChest.itemID||par1.itemID==EOItemManager.BPIronBoots.itemID)
		{
			return "ExtraOres:armor/iron_plated_1.png";
		}
		if(par1.itemID==EOItemManager.BPIronPants.itemID)
		{
			return "ExtraOres:armor/iron_plated_2.png";
		}
		if(par1.itemID==EOItemManager.BPGoldHelmet.itemID||par1.itemID==EOItemManager.BPGoldChest.itemID||par1.itemID==EOItemManager.BPGoldBoots.itemID)
		{
			return "ExtraOres:armor/gold_plated_1.png";
		}
		if(par1.itemID==EOItemManager.BPGoldPants.itemID)
		{
			return "ExtraOres:armor/gold_plated_2.png";
		}
		if(par1.itemID==EOItemManager.BPDiamondHelmet.itemID||par1.itemID==EOItemManager.BPDiamondChest.itemID||par1.itemID==EOItemManager.BPDiamondBoots.itemID)
		{
			return "ExtraOres:armor/diamond_plated_1.png";
		}
		if(par1.itemID==EOItemManager.BPDiamondPants.itemID)
		{
			return "ExtraOres:armor/diamond_plated_2.png";
		}
		return "ExtraOres:armor/zirconium_1.png";
	}
	
	public void registerIcons(IconRegister par1IconRegister)
	{
	         this.itemIcon = par1IconRegister.registerIcon(texture);
	}


}