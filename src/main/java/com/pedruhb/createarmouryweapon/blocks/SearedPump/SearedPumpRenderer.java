package com.pedruhb.createarmouryweapon.blocks.SearedPump;

import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import com.simibubi.create.foundation.render.CachedBufferer;
import com.simibubi.create.foundation.render.SuperByteBuffer;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.state.BlockState;

public class SearedPumpRenderer extends KineticBlockEntityRenderer<SearedPumpBlockEntity> {

	public SearedPumpRenderer(BlockEntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	protected SuperByteBuffer getRotatedModel(SearedPumpBlockEntity be, BlockState state) {
		return CachedBufferer.partialFacing(AllPartialModels.MECHANICAL_PUMP_COG, state);
	}

}
