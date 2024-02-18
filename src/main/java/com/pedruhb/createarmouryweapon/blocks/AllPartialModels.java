package com.pedruhb.createarmouryweapon.blocks;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import com.jozufozu.flywheel.core.PartialModel;
import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;
import com.simibubi.create.content.fluids.FluidTransportBehaviour;
import com.simibubi.create.foundation.utility.Iterate;
import com.simibubi.create.foundation.utility.Lang;

import net.minecraft.core.Direction;

public class AllPartialModels {

	public static final Map<FluidTransportBehaviour.AttachmentTypes.ComponentPartials, Map<Direction, PartialModel>> PIPE_ATTACHMENTS = new EnumMap<>(FluidTransportBehaviour.AttachmentTypes.ComponentPartials.class);

	static {

		for (FluidTransportBehaviour.AttachmentTypes.ComponentPartials type : FluidTransportBehaviour.AttachmentTypes.ComponentPartials.values()) {
			Map<Direction, PartialModel> map = new HashMap<>();
			for (Direction d : Iterate.directions) {
				String asId = Lang.asId(type.name());
				map.put(d, block("seared_pipe/" + asId + "/" + Lang.asId(d.getSerializedName())));
			}
                        
			PIPE_ATTACHMENTS.put(type, map);
		}
		
		
	}

	private static PartialModel block(String path) {
		return new PartialModel(CreateArmouryWeapon.getResource("block/" + path));
	}

	private static PartialModel entity(String path) {
		return new PartialModel(CreateArmouryWeapon.getResource("entity/" + path));
	}

	public static void init() {
	}

}