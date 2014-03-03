package sobiohazardous.minestrappolation.extrafoods.item;

import java.util.List;

import sobiohazardous.minestrappolation.extrafoods.ExtraFoods;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class EFFoodSpoilable extends ItemFood
{
        private static long tickTime;
        private int daysFresh;
        private ItemStack spoiledItem;
        private String texture;
        public EFFoodSpoilable(int id, String texture, int healAmount, float saturation, int daysFresh, ItemStack spoiledItem)
        {
                super(id, healAmount, saturation, false);
                this.setCreativeTab(ExtraFoods.tabFoods);
                this.daysFresh = daysFresh;
                this.spoiledItem = spoiledItem;
                this.texture = "crazyfoods:" + texture;

                this.setMaxStackSize(1); // NBT items do not stack
        }

        public static void setFrozen(ItemStack par1ItemStack, boolean frozen)
        {
                boolean flag = isFrozen(par1ItemStack);
                if (flag ^ frozen)
                {
                	setUpdateTicks(par1ItemStack, 0L);
                }
                par1ItemStack.setTagInfo("frozen", new NBTTagByte((String)null, frozen ? (byte)1 : (byte)0));
        }

        public static boolean isFrozen(ItemStack par1ItemStack)
        {
                return par1ItemStack.hasTagCompound() && par1ItemStack.getTagCompound().getByte("frozen") != 0;
        }

        @Override
        public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
                par1ItemStack.setTagInfo("updateTicks",  new NBTTagLong((String)null, 0L));
                par1ItemStack.setTagInfo("lastDimension", new NBTTagInt((String)null, par3EntityPlayer.dimension));
                par1ItemStack.setTagInfo("lastWorldTime", new NBTTagLong((String)null, par2World.getTotalWorldTime()));
        }

        public static long getUpdateTicks(ItemStack par1ItemStack)
        {
                return par1ItemStack.hasTagCompound() ? par1ItemStack.getTagCompound().getLong("updateTicks") : 0L;
        }

        public static void setUpdateTicks(ItemStack par1ItemStack, long ticks)
        {
                par1ItemStack.setTagInfo("updateTicks", new NBTTagLong((String)null, ticks));
        }

        public static long incrementTick(ItemStack par1ItemStack)
        {
                long ticks = getUpdateTicks(par1ItemStack);
                setUpdateTicks(par1ItemStack, ++ticks);
                return ticks;
        }

        public static long getExtraTicks(ItemStack par1ItemStack, World par2World, int dimension)
        {
                long extraTicks = 0L;
                NBTTagCompound tagCompound = par1ItemStack.getTagCompound();
                if (tagCompound != null)
                {
                        if (tagCompound.hasKey("lastDimension") && tagCompound.hasKey("lastWorldTime") && tagCompound.getInteger("lastDimension") == dimension)
                        {
                         extraTicks = par2World.getTotalWorldTime() - tagCompound.getLong("lastWorldTime");
                        }
                }
                par1ItemStack.setTagInfo("lastDimension", new NBTTagInt((String)null, dimension));
                par1ItemStack.setTagInfo("lastWorldTime", new NBTTagLong((String)null, par2World.getTotalWorldTime()));
                return extraTicks;
        }

        @Override
        public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
        {
        	if (!(par3Entity instanceof EntityPlayer))
                {
                        return;
                }

                boolean frozen = isFrozen(par1ItemStack);
                long ticks = !frozen || par2World.rand.nextInt(20) == 0 ? incrementTick(par1ItemStack) : getUpdateTicks(par1ItemStack);
                long extraTicks = getExtraTicks(par1ItemStack, par2World, par3Entity.dimension);
                if (frozen)
                        extraTicks /= 20L;
                if (extraTicks > 0)
                {
                        ticks += extraTicks;
                        setUpdateTicks(par1ItemStack, ticks);
                }
                int daysPassed = (int)(ticks / 24000L);
                if (daysPassed >= this.daysFresh)
                {
                        EntityPlayer player = (EntityPlayer)par3Entity;
                        IInventory inventory = player.inventory;
                        inventory.setInventorySlotContents(par4, this.spoiledItem.copy());
                }
                
                if(this.isFrozen(par1ItemStack) && par4 >= 0)
                {
                	this.setFrozen(par1ItemStack, false);
                }
        }

        @Override
        public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
        {
                boolean frozen = isFrozen(par1ItemStack); // In case you want to add information regarding frozen state
                int daysPassed = (int)(getUpdateTicks(par1ItemStack) / 24000L);
                if (daysPassed >= 0)
                {
                        par3List.add(EnumChatFormatting.RED + "Spoils in: " + Integer.toString(this.daysFresh - daysPassed) + " Days");
                        if(frozen)
                        {
                        	par3List.add(EnumChatFormatting.BLUE + "Frozen");
                        }
                        if(!frozen)
                        {
                        	par3List.add(EnumChatFormatting.BLUE + "Not Frozen");
                        }
                }
        }

        public void registerIcons(IconRegister iconRegister)
        {
                itemIcon = iconRegister.registerIcon(this.texture);
        }
}