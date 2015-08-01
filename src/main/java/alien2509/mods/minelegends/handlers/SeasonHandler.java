package alien2509.mods.minelegends.handlers;

import alien2509.mods.minelegends.util.Seasons;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;

public class SeasonHandler
{
	
	public static Seasons currentSeason;
	
	// System DateTime only
	public static void onMonthChange(int month)
	{
		if(month == 1 || month == 2 || month == 12)
		{
			currentSeason = Seasons.WINTER;
		} else if(month == 3 || month == 4 || month == 5)
		{
			currentSeason = Seasons.SPRING;
		} else if(month == 6 || month == 7 || month == 8)
		{
			currentSeason = Seasons.SUMMER;
		} else if(month == 9 || month == 10 || month == 11)
		{
			currentSeason = Seasons.AUTUMN;
		}
	}
	
	@SubscribeEvent
	public static void onServerTick(ServerTickEvent event)
	{
		
		// apply season effects
		
	}
	
}