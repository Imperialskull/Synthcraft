package com.Imperialskull.mods.synthcraft.client;

import org.lwjgl.opengl.GL11;

import com.Imperialskull.mods.synthcraft.Synthcraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class RenderPlexiboat extends Render {
    protected ModelBase boat;
    
    public RenderPlexiboat(){
      shadowSize = 0.5F;
      boat = new ModelPlexiboat();
    }
    
    @SideOnly(Side.CLIENT)

    /**
* Returns the texture's file path as a String.
*/
    public String getTexture()
    {
        return "mods/synthcraft/item/plexiboat.png";
    }


    public String setTexture()
    {
     return "/mods/synthcraft/item/plexiboat.png";
    }

    public void renderBoat(EntityPlexiboat entityplexiboat, double d, double d1, double d2, float f1, float f2) {

      GL11.glPushMatrix();
      GL11.glTranslatef((float)d, (float)d1, (float)d2);
      GL11.glRotatef(180F - f1, 0.0F, 1.0F, 0.0F);
      loadTexture("com/Imperialskull/mods/synthcraft/item/plexiboatboat.png");
      
      float f3 = (float)entityplexiboat.getTimeSinceHit() - f2;
      float f4 = (float)entityplexiboat.getDamageTaken() - f2;
      if(f4 < 0.0F) f4 = 0.0F;
      if(f3 > 0.0F) GL11.glRotatef(((MathHelper.sin(f3) * f3 * f4) / 10F) * (float)entityplexiboat.getForwardDirection(), 1.0F, 0.0F, 0.0F);
      
      GL11.glEnable(GL11.GL_TEXTURE_2D);
      loadTexture("com/Imperialskull/mods/synthcraft/item/plexiboatboat.png");
      float f5 = 0.75F;
      GL11.glScalef(f5, f5, f5);
      GL11.glScalef(1.0F / f5, 1.0F / f5, 1.0F / f5);
      loadTexture("com/Imperialskull/mods/synthcraft/item/plexiboat.png");
      GL11.glScalef(-1F, -1F, 1.0F);
      boat.render(entityplexiboat, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      GL11.glEnable(GL11.GL_TEXTURE_2D);
      GL11.glPopMatrix();
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f1, float f2) {
      renderBoat((EntityPlexiboat)entity, d, d1, d2, f1, f2);
    }
    




  }