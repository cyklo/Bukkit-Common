package com.sargant.bukkit.common;

import org.bukkit.entity.*;

public class CommonEntity {
	
	public static CreatureType getCreatureType(Entity e) {
		
		if(e instanceof Chicken)   return CreatureType.CHICKEN;
		if(e instanceof Cow)       return CreatureType.COW;
		if(e instanceof Creeper)   return CreatureType.CREEPER;
		if(e instanceof Ghast)     return CreatureType.GHAST;
		if(e instanceof Giant)     return CreatureType.GIANT;
		if(e instanceof Pig)       return CreatureType.PIG;
		if(e instanceof PigZombie) return CreatureType.PIG_ZOMBIE;
		if(e instanceof Sheep)     return CreatureType.SHEEP;
		if(e instanceof Skeleton)  return CreatureType.SKELETON;
		if(e instanceof Slime)     return CreatureType.SLIME;
		if(e instanceof Spider)    return CreatureType.SPIDER;
		if(e instanceof Squid)     return CreatureType.SQUID;
		if(e instanceof Wolf)      return CreatureType.WOLF;
		if(e instanceof Zombie)    return CreatureType.ZOMBIE;

		// Monster last - is a supertype!
		if(e instanceof Monster) return CreatureType.MONSTER;
		
		return null;
	}
}
