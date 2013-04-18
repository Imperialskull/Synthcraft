package com.Imperialskull.mods.synthcraft;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;


@Mod(modid = "Synthcraft", name = "Synthcraft", version = "A-1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Synthcraft 
{
    
    public static final String modid = "Synthcraft";
    
    //INTEGER DECLARATION FOR BLOCKS
    
    //public static integer blocknamehere = integer **
    
    //END INTEGER DECLARATION OF BLOCKS
    
    //BLOCK DECLARATION
    public static Block BlockPlastic;
    public static Block BlockGlowstick;
    public static Block BlockPlexiglass;
    //END BLOCK DECLARATION
    
    
    private static final String[] PlasticBlockColours = {
        "White", "Orange", "Magenta",
        "Light-Blue", "Yellow", "Lime", 
        "Pink", "Grey", "Light-Grey", 
        "Cyan","Purple", "Blue", 
        "Brown", "Green", "Red", "Black"
};
   
    //INSTANCING DECLARATION
    @Instance("Imperialskull.synthcraft")
    public static Synthcraft instance;
    //END INSTANCING DECLARATION
    
    
    
    
    @SidedProxy(clientSide = "com.Imperialskull.mods.synthcraft.client.ClientProxy", serverSide = "com.Imperialskull.mods.synthcraft.CommonProxy")
    public static CommonProxy proxy;
    
    @PreInit
    public void PreInit(FMLPreInitializationEvent event){
        
    }
    
    @Init
    public void Init(FMLInitializationEvent event)
    {
        InitAllBlocks();
        RegisterTheBlocks();
        NameTheBlocks();
    }

    @PostInit
    public void PostInit(FMLPostInitializationEvent event)
    {
        
    }
    
    //tells forge to initialize the block
    public void InitAllBlocks()
    {
        BlockPlastic = new BlockPlastic(500).setUnlocalizedName("imperialskull.synthcraft.BlockPlastic");
        BlockGlowstick = new BlockGlowstick(501, Material.air).setUnlocalizedName("imperialskull.synthcraft.BlockGlowstick");
        BlockPlexiglass = new BlockPlexiglass(502, Material.glass, false).setUnlocalizedName("imperialskull.synthcraft.BlockPlexiglass");
    }
    
    //where all blocks are added to GameRegistry
    public void RegisterTheBlocks()
    {
        GameRegistry.registerBlock(BlockPlastic,ItemPlasticBlock.class,"Imperialskull.synthcraft.PlasticBlock");
        GameRegistry.registerBlock(BlockGlowstick,"Imperialskull.synthcraft.BlockGlowstick");
        GameRegistry.registerBlock(BlockPlexiglass,ItemPlexiglassBlock.class,"Imperialskull.synthcraft.BlockPlexiglass");
        
    }
    
    //SET ALL THE NAMES
    public void NameTheBlocks()
    {
        for (int i = 0; i < 16; i++) {
            LanguageRegistry.addName(new ItemStack(BlockPlastic, 1, i), PlasticBlockColours[new ItemStack(BlockPlastic,1,i).getItemDamage()]+" Plastic Block");
            LanguageRegistry.addName(new ItemStack(BlockPlexiglass, 1, i), PlasticBlockColours[new ItemStack(BlockPlastic,1,i).getItemDamage()]+" Plexiglass");
            
       
        }
        
        LanguageRegistry.addName(BlockGlowstick, "Glowstick");
        LanguageRegistry.addName(BlockPlexiglass,"PlexiGlass");
        }
    
    }
    



        

    

