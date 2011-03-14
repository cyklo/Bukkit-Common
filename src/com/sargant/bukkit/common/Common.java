package com.sargant.bukkit.common;

import java.util.List;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.java.JavaPlugin;

public class Common {
	
	//static public short getFixedMaxDurability(Material m) {
	//	// If the maxstacksize is -1, then the values are the wrong way round
	//	return (short) ((m.getMaxStackSize() < 1) ? m.getMaxStackSize() : m.getMaxDurability());
	//}

	//static public int getFixedMaxStackSize(Material m) {
	//	return ((m.getMaxStackSize() < 1) ? m.getMaxDurability() : m.getMaxStackSize());
	//}
	
	static public short getWoolColor(DyeColor color) {
		switch (color) {
		case WHITE: return 0x0;
		case ORANGE: return 0x1;
		case MAGENTA: return 0x2;
		case LIGHT_BLUE: return 0x3;
		case YELLOW: return 0x4;
		case LIME: return 0x5;
		case PINK: return 0x6;
		case GRAY: return 0x7;
		case SILVER: return 0x8;
		case CYAN: return 0x9;
		case PURPLE: return 0xA;
		case BLUE: return 0xB;
		case BROWN: return 0xC;
		case GREEN: return 0xD;
		case RED: return 0xE;
		case BLACK: return 0xF;
		default: return 0xF;
		}
	}

	static public short getDyeColor(DyeColor color) {
		switch (color) {
		case WHITE: return 0xF;
		case ORANGE: return 0xE;
		case MAGENTA: return 0xD;
		case LIGHT_BLUE: return 0xC;
		case YELLOW: return 0xB;
		case LIME: return 0xA;
		case PINK: return 0x9;
		case GRAY: return 0x8;
		case SILVER: return 0x7;
		case CYAN: return 0x6;
		case PURPLE: return 0x5;
		case BLUE: return 0x4;
		case BROWN: return 0x3;
		case GREEN: return 0x2;
		case RED: return 0x1;
		case BLACK: return 0x0;
		default: return 0x0;
		}
	}
	
	static public CreatureType getCreatureType(Entity e) {
		
		if(e instanceof Chicken)   { return CreatureType.CHICKEN; }
		if(e instanceof Cow)       { return CreatureType.COW; }
		if(e instanceof Creeper)   { return CreatureType.CREEPER; }
		if(e instanceof Ghast)     { return CreatureType.GHAST; }
		if(e instanceof Pig)       { return CreatureType.PIG; }
		if(e instanceof PigZombie) { return CreatureType.PIG_ZOMBIE; }
		if(e instanceof Sheep)     { return CreatureType.SHEEP; }
		if(e instanceof Skeleton)  { return CreatureType.SKELETON; }
		if(e instanceof Slime)     { return CreatureType.SLIME; }
		if(e instanceof Spider)    { return CreatureType.SPIDER; }
		if(e instanceof Squid)     { return CreatureType.SQUID; }
		if(e instanceof Zombie)    { return CreatureType.ZOMBIE; }
		
		return null;
	}

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
		
		if(keys == null || !keys.contains("verbosity")) { return 2;}
		
		String verb_string = plugin.getConfiguration().getString("verbosity", "normal");

		if(verb_string.equalsIgnoreCase("low"))       { return 1; }
		else if(verb_string.equalsIgnoreCase("high")) { return 3; }
		
		return 2;
	}

	static public Priority getPriority(JavaPlugin plugin) {
		
		List <String> keys = getRootKeys(plugin);
		
		if(keys == null || !keys.contains("priority")) { return Priority.Lowest; }
		
		String priority_string = plugin.getConfiguration().getString("priority", "lowest");
		if(priority_string.equalsIgnoreCase("low"))          { return Priority.Low; }
		else if(priority_string.equalsIgnoreCase("normal"))  { return Priority.Normal; }
		else if(priority_string.equalsIgnoreCase("high"))    { return Priority.High; }
		else if(priority_string.equalsIgnoreCase("highest")) { return Priority.Highest; }
		
		return Priority.Lowest;
	}
}
