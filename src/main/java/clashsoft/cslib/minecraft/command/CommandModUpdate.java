package clashsoft.cslib.minecraft.command;

import clashsoft.cslib.minecraft.CSLib;
import clashsoft.cslib.minecraft.update.CSUpdate;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class CommandModUpdate extends CommandBase
{
	
	@Override
	public String getCommandName()
	{
		return "mu";
	}
	
	@Override
	public String getCommandUsage(ICommandSender sender)
	{
		return "/mu [update|updateall]";
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] args)
	{
		if (args.length >= 1)
		{
			if ("update".equals(args[0]))
			{
				if (args.length >= 2)
				{
					String mod = args[1];
					CSUpdate.update((EntityPlayer) sender, mod);
				}
			}
			else if ("updateall".equals(args[0]))
			{
				CSUpdate.updateAll((EntityPlayer) sender);
			}
		}
		else
		{
			CSLib.proxy.displayUpdatesGUI();
		}
	}
	
	@Override
	public int compareTo(Object o)
	{
		return 0;
	}
	
}
