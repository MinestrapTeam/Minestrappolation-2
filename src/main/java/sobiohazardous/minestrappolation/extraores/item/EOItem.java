package sobiohazardous.minestrappolation.extraores.item;

import sobiohazardous.minestrappolation.api.item.MItem;
import sobiohazardous.minestrappolation.extraores.lib.EOItemManager;

public class EOItem extends MItem
{       
	public EOItem(int i)
    {
		super(i);
        this.setCreativeTab(EOItemManager.tabOresItems);	
    }                      		
}