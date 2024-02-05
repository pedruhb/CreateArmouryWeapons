package com.pedruhb.createarmouryweapon.blocks.CastingDepot;

import javax.annotation.ParametersAreNonnullByDefault;

import com.pedruhb.createarmouryweapon.CreateArmouryWeapon;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.block.ProperWaterloggedBlock;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import java.util.stream.Stream;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CastingDepotBlock extends Block
		implements IBE<CastingDepotBlockEntity>, IWrenchable, ProperWaterloggedBlock {

	public CastingDepotBlock(Properties p_i48440_1_) {
		super(p_i48440_1_);
		registerDefaultState(defaultBlockState().setValue(WATERLOGGED, false));
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> pBuilder) {
		super.createBlockStateDefinition(pBuilder.add(WATERLOGGED));
	}

	@Override
	public FluidState getFluidState(BlockState pState) {
		return fluidState(pState);
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState,
			LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		updateWater(pLevel, pState, pCurrentPos);
		return pState;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return withWater(super.getStateForPlacement(pContext), pContext);
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return shape;
	}

	static final VoxelShape shape = Stream.of(
		Block.box(0, 0, 12, 4, 11, 16),
		Block.box(12, 0, 12, 16, 11, 16),
		Block.box(0, 0, 0, 4, 11, 4),
		Block.box(12, 0, 0, 16, 11, 4),
		Block.box(12, 7, 4, 16, 11, 12),
		Block.box(4, 7, 0, 12, 11, 4),
		Block.box(4, 7, 12, 12, 11, 16),
		Block.box(0, 7, 4, 4, 11, 12),
		Block.box(4, 7, 4, 12, 11, 12),
		Block.box(1, 11, 1, 2, 13, 15),
		Block.box(2, 11, 1, 14, 13, 2),
		Block.box(14, 11, 1, 15, 13, 15),
		Block.box(2, 11, 14, 14, 13, 15),
		Block.box(2, 10, 2, 14, 12, 14),
		Block.box(0, 11, 0, 1, 13, 16),
		Block.box(15, 11, 0, 16, 13, 16),
		Block.box(1, 11, 0, 15, 13, 1),
		Block.box(1, 11, 15, 15, 13, 16)
			).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

	@Override
	public Class<CastingDepotBlockEntity> getBlockEntityClass() {
		return CastingDepotBlockEntity.class;
	}

	@Override
	public BlockEntityType<? extends CastingDepotBlockEntity> getBlockEntityType() {
		return CreateArmouryWeapon.CASTING_DEPOT_ENTITY.get();
	}

	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult ray) {
		return SharedCastingDepotBlockMethods.onUse(state, world, pos, player, hand, ray);
	}

	@Override
	public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		IBE.onRemove(state, worldIn, pos, newState);
	}

	@Override
	public void updateEntityAfterFallOn(BlockGetter worldIn, Entity entityIn) {
		super.updateEntityAfterFallOn(worldIn, entityIn);
		SharedCastingDepotBlockMethods.onLanded(worldIn, entityIn);
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level worldIn, BlockPos pos) {
		return SharedCastingDepotBlockMethods.getComparatorInputOverride(blockState, worldIn, pos);
	}

	@Override
	public boolean isPathfindable(BlockState state, BlockGetter reader, BlockPos pos, PathComputationType type) {
		return false;
	}

}