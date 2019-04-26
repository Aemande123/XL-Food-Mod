package mariot7.xlfoodmod.items;

import java.util.List;

import mariot7.xlfoodmod.Main;
import mariot7.xlfoodmod.XLFoodModTab;
import mariot7.xlfoodmod.init.ItemListxlfoodmod;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StealthyEnergyDrink extends ItemFood {
	
	protected String name;
	
	public StealthyEnergyDrink(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setAlwaysEdible();
		this.setMaxStackSize(1);
		this.setCreativeTab(XLFoodModTab.tabXLFoodMod);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	public StealthyEnergyDrink(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
    }
	
	public void registerItemModel() {
		Main.proxy.registerItemRenderer(this, 0, name);
	}
	
	protected void onFoodEaten(ItemStack itemstack, World world, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 2400, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 2400, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 2400, 0));
		player.inventory.addItemStackToInventory(new ItemStack(ItemListxlfoodmod.empty_can));
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("stealthyenergydrink.tooltip", TextFormatting.BLUE, TextFormatting.RESET));
		tooltip.add(I18n.format("stealthyenergydrink2.tooltip", TextFormatting.BLUE, TextFormatting.RESET));
		tooltip.add(I18n.format("stealthyenergydrink3.tooltip", TextFormatting.BLUE, TextFormatting.RESET));
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}

	
}
