package net.gbm.western_wasteland.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.data.SoundDefinition;

import static net.minecraft.world.damagesource.DamageTypes.THORNS;

public class TrapBlock extends Block {
    public TrapBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {

        pLevel.playSound(pEntity, pPos, SoundEvents.NOTE_BLOCK_GUITAR.get(),
                SoundSource.BLOCKS, 1f, 1f);


        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
