package clashsoft.playerinventoryapi.client.gui;

import static clashsoft.playerinventoryapi.CreativeInventory.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import clashsoft.cslib.math.Point2i;
import clashsoft.cslib.minecraft.client.gui.GuiBuilder;
import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.playerinventoryapi.CreativeInventory;
import clashsoft.playerinventoryapi.PlayerInventoryAPI;
import clashsoft.playerinventoryapi.api.IInventoryHandler;
import clashsoft.playerinventoryapi.api.invobject.IInventoryObject;
import clashsoft.playerinventoryapi.inventory.ContainerCreativeList;
import clashsoft.playerinventoryapi.inventory.ContainerInventory;
import clashsoft.playerinventoryapi.inventory.SlotCreative;
import clashsoft.playerinventoryapi.lib.ExtendedInventory;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.CreativeCrafting;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public class GuiCreativeInventory extends GuiBasicInventory
{
	private static final ResourceLocation			background			= new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
	private static InventoryBasic					inventory			= new InventoryBasic("tmp", true, 45);
	
	private EntityPlayer							player;
	
	private static int								selectedTabIndex	= CreativeTabs.tabBlock.getTabIndex();
	private float									currentScroll;
	private boolean									isScrolling;
	private boolean									wasClicking;
	private GuiTextField							searchField;
	private List									backupSlots;
	private Slot									binSlot;
	private boolean									mouseClicked;
	private CreativeCrafting						creativeCrafting;
	private static int								tabPage				= 0;
	private int										maxPages			= 0;
	
	protected GuiButton								buttonPrevPage;
	protected GuiButton								buttonNextPage;
	
	protected GuiBuilder							guiBuilder;
	
	public GuiCreativeInventory(EntityPlayer player, ContainerCreativeList creativelist, ContainerInventory container)
	{
		super(creativelist);
		
		container.onContainerOpened(player);
		
		this.allowUserInput = true;
		this.player = player;
		this.player.addStat(AchievementList.openInventory, 1);
		
		this.xSize = windowWidth;
		this.ySize = windowHeight;
		
		this.guiBuilder = new GuiBuilder(this);
	}
	
	@Override
	public void updateScreen()
	{
		super.updateScreen();
		
		if (!this.mc.playerController.isInCreativeMode())
		{
			this.mc.displayGuiScreen(new GuiSurvivalInventory(this.player, (ContainerInventory) this.player.inventoryContainer));
		}
		
		this.buttonPrevPage.enabled = tabPage > 0;
		this.buttonNextPage.enabled = tabPage < this.maxPages;
	}
	
	@Override
	public void initGui()
	{
		if (!this.mc.playerController.isInCreativeMode())
		{
			this.mc.displayGuiScreen(new GuiSurvivalInventory(this.player, (ContainerInventory) this.player.inventoryContainer));
		}
		
		super.initGui();
		this.buttonList.addAll(buttons);
		
		Keyboard.enableRepeatEvents(true);
		
		this.searchField = new GuiTextField(this.fontRendererObj, this.guiLeft + 82, this.guiTop + 6, 89, this.fontRendererObj.FONT_HEIGHT);
		this.searchField.setMaxStringLength(15);
		this.searchField.setEnableBackgroundDrawing(false);
		this.searchField.setVisible(false);
		this.searchField.setTextColor(16777215);
		
		int i = selectedTabIndex;
		selectedTabIndex = -1;
		this.setCurrentCreativeTab(CreativeTabs.creativeTabArray[i]);
		
		this.creativeCrafting = new CreativeCrafting(this.mc);
		this.mc.thePlayer.inventoryContainer.addCraftingToCrafters(this.creativeCrafting);
		int tabCount = CreativeTabs.creativeTabArray.length;
		if (tabCount > 12)
		{
			this.buttonList.add(this.buttonPrevPage = new GuiButton(0, this.guiLeft, this.guiTop - 50, 20, 20, "<"));
			this.buttonList.add(this.buttonNextPage = new GuiButton(1, this.guiLeft + this.xSize - 20, this.guiTop - 50, 20, 20, ">"));
			this.maxPages = (tabCount - 12) / 10 + 1;
		}
	}
	
	@Override
	public void onGuiClosed()
	{
		super.onGuiClosed();
		
		if (this.mc.thePlayer != null && this.mc.thePlayer.inventory != null)
		{
			this.mc.thePlayer.inventoryContainer.removeCraftingFromCrafters(this.creativeCrafting);
		}
		
		Keyboard.enableRepeatEvents(false);
	}
	
	private void setCurrentCreativeTab(CreativeTabs tab)
	{
		if (tab == null)
		{
			return;
		}
		
		int prevTabIndex = selectedTabIndex;
		selectedTabIndex = tab.getTabIndex();
		ContainerCreativeList containercreative = (ContainerCreativeList) this.inventorySlots;
		this.field_147008_s.clear();
		containercreative.itemList.clear();
		tab.displayAllReleventItems(containercreative.itemList);
		
		if (tab == CreativeTabs.tabInventory)
		{
			this.xSize = windowWidth;
			this.ySize = windowHeight;
			
			ContainerInventory container = (ContainerInventory) this.mc.thePlayer.inventoryContainer;
			
			if (this.backupSlots == null)
			{
				this.backupSlots = containercreative.inventorySlots;
			}
			
			containercreative.inventorySlots = new ArrayList();
			
			for (int j = 0; j < container.inventorySlots.size(); ++j)
			{
				SlotCreative creativeslot = new SlotCreative((Slot) container.inventorySlots.get(j), j);
				containercreative.inventorySlots.add(creativeslot);
			}
			
			this.binSlot = new Slot(inventory, 0, binSlotX, binSlotY);
			containercreative.inventorySlots.add(this.binSlot);
		}
		else
		{
			this.xSize = 195;
			this.ySize = 136;
			if (prevTabIndex == CreativeTabs.tabInventory.getTabIndex())
			{
				ContainerInventory container = (ContainerInventory) this.mc.thePlayer.inventoryContainer;
				
				containercreative.inventorySlots = this.backupSlots;
				this.backupSlots = null;
			}
		}
		
		if (this.searchField != null)
		{
			if (tab.hasSearchBar())
			{
				this.searchField.setVisible(true);
				this.searchField.setCanLoseFocus(false);
				this.searchField.setFocused(true);
				this.searchField.setText("");
				this.updateCreativeSearch();
			}
			else
			{
				this.searchField.setVisible(false);
				this.searchField.setCanLoseFocus(true);
				this.searchField.setFocused(false);
			}
		}
		
		this.currentScroll = 0.0F;
		containercreative.scrollTo(0.0F);
	}
	
	private void updateCreativeSearch()
	{
		ContainerCreativeList containercreative = (ContainerCreativeList) this.inventorySlots;
		containercreative.itemList.clear();
		
		CreativeTabs tab = CreativeTabs.creativeTabArray[selectedTabIndex];
		
		Iterator iterator = Item.itemRegistry.iterator();
		
		while (iterator.hasNext())
		{
			Item item = (Item) iterator.next();
			
			if (item != null && item.getCreativeTab() != null)
			{
				item.getSubItems(item, null, containercreative.itemList);
			}
		}
		this.updateFilteredItems(containercreative);
	}
	
	private void updateFilteredItems(ContainerCreativeList containercreative)
	{
		Enchantment[] aenchantment = Enchantment.enchantmentsList;
		int j = aenchantment.length;
		
		for (int i = 0; i < j; ++i)
		{
			Enchantment enchantment = aenchantment[i];
			
			if (enchantment == null || enchantment.type == null)
			{
				continue;
			}
			Items.enchanted_book.func_92113_a(enchantment, containercreative.itemList);
		}
		
		Iterator iterator = containercreative.itemList.iterator();
		String s1 = this.searchField.getText().toLowerCase();
		
		label0:
		while (iterator.hasNext())
		{
			ItemStack itemstack = (ItemStack) iterator.next();
			List<String> tooltip = itemstack.getTooltip(this.mc.thePlayer, this.mc.gameSettings.advancedItemTooltips);
			
			for (String s : tooltip)
			{
				if (s.toLowerCase().contains(s1))
				{
					continue label0;
				}
			}
			iterator.remove();
		}
		
		this.currentScroll = 0.0F;
		containercreative.scrollTo(0.0F);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTickTime)
	{
		boolean flag = Mouse.isButtonDown(0);
		int k = this.guiLeft;
		int l = this.guiTop;
		int i1 = k + 175;
		int j1 = l + 18;
		int k1 = i1 + 14;
		int l1 = j1 + 112;
		
		if (!this.wasClicking && flag && mouseX >= i1 && mouseY >= j1 && mouseX < k1 && mouseY < l1)
		{
			this.isScrolling = this.needsScrollBars();
		}
		
		if (!flag)
		{
			this.isScrolling = false;
		}
		
		this.wasClicking = flag;
		
		if (this.isScrolling)
		{
			this.currentScroll = (mouseY - j1 - 7.5F) / (l1 - j1 - 15.0F);
			
			if (this.currentScroll < 0.0F)
			{
				this.currentScroll = 0.0F;
			}
			
			if (this.currentScroll > 1.0F)
			{
				this.currentScroll = 1.0F;
			}
			
			((ContainerCreativeList) this.inventorySlots).scrollTo(this.currentScroll);
		}
		
		super.drawScreen(mouseX, mouseY, partialTickTime);
		
		if (this.maxPages != 0)
		{
			String page = String.format("%d / %d", new Object[] { Integer.valueOf(tabPage + 1), Integer.valueOf(this.maxPages + 1) });
			int width = this.fontRendererObj.getStringWidth(page);
			GL11.glDisable(2896);
			this.fontRendererObj.drawString(page, this.guiLeft + (this.xSize - width) / 2, this.guiTop - 44, -1);
		}
		
		CreativeTabs[] tabs = CreativeTabs.creativeTabArray;
		int start = tabPage * 10;
		int end = Math.min(tabs.length, start + 12);
		if (tabPage != 0)
		{
			start += 2;
		}
		boolean rendered = false;
		
		for (int i = start; i < end; ++i)
		{
			CreativeTabs tab = tabs[i];
			String page;
			int width;
			if (tab != null)
			{
				if (this.renderTabHoveringText(tab, mouseX, mouseY))
				{
					rendered = true;
					break;
				}
			}
		}
		
		if (!rendered)
		{
			if (!this.renderTabHoveringText(CreativeTabs.tabAllSearch, mouseX, mouseY))
			{
				this.renderTabHoveringText(CreativeTabs.tabInventory, mouseX, mouseY);
			}
		}
		
		if (this.binSlot != null && selectedTabIndex == CreativeTabs.tabInventory.getTabIndex() && this.func_146978_c(this.binSlot.xDisplayPosition, this.binSlot.yDisplayPosition, 16, 16, mouseX, mouseY))
		{
			String s;
			if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
			{
				s = "Clear Inventory";
			}
			else
			{
				s = I18n.getString("inventory.binSlot");
			}
			this.drawCreativeTabHoveringText(s, mouseX, mouseY);
		}
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(2896);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		CreativeTabs tab = CreativeTabs.creativeTabArray[selectedTabIndex];
		
		if (tab != null && tab.drawInForegroundOfTab())
		{
			GL11.glDisable(3042);
			this.fontRendererObj.drawString(I18n.getString(tab.getTranslatedTabLabel()), 8, 6, 4210752);
		}
		
		if (PlayerInventoryAPI.playerTooltip && tab == CreativeTabs.tabInventory && this.func_146978_c(playerDisplayX, playerDisplayY, 34, 45, mouseX, mouseY))
		{
			this.drawPlayerHoveringText(this.player, mouseX, mouseY, this.fontRendererObj);
		}
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTickTime, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		RenderHelper.enableGUIStandardItemLighting();
		CreativeTabs[] tabs = CreativeTabs.creativeTabArray;
		CreativeTabs tab = tabs[selectedTabIndex];
		
		int start = tabPage * 10;
		int end = Math.min(tabs.length, start + 12);
		
		if (tabPage != 0)
			start += 2;
		
		for (int i = start; i < end; ++i)
		{
			CreativeTabs tab1 = tabs[i];
			this.mc.getTextureManager().bindTexture(background);
			
			if (tab1 != null && tab1.getTabIndex() != selectedTabIndex)
			{
				drawCreativeTab(tab1);
			}
		}
		
		if (tabPage != 0)
		{
			if (tab != CreativeTabs.tabAllSearch)
			{
				this.mc.getTextureManager().bindTexture(background);
				this.drawCreativeTab(CreativeTabs.tabAllSearch);
			}
			if (tab != CreativeTabs.tabInventory)
			{
				this.mc.getTextureManager().bindTexture(background);
				this.drawCreativeTab(CreativeTabs.tabInventory);
			}
		}
		
		this.mc.getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/creative_inventory/tab_" + tab.getBackgroundImageName()));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		this.searchField.drawTextBox();
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(background);
		
		if (tab.shouldHidePlayerInventory())
		{
			if (this.needsScrollBars())
			{
				this.drawTexturedModalRect(this.guiLeft + 175, this.guiTop + 18 + (int) (95 * this.currentScroll), 232, 0, 12, 15);
			}
			else
			{
				this.drawTexturedModalRect(this.guiLeft + 175, this.guiTop + 18, 244, 0, 12, 15);
			}
		}
		
		if ((tab == CreativeTabs.tabInventory))
		{
			this.renderInventoryTab(mouseX, mouseY, partialTickTime);
			this.drawCreativeTab(tab);
		}
		else if (tab.getTabPage() == tabPage || tab == CreativeTabs.tabAllSearch)
		{
			this.drawCreativeTab(tab);
		}
	}
	
	protected void renderInventoryTab(int mouseX, int mouseY, float partialTickTime)
	{
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		GL11.glTranslatef(this.guiLeft, this.guiTop, 0F);
		
		// Background Frame
		this.drawBackgroundFrame(0, 0, windowWidth, windowHeight);
		
		// Player
		this.guiBuilder.drawPlayerBackgroundS(playerDisplayX, playerDisplayY);
		GuiSurvivalInventory.drawPlayerOnGui(this.mc, playerDisplayX + 16, playerDisplayY + 41, 20, this.guiLeft + playerDisplayX + 16 - mouseX, this.guiTop + playerDisplayY + 10 - mouseY);
		
		// Slots
		for (Point2i pos : CreativeInventory.getSlots())
		{
			if (pos != null)
			{
				this.drawSlot(pos.getX(), pos.getY());
			}
		}
		this.guiBuilder.drawSlot(binSlotX, binSlotY, 1);
		
		// Objects
		for (IInventoryObject object : objects)
		{
			if (object != null)
			{
				object.render(this.width, this.height);
			}
		}
		
		GL11.glTranslatef(-this.guiLeft, -this.guiTop, 0F);
	}
	
	protected void drawCreativeTab(CreativeTabs tab)
	{
		boolean flag = tab.getTabIndex() == selectedTabIndex;
		boolean flag1 = tab.isTabInFirstRow();
		int i = tab.getTabColumn();
		int j = i * 28;
		int k = 0;
		int x = this.guiLeft + 28 * i;
		int y = this.guiTop;
		byte b0 = 32;
		
		this.mc.getTextureManager().bindTexture(background);
		
		if (flag)
		{
			k += 32;
		}
		
		if (i == 5)
		{
			x = this.guiLeft + this.xSize - 28;
		}
		else if (i > 0)
		{
			x += i;
		}
		
		if (flag1)
		{
			y -= 28;
		}
		else
		{
			k += 64;
			y += this.ySize - 4;
		}
		
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.drawTexturedModalRect(x, y, j, k, 28, b0);
		
		x += 6;
		y += 8 + (flag1 ? 1 : -1);
		ItemStack itemstack = tab.getIconItemStack();
		
		if (itemstack != null && itemstack.getItem() != null)
		{
			itemRender.zLevel = 100.0F;
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			RenderHelper.enableGUIStandardItemLighting();
			
			itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), itemstack, x, y);
			itemRender.renderItemOverlayIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), itemstack, x, y);
			itemRender.zLevel = 0.0F;
		}
	}
	
	@Override
	protected void renderToolTip(ItemStack stack, int x, int y)
	{
		if (selectedTabIndex == CreativeTabs.tabAllSearch.getTabIndex())
		{
			List list = stack.getTooltip(this.mc.thePlayer, this.mc.gameSettings.advancedItemTooltips);
			CreativeTabs tab = stack.getItem().getCreativeTab();
			
			if (tab == null && stack.getItem() == Items.enchanted_book)
			{
				Map map = EnchantmentHelper.getEnchantments(stack);
				
				if (map.size() == 1)
				{
					Enchantment enchantment = Enchantment.enchantmentsList[((Integer) map.keySet().iterator().next()).intValue()];
					CreativeTabs[] tabs = CreativeTabs.creativeTabArray;
					int len = tabs.length;
					
					for (int i = 0; i < len; ++i)
					{
						CreativeTabs tab1 = tabs[i];
						
						if (tab1.func_111226_a(enchantment.type))
						{
							tab = tab1;
							break;
						}
					}
				}
			}
			
			if (tab != null)
			{
				list.add(1, "\u00a79\u00a7n" + I18n.getString(tab.getTranslatedTabLabel()));
			}
			
			for (int i1 = 0; i1 < list.size(); ++i1)
			{
				if (i1 == 0)
				{
					list.set(i1, stack.getRarity().rarityColor + (String) list.get(i1));
				}
				else
				{
					list.set(i1, EnumChatFormatting.GRAY + (String) list.get(i1));
				}
			}
			
			this.drawHoveringText(list, x, y, this.fontRendererObj);
		}
		else
		{
			List<String> list = stack.getTooltip(this.mc.thePlayer, this.mc.gameSettings.advancedItemTooltips);
			
			list.set(0, stack.getRarity().rarityColor + list.get(0));
			for (int k = 1; k < list.size(); ++k)
			{
				list.set(k, EnumChatFormatting.GRAY + list.get(k));
			}
			
			FontRenderer font = stack.getItem().getFontRenderer(stack);
			this.drawHoveringText(list, x, y, font == null ? this.fontRendererObj : font);
		}
	}
	
	protected boolean renderTabHoveringText(CreativeTabs tab, int x, int y)
	{
		int k = tab.getTabColumn();
		int l = 28 * k;
		
		if (k == 5)
		{
			l = this.xSize - 26;
		}
		else if (k > 0)
		{
			l += k;
		}
		int i1;
		if (tab.isTabInFirstRow())
		{
			i1 = -32;
		}
		else
		{
			i1 = this.ySize;
		}
		
		if (this.func_146978_c(l + 3, i1 + 3, 23, 27, x, y))
		{
			this.drawCreativeTabHoveringText(I18n.getString(tab.getTranslatedTabLabel()), x, y);
			return true;
		}
		
		return false;
	}
	
	protected boolean isMouseHoveringTab(CreativeTabs tab, int x, int y)
	{
		if (tab.getTabPage() != tabPage && tab != CreativeTabs.tabAllSearch && tab != CreativeTabs.tabInventory)
		{
			return false;
		}
		
		int column = tab.getTabColumn();
		int x1 = 28 * column;
		int y1;
		
		if (column == 5)
		{
			x1 = this.xSize - 26;
		}
		else if (column > 0)
		{
			x1 += column;
		}
		if (tab.isTabInFirstRow())
		{
			y1 = -32;
		}
		else
		{
			y1 = this.ySize;
		}
		
		return x >= x1 && x <= x1 + 28 && y >= y1 && y <= y1 + 32;
	}
	
	private boolean needsScrollBars()
	{
		CreativeTabs tab = CreativeTabs.creativeTabArray[selectedTabIndex];
		if (tab == null || tab == CreativeTabs.tabInventory)
		{
			return false;
		}
		return tab.shouldHidePlayerInventory() && ((ContainerCreativeList) this.inventorySlots).hasMoreThanOnePage();
	}
	
	@Override
	protected void mouseMovedOrUp(int mouseX, int mouseY, int which)
	{
		super.mouseMovedOrUp(mouseX, mouseY, which);
	}
	
	@Override
	protected void mouseClicked(int x, int y, int which)
	{
		if (which == 0)
		{
			int l = x - this.guiLeft;
			int i1 = y - this.guiTop;
			CreativeTabs[] tabs = CreativeTabs.creativeTabArray;
			int len = tabs.length;
			
			for (int i = 0; i < len; ++i)
			{
				CreativeTabs tab = tabs[i];
				
				if (tab != null && this.isMouseHoveringTab(tab, l, i1))
				{
					this.setCurrentCreativeTab(tab);
					return;
				}
			}
		}
		
		super.mouseClicked(x, y, which);
	}
	
	@Override
	protected void handleMouseClick(Slot slot, int slotID, int var1, int var2)
	{
		this.mouseClicked = true;
		boolean flag = var2 == 1;
		var2 = slotID == -999 && var2 == 0 ? 4 : var2;
		
		if (slot == null && selectedTabIndex != CreativeTabs.tabInventory.getTabIndex() && var2 != 5)
		{
			InventoryPlayer inventoryplayer = this.mc.thePlayer.inventory;
			
			if (inventoryplayer.getItemStack() == null)
			{
				return;
			}
			if (var1 == 0)
			{
				this.mc.thePlayer.dropPlayerItemWithRandomChoice(inventoryplayer.getItemStack(), true);
				this.mc.playerController.sendPacketDropItem(inventoryplayer.getItemStack());
				inventoryplayer.setItemStack((ItemStack) null);
			}
			
			if (var1 != 1)
			{
				return;
			}
			ItemStack itemstack1 = inventoryplayer.getItemStack().splitStack(1);
			this.mc.thePlayer.dropPlayerItemWithRandomChoice(itemstack1, true);
			this.mc.playerController.sendPacketDropItem(itemstack1);
			
			if (inventoryplayer.getItemStack().stackSize != 0)
			{
				return;
			}
			inventoryplayer.setItemStack((ItemStack) null);
		}
		else
		{
			if (slot == this.binSlot && flag)
			{
				int len = this.inventorySlots.inventorySlots.size();
				for (int i = 0; i < len; ++i)
				{
					this.mc.playerController.sendSlotPacket((ItemStack) null, i);
				}
				ExtendedInventory.get(this.player).clear();
			}
			
			if (selectedTabIndex == CreativeTabs.tabInventory.getTabIndex())
			{
				if (slot == this.binSlot)
				{
					this.mc.thePlayer.inventory.setItemStack((ItemStack) null);
				}
				else if (var2 == 4 && slot != null && slot.getHasStack())
				{
					ItemStack itemstack = slot.decrStackSize(var1 == 0 ? 1 : slot.getStack().getMaxStackSize());
					this.mc.thePlayer.dropPlayerItemWithRandomChoice(itemstack, true);
					this.mc.playerController.sendPacketDropItem(itemstack);
				}
				else if (var2 == 4 && this.mc.thePlayer.inventory.getItemStack() != null)
				{
					this.mc.thePlayer.dropPlayerItemWithRandomChoice(this.mc.thePlayer.inventory.getItemStack(), true);
					this.mc.playerController.sendPacketDropItem(this.mc.thePlayer.inventory.getItemStack());
					this.mc.thePlayer.inventory.setItemStack((ItemStack) null);
				}
				else
				{
					this.mc.thePlayer.inventoryContainer.slotClick(slot == null ? slotID : ((SlotCreative) slot).getSlot().slotNumber, var1, var2, this.mc.thePlayer);
					this.mc.thePlayer.inventoryContainer.detectAndSendChanges();
				}
			}
			else if (var2 != 5 && slot != null && slot.inventory == inventory)
			{
				InventoryPlayer inventoryplayer = this.mc.thePlayer.inventory;
				ItemStack itemstack1 = inventoryplayer.getItemStack();
				ItemStack itemstack2 = slot.getStack();
				
				if (var2 == 2)
				{
					if (itemstack2 != null && var1 >= 0 && var1 < 9)
					{
						ItemStack itemstack3 = itemstack2.copy();
						itemstack3.stackSize = itemstack3.getMaxStackSize();
						this.mc.thePlayer.inventory.setInventorySlotContents(var1, itemstack3);
						this.mc.thePlayer.inventoryContainer.detectAndSendChanges();
					}
					
					return;
				}
				
				if (var2 == 3)
				{
					if (inventoryplayer.getItemStack() == null && slot.getHasStack())
					{
						ItemStack itemstack3 = slot.getStack().copy();
						itemstack3.stackSize = itemstack3.getMaxStackSize();
						inventoryplayer.setItemStack(itemstack3);
					}
					
					return;
				}
				
				if (var2 == 4)
				{
					if (itemstack2 != null)
					{
						ItemStack itemstack3 = itemstack2.copy();
						itemstack3.stackSize = var1 == 0 ? 1 : itemstack3.getMaxStackSize();
						this.mc.thePlayer.dropPlayerItemWithRandomChoice(itemstack3, true);
						this.mc.playerController.sendPacketDropItem(itemstack3);
					}
					
					return;
				}
				
				if (itemstack1 != null && itemstack2 != null && itemstack1.isItemEqual(itemstack2) && ItemStack.areItemStackTagsEqual(itemstack1, itemstack2))
				{
					if (var1 == 0)
					{
						if (flag)
						{
							itemstack1.stackSize = itemstack1.getMaxStackSize();
						}
						else if (itemstack1.stackSize < itemstack1.getMaxStackSize())
						{
							itemstack1.stackSize += 1;
						}
					}
					else if (itemstack1.stackSize <= 1)
					{
						inventoryplayer.setItemStack((ItemStack) null);
					}
					else
					{
						itemstack1.stackSize -= 1;
					}
				}
				else if (itemstack2 != null && itemstack1 == null)
				{
					inventoryplayer.setItemStack(ItemStack.copyItemStack(itemstack2));
					itemstack1 = inventoryplayer.getItemStack();
					
					if (flag)
					{
						itemstack1.stackSize = itemstack1.getMaxStackSize();
					}
				}
				else
				{
					inventoryplayer.setItemStack((ItemStack) null);
				}
			}
			else
			{
				this.inventorySlots.slotClick(slot == null ? slotID : slot.slotNumber, var1, var2, this.mc.thePlayer);
				
				if (Container.func_94532_c(var1) == 2)
				{
					for (int l = 0;; ++l)
					{
						if (l >= 9)
						{
							return;
						}
						this.mc.playerController.sendSlotPacket(this.inventorySlots.getSlot(45 + l).getStack(), 36 + l);
					}
				}
				if (slot == null)
				{
					return;
				}
				ItemStack itemstack = this.inventorySlots.getSlot(slot.slotNumber).getStack();
				this.mc.playerController.sendSlotPacket(itemstack, slot.slotNumber - this.inventorySlots.inventorySlots.size() + 45);
			}
		}
	}
	
	@Override
	public void handleMouseInput()
	{
		super.handleMouseInput();
		if (this.needsScrollBars())
		{
			int i = Mouse.getEventDWheel();
			
			if (i == 0)
			{
				return;
			}
			
			float j = ((ContainerCreativeList) this.inventorySlots).itemList.size() / 9F - 4;
			
			if (i > 0)
			{
				i = 1;
			}
			
			if (i < 0)
			{
				i = -1;
			}
			
			this.currentScroll -= i / j;
			
			if (this.currentScroll < 0.0F)
			{
				this.currentScroll = 0.0F;
			}
			
			if (this.currentScroll > 1.0F)
			{
				this.currentScroll = 1.0F;
			}
			
			((ContainerCreativeList) this.inventorySlots).scrollTo(this.currentScroll);
		}
	}
	
	@Override
	protected void keyTyped(char c, int key)
	{
		if (!CreativeTabs.creativeTabArray[selectedTabIndex].hasSearchBar())
		{
			if (GameSettings.isKeyDown(this.mc.gameSettings.keyBindChat))
			{
				this.setCurrentCreativeTab(CreativeTabs.tabAllSearch);
			}
			else
			{
				super.keyTyped(c, key);
			}
		}
		else
		{
			if (this.mouseClicked)
			{
				this.mouseClicked = false;
				this.searchField.setText("");
			}
			
			if (this.checkHotbarKeys(key))
			{
				return;
			}
			if (this.searchField.textboxKeyTyped(c, key))
			{
				this.updateCreativeSearch();
			}
			else
			{
				super.keyTyped(c, key);
			}
		}
	}
	
	@Override
	public void actionPerformed(GuiButton button)
	{
		for (IInventoryHandler handler : CreativeInventory.handlers)
		{
			handler.buttonPressed(button, this.player, true);
		}
		
		if (button.id == 0)
		{
			if (tabPage > 0)
				tabPage--;
		}
		else if (button.id == 1)
		{
			if (tabPage < this.maxPages)
				tabPage++;
		}
	}
	
	public int func_147056_g()
	{
		return selectedTabIndex;
	}
	
	public static InventoryBasic getInventory()
	{
		return inventory;
	}
}
