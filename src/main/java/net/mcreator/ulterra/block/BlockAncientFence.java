
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
import net.minecraft.block.BlockFence;
import net.minecraft.block.Block;

import net.mcreator.ulterra.ElementsUlterra;

@ElementsUlterra.ModElement.Tag
public class BlockAncientFence extends ElementsUlterra.ModElement {
	@GameRegistry.ObjectHolder("ulterra:ancientfence")
	public static final Block block = null;
	public BlockAncientFence(ElementsUlterra instance) {
		super(instance, 30);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("ancientfence"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("ulterra:ancientfence", "inventory"));
	}
	public static class BlockCustom extends BlockFence {
		public BlockCustom() {
			super(Material.WOOD, Material.WOOD.getMaterialMapColor());
			setUnlocalizedName("ancientfence");
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
