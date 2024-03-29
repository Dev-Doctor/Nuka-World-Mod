package net.devdoctor.nukaworld.Items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class LimitedSlotItemHandler extends SlotItemHandler {
	private final Item item_type;
	public LimitedSlotItemHandler(IItemHandler itemHandler, int index, int xPosition, int yPosition, Item item_type) {
		super(itemHandler, index, xPosition, yPosition);
		this.item_type = item_type;
	}

	@Override
	public boolean mayPlace(@NotNull ItemStack stack) {
		if (stack.isEmpty())
			return false;
		if (item_type != stack.getItem()) {
			return false;
		}
		return getItemHandler().isItemValid(getSlotIndex(), stack);
	}
}
