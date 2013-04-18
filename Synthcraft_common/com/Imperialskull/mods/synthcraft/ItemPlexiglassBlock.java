package com.Imperialskull.mods.synthcraft;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;



public class ItemPlexiglassBlock extends ItemBlock 
{
    public static final String[] plexiColours = {
        "white", "orange", "magenta",
        "lBlue", "yellow", "lime", "pink", "gray", "lGray", "cyan",
        "purple", "blue", "brown", "green", "red", "black"
    };
public ItemPlexiglassBlock(int par1){
    super(par1);
    this.setHasSubtypes(true);
}

public int getMetadata(int par1)
{
    return par1;
}

@Override
public String getUnlocalizedName(ItemStack par1ItemStack)
{
    return getUnlocalizedName() + "." + plexiColours[par1ItemStack.getItemDamage()];
}

}



