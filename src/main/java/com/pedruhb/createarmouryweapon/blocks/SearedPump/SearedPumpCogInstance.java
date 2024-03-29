package com.pedruhb.createarmouryweapon.blocks.SearedPump;

import com.jozufozu.flywheel.api.Instancer;
import com.jozufozu.flywheel.api.MaterialManager;
import com.jozufozu.flywheel.api.instance.DynamicInstance;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.base.SingleRotatingInstance;
import com.simibubi.create.content.kinetics.base.flwdata.RotatingData;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class SearedPumpCogInstance extends SingleRotatingInstance<SearedPumpBlockEntity> implements DynamicInstance {

	public SearedPumpCogInstance(MaterialManager materialManager, SearedPumpBlockEntity blockEntity) {
		super(materialManager, blockEntity);
	}
	
	@Override
	public void beginFrame() {}

	@Override
	protected Instancer<RotatingData> getModel() {
		BlockState referenceState = blockEntity.getBlockState();
		Direction facing = referenceState.getValue(BlockStateProperties.FACING);
		return getRotatingMaterial().getModel(AllPartialModels.MECHANICAL_PUMP_COG, referenceState, facing);
	}

}
