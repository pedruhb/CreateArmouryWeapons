package com.pedruhb.createarmouryweapon;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;

public class CAWSpriteShifts {
    
    public static final CTSpriteShiftEntry SEARED_CASING = omni("seared_casing");
    public static final CTSpriteShiftEntry SCORCHED_CASING = omni("scorched_casing");

	public static final CTSpriteShiftEntry 
		SEARED_TANK = getCT(AllCTTypes.RECTANGLE, "seared_tank"),
		SEARED_TANK_TOP = getCT(AllCTTypes.RECTANGLE, "seared_tank_top"),
		SEARED_TANK_INNER = getCT(AllCTTypes.RECTANGLE, "seared_tank_inner");

	private static CTSpriteShiftEntry omni(String name) {
		return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
	}

	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
		return CTSpriteShifter.getCT(type, CreateArmouryWeapon.asResource("block/" + blockTextureName), CreateArmouryWeapon.asResource("block/" + connectedTextureName + "_connected"));
	}

	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
		return getCT(type, blockTextureName, blockTextureName);
	}

	private static CTSpriteShiftEntry horizontal(String name) {
		return getCT(AllCTTypes.HORIZONTAL, name);
	}

	private static CTSpriteShiftEntry vertical(String name) {
		return getCT(AllCTTypes.VERTICAL, name);
	}
}
