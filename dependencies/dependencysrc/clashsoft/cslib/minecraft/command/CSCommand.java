package clashsoft.cslib.minecraft.command;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.command.ICommand;

public class CSCommand
{
	public static List<ICommand>	commands;
	
	public static void registerCommand(ICommand command)
	{
		if (commands == null)
		{
			commands = new LinkedList();
		}
		commands.add(command);
	}
}
