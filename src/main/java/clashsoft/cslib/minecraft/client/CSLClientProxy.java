package clashsoft.cslib.minecraft.client;

import net.minecraft.client.Minecraft;

import clashsoft.cslib.minecraft.client.gui.GuiModUpdates;
import clashsoft.cslib.minecraft.common.CSLProxy;

public class CSLClientProxy extends CSLProxy
{
	@Override
	public void displayUpdatesGUI()
	{
		Minecraft mc = Minecraft.getMinecraft();
		mc.displayGuiScreen(new GuiModUpdates(mc.currentScreen));
	}
}
