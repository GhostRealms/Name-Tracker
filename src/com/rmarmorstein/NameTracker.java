package com.rmarmorstein;

import org.apache.commons.lang.StringUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class NameTracker extends JavaPlugin {
	
	@Override
	public void onEnable() {
		//TODO sql init
		//TODO get the converter ready
		getCommand("name").setExecutor(new nameCommand());
		getCommand("uuid").setExecutor(new UUIDexe());
		getServer().getPluginManager().registerEvents(new LoginListener(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public String getUUID(String user) {
		Converter convert = new Converter(user);
		convert.run();
		return convert.getUUID();
	}
	
	public String convertArray2String(String[] alts) {
		return StringUtils.join(alts, ",");
	}
	
	public String[] convertString2Array(String s) {
		return StringUtils.split(s, ",");
	}

}
