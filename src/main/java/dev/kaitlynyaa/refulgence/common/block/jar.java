package dev.kaitlynyaa.refulgence.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class jar extends Block {
    private static final VoxelShape JAR_SHAPE = Block.createCuboidShape(4, 0, 4, 12, 13, 12);
    public jar(Settings settings) {
		super(settings);
	}
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return JAR_SHAPE;
	}
    @Override
	public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return JAR_SHAPE;
	}
}