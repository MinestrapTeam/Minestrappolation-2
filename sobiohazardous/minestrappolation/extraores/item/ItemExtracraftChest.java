package sobiohazardous.minestrappolation.extraores.item;

import sobiohazardous.minestrappolation.extraores.ExtraOres;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

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
		if(par1.itemID==ExtraOres.meuroditeHelmet.itemID||par1.itemID==ExtraOres.meuroditeChest.itemID||par1.itemID==ExtraOres.meuroditeBoots.itemID)
		{
			return "ExtraOres:armor/meurodite_1.png";
		}
		if(par1.itemID==ExtraOres.meuroditePants.itemID)
		{
			return "ExtraOres:armor/meurodite_2.png";
		}
		if(par1.itemID==ExtraOres.TitaniumHelmet.itemID||par1.itemID==ExtraOres.TitaniumChest.itemID||par1.itemID==ExtraOres.TitaniumBoots.itemID)
		{
			return "ExtraOres:armor/titanium_1.png";
		}
		if(par1.itemID==ExtraOres.TitaniumPants.itemID)
		{
			return "ExtraOres:armor/titanium_2.png";
		}
		if(par1.itemID==ExtraOres.ToriteHelmet.itemID||par1.itemID==ExtraOres.ToriteChest.itemID||par1.itemID==ExtraOres.ToriteBoots.itemID)
		{
			return "ExtraOres:armor/torite_1.png";
		}
		if(par1.itemID==ExtraOres.ToritePants.itemID)
		{
			return "ExtraOres:armor/torite_2.png";
		}
		if(par1.itemID==ExtraOres.BlaziumHelmet.itemID||par1.itemID==ExtraOres.BlaziumChest.itemID||par1.itemID==ExtraOres.BlaziumBoots.itemID)
		{
			return "ExtraOres:armor/fire_1.png";
		}
		if(par1.itemID==ExtraOres.BlaziumPants.itemID)
		{
			return "ExtraOres:armor/fire_2.png";
		}
		if(par1.itemID==ExtraOres.TinHelmet.itemID||par1.itemID==ExtraOres.TinChest.itemID||par1.itemID==ExtraOres.TinBoots.itemID)
		{
			return "ExtraOres:armor/tin_1.png";
		}
		if(par1.itemID==ExtraOres.TinPants.itemID)
		{
			return "ExtraOres:armor/tin_2.png";
		}
		if(par1.itemID==ExtraOres.BronzeHelmet.itemID||par1.itemID==ExtraOres.BronzeChest.itemID||par1.itemID==ExtraOres.BronzeBoots.itemID)
		{
			return "ExtraOres:armor/bronze_1.png";
		}
		if(par1.itemID==ExtraOres.BronzePants.itemID)
		{
			return "ExtraOres:armor/bronze_2.png";
		}
		if(par1.itemID==ExtraOres.SteelHelmet.itemID||par1.itemID==ExtraOres.SteelChest.itemID||par1.itemID==ExtraOres.SteelBoots.itemID)
		{
			return "ExtraOres:armor/steel_1.png";
		}
		if(par1.itemID==ExtraOres.SteelPants.itemID)
		{
			return "ExtraOres:armor/steel_2.png";
		}
		
		if(par1.itemID==ExtraOres.BPMeuroditeHelmet.itemID||par1.itemID==ExtraOres.BPMeuroditeChest.itemID||par1.itemID==ExtraOres.BPMeuroditeBoots.itemID)
		{
			return "ExtraOres:armor/meurodite_plated_1.png";
		}
		if(par1.itemID==ExtraOres.BPMeuroditePants.itemID)
		{
			return "ExtraOres:armor/meurodite_plated_2.png";
		}
		if(par1.itemID==ExtraOres.BPTitaniumHelmet.itemID||par1.itemID==ExtraOres.BPTitaniumChest.itemID||par1.itemID==ExtraOres.BPTitaniumBoots.itemID)
		{
			return "ExtraOres:armor/titanium_plated_1.png";
		}
		if(par1.itemID==ExtraOres.BPTitaniumPants.itemID)
		{
			return "ExtraOres:armor/titanium_plated_2.png";
		}
		if(par1.itemID==ExtraOres.BPToriteHelmet.itemID||par1.itemID==ExtraOres.BPToriteChest.itemID||par1.itemID==ExtraOres.BPToriteBoots.itemID)
		{
			return "ExtraOres:armor/torite_plated_1.png";
		}
		if(par1.itemID==ExtraOres.BPToritePants.itemID)
		{
			return "ExtraOres:armor/torite_plated_2.png";
		}
		if(par1.itemID==ExtraOres.BPBlaziumHelmet.itemID||par1.itemID==ExtraOres.BPBlaziumChest.itemID||par1.itemID==ExtraOres.BPBlaziumBoots.itemID)
		{
			return "ExtraOres:armor/fire_plated_1.png";
		}
		if(par1.itemID==ExtraOres.BPBlaziumPants.itemID)
		{
			return "ExtraOres:armor/fire_plated_2.png";
		}
		if(par1.itemID==ExtraOres.BPTinHelmet.itemID||par1.itemID==ExtraOres.BPTinChest.itemID||par1.itemID==ExtraOres.BPTinBoots.itemID)
		{
			return "ExtraOres:armor/tin_plated_1.png";
		}
		if(par1.itemID==ExtraOres.BPTinPants.itemID)
		{
			return "ExtraOres:armor/tin_plated_2.png";
		}
		if(par1.itemID==ExtraOres.BPSteelHelmet.itemID||par1.itemID==ExtraOres.BPSteelChest.itemID||par1.itemID==ExtraOres.BPSteelBoots.itemID)
		{
			return "ExtraOres:armor/steel_plated_1.png";
		}
		if(par1.itemID==ExtraOres.BPSteelPants.itemID)
		{
			return "ExtraOres:armor/steel_plated_2.png";
		}
		if(par1.itemID==ExtraOres.BPClothHelmet.itemID||par1.itemID==ExtraOres.BPClothChest.itemID||par1.itemID==ExtraOres.BPClothBoots.itemID)
		{
			return "ExtraOres:armor/cloth_plated_1.png";
		}
		if(par1.itemID==ExtraOres.BPClothPants.itemID)
		{
			return "ExtraOres:armor/cloth_plated_2.png";
		}
		if(par1.itemID==ExtraOres.BPChainHelmet.itemID||par1.itemID==ExtraOres.BPChainChest.itemID||par1.itemID==ExtraOres.BPChainBoots.itemID)
		{
			return "ExtraOres:armor/chain_plated_1.png";
		}
		if(par1.itemID==ExtraOres.BPChainPants.itemID)
		{
			return "ExtraOres:armor/chain_plated_2.png";
		}
		if(par1.itemID==ExtraOres.BPIronHelmet.itemID||par1.itemID==ExtraOres.BPIronChest.itemID||par1.itemID==ExtraOres.BPIronBoots.itemID)
		{
			return "ExtraOres:armor/iron_plated_1.png";
		}
		if(par1.itemID==ExtraOres.BPIronPants.itemID)
		{
			return "ExtraOres:armor/iron_plated_2.png";
		}
		if(par1.itemID==ExtraOres.BPGoldHelmet.itemID||par1.itemID==ExtraOres.BPGoldChest.itemID||par1.itemID==ExtraOres.BPGoldBoots.itemID)
		{
			return "ExtraOres:armor/gold_plated_1.png";
		}
		if(par1.itemID==ExtraOres.BPGoldPants.itemID)
		{
			return "ExtraOres:armor/gold_plated_2.png";
		}
		if(par1.itemID==ExtraOres.BPDiamondHelmet.itemID||par1.itemID==ExtraOres.BPDiamondChest.itemID||par1.itemID==ExtraOres.BPDiamondBoots.itemID)
		{
			return "ExtraOres:armor/diamond_plated_1.png";
		}
		if(par1.itemID==ExtraOres.BPDiamondPants.itemID)
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