package alien2509.mods.minelegends.handlers;

import java.io.File;

import alien2509.mods.minelegends.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler
{
	
	public static Configuration configuration;
	
	public static void init(File configFile)
	{
		
		if(configuration == null)
		{
			
			configuration = new Configuration(configFile);
			loadConfiguration();
			
		}
		
	}
	
	private static void loadConfiguration()
	{
		
		if(configuration.hasChanged())
		{
			configuration.save();
		}
		
	}
	
	@SubscribeEvent
	public void onConfigurationChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		
		if(event.modID.equalsIgnoreCase(Reference.MOD_ID))
		{
			loadConfiguration();
		}
		
	}
	
}
