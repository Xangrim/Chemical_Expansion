package chemicalexpansion.common.world;

import chemicalexpansion.common.block.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/********************************
 Copyright (C) Xangrim, 2017
 All rights reserved

 Class: ModWorldGeneration
 Created: 17/01/2017, 13:57:43
 Project: ChemicalExpansion
 Description: All world generation
 ********************************/

public class ModWorldGeneration implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == 0) { // the overworld
            generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
    }

    private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateOre(ModBlocks.ore_chalcopyrite.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 100, 4 + random.nextInt(4), 6);
        generateOre(ModBlocks.ore_garnierite.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 100, 4 + random.nextInt(4), 6);
        generateOre(ModBlocks.ore_pyrolusite.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 100, 4 + random.nextInt(4), 6);
        generateOre(ModBlocks.ore_wolframite.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 100, 4 + random.nextInt(4), 6);
        generateOre(ModBlocks.ore_bauxite.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 100, 4 + random.nextInt(4), 6);
        generateOre(ModBlocks.ore_galena.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 100, 4 + random.nextInt(4), 6);
        generateOre(ModBlocks.ore_ilmenite.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 100, 4 + random.nextInt(4), 6);
        generateOre(ModBlocks.ore_sphalerite.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 16, 100, 4 + random.nextInt(4), 6);
    }

    private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) {
        int deltaY = maxY - minY;

        for (int i = 0; i < chances; i++) {
            BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

            WorldGenMinable generator = new WorldGenMinable(ore, size);
            generator.generate(world, random, pos);
        }
    }

}