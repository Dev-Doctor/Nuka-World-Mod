package net.devdoctor.nukaworld.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.devdoctor.nukaworld.Blocks.ModBlocks;
import net.devdoctor.nukaworld.Items.ModItems;
import net.devdoctor.nukaworld.NukaWorld;
import net.devdoctor.nukaworld.recipe.MixingStationRecipe;
import net.devdoctor.nukaworld.util.ModTags;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;

public class MixingStationRecipeCategory implements IRecipeCategory<MixingStationRecipe> {
	public final static ResourceLocation UID = new ResourceLocation(NukaWorld.MOD_ID, "mixing_station");
	public final static ResourceLocation TEXTURE =
			new ResourceLocation(NukaWorld.MOD_ID, "textures/gui/mixing_station_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	public MixingStationRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0,0, 176, 220);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.MIXING_STATION.get()));
	}

	@Override
	public RecipeType<MixingStationRecipe> getRecipeType() {
		return JEINukaworldPlugin.MIXING_TYPE;
	}

	@Override
	public Component getTitle() {
		return Component.translatable("block.nukaworld.mixing_station");
	}


	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

//	private Ingredient checkIngredient() {
//
//	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, MixingStationRecipe recipe, IFocusGroup focuses) {
		ArrayList<IRecipeSlotBuilder> NUKA_COLA_SLOTS = new ArrayList<IRecipeSlotBuilder>();
		ArrayList<IRecipeSlotBuilder> OTHER_SLOTS = new ArrayList<IRecipeSlotBuilder>();
		Boolean[] already_found = new Boolean[]{false,false,false,false,false,false,false,false,false};
		Boolean[] other_slots_found = new Boolean[]{false,false,false};
		int bottles = 0;

		for(int i = 0; i < 9; i++) {
			NUKA_COLA_SLOTS.add(builder.addSlot(RecipeIngredientRole.INPUT, 7 + 18 * i, 35));
		}

		for(int i = 0; i < 3; i++) {
			OTHER_SLOTS.add(builder.addSlot(RecipeIngredientRole.INPUT, 7 + 18 * i, 107));
		}



		int counter = 0;
		for(Ingredient ing : recipe.getRecipeItems()) {
			for(ItemStack itemStack : ing.getItems()) {
				if(itemStack.is(ModTags.Items.NUKACOLAS)) {
					bottles++;
				} else {
					for(int j = 0; j < other_slots_found.length; j++) {
						if(!other_slots_found[j]) {
							OTHER_SLOTS.get(j).addIngredients(ing);
							other_slots_found[j] = true;
							break;
						}
					}
				}
			}
		}
		for(int i = 0; i < recipe.getRecipeItems().size(); i++) {
			boolean another_ingredient = false;
			Ingredient ing = recipe.getIngredients().get(i);

			if(ing.test(new ItemStack(ModItems.NUKA_COLA.get())) && !already_found[0]) {
				NUKA_COLA_SLOTS.get(0).addIngredients(ing);
				already_found[0] = true;
			} else if(already_found[0]) {another_ingredient = true;}

			if(ing.test(new ItemStack(ModItems.NUKA_COLA_CHERRY.get())) && !already_found[1]) {
				NUKA_COLA_SLOTS.get(1).addIngredients(ing);
				already_found[1] = true;
			} else if(already_found[1]) {another_ingredient = true;}

			if(ing.test(new ItemStack(ModItems.NUKA_COLA_GRAPE.get())) && !already_found[2]) {
				NUKA_COLA_SLOTS.get(2).addIngredients(ing);
				already_found[2] = true;
			} else if(already_found[2]) {another_ingredient = true;}

			if(ing.test(new ItemStack(ModItems.NUKA_COLA_WILD.get())) && !already_found[3]) {
				NUKA_COLA_SLOTS.get(3).addIngredients(ing);
				already_found[3] = true;
			} else if(already_found[3]) {another_ingredient = true;}

			if(ing.test(new ItemStack(ModItems.NUKA_COLA_QUARTZ.get())) && !already_found[4]) {
				NUKA_COLA_SLOTS.get(4).addIngredients(ing);
				already_found[4] = true;
			} else if(already_found[4]) {another_ingredient = true;}

			if(ing.test(new ItemStack(ModItems.NUKA_COLA_QUANTUM.get())) && !already_found[5]) {
				NUKA_COLA_SLOTS.get(5).addIngredients(ing);
				already_found[5] = true;
			} else if(already_found[5]) {another_ingredient = true;}

			if(ing.test(new ItemStack(ModItems.NUKA_COLA_VICTORY.get())) && !already_found[6]) {
				NUKA_COLA_SLOTS.get(6).addIngredients(ing);
				already_found[6] = true;
			} else if(already_found[6]) {another_ingredient = true;}

			if(ing.test(new ItemStack(ModItems.NUKA_COLA_ORANGE.get())) && !already_found[7]) {
				NUKA_COLA_SLOTS.get(7).addIngredients(ing);
				already_found[7] = true;
			} else if(already_found[7]) {another_ingredient = true;}

			if(ing.test(new ItemStack(ModItems.NUKA_COLA_DARK.get())) && !already_found[8]) {
				NUKA_COLA_SLOTS.get(8).addIngredients(ing);
				already_found[8] = true;
			} else if(already_found[8]) {another_ingredient = true;}

			if(another_ingredient) {
				for(int j = 0; j < other_slots_found.length; j++) {
					if(!other_slots_found[j]) {
						OTHER_SLOTS.get(j).addIngredients(ing);
						other_slots_found[j] = true;
						break;
					}
				}
			}
		}

		builder.addSlot(RecipeIngredientRole.OUTPUT, 97, 107).addItemStack(new ItemStack(ModItems.EMPTY_ROCKET_BOTTLE.get(), bottles - 1));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 79, 71).addItemStack(recipe.getResultItem());
	}


}
