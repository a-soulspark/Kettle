package soulspark.tea_kettle.core.init;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import soulspark.tea_kettle.TeaKettle;
import soulspark.tea_kettle.common.recipes.TeaSteepingRecipe;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = TeaKettle.MODID)
public class ModRecipeTypes {
	public static final IRecipeType<TeaSteepingRecipe> TEA_STEEPING = new IRecipeType<TeaSteepingRecipe>() {
		public String toString() {
			ResourceLocation key = Registry.RECIPE_TYPE.getKey(this);
			return (key != null) ? key.toString() : "";
		}
	};
	
	public static final IRecipeSerializer<TeaSteepingRecipe> TEA_STEEPING_SERIALIZER = new TeaSteepingRecipe.Serializer();
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<IRecipeSerializer<?>> event) {
	 	ResourceLocation id = new ResourceLocation(TeaKettle.MODID, "tea_steeping");
		Registry.register(Registry.RECIPE_TYPE, id, TEA_STEEPING);
		event.getRegistry().register(TEA_STEEPING_SERIALIZER.setRegistryName(id));
	}
}
