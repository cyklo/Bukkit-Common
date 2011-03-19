package com.sargant.bukkit.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.java.JavaPlugin;

public class Common {
	
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
	
	static public boolean isSynonym(String syn_name, Material mat) {
		
		Map<String, List<Material>> synonyms = new HashMap<String, List<Material>>();

		// Blocks
		synonyms.put("ANY_FURNACE",			Arrays.asList(Material.FURNACE, Material.BURNING_FURNACE));
		synonyms.put("ANY_SIGN",			Arrays.asList(Material.SIGN, Material.SIGN_POST, Material.WALL_SIGN));
		synonyms.put("ANY_REDSTONE_ORE",	Arrays.asList(Material.REDSTONE_ORE, Material.GLOWING_REDSTONE_ORE));
		synonyms.put("ANY_REDSTONE_TORCH",	Arrays.asList(Material.REDSTONE_TORCH_OFF, Material.REDSTONE_TORCH_ON));
		synonyms.put("ANY_DIODE_BLOCK",		Arrays.asList(Material.DIODE_BLOCK_OFF, Material.DIODE_BLOCK_ON));
		
		// Tools
		synonyms.put("ANY_SPADE",	Arrays.asList(Material.WOOD_SPADE, Material.STONE_SPADE, Material.GOLD_SPADE, Material.IRON_SPADE, Material.DIAMOND_SPADE));
		synonyms.put("ANY_AXE", 	Arrays.asList(Material.WOOD_AXE, Material.STONE_AXE, Material.GOLD_AXE, Material.IRON_AXE, Material.DIAMOND_AXE));
		synonyms.put("ANY_HOE", 	Arrays.asList(Material.WOOD_HOE, Material.STONE_HOE, Material.GOLD_HOE, Material.IRON_HOE, Material.DIAMOND_HOE));
		synonyms.put("ANY_PICKAXE",	Arrays.asList(Material.WOOD_PICKAXE, Material.STONE_PICKAXE, Material.GOLD_PICKAXE, Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE));
		synonyms.put("ANY_SWORD",	Arrays.asList(Material.WOOD_SWORD, Material.STONE_SWORD, Material.GOLD_SWORD, Material.IRON_SWORD, Material.DIAMOND_SWORD));
		
		// Armour
		synonyms.put("ANY_HELMET",		Arrays.asList(Material.LEATHER_HELMET, Material.CHAINMAIL_HELMET, Material.GOLD_HELMET, Material.IRON_HELMET, Material.DIAMOND_HELMET));
		synonyms.put("ANY_CHESTPLATE",	Arrays.asList(Material.LEATHER_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.GOLD_CHESTPLATE, Material.IRON_CHESTPLATE, Material.DIAMOND_CHESTPLATE));
		synonyms.put("ANY_LEGGINGS",	Arrays.asList(Material.LEATHER_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.GOLD_LEGGINGS, Material.IRON_LEGGINGS, Material.DIAMOND_LEGGINGS));
		synonyms.put("ANY_BOOTS",		Arrays.asList(Material.LEATHER_BOOTS, Material.CHAINMAIL_BOOTS, Material.GOLD_BOOTS, Material.IRON_BOOTS, Material.DIAMOND_BOOTS));
		
		for(Map.Entry<String, List<Material>> entry : synonyms.entrySet()) {
			if(!entry.getKey().equalsIgnoreCase(syn_name)) continue;
			if(entry.getValue().contains(mat)) return true;
		}
		return false;
	}
}
