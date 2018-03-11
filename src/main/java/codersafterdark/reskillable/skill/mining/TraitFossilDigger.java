package codersafterdark.reskillable.skill.mining;

import codersafterdark.reskillable.base.ConditionHelper;
import codersafterdark.reskillable.api.unlockable.Trait;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class TraitFossilDigger extends Trait {

    public TraitFossilDigger() {
        super("fossil_digger", 2, 1, 2, "mining:6");
    }

    @Override
    public void onBlockDrops(HarvestDropsEvent event) {
        EntityPlayer player = event.getHarvester();
        IBlockState state = event.getState();

        if (state.getBlock() == Blocks.COAL_ORE && ConditionHelper.hasRightTool(player, state, "pickaxe", ToolMaterial.IRON.getHarvestLevel())
                && player.world.rand.nextInt(10) == 0 && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, player.getHeldItemMainhand()) == 0)
            event.getDrops().add(new ItemStack(Items.COAL));
    }


}
