package net.devdoctor.nukaworld.Blocks.entity;

import net.devdoctor.nukaworld.Items.ModItems;
import net.devdoctor.nukaworld.recipe.MixingStationRecipe;
import net.devdoctor.nukaworld.screen.MixingStationMenu;
import net.devdoctor.nukaworld.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class MixingStationBlockEntity extends BlockEntity implements MenuProvider {
	private final ItemStackHandler itemHandler = new ItemStackHandler(14) {
		@Override
		protected void onContentsChanged(int slot) {
			setChanged();
		}
	};

	private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

	protected final ContainerData data;
	private int progress = 0;
	private int maxProgress = 78;
	public MixingStationBlockEntity(BlockPos blockPos, BlockState blockState) {
		super(ModBlockEntities.MIXING_STATION.get(), blockPos, blockState);
		this.data = new ContainerData() {
			@Override
			public int get(int index) {
				return switch (index) {
					case 0 -> MixingStationBlockEntity.this.progress;
					case 1 -> MixingStationBlockEntity.this.maxProgress;
					default -> 0;
				};
			}

			@Override
			public void set(int index, int value) {
				switch (index) {
					case 0 -> MixingStationBlockEntity.this.progress = value;
					case 1 -> MixingStationBlockEntity.this.maxProgress = value;
				}
			}

			@Override
			public int getCount() {
				return 2;
			}
		};
	}

	@Override
	public Component getDisplayName() {
		return Component.translatable("blockentity.nukaworld.mixingstation.displayname");
	}

	@Nullable
	@Override
	public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
		return new MixingStationMenu(id, inventory, this, this.data);
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if(cap == ForgeCapabilities.ITEM_HANDLER) {
			return lazyItemHandler.cast();
		}

		return super.getCapability(cap, side);
	}

	@Override
	public void onLoad() {
		super.onLoad();
		lazyItemHandler = lazyItemHandler.of(() -> itemHandler);
	}

	@Override
	public void invalidateCaps() {
		super.invalidateCaps();
		lazyItemHandler.invalidate();
	}

	@Override
	protected void saveAdditional(CompoundTag nbt) {
		nbt.put("inventory", itemHandler.serializeNBT());

		super.saveAdditional(nbt);
	}

	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
		itemHandler.deserializeNBT(nbt.getCompound("inventory"));
	}

	public void drops() {
		SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
		for(int i = 0; i < itemHandler.getSlots(); i++) {
			inventory.setItem(i, itemHandler.getStackInSlot(i));
		}

		Containers.dropContents(this.level, this.worldPosition, inventory);
	}

	public static <E extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, MixingStationBlockEntity pEntity) {
		if(level.isClientSide()) {
			return;
		}

		if(hasRecipe(pEntity)) {
			pEntity.progress++;
			setChanged(level, blockPos, blockState);

			if(pEntity.progress >= pEntity.maxProgress) {
				craftItem(pEntity);
			}
		} else {
			pEntity.resetProgress();
			setChanged(level,blockPos,blockState);
		}
	}

	private void resetProgress() {
		this.progress = 0;
	}

	private static void craftItem(MixingStationBlockEntity pEntity) {
		Level level = pEntity.level;
		SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());

		for(int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
			inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
		}

		Optional<MixingStationRecipe> recipe = level.getRecipeManager().getRecipeFor(MixingStationRecipe.Type.INSTANCE, inventory, level);

		int bottles = countBottles(pEntity);

		if(hasRecipe(pEntity)) {
			for(int i = 0; i < 12; i++) {
				if(!pEntity.itemHandler.getStackInSlot(i).isEmpty()) {
					pEntity.itemHandler.extractItem(i, 1, false);
				}
			}

			// ADD ITEM RESULT
			pEntity.itemHandler.insertItem(13, new ItemStack(recipe.get().getResultItem().getItem()), false);

			// ADD EMPTY BOTTLES MINUS ONE IN THEIR SLOT
			if(bottles >= 0) {
				pEntity.itemHandler.setStackInSlot(12, new ItemStack(ModItems.EMPTY_ROCKET_BOTTLE.get(), pEntity.itemHandler.getStackInSlot(12).getCount() + bottles));
			}

			level.playSound(null, pEntity.getBlockPos(), SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, .5f, 0f);
			pEntity.resetProgress();
		}
	}

	private static boolean hasRecipe(MixingStationBlockEntity pEntity) {
		Level level = pEntity.level;
		SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());

		int bottles = countBottles(pEntity);

		for(int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
			inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
		}

		Optional<MixingStationRecipe> recipe = level.getRecipeManager().getRecipeFor(MixingStationRecipe.Type.INSTANCE, inventory, level);

//		if (Minecraft.getInstance().player != null) { // String.valueOf(itemsCounter) + " " + String.valueOf(recipeItems.size())
//			Minecraft.getInstance().player.displayClientMessage(Component.literal(String.valueOf(String.valueOf(bottles) + " - " + String.valueOf(neg_bottles) + " - " + String.valueOf(neg_neg_bottles))), false);
//		}

		return recipe.isPresent() && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, recipe.get().getResultItem())
				&& canInsertAmountIntoBottleSlot(inventory, bottles);
	}

	private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack itemStack) {
		return inventory.getItem(13).getItem() == itemStack.getItem() || inventory.getItem(13).isEmpty();
	}

	private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
		return inventory.getItem(13).getMaxStackSize() > inventory.getItem(13).getCount();
	}

	private static boolean canInsertAmountIntoBottleSlot(SimpleContainer inventory, int bottles) {
		return inventory.getItem(12).getMaxStackSize() > inventory.getItem(12).getCount() + bottles;
	}

	private static int countBottles(MixingStationBlockEntity pEntity) {
		int bottles = -1;
		for(int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
			if(!pEntity.itemHandler.getStackInSlot(i).isEmpty() && pEntity.itemHandler.getStackInSlot(i).is(ModTags.Items.NUKACOLAS)) {
				bottles++;
			}
		}
		return bottles;
	}

    public ItemStack getRenderStack() {
    	return itemHandler.getStackInSlot(13);
	}
}
