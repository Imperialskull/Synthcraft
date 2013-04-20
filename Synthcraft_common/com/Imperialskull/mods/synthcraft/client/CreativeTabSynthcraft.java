package com.Imperialskull.mods.synthcraft.client;

import com.Imperialskull.mods.synthcraft.Synthcraft;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public final class CreativeTabSynthcraft extends CreativeTabs
{
    public CreativeTabSynthcraft(String label)
    {
        super(label);
    }
    
    CreativeTabSynthcraft(int par1, String par2Str)
    {
        super(par1, par2Str);
    }

    @SideOnly(Side.CLIENT)

    /**
* the itemID for the item to be displayed on the tab
*/
    public int getTabIconItemIndex()
    {
        return Synthcraft.BlockPlastic.blockID;
    }
}