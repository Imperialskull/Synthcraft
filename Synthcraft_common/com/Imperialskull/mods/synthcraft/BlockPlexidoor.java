package com.Imperialskull.mods.synthcraft;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPlexidoor extends BlockBreakable
{
    
    public BlockPlexidoor(int par1, Material par2Material, boolean par3)
    {
        super(par1, "glass", par2Material, par3);
        this.setHardness(1);
        this.setResistance(17000000000F);
        this.setLightOpacity(0);
        this.setStepSound(soundGlassFootstep);
  
        float f = 0.5F;
        float f1 = 1.0F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
        }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    blockIcon = par1IconRegister.registerIcon("synthcraft:Imperialskull.synthcraft.BlockPlexiGlass");
    }
    
    @Override
public boolean isOpaqueCube()
{
return false;
}
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

@Override
public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
{
int i = getFullMetadata(par1IBlockAccess, par2, par3, par4);
return (i & 4) != 0;
}

@Override
public boolean renderAsNormalBlock()
{
return false;
}

/**
* The type of render function that is called for this block
*/
@Override
public int getRenderType()
{
return 0;
}

/**
* Returns the bounding box of the wired rectangular prism to render.
*/
@Override
public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
{
setBlockBoundsBasedOnState(par1World, par2, par3, par4);
return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
}

/**
* Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
* cleared to be reused)
*/
@Override
public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
{
setBlockBoundsBasedOnState(par1World, par2, par3, par4);
return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
}

/**
* Updates the blocks bounds based on its current state. Args: world, x, y, z
*/
@Override
public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
{
setDoorRotation(getFullMetadata(par1IBlockAccess, par2, par3, par4));
}

/**
* Returns 0, 1, 2 or 3 depending on where the hinge is.
*/
public int getDoorOrientation(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
{
return getFullMetadata(par1IBlockAccess, par2, par3, par4) & 3;
}

public boolean func_48213_h(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
{
return (getFullMetadata(par1IBlockAccess, par2, par3, par4) & 4) != 0;
}

private void setDoorRotation(int par1)
{
float f = 0.1875F;

setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
int i = par1 & 3;

boolean flag = (par1 & 4) != 0;
boolean flag1 = (par1 & 0x10) != 0;

if (i == 0)
{
if (!flag)
{
setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
}
else if (!flag1)
{
setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
}
else
{
setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
}
}
else if (i == 1)
{
if (!flag)
{
setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
}
else if (!flag1)
{
setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
}
else
{
setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
}
}
else if (i == 2)
{
if (!flag)
{
setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
}
else if (!flag1)
{
setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
}
else
{
setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
}
}
else if (i == 3)
if (!flag)
{
setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
}
else if (!flag1)
{
setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
}
else
{
setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
}
}

/**
* Called upon block activation (left or right click on the block.). The three integers represent x,y,z of the
* block.
*/
@Override
public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int something, float somthin1, float somethin2, float something3)
{
if (blockMaterial.equals(Material.iron))
return true;

int i = getFullMetadata(par1World, par2, par3, par4);
int j = i & 7;
j ^= 4;

if ((i & 8) != 0)
{
par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, j, 2);
par1World.markBlocksDirtyVertical(par2, par4, par3 - 1, par3);
}
else
{
par1World.setBlockMetadataWithNotify(par2, par3, par4, j, 2);
par1World.markBlockForUpdate(par2, par3, par4);
}

par1World.playAuxSFXAtEntity(par5EntityPlayer, 1003, par2, par3, par4, 0);
return true;
}

/**
* A function to open a door.
*/
public void onPoweredBlockChange(World par1World, int par2, int par3, int par4, boolean par5)
{
int i = getFullMetadata(par1World, par2, par3, par4);
boolean flag = (i & 4) != 0;

if (flag == par5)
return;

int j = i & 7;
j ^= 4;

if ((i & 8) != 0)
{
par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, j, 2);
par1World.markBlocksDirtyVertical(par2, par4, par3 - 1, par3);
}
else
{
par1World.setBlockMetadataWithNotify(par2, par3, par4, j, 2);
par1World.markBlockForUpdate(par2, par3, par4);
}

par1World.playAuxSFXAtEntity(null, 1003, par2, par3, par4, 0);
}

/**
* Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
* their own) Args: x, y, z, neighbor blockID
*/
@Override
public void onNeighborBlockChange(World world, int x, int y, int z, int id)
{
int i1 = world.getBlockMetadata(x, y, z);

if ((i1 & 8) == 0)
{
boolean flag = false;

if (world.getBlockId(x, y + 1, z) != blockID)
{
world.setBlockToAir(x, y, z);
flag = true;
}

if (!world.doesBlockHaveSolidTopSurface(x, y - 1, z))
{
world.setBlockToAir(x, y, z);
flag = true;

if (world.getBlockId(x, y + 1, z) == blockID)
{
world.setBlockToAir(x, y + 1, z);
}
}

if (flag)
{
if (!world.isRemote)
{
dropBlockAsItem(world, x, y, z, i1, 0);
}
}
else
{
boolean flag1 = world.isBlockIndirectlyGettingPowered(x, y, z) || world.isBlockIndirectlyGettingPowered(x, y + 1, z);

if ((flag1 || id > 0 && Block.blocksList[id].canProvidePower()) && id != blockID)
{
onPoweredBlockChange(world, x, y, z, flag1);
}
}
}
else
{
if (world.getBlockId(x, y - 1, z) != blockID)
{
world.setBlockToAir(x, y, z);
}

if (id > 0 && id != blockID)
{
onNeighborBlockChange(world, x, y - 1, z, id);
}
}
}

/**
* Returns the ID of the items to drop on destruction.
*/
@Override
public int idDropped(int par1, Random par2Random, int par3)
{
return Synthcraft.ItemPlexidoor.itemID;}


/**
* Ray traces through the blocks collision from start vector to end vector returning a ray trace hit. Args: world,
* x, y, z, startVec, endVec
*/
@Override
public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3D, Vec3 par6Vec3D)
{
setBlockBoundsBasedOnState(par1World, par2, par3, par4);
return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3D, par6Vec3D);
}


/**
* Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
*/
@Override
public boolean canPlaceBlockAt(World world, int x, int y, int z)
{
if (y >= 255)
return false;

return world.doesBlockHaveSolidTopSurface(x, y - 1, z) && super.canPlaceBlockAt(world, x, y, z) && super.canPlaceBlockAt(world, x, y + 1, z);
}

/**
* Returns the mobility information of the block, 0 = free, 1 = can't push but can move over, 2 = total immobility
* and stop pistons
*/
@Override
public int getMobilityFlag()
{
return 1;
}

/**
* Returns the full metadata value created by combining the metadata of both blocks the door takes up.
*/
public int getFullMetadata(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
{
int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
boolean flag = (i & 8) != 0;
int j;
int k;

if (flag)
{
j = par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4);
k = i;
}
else
{
j = i;
k = par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4);
}

boolean flag1 = (k & 1) != 0;
int l = j & 7 | (flag ? 8 : 0) | (flag1 ? 0x10 : 0);
return l;
}

@Override
public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player)
{
if (player.capabilities.isCreativeMode && (meta & 8) != 0 && world.getBlockId(x, y - 1, z) == blockID)
{
world.setBlockToAir(x, y - 1, z);
}
}
    }


