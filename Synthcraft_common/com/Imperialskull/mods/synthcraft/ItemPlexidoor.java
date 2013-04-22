package com.Imperialskull.mods.synthcraft;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemPlexidoor extends Item {

    public ItemPlexidoor(int i) {
        super(i);
        maxStackSize = 1;
        this.setCreativeTab(Synthcraft.CreativeTabSynthcraft);
    }
    
    @Override
public void updateIcons(IconRegister par1IconRegister){
this.iconIndex = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.ItemPlexidoor");
    }
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float clickX, float clickY, float clickZ)
    {
        if (side !=1)
            return false;
        
        Block block;
        y++;
        
        block = Synthcraft.BlockPlexidoor;
        
        if (!player.canPlayerEdit(x, y, z, side, stack)|| !player.canPlayerEdit(x, y + 1, z, side, stack))
            return false;
        
        if (!block.canPlaceBlockAt(world, x,y,z))
            return false;
        else
        {
            int i = MathHelper.floor_double((player.rotationYaw + 180F) * 4F / 360F - 0.5D) & 3;
            placeDoorBlock(world, x, y, z, i, block);
            stack.stackSize--;
            return true;
        }
    }
    
    public static void placeDoorBlock(World world, int x, int y, int z, int meta, Block block)
{
byte byte0 = 0;
byte byte1 = 0;

if (meta == 0)
{
byte1 = 1;
}

if (meta == 1)
{
byte0 = -1;
}

if (meta == 2)
{
byte1 = -1;
}

if (meta == 3)
{
byte0 = 1;
}

int i = (world.isBlockNormalCube(x - byte0, y, z - byte1) ? 1 : 0) + (world.isBlockNormalCube(x - byte0, y + 1, z - byte1) ? 1 : 0);
int j = (world.isBlockNormalCube(x + byte0, y, z + byte1) ? 1 : 0) + (world.isBlockNormalCube(x + byte0, y + 1, z + byte1) ? 1 : 0);
boolean flag = world.getBlockId(x - byte0, y, z - byte1) == block.blockID || world.getBlockId(x - byte0, y + 1, z - byte1) == block.blockID;
boolean flag1 = world.getBlockId(x + byte0, y, z + byte1) == block.blockID || world.getBlockId(x + byte0, y + 1, z + byte1) == block.blockID;
boolean flag2 = false;

if (flag && !flag1)
{
flag2 = true;
}
else if (j > i)
{
flag2 = true;
}

world.setBlock(x, y, z, block.blockID, meta, 2);
world.setBlock(x, y + 1, z, block.blockID, 8 | (flag2 ? 1 : 0), 2);

if (world.getBlockId(x, y - 1, z) == Block.grass.blockID)
{
world.setBlock(x, y - 1, z, Block.dirt.blockID);
}



world.notifyBlocksOfNeighborChange(x, y, z, block.blockID);
world.notifyBlocksOfNeighborChange(x, y + 1, z, block.blockID);
}
}



    
  

   