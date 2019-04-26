package mariot7.xlfoodmod.world;

import java.util.Random;

import mariot7.xlfoodmod.config.Configurationxlfoodmod;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGeneratorVanillaFlowerxlfoodmod implements IWorldGenerator {

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		int blockX = chunkX * 16;
		int blockZ = chunkZ * 16;
		
		generateOverworld(world, random, blockX, blockZ);
	}

	private void generateOverworld(World world, Random rand, int blockX, int blockZ) 
	{
		WorldGenerator genVanillaFlower = new WorldGenVanillaFlowerxlfoodmod();
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(blockX, 64, blockZ));		
		{
			int MIN = Configurationxlfoodmod.vanillaflowergeneration.minchunk;
			int MAX = Configurationxlfoodmod.vanillaflowergeneration.maxchunk;
			int numBushes = MIN + rand.nextInt(MAX - MIN);
			for(int i = 0; i < numBushes; i++)
			{
				int randX = blockX + rand.nextInt(16)+ 8;
				int randZ = blockZ + rand.nextInt(16)+ 8;
				genVanillaFlower.generate(world, rand, new BlockPos(randX, 24, randZ));
			}
		}
	}

	public static int getGroundFromAbove(World world, int x, int z)
	{
		int y = 255;
		boolean foundGround = false;
		while(!foundGround && y-- >= 0)
		{
			Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround = blockAt == Blocks.DIRT || blockAt == Blocks.GRASS;
		}

		return y;
	}
	

}
