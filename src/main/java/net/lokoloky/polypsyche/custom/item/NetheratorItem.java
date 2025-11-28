package net.lokoloky.polypsyche.custom.item;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class NetheratorItem extends Item {
    private static final Map<Block, Block> NETHERATOR_MAP =
            Map.of(
                    Blocks.STONE, Blocks.BLACKSTONE,
                    Blocks.DIRT, Blocks.NETHERRACK,
                    Blocks.GRASS_BLOCK, Blocks.WARPED_NYLIUM,
                    Blocks.OAK_SAPLING, Blocks.WARPED_FUNGUS,
                    Blocks.OAK_PLANKS, Blocks.WARPED_PLANKS,
                    Blocks.OAK_SLAB, Blocks.WARPED_SLAB,
                    Blocks.OAK_STAIRS, Blocks.WARPED_STAIRS,
                    Blocks.OAK_LOG, Blocks.WARPED_STEM
            );

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        if (NETHERATOR_MAP.containsKey(clickedBlock)) {
            if (!world.isClient) {
                world.setBlockState(context.getBlockPos(), NETHERATOR_MAP.get(clickedBlock).getDefaultState());

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_NETHER_WOOD_PLACE, SoundCategory.BLOCKS);
            }
        }



        return ActionResult.SUCCESS;
    };

    public NetheratorItem(Settings settings) {
        super(settings);
    }
}
