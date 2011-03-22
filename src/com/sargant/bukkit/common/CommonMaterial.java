package com.sargant.bukkit.common;

import java.util.*;

import org.bukkit.*;

public final class CommonMaterial {
	
	// Synonyms between materials

	private static final Map<String, List<Material>> SYNONYMS = initSynonyms();

	private static Map<String, List<Material>> initSynonyms() {
		
		Map<String, List<Material>> result = new HashMap<String, List<Material>>();
		// Blocks
		result.put("ANY_FURNACE",        Arrays.asList(Material.FURNACE, Material.BURNING_FURNACE));
		result.put("ANY_SIGN",           Arrays.asList(Material.SIGN, Material.SIGN_POST, Material.WALL_SIGN));
		result.put("ANY_REDSTONE_ORE",   Arrays.asList(Material.REDSTONE_ORE, Material.GLOWING_REDSTONE_ORE));
		result.put("ANY_REDSTONE_TORCH", Arrays.asList(Material.REDSTONE_TORCH_OFF, Material.REDSTONE_TORCH_ON));
		result.put("ANY_DIODE_BLOCK",    Arrays.asList(Material.DIODE_BLOCK_OFF, Material.DIODE_BLOCK_ON));
		// Tools
		result.put("ANY_SPADE",   Arrays.asList(Material.WOOD_SPADE, Material.STONE_SPADE, Material.GOLD_SPADE, Material.IRON_SPADE, Material.DIAMOND_SPADE));
		result.put("ANY_AXE",     Arrays.asList(Material.WOOD_AXE, Material.STONE_AXE, Material.GOLD_AXE, Material.IRON_AXE, Material.DIAMOND_AXE));
		result.put("ANY_HOE",     Arrays.asList(Material.WOOD_HOE, Material.STONE_HOE, Material.GOLD_HOE, Material.IRON_HOE, Material.DIAMOND_HOE));
		result.put("ANY_PICKAXE", Arrays.asList(Material.WOOD_PICKAXE, Material.STONE_PICKAXE, Material.GOLD_PICKAXE, Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE));
		result.put("ANY_SWORD",   Arrays.asList(Material.WOOD_SWORD, Material.STONE_SWORD, Material.GOLD_SWORD, Material.IRON_SWORD, Material.DIAMOND_SWORD));
		// Armour
		result.put("ANY_HELMET",     Arrays.asList(Material.LEATHER_HELMET, Material.CHAINMAIL_HELMET, Material.GOLD_HELMET, Material.IRON_HELMET, Material.DIAMOND_HELMET));
		result.put("ANY_CHESTPLATE", Arrays.asList(Material.LEATHER_CHESTPLATE, Material.CHAINMAIL_CHESTPLATE, Material.GOLD_CHESTPLATE, Material.IRON_CHESTPLATE, Material.DIAMOND_CHESTPLATE));
		result.put("ANY_LEGGINGS",   Arrays.asList(Material.LEATHER_LEGGINGS, Material.CHAINMAIL_LEGGINGS, Material.GOLD_LEGGINGS, Material.IRON_LEGGINGS, Material.DIAMOND_LEGGINGS));
		result.put("ANY_BOOTS",      Arrays.asList(Material.LEATHER_BOOTS, Material.CHAINMAIL_BOOTS, Material.GOLD_BOOTS, Material.IRON_BOOTS, Material.DIAMOND_BOOTS));
		
		return Collections.unmodifiableMap(result);
	}
	
	public static Set<String> getValidSynonyms() {
		return SYNONYMS.keySet();
	}
	
	public static boolean isValidSynonym(String string) {
		return SYNONYMS.containsKey(string);
	}
	
	public static boolean isSynonymFor(String string, Material material) {
		if(!isValidSynonym(string)) return false;
		return SYNONYMS.get(string).contains(material);
	}
	
	// Colors
	
	public static short getWoolColor(DyeColor color) {
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

	public static short getDyeColor(DyeColor color) {
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
	
	public static short getAnyDataShort(Material material, String enumValue) throws IllegalArgumentException {
		// Firstly, can the string be cast directly as a short?
		try {
			Short s = Short.parseShort(enumValue);
			return s;
		} catch(NumberFormatException ex) {}
		
		// If not, test the enums
		switch(material) {
		case LOG:
		case LEAVES:
			return (short) TreeSpecies.valueOf(enumValue).getData();
		case WOOL:
			return (short) DyeColor.valueOf(enumValue).getData();
		case INK_SACK:
			return (short) (0xF - DyeColor.valueOf(enumValue).getData());
		case COAL:
			return (short) (CoalType.valueOf(enumValue).getData());
		case CROPS:
			return (short) (CropState.valueOf(enumValue).getData());
		case DOUBLE_STEP:
		case STEP:
			if(enumValue.equalsIgnoreCase("STONE")) return 0;
			else if(enumValue.equalsIgnoreCase("SANDSTONE")) return 1;
			else if(enumValue.equalsIgnoreCase("WOOD")) return 2;
			else if(enumValue.equalsIgnoreCase("COBBLESTONE")) return 3;
			else throw new IllegalArgumentException();			
		default:
			return 0;
		}
	}
}
