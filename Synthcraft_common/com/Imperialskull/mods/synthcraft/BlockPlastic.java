package com.Imperialskull.mods.synthcraft;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPlastic extends Block {
    
    private Icon[] plasticColours = new Icon[16];
    
    public BlockPlastic(int blockID){
        super(blockID, Material.wood);
        this.setLightOpacity(15);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(1F);
        this.setResistance(17000000000F);
    }
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return plasticColours[par2];
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
    
    @Override
    public int damageDropped(int par1)
    {
        return par1;
    }
    
    public void registerIcons(IconRegister par1IconRegister)
    {
     this.plasticColours[0] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.PlasticWhite");
     this.plasticColours[1] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.PlasticOrange");
     this.plasticColours[2] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.PlasticMagenta");
     this.plasticColours[3] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.PlasticLBlue");
     this.plasticColours[4] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.PlasticYellow");
     this.plasticColours[5] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.PlasticLime");
     this.plasticColours[6] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.PlasticPink");
     this.plasticColours[7] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.PlasticGrey");
     this.plasticColours[8] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.PlasticLGrey");
     this.plasticColours[9] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.PlasticCyan");
     this.plasticColours[10] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.PlasticPurple");
     this.plasticColours[11] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.PlasticBlue");
     this.plasticColours[12] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.PlasticBrown");
     this.plasticColours[13] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.PlasticGreen");
     this.plasticColours[14] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.PlasticRed");
     this.plasticColours[15] = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.PlasticBlack");
    }

}
