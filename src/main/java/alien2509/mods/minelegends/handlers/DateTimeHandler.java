package alien2509.mods.minelegends.handlers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;
import alien2509.mods.minelegends.util.DateTime;

public class DateTimeHandler
{
	
	public static Map<String, DateTime> DateTimeList = new HashMap<String, DateTime>();
	
	public static void registerDateTime(DateTime dateTime)
	{
		DateTimeList.put(dateTime.getName(), dateTime);
	}
	
	public static void removeDateTime(String name)
	{
		DateTimeList.remove(name);
	}
	
	public static DateTime getDateTimeFromTicks(long ticks)
	{
		return null;
	}
	
	public static DateTime getCurrentDateTime(String name)
	{
		return DateTimeList.get(name);
	}
	
	public static long getCurrentDateTimeInTicks(String name)
	{
		DateTime temp = DateTimeList.get(name);
		return temp.totalTicks;
	}
	
	@SubscribeEvent
	public static void onTickUpdate(ServerTickEvent event)
	{
		for(Entry<String, DateTime> entry : DateTimeList.entrySet())
		{
			DateTime currentDate = (DateTime)entry;
			currentDate.onTick();
		}
	}
	
}
