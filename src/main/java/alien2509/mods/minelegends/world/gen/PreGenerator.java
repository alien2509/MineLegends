package alien2509.mods.minelegends.world.gen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.ImmutableSetMultimap;

import alien2509.mods.minelegends.util.LogHelper;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.ForgeChunkManager.Ticket;

public class PreGenerator
{
	
	public List<ChunkCoordIntPair> chunkList;
	public ChunkCoordIntPair centerCoordinates;
	public int range;
	public WorldChunkManager chunkManager;
	public ChunkProviderServer provider;
	public long generatedChunksAmount;
	Iterator<ChunkCoordIntPair> iterator = chunkList.iterator();
	ImmutableSetMultimap<ChunkCoordIntPair, Ticket> persistentChunks;
	public boolean done = false;
	
	public PreGenerator(ChunkCoordIntPair centerCoordinates, int range, int DimID)
	{
		
		this.centerCoordinates = centerCoordinates;
		this.range = range;
		World world = DimensionManager.getWorld(DimID);
		if(world == null)
		{
			LogHelper.warn("PreGenerator can't find the dimension specified");
		}
		chunkManager = world.getWorldChunkManager();
		provider = (ChunkProviderServer)world.getChunkProvider();
		persistentChunks = ForgeChunkManager.getPersistentChunksFor(world);
		createChunkList();
		
	}
	
	public void createChunkList()
	{
		
		int minX = centerCoordinates.chunkXPos - range;
		int maxX = centerCoordinates.chunkXPos + range;
		int minY = centerCoordinates.chunkZPos - range;
		int maxY = centerCoordinates.chunkZPos + range;
		
		for(int i = minX; i <= maxX; i++)
		{
			for(int j = minY; j <= maxY; j++)
			{
				chunkList.add(new ChunkCoordIntPair(i, j));
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void generateChunk()
	{
		
		if(iterator.hasNext() == true)
		{
			
			ChunkCoordIntPair chunkLocation = iterator.next();
			provider.loadChunk(chunkLocation.chunkXPos, chunkLocation.chunkZPos);
			generatedChunksAmount += 1;
			if(generatedChunksAmount % 100 == 0)
			{
				
				ArrayList<Chunk> loadedChunks = new ArrayList<Chunk>();
				for(Chunk chunk : (List<Chunk>)provider.loadedChunks)
				{
					loadedChunks.add(chunk);
				}
				
				for(Chunk chunk : loadedChunks)
				{
					
					if(!persistentChunks.containsKey(new ChunkCoordIntPair(chunk.xPosition, chunk.zPosition)))
					{
						
						long k = Long.valueOf(ChunkCoordIntPair.chunkXZ2Int(chunk.xPosition,  chunk.zPosition));
						provider.id2ChunkMap.remove(k);
						provider.loadedChunks.remove(chunk);
						chunk.onChunkUnload();
						
					}
					
				}
				
			}
			
			if(generatedChunksAmount % 1000 == 0)
			{
				MinecraftServer server = MinecraftServer.getServer();
				try
				{
					int i;
					WorldServer worldserver;
					boolean flag;
					
					for(i = 0; 1 < server.worldServers.length; i++)
					{
						if(server.worldServers[i] != null)
						{
							worldserver = server.worldServers[i];
							flag = worldserver.disableLevelSaving;
							worldserver.disableLevelSaving = false;
							worldserver.saveAllChunks(true, null);
							worldserver.disableLevelSaving = flag;
						}
					}
					
					for(i = 0; i < server.worldServers.length; i++)
					{
						if(server.worldServers[i] != null)
						{
							worldserver = server.worldServers[i];
							flag = worldserver.disableLevelSaving;
							worldserver.saveChunkData();
							worldserver.disableLevelSaving = flag;
						}
					}
					
				} catch ( Exception e)
				{
					e.printStackTrace();
				}
				chunkManager.cleanupCache();
			}
			
		}else
		{
			this.done = true;
		}
		
	}
	
}
