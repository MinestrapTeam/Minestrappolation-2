package clashsoft.playerinventoryapi.lib;

import gnu.trove.strategy.HashingStrategy;

import net.minecraft.client.gui.GuiButton;

public class ButtonHashingStrategy implements HashingStrategy<GuiButton>
{
	public static ButtonHashingStrategy instance = new ButtonHashingStrategy();
	
	@Override
	public int computeHashCode(GuiButton object)
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((object.displayString == null) ? 0 : object.displayString.hashCode());
		result = prime * result + object.id;
		result = prime * result + object.xPosition;
		result = prime * result + object.yPosition;
		return result;
	}

	@Override
	public boolean equals(GuiButton o1, GuiButton o2)
	{
		if (o1 == o2)
			return true;
		if (o2 == null ^ o1 == null)
			return false;
		
		if (o1.getClass() != o2.getClass())
			return false;
		if (o1.displayString == null)
		{
			if (o2.displayString != null)
				return false;
		}
		else if (!o1.displayString.equals(o2.displayString))
			return false;
		if (o1.id != o2.id)
			return false;
		if (o1.xPosition != o2.xPosition)
			return false;
		if (o1.yPosition != o2.yPosition)
			return false;
		return true;
	}
	
}
