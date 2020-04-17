
package net.mcreator.ulterra.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.Block;

import net.mcreator.ulterra.ElementsUlterra;

@ElementsUlterra.ModElement.Tag
public class BlockAncientPlanksStairs extends ElementsUlterra.ModElement {
	@GameRegistry.ObjectHolder("ulterra:ancientplanksstairs")
	public static final Block block = null;
	public BlockAncientPlanksStairs(ElementsUlterra instance) {
		super(instance, 23);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("ancientplanksstairs"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("ulterra:ancientplanksstairs", "inventory"));
	}
	public static class BlockCustom extends BlockStairs {
		public BlockCustom() {
			super(new Block(Material.WOOD).getDefaultState());
			setUnlocalizedName("ancientplanksstairs");
			setSoundType(SoundType.WOOD);
			setHardness(8F);
			setResistance(30F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		}

		@Override
		public int tickRate(World world) {
			return 40;
		}

		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}
	}
}
