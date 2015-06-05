package alien2509.mods.minelegends.handlers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;
import alien2509.mods.minelegends.util.Date;

public class TimeHandler
{
	
	public static Map<String, Date> Dates = new HashMap<String, Date>();
	
	public static void registerDate(Date date)
	{
		
		Dates.put(date.getName(), date);
		
	}
	
	public static Date getDateFromTicks(long ticks)
	{
		
		return null;
		
	}
	
	public static Date getCurrentDate()
	{
		
		return null;
		
	}
	
	public static long getCurrentDateInTicks()
	{
		
		return 0;
		
	}
	
	@SubscribeEvent
	public static void onTickUpdate(ServerTickEvent event)
	{
		
		for(Entry<String, Date> entry : Dates.entrySet())
		{
			
			Date currentDate = (Date)entry;
			currentDate.onTick();
			
		}
		
	}
	
}
