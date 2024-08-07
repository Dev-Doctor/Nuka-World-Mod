package net.devdoctor.nukaworld.screen;

import net.devdoctor.nukaworld.Blocks.ModBlocks;
import net.devdoctor.nukaworld.Blocks.entity.MixingStationBlockEntity;
import net.devdoctor.nukaworld.Items.LimitedSlotItemHandler;
import net.devdoctor.nukaworld.Items.ModItems;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;

public class MixingStationMenu extends AbstractContainerMenu {
	private static final int MIXING_STATION_SLOTS = 14;

	public final MixingStationBlockEntity blockEntity;
	private final Level level;
	private final ContainerData data;

	public MixingStationMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
		this(id, inventory, inventory.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(2));
	}

	public MixingStationMenu(int id, Inventory inventory, BlockEntity entity, ContainerData data) {
		super(ModMenuTypes.MIXING_STATION_MENU.get(), id);
		checkContainerSize(inventory, MIXING_STATION_SLOTS);
		blockEntity = (MixingStationBlockEntity) entity;
		this.level = inventory.player.level;
		this.data = data;

		addPlayerInventory(inventory);
		addPlayerHotbar(inventory);

		this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
			// NUKA COLA
			this.addSlot(new LimitedSlotItemHandler(iItemHandler, 0, 7, 35, ModItems.NUKA_COLA.get()));
			// NUKA COLA CHERRY
			this.addSlot(new LimitedSlotItemHandler(iItemHandler, 1, 25, 35, ModItems.NUKA_COLA_CHERRY.get()));
			// NUKA COLA GRAPE
			this.addSlot(new LimitedSlotItemHandler(iItemHandler, 2, 43, 35, ModItems.NUKA_COLA_GRAPE.get()));
			// NUKA COLA WILD
			this.addSlot(new LimitedSlotItemHandler(iItemHandler, 3, 61, 35, ModItems.NUKA_COLA_WILD.get()));
			// NUKA COLA QUARTZ
			this.addSlot(new LimitedSlotItemHandler(iItemHandler, 4, 79, 35, ModItems.NUKA_COLA_QUARTZ.get()));
			// NUKA COLA QUANTIUM
			this.addSlot(new LimitedSlotItemHandler(iItemHandler, 5, 97, 35, ModItems.NUKA_COLA_QUANTUM.get()));
			// NUKA COLA VICTORY
			this.addSlot(new LimitedSlotItemHandler(iItemHandler, 6, 115, 35, ModItems.NUKA_COLA_VICTORY.get()));
			// NUKA COLA ORANGE
			this.addSlot(new LimitedSlotItemHandler(iItemHandler, 7, 133, 35, ModItems.NUKA_COLA_ORANGE.get()));
			// NUKA COLA DARK
			this.addSlot(new LimitedSlotItemHandler(iItemHandler, 8, 151, 35, ModItems.NUKA_COLA_DARK.get()));
			// OTHER MATERIAL CRAFTING
			this.addSlot(new SlotItemHandler(iItemHandler, 9, 7, 107));
			this.addSlot(new SlotItemHandler(iItemHandler, 10, 25, 107));
			this.addSlot(new SlotItemHandler(iItemHandler, 11, 43, 107));
			// BOTTLE SLOT
			this.addSlot(new LimitedSlotItemHandler(iItemHandler, 12, 97, 107, Items.AIR));
			// OUTPUT
			this.addSlot(new LimitedSlotItemHandler(iItemHandler, 13, 79, 71, Items.AIR));
		});
		addDataSlots(data);
	}

	public boolean isCrafting() {
		return data.get(0) > 0;
	}

	public int getScaledProgress() {
		int progress = this.data.get(0);
		int maxProgress = this.data.get(1);  // Max Progress
		int progressArrowSize = 29; // This is the height in pixels of your arrow

		return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
	}

	// must assign a slot number to each of the slots used by the GUI.
	// For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
	// Each time we add a Slot to the container, it automatically increases the slotIndex, which means
	//  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
	//  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
	//  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
	private static final int HOTBAR_SLOT_COUNT = 9;
	private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
	private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
	private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
	private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
	private static final int VANILLA_FIRST_SLOT_INDEX = 0;
	private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

	// THIS YOU HAVE TO DEFINE!
	private static final int TE_INVENTORY_SLOT_COUNT = MIXING_STATION_SLOTS;

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		Slot sourceSlot = slots.get(index);
		if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
		ItemStack sourceStack = sourceSlot.getItem();
		ItemStack copyOfSourceStack = sourceStack.copy();

		// Check if the slot clicked is one of the vanilla container slots
		if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
			// This is a vanilla container slot so merge the stack into the tile inventory
			if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
					+ TE_INVENTORY_SLOT_COUNT, false)) {
				return ItemStack.EMPTY;  // EMPTY_ITEM
			}
		} else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
			// This is a TE slot so merge the stack into the players inventory
			if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
				return ItemStack.EMPTY;
			}
		} else {
			System.out.println("Invalid slotIndex:" + index);
			return ItemStack.EMPTY;
		}
		// If stack size == 0 (the entire stack was moved) set slot contents to null
		if (sourceStack.getCount() == 0) {
			sourceSlot.set(ItemStack.EMPTY);
		} else {
			sourceSlot.setChanged();
		}
		sourceSlot.onTake(playerIn, sourceStack);
		return copyOfSourceStack;
	}


	@Override
	public boolean stillValid(Player player) {
		return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
				player, ModBlocks.MIXING_STATION.get());
	}

	private void addPlayerInventory(Inventory inventory) {
		for(int i = 0; i < 3; ++i) {
			for(int l = 0; l < 9; ++l) {
				this.addSlot(new Slot(inventory, l + i * 9 + 9, 8 + l * 18, 138 + i * 18)); //x:8 y:86-93
			}
		}
	}

	private void addPlayerHotbar(Inventory inventory) {
		for(int i = 0; i < 9; ++i) {
			this.addSlot(new Slot(inventory, i, 8 + i * 18, 196)); //y: 144
		}
	}
}
