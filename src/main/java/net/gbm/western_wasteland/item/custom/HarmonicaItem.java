package net.gbm.western_wasteland.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class HarmonicaItem extends InstrumentItem {

    public HarmonicaItem(Properties pProperties, TagKey<Instrument> pInstruments) {
        super(pProperties, pInstruments);
    }


//    @Override
//    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
//        if (pLevel.isClientSide() && pUsedHand == InteractionHand.MAIN_HAND) {
//            // toca som
//            pLevel.playSound(pPlayer, BlockPos.containing(pPlayer.position()), SoundEvents.GOAT_HORN_PLAY,
//                    SoundSource.PLAYERS, 1f, 1f);
//            // add cooldown
//            pPlayer.getCooldowns().addCooldown(this, 10);
//
//        }
//        return super.use(pLevel, pPlayer, pUsedHand);
//    }
}
