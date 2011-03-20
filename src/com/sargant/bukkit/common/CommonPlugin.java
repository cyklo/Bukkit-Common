package com.sargant.bukkit.common;

import java.util.List;

import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.java.JavaPlugin;

public class CommonPlugin {
	
	static public List<String> getRootKeys(JavaPlugin plugin) {
		List <String> keys;	
		try {
			keys = plugin.getConfiguration().getKeys(null);
		} 
		catch(NullPointerException ex) { return null; }
		return keys;
	}
	
	static public Integer getVerbosity(JavaPlugin plugin) {
		
		List <String> keys = getRootKeys(plugin);
		if(keys == null || !keys.contains("verbosity")) return 2;
		
		String verb_string = plugin.getConfiguration().getString("verbosity", "normal");
		
		if(verb_string.equalsIgnoreCase("low")) return 1;
		else if(verb_string.equalsIgnoreCase("high")) return 3;
		else return 2;
	}

	static public Priority getPriority(JavaPlugin plugin) {
		
		List <String> keys = getRootKeys(plugin);
		if(keys == null || !keys.contains("priority")) { return Priority.Lowest; }
		
		String priority_string = plugin.getConfiguration().getString("priority", "lowest");
		if(priority_string.equalsIgnoreCase("low"))  return Priority.Low;
		else if(priority_string.equalsIgnoreCase("normal")) return Priority.Normal;
		else if(priority_string.equalsIgnoreCase("high")) return Priority.High;
		else if(priority_string.equalsIgnoreCase("highest")) return Priority.Highest;
		else return Priority.Lowest;
	}
}
