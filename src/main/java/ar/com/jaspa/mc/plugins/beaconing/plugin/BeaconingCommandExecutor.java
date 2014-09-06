package ar.com.jaspa.mc.plugins.beaconing.plugin;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BeaconingCommandExecutor implements CommandExecutor {

	private ArrayList<String> msgDontCareSender = new ArrayList<String>();
	private ArrayList<String> msgCare = new ArrayList<String>();

	private final BeaconingPlugin plugin;
	
	public BeaconingCommandExecutor(BeaconingPlugin plugin) {
		this.plugin = plugin; // Store the plugin in situations where you need it.
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		BeaconingCommands selected = null;
		for (BeaconingCommands cmds : BeaconingCommands.values()) {
			if (cmds.getCmd().equals(cmd.getName())) {
				selected = cmds;
				break;
			}
		}
		if (selected.getCareSender()) {
			msgCareSender(sender, cmd, args);
		}else{
			msgDontCareSender(cmd);
		}

		return false;
	}

	private boolean msgDontCareSender(Command cmd,BeaconingCommands standardCommand) {
		if (cmd.getName().equalsIgnoreCase(COMMAND_PUTO)) {
			Bukkit.broadcastMessage(MSG_PUTO_EL_QUE_LEE);
			return true;
		}
		return false;
	}

	private boolean msgCareSender(CommandSender sender, Command cmd, String[] args ,BeaconingCommands standardCommand) {
		if (sender instanceof Player) {
			return commandsSentByPlayer(sender, args, cmd);
		} else {
			return commandSentByConsole(sender, args, cmd);
		}
	}

	private boolean commandSentByConsole(CommandSender sender, String[] args, Command cmd,BeaconingCommands standardCommand) {
		sender.sendMessage(MSG_PUTITO_EL_QUE_LEE  + " Mr. Admin cosole JOJOJO! ");
		Bukkit.broadcastMessage("El admin dice: " + MSG_PUTOS );
		return true;
	}

	private boolean commandsSentByPlayer(CommandSender sender, String[] args, Command cmd,BeaconingCommands standardCommand) {
		Player player = (Player) sender;
		sender.sendMessage(MSG_PUTITO_EL_QUE_LEE  +  player.getCustomName() +  " JOJOJO! ");
		return true;
	}

}
