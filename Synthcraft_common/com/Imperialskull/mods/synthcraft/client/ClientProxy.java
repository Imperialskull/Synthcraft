package com.Imperialskull.mods.synthcraft.client;

import com.Imperialskull.mods.synthcraft.CommonProxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.model.ModelBoat;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
@Override
      public void registerRenderThings()
{   
    RenderingRegistry.registerEntityRenderingHandler(EntityPlexiboat.class, new RenderPlexiboat());
   
    
}

public void preInit()
{
    MinecraftForge.EVENT_BUS.register(this);
}

}