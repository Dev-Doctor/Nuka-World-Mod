package net.devdoctor.nukaworld.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.devdoctor.nukaworld.Items.ModItems;
import net.devdoctor.nukaworld.NukaWorld;
import net.minecraft.client.Minecraft;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class MixingStationRecipe implements Recipe<SimpleContainer> {
	private static final String recipe_type = "nukacola_mixing";
	private final ResourceLocation id;
	private final ItemStack output;
	private final NonNullList<Ingredient> recipeItems;

	public MixingStationRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
		this.id = id;
		this.output = output;
		this.recipeItems = recipeItems;
	}

	@Override
	public boolean matches(SimpleContainer pContainer, Level pLevel) {
		int itemsCounter = 0;

		if(pLevel.isClientSide()) {
			return false;
		}

		// Count the number of slots that aren't empty
		for(int i = 0; i < pContainer.getContainerSize(); i++) {
			// i needs to be different from 13 because it's the output
			if(!pContainer.getItem(i).isEmpty() && !pContainer.getItem(i).is(ModItems.EMPTY_ROCKET_BOTTLE.get()) && i != 13) {
				itemsCounter++;
			}
		}

		// Exit if the number of not empty slots is different from the number of items used by the recipe
		if(recipeItems.size() != itemsCounter) {
			return false;
		}

//		if (Minecraft.getInstance().player != null) { // String.valueOf(itemsCounter) + " " + String.valueOf(recipeItems.size())
//			Minecraft.getInstance().player.displayClientMessage(Component.literal(String.valueOf(pContainer.getContainerSize())), false);
//		}

		for (Ingredient ingredient : recipeItems) {
			boolean found = false;
			// Check if the ingredient matches any item in the container
			for (int i = 0; i < pContainer.getContainerSize(); i++) {
				ItemStack stack = pContainer.getItem(i);
				if (!stack.isEmpty() && ingredient.test(stack)) {
					// If the ingredient is found, set found to true and break the inner loop
					found = true;
					break;
				}
			}
			// If the ingredient is not found in the container, return false
			if (!found) {
				return false;
			}
		}
		// If all ingredients are found, return true
		return true;
	}

	public boolean hasItem(ItemStack item) {
		for(Ingredient ing : recipeItems) {
			if(ing.test(item)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ItemStack assemble(SimpleContainer pContainer) {
		return output;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public ItemStack getResultItem() {
		return output.copy();
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	@Override
	public RecipeType<?> getType() {
		return Type.INSTANCE;
	}

	public NonNullList<Ingredient> getRecipeItems() {
		return recipeItems;
	}

	public static class Type implements RecipeType<MixingStationRecipe> {
		private Type() {}
		public static final Type INSTANCE = new Type();
		public static final String ID = recipe_type;
	}

	public static class Serializer implements RecipeSerializer<MixingStationRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		public static final ResourceLocation ID =
				new ResourceLocation(NukaWorld.MOD_ID, recipe_type);

		@Override
		public MixingStationRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
			ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));

			JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
			NonNullList<Ingredient> inputs = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);

			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
			}

			return new MixingStationRecipe(pRecipeId, output, inputs);
		}

		@Override
		public @Nullable MixingStationRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
			NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromNetwork(buf));
			}

			ItemStack output = buf.readItem();
			return new MixingStationRecipe(id, output, inputs);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buf, MixingStationRecipe recipe) {
			buf.writeInt(recipe.getIngredients().size());

			for (Ingredient ing : recipe.getIngredients()) {
				ing.toNetwork(buf);
			}
			buf.writeItemStack(recipe.getResultItem(), false);
		}
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return recipeItems;
	}
}
