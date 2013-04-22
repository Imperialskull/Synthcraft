package com.Imperialskull.mods.synthcraft;

import java.io.File;
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
    // CONFIG SETUP DEC
    public static Configuration config;
    public static File configDir;
    
    //INTEGER DECLARATION FOR BLOCKS (CFG)
    
    public static int BlockPlasticID = 1000;
    public static int BlockGlowstickID = 1001;
    public static int BlockPlexiglassID = 1002;
    public static int BlockGlowingplexiglassID = 1003;
    public static int BlockPlexidoorID = 1004;
    //END INTEGER DECLARATION OF BLOCKS
    
    //INTEGER DECLARATION FOR ITEMS (CFG)
    public static int ItemPlexidoorID = 2000;

            
    //END INETEGER DECLARATION FOR ITEMS
    
    //BLOCK DECLARATION
    public static Block BlockPlastic;
    public static Block BlockGlowstick;
    public static Block BlockPlexiglass;
    public static Block BlockGlowingplexiglass;
    public static Block BlockPlexidoor;

    //END BLOCK DECLARATION
    
    //ITEM DECLARATION
    public static Item ItemPlexidoor;

    //END ITEM DECLARATION
    
    //CREATIVETAB
    public static CreativeTabs CreativeTabSynthcraft;
    
    
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
        configDir = event.getModConfigurationDirectory();
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        //BLOCKS
        BlockPlasticID = config.getBlock("Plastic Block ID",BlockPlasticID).getInt();
        BlockGlowstickID = config.getBlock("Glowstick ID",BlockGlowstickID).getInt();
        BlockPlexiglassID = config.getBlock("Plexiglass ID", BlockPlexiglassID).getInt();
        BlockGlowingplexiglassID = config.getBlock("Plexiglow ID", BlockGlowingplexiglassID).getInt();
        BlockPlexidoorID = config.getBlock("Plexidoor ID",BlockPlexidoorID).getInt();
        //ITEMS
        ItemPlexidoorID = config.getItem("Plexidoor item ID", ItemPlexidoorID).getInt();

        //CONFIG END
        config.save();
        
    }
    
    @Init
    public void Init(FMLInitializationEvent event)
    {
        if(event.getSide() == Side.CLIENT)
        {
            registerCreativeTab();
            }
        
        InitAllBlocks();
        RegisterTheBlocks();
        NameTheBlocks();
        InitAllItems();
        NameTheItems();
    }

    @PostInit
    public void PostInit(FMLPostInitializationEvent event)
    {
        
    }
    
    public void registerCreativeTab(){
        CreativeTabSynthcraft = new com.Imperialskull.mods.synthcraft.client.CreativeTabSynthcraft("Imperialskull.synthcraft");
        LanguageRegistry.instance().addStringLocalization("itemGroup." + CreativeTabSynthcraft.getTabLabel(), CommonProxy.modName);
}
    
    //tells forge to initialize the block
    public void InitAllBlocks()
    {
        BlockPlastic = new BlockPlastic(BlockPlasticID).setUnlocalizedName("imperialskull.synthcraft.BlockPlastic");
        BlockGlowstick = new BlockGlowstick(BlockGlowstickID, Material.air).setUnlocalizedName("imperialskull.synthcraft.BlockGlowstick");
        BlockPlexiglass = new BlockPlexiglass(BlockPlexiglassID, Material.glass, false).setUnlocalizedName("imperialskull.synthcraft.BlockPlexiglass");
        BlockGlowingplexiglass = new BlockGlowingplexiglass(BlockGlowingplexiglassID,Material.glass, null, false).setUnlocalizedName("imperialskull.synthcraft.BlockGlowingplexiglass");
        BlockPlexidoor = new BlockPlexidoor(BlockPlexidoorID, Material.glass, false).setUnlocalizedName("imperialskull.synthcraft.BlockPlexidoor");

    }
    
    //where all blocks are added to GameRegistry
    public void RegisterTheBlocks()
    {
        GameRegistry.registerBlock(BlockPlastic,ItemPlasticBlock.class,"Imperialskull.synthcraft.PlasticBlock");
        GameRegistry.registerBlock(BlockGlowstick,"Imperialskull.synthcraft.BlockGlowstick");
        GameRegistry.registerBlock(BlockPlexiglass,ItemPlexiglassBlock.class,"Imperialskull.synthcraft.BlockPlexiglass");
        GameRegistry.registerBlock(BlockGlowingplexiglass,ItemGlowingplexiglass.class,"Imperialskull.synthcraft.BlockGlowingplexiglass");
        GameRegistry.registerBlock(BlockPlexidoor,"Imperialskull.synthcraft.BlockPlexidoor");

        
        
    }
    
    //SET ALL THE NAMES
    public void NameTheBlocks()
    {
        for (int i = 0; i < 16; i++) {
            LanguageRegistry.addName(new ItemStack(BlockPlastic, 1, i), PlasticBlockColours[new ItemStack(BlockPlastic,1,i).getItemDamage()]+" Plastic Block");
            LanguageRegistry.addName(new ItemStack(BlockPlexiglass, 1, i), PlasticBlockColours[new ItemStack(BlockPlexiglass,1,i).getItemDamage()]+" Plexiglass");
            LanguageRegistry.addName(new ItemStack(BlockGlowingplexiglass, 1, i), PlasticBlockColours[new ItemStack(BlockGlowingplexiglass,1,i).getItemDamage()]+" Plexiglow");
            LanguageRegistry.addName(new ItemStack(BlockPlexidoor, 1, i), PlasticBlockColours[new ItemStack(BlockPlexidoor,1,i).getItemDamage()]+" Plexidoor");
            
            
            
       
        }
        
        LanguageRegistry.addName(BlockGlowstick, "Glowstick");

        }
    public void InitAllItems(){
       ItemPlexidoor = new ItemPlexidoor(ItemPlexidoorID).setUnlocalizedName("Imperialskull.synthcraft.ItemPlexidoor");
        
    }
    
    public void NameTheItems(){
        LanguageRegistry.addName(ItemPlexidoor, "plexidoor");

    }
    
    }
    



        

    

