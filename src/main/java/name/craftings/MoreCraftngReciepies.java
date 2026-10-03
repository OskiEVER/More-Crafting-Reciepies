package name.craftings;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreCraftngReciepies implements ModInitializer {
    public static final String MOD_ID = "more-craftng-reciepies";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Inicjalizacja odblokowania bloków technicznych...");

        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            ItemStack stack = player.getItemInHand(hand);
            if (stack.getItem() instanceof BlockItem blockItem) {
                Block block = blockItem.getBlock();
                if (block == Blocks.COMMAND_BLOCK || 
                    block == Blocks.CHAIN_COMMAND_BLOCK || 
                    block == Blocks.REPEATING_COMMAND_BLOCK || 
                    block == Blocks.BARRIER || 
                    block == Blocks.STRUCTURE_BLOCK || 
                    block == Blocks.JIGSAW || 
                    block == Blocks.STRUCTURE_VOID || 
                    block == Blocks.LIGHT) {
                    return InteractionResult.PASS;
                }
            }
            return InteractionResult.PASS;
        });
    }
}