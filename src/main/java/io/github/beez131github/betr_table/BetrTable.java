package io.github.beez131github.betr_table;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.fabricmc.fabric.api.item.v1.EnchantmentEvents;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Holder;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import org.quiltmc.loader.api.ModContainer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BetrTable implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Better Enchant Table");

	public void onInitialize() {
		System.out.println("BetrTable mod initializing!");
		EnchantmentEvents.ALLOW_ENCHANTING.register(BetrTable::allowEnchanting);
		System.out.println("BetrTable mod initialized!");
	}

	private static TriState allowEnchanting(Holder<Enchantment> holder, ItemStack stack, EnchantingContext context) {
		if (holder.getKey().filter(Enchantments.SHARPNESS::equals).isPresent() && stack.isIn(ItemTags.AXES)) {
			return TriState.TRUE;
		} else {
			return TriState.DEFAULT;
		}
	}
}
