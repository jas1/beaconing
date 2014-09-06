package ar.com.jaspa.mc.plugins.beaconing.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class BeaconingPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("n_n plugin enabled: " + this.getClass().getSimpleName());
		// just a test line :p
		for (BeaconingCommands cmds : BeaconingCommands.values()) {
			this.getCommand(cmds.getCmd()).setExecutor(new BeaconingCommandExecutor(this));	
		}
	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
		getLogger().info("u_u plugin disabled: " + this.getClass().getSimpleName());
	}

}
