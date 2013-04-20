package com.Imperialskull.mods.synthcraft;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockPlexiglass extends BlockBreakable 

{
    private Icon[] plexiColours = new Icon[16];
    
    public BlockPlexiglass(int par1, Material par2Material, boolean par3)
    {
        super(par1, "glass", par2Material, par3);
        this.setCreativeTab(Synthcraft.CreativeTabSynthcraft);
        this.setHardness(1F);
        this.setResistance(17000000000F);
        this.setLightOpacity(0);
        this.setStepSound(soundGlassFootstep);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return plexiColours[par2];
    }
    
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(int par1, CreativeTabs par2Creativetabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
        par3List.add(new ItemStack(par1, 1, 4));
        par3List.add(new ItemStack(par1, 1, 5));
        par3List.add(new ItemStack(par1, 1, 6));
        par3List.add(new ItemStack(par1, 1, 7));
        par3List.add(new ItemStack(par1, 1, 8));
        par3List.add(new ItemStack(par1, 1, 9));
        par3List.add(new ItemStack(par1, 1, 10));
        par3List.add(new ItemStack(par1, 1, 11));
        par3List.add(new ItemStack(par1, 1, 12));
        par3List.add(new ItemStack(par1, 1, 13));
        par3List.add(new ItemStack(par1, 1, 14));
        par3List.add(new ItemStack(par1, 1, 15));
    }


    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }


    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
        return super.shouldSideBeRendered(iblockaccess, i, j, k, 1 - l);
      }
    
    @Override
    public int damageDropped(int par1)
    {
        return par1;
    }
    
     public void registerIcons(IconRegister par1IconRegister)
    {
     this.plexiColours[0] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPlexiGlass");
     this.plexiColours[1] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPlexiOrange");
     this.plexiColours[2] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPleximagenta");
     this.plexiColours[3] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPlexiLBlue");
     this.plexiColours[4] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPlexiYellow");
     this.plexiColours[5] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPlexiLime");
     this.plexiColours[6] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPlexiPink");
     this.plexiColours[7] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPlexiGrey");
     this.plexiColours[8] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPlexiLgrey");
     this.plexiColours[9] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPlexiCyan");
     this.plexiColours[10] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPlexiPurple");
     this.plexiColours[11] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPlexiBlue");
     this.plexiColours[12] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPlexiBrown");
     this.plexiColours[13] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPlexiGreen");
     this.plexiColours[14] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPlexiRed");
     this.plexiColours[15] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPlexiBlack");
    }

}