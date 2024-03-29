package net.devdoctor.nukaworld.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.devdoctor.nukaworld.NukaWorld;
import net.devdoctor.nukaworld.recipe.MixingStationRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEINukaworldPlugin implements IModPlugin {
	public static RecipeType<MixingStationRecipe> MIXING_TYPE =
			new RecipeType<>(MixingStationRecipeCategory.UID, MixingStationRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation(NukaWorld.MOD_ID, "jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(
				new MixingStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

		List<MixingStationRecipe> recipesInfusing = rm.getAllRecipesFor(MixingStationRecipe.Type.INSTANCE);
		registration.addRecipes(MIXING_TYPE, recipesInfusing);
	}

}
