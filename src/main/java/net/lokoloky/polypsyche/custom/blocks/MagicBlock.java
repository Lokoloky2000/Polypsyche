package net.lokoloky.polypsyche.custom.blocks;

import net.lokoloky.polypsyche.block.ModBlocks;
import net.lokoloky.polypsyche.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagicBlock extends Block {
    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

            world.playSound(player, pos, SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.BLOCKS, 1f, 1f);

        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity ItemEntity){
            if(ItemEntity.getStack().getItem() == ModItems.RAW_PINK_GARNET){
                ItemEntity.setStack(new ItemStack(ModItems.PINK_GARNET, ItemEntity.getStack().getCount()));
            }
        }
        if (entity instanceof ItemEntity ItemEntity){
            if(ItemEntity.getStack().getItem() == ModBlocks.RAW_PINK_GARNET_BLOCK.asItem()){
                ItemEntity.setStack(new ItemStack(ModBlocks.PINK_GARNET_BLOCK, ItemEntity.getStack().getCount()));
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    public MagicBlock(Settings settings) {
        super(settings);
    }
}
