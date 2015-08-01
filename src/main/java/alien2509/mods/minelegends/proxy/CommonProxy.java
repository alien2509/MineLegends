package alien2509.mods.minelegends.proxy;

import net.minecraftforge.fml.common.FMLCommonHandler;

public abstract class CommonProxy implements IProxy
{
	
	public void registerEventHandlers()
	{
		
		// Register them either via FML or Forge depending on the event
		// FMLCommonHandler.instance().bus().register();
		// MinecraftForge.EVENT_BUS.register();
		
		FMLCommonHandler.instance().bus().register(alien2509.mods.minelegends.handlers.DateTimeHandler.class);
		
	}
	
}
