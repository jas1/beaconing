package ar.com.jaspa.mc.plugins.beaconing.plugin;

public enum BeaconingCommands {

	
	PUTO("puto","JAJAJA  ! PUTOS! ","JAJAJA  ! PUTOS! ",false),
	PUTITO("putito","JAJAJA  ! Putito sos vos : ","",true);
	
	private final String cmd;
	private final Boolean careSender;
	private final String msg;
	private final String msgAdmin;
	
	private BeaconingCommands(String cmd, String msg,String msgAdmin,Boolean careSender) {
		this.cmd = cmd;
		this.msg = msg;
		this.msgAdmin= msgAdmin;
		this.careSender=careSender;
	}
	public String getCmd() {
		return cmd;
	}
	public String getMsg() {
		return msg;
	}
	public Boolean getCareSender() {
		return careSender;
	}
	public String getMsgAdmin() {
		return msgAdmin;
	}
}
