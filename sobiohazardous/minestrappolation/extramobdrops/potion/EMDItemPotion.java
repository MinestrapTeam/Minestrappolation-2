package sobiohazardous.minestrappolation.extramobdrops.potion;

import com.google.common.collect.HashMultimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import sobiohazardous.minestrappolation.extramobdrops.ExtraMobDrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class EMDItemPotion extends Item
{
    /** maps potion damage values to lists of effect names */
    private HashMap effectCache = new HashMap();
    private static final Map field_77835_b = new LinkedHashMap();
    @SideOnly(Side.CLIENT)
    private Icon field_94591_c;
    @SideOnly(Side.CLIENT)
    private Icon field_94590_d;
    @SideOnly(Side.CLIENT)
    private Icon field_94592_ct;

    public EMDItemPotion(int par1)
    {
        super(par1);
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(ExtraMobDrops.tabPotions);
    }

    /**
     * Returns a list of potion effects for the specified itemstack.
     */
    public List getEffects(ItemStack par1ItemStack)
    {
        if (par1ItemStack.hasTagCompound() && par1ItemStack.getTagCompound().hasKey("CustomPotionEffects"))
        {
            ArrayList arraylist = new ArrayList();
            NBTTagList nbttaglist = par1ItemStack.getTagCompound().getTagList("CustomPotionEffects");

            for (int i = 0; i < nbttaglist.tagCount(); ++i)
            {
                NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
                arraylist.add(PotionEffect.readCustomPotionEffectFromNBT(nbttagcompound));
            }

            return arraylist;
        }
        else
        {
            List list = (List)this.effectCache.get(Integer.valueOf(par1ItemStack.getItemDamage()));

            if (list == null)
            {
                list = EMDPotionHelper.getPotionEffects(par1ItemStack.getItemDamage(), false);
                this.effectCache.put(Integer.valueOf(par1ItemStack.getItemDamage()), list);
            }

            return list;
        }
    }

    /**
     * Returns a list of effects for the specified potion damage value.
     */
    public List getEffects(int par1)
    {
        List list = (List)this.effectCache.get(Integer.valueOf(par1));

        if (list == null)
        {
            list = EMDPotionHelper.getPotionEffects(par1, false);
            this.effectCache.put(Integer.valueOf(par1), list);
        }

        return list;
    }

    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        if (!par2World.isRemote)
        {
            List list = this.getEffects(par1ItemStack);

            if (list != null)
            {
                Iterator iterator = list.iterator();

                while (iterator.hasNext())
                {
                    PotionEffect potioneffect = (PotionEffect)iterator.next();
                    par3EntityPlayer.addPotionEffect(new PotionEffect(potioneffect));
                }
            }
        }

        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            if (par1ItemStack.stackSize <= 0)
            {
                return new ItemStack(Item.glassBottle);
            }

            par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.glassBottle));
        }

        return par1ItemStack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (isSplash(par1ItemStack.getItemDamage()))
        {
            if (!par3EntityPlayer.capabilities.isCreativeMode)
            {
                --par1ItemStack.stackSize;
            }

            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(new EMDEntityPotion(par2World, par3EntityPlayer, par1ItemStack));
            }

            return par1ItemStack;
        }
        else
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
            return par1ItemStack;
        }
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value
     */
    public Icon getIconFromDamage(int par1)
    {
        return isSplash(par1) ? this.field_94591_c : this.field_94590_d;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value and the given render pass
     */
    public Icon getIconFromDamageForRenderPass(int par1, int par2)
    {
        return par2 == 0 ? this.field_94592_ct : super.getIconFromDamageForRenderPass(par1, par2);
    }

    /**
     * returns wether or not a potion is a throwable splash potion based on damage value
     */
    public static boolean isSplash(int par0)
    {
        return (par0 & 16384) != 0;
    }

    @SideOnly(Side.CLIENT)
    public int getColorFromDamage(int par1)
    {
        return EMDPotionHelper.func_77915_a(par1, false);
    }

    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
        return par2 > 0 ? 16777215 : this.getColorFromDamage(par1ItemStack.getItemDamage());
    }

    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public boolean isEffectInstant(int par1)
    {
        List list = this.getEffects(par1);

        if (list != null && !list.isEmpty())
        {
            Iterator iterator = list.iterator();
            PotionEffect potioneffect;

            do
            {
                if (!iterator.hasNext())
                {
                    return false;
                }

                potioneffect = (PotionEffect)iterator.next();
            }
            while (!Potion.potionTypes[potioneffect.getPotionID()].isInstant());

            return true;
        }
        else
        {
            return false;
        }
    }

    public String getItemDisplayName(ItemStack par1ItemStack)
    {
        if (par1ItemStack.getItemDamage() == 0)
        {
            return StatCollector.translateToLocal("item.emptyPotion.name").trim();
        }
        else
        {
            String s = "";

            if (isSplash(par1ItemStack.getItemDamage()))
            {
                s = StatCollector.translateToLocal("potion.prefix.grenade").trim() + " ";
            }
            
            //TODO Find solution for external potion api
            List list = ExtraMobDrops.potion.getEffects(par1ItemStack);
            String s1;

            if (list != null && !list.isEmpty())
            {
                s1 = ((PotionEffect)list.get(0)).getEffectName();
                s1 = s1 + ".postfix";
                return s + StatCollector.translateToLocal(s1).trim();
            }
            else
            {
                s1 = EMDPotionHelper.func_77905_c(par1ItemStack.getItemDamage());
                return StatCollector.translateToLocal(s1).trim() + " " + super.getItemDisplayName(par1ItemStack);
            }
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        if (par1ItemStack.getItemDamage() != 0)
        {
            List list1 = ExtraMobDrops.potion.getEffects(par1ItemStack);
            HashMultimap hashmultimap = HashMultimap.create();
            Iterator iterator;

            if (list1 != null && !list1.isEmpty())
            {
                iterator = list1.iterator();

                while (iterator.hasNext())
                {
                    PotionEffect potioneffect = (PotionEffect)iterator.next();
                    String s = StatCollector.translateToLocal(potioneffect.getEffectName()).trim();
                    Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
                    Map map = potion.func_111186_k();

                    if (map != null && map.size() > 0)
                    {
                        Iterator iterator1 = map.entrySet().iterator();

                        while (iterator1.hasNext())
                        {
                            Entry entry = (Entry)iterator1.next();
                            AttributeModifier attributemodifier = (AttributeModifier)entry.getValue();
                            AttributeModifier attributemodifier1 = new AttributeModifier(attributemodifier.func_111166_b(), potion.func_111183_a(potioneffect.getAmplifier(), attributemodifier), attributemodifier.func_111169_c());
                            hashmultimap.put(((Attribute)entry.getKey()).func_111108_a(), attributemodifier1);
                        }
                    }

                    if (potioneffect.getAmplifier() > 0)
                    {
                        s = s + " " + StatCollector.translateToLocal("potion.potency." + potioneffect.getAmplifier()).trim();
                    }

                    if (potioneffect.getDuration() > 20)
                    {
                        s = s + " (" + Potion.getDurationString(potioneffect) + ")";
                    }

                    if (potion.isBadEffect())
                    {
                        par3List.add(EnumChatFormatting.RED + s);
                    }
                    else
                    {
                        par3List.add(EnumChatFormatting.GRAY + s);
                    }
                }
            }
            else
            {
                String s1 = StatCollector.translateToLocal("potion.empty").trim();
                par3List.add(EnumChatFormatting.GRAY + s1);
            }

            if (!hashmultimap.isEmpty())
            {
                par3List.add("");
                par3List.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("potion.effects.whenDrank"));
                iterator = hashmultimap.entries().iterator();

                while (iterator.hasNext())
                {
                    Entry entry1 = (Entry)iterator.next();
                    AttributeModifier attributemodifier2 = (AttributeModifier)entry1.getValue();
                    double d0 = attributemodifier2.func_111164_d();
                    double d1;

                    if (attributemodifier2.func_111169_c() != 1 && attributemodifier2.func_111169_c() != 2)
                    {
                        d1 = attributemodifier2.func_111164_d();
                    }
                    else
                    {
                        d1 = attributemodifier2.func_111164_d() * 100.0D;
                    }

                    if (d0 > 0.0D)
                    {
                        par3List.add(EnumChatFormatting.BLUE + StatCollector.translateToLocalFormatted("attribute.modifier.plus." + attributemodifier2.func_111169_c(), new Object[] {ItemStack.field_111284_a.format(d1), StatCollector.translateToLocal("attribute.name." + (String)entry1.getKey())}));
                    }
                    else if (d0 < 0.0D)
                    {
                        d1 *= -1.0D;
                        par3List.add(EnumChatFormatting.RED + StatCollector.translateToLocalFormatted("attribute.modifier.take." + attributemodifier2.func_111169_c(), new Object[] {ItemStack.field_111284_a.format(d1), StatCollector.translateToLocal("attribute.name." + (String)entry1.getKey())}));
                    }
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        List list = this.getEffects(par1ItemStack);
        return list != null && !list.isEmpty();
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        super.getSubItems(par1, par2CreativeTabs, par3List);
        int j;

        if (field_77835_b.isEmpty())
        {
            for (int k = 0; k <= 15; ++k)
            {
                for (j = 0; j <= 1; ++j)
                {
                    int l;

                    if (j == 0)
                    {
                        l = k | 8192;
                    }
                    else
                    {
                        l = k | 16384;
                    }

                    for (int i1 = 0; i1 <= 2; ++i1)
                    {
                        int j1 = l;

                        if (i1 != 0)
                        {
                            if (i1 == 1)
                            {
                                j1 = l | 32;
                            }
                            else if (i1 == 2)
                            {
                                j1 = l | 64;
                            }
                        }

                        List list1 = EMDPotionHelper.getPotionEffects(j1, false);

                        if (list1 != null && !list1.isEmpty())
                        {
                            field_77835_b.put(list1, Integer.valueOf(j1));
                        }
                    }
                }
            }
        }

        Iterator iterator = field_77835_b.values().iterator();

        while (iterator.hasNext())
        {
            j = ((Integer)iterator.next()).intValue();
            par3List.add(new ItemStack(par1, 1, j));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94590_d = par1IconRegister.registerIcon(this.func_111208_A() + "_" + "bottle_drinkable");
        this.field_94591_c = par1IconRegister.registerIcon(this.func_111208_A() + "_" + "bottle_splash");
        this.field_94592_ct = par1IconRegister.registerIcon(this.func_111208_A() + "_" + "overlay");
    }

    @SideOnly(Side.CLIENT)
    public static Icon func_94589_d(String par0Str)
    {
        return par0Str.equals("bottle_drinkable") ? ExtraMobDrops.potion.field_94590_d : (par0Str.equals("bottle_splash") ? ExtraMobDrops.potion.field_94591_c : (par0Str.equals("overlay") ? ExtraMobDrops.potion.field_94592_ct : null));
    }
}
