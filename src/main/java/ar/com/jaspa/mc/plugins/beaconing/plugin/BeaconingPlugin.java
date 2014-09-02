package ar.com.jaspa.mc.plugins.beaconing.plugin;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class BeaconingPlugin extends JavaPlugin {

	private static final String MSG_PUTOS = "JAJAJA  ! PUTOS! ";
	private static final String MSG_PUTITO_EL_QUE_LEE = "JAJAJA  ! Putito sos vos : ";
	private static final String MSG_PUTO_EL_QUE_LEE = "JOJOJO ! puto el que lee ! xD !";
	private static final String COMMAND_PUTO = "puto";
	private static final String COMMAND_PUTITO = "putito";
	
	
	private ArrayList<String> msgDontCareSender = new ArrayList<String>();
	private ArrayList<String> msgCare = new ArrayList<String>();

	@Override
	public void onEnable() {
		// just a test line :p
		getLogger().info(MSG_PUTO_EL_QUE_LEE);
		
		// commands MUST be in upper case
		msgDontCareSender.add(COMMAND_PUTO.toUpperCase());
		msgCare.add(COMMAND_PUTITO.toUpperCase());

	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
		getLogger().info("u_u plugin disabled: BeaconingPlugins ");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// validate the commands available on the plugin
		validateCommands(cmd);
		
		// mensajes que te meneferga
		if (msgDontCareSender.contains(cmd.getName().toUpperCase())) {
			msgDontCareSender(cmd); 
		}else{
			if (msgCare.contains(cmd.getName().toUpperCase())) {
				msgCareSender(sender, cmd, args);
			}else{
				// message care by other plugin

			}
		}
		// mensajes que no te meneFrega
		
		/*
		 * this is for commands that are from player or from console
		 */


		// comandos OK to player and admin
// If this has happened the fu1nction will return true.
			// If this hasn't happened the value of false will be returned.
		return false;
	}

	/**
	 * validate the commands that are included in the pluggin
	 * @param cmd
	 */
	private boolean validateCommands(Command cmd) {
		if (msgDontCareSender.contains(cmd.getName().toUpperCase())) {
			return true; 
		}else{
			if (msgCare.contains(cmd.getName().toUpperCase())) {
				return true;
			}else{
				return false;
			}
		}
		
	}

	private boolean msgDontCareSender(Command cmd) {
		if (cmd.getName().equalsIgnoreCase(COMMAND_PUTO)) {
			Bukkit.broadcastMessage(MSG_PUTO_EL_QUE_LEE);
			return true;
		}
		return false;
	}

	private boolean msgCareSender(CommandSender sender, Command cmd,
			String[] args) {
		if (sender instanceof Player) {
			return commandsSentByPlayer(sender, args, cmd);
		} else {
			return commandSentByConsole(sender, args, cmd);
		}
	}

	private boolean commandSentByConsole(CommandSender sender, String[] args, Command cmd) {
		sender.sendMessage(MSG_PUTITO_EL_QUE_LEE  + " Mr. Admin cosole JOJOJO! ");
		Bukkit.broadcastMessage("El admin dice: " + MSG_PUTOS );
		return true;
	}

	private boolean commandsSentByPlayer(CommandSender sender, String[] args, Command cmd) {
		Player player = (Player) sender;
		sender.sendMessage(MSG_PUTITO_EL_QUE_LEE  +  player.getCustomName() +  " JOJOJO! ");
		return true;
	}

}
