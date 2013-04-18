package com.Imperialskull.mods.synthcraft;

import net.minecraft.world.IBlockAccess;

public class BlockGlowingplexiglass {
    
    public int getLightValue(IBlockAccess iblockaccess, int i, int j, int k) {
        int meta = iblockaccess.getBlockMetadata(i, j, k);
        if (meta == 1) return 15;
        return 0;
       }

}
