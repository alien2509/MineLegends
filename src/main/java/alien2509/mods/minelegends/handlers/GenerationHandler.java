package alien2509.mods.minelegends.handlers;

import java.util.List;

import alien2509.mods.minelegends.world.gen.PreGenerator;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;

public class GenerationHandler
{
	
	public static List<PreGenerator> pregenerators;
	
	static double multiplier = 1.0d;
	static double overflow = .0d;
	
	@SubscribeEvent
	public static void onServerTick(ServerTickEvent event)
	{
		
		PreGenerator toRun = pregenerators.get(0);
		
		double target = multiplier + overflow;
		int liTarget = (int) Math.floor(target);
		overflow =  target - liTarget;
		
		long delta = System.currentTimeMillis();
		for(int i = 0; i < liTarget; i++)
		{
			toRun.generateChunk();
		}
		delta = System.currentTimeMillis() - delta;
		
		if(delta > 50.0d)
		{
			multiplier -= .1d;
		} else
		{
			multiplier += .1d;
		}
		
		if(multiplier > 100.0d) multiplier = 100.0d;
		if(multiplier < 1.0d) multiplier = 1.0d;
		
		if(toRun.done == true)
		{
			pregenerators.remove(0);
		}
		
	}
	
	public static void createWorldPreGenerator(ChunkCoordIntPair center, int range, int DimID)
	{
		
		pregenerators.add(new PreGenerator(center, range, DimID));
		
	}
	
}
