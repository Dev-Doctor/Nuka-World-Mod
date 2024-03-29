package net.devdoctor.nukaworld.recipe;

import net.devdoctor.nukaworld.NukaWorld;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
			DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, NukaWorld.MOD_ID);

	public static final RegistryObject<RecipeSerializer<MixingStationRecipe>> MIXING_STATION_SERIALIZER =
			SERIALIZERS.register("nukacola_mixing", () -> MixingStationRecipe.Serializer.INSTANCE);

	public static void register(IEventBus eventBus) {
		SERIALIZERS.register(eventBus);
	}
}
