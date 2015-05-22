package alien2509.mods.minelegends;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.Mod_Name, certificateFingerprint = Reference.FINGERPRINT, version = Reference.MOD_VERSION, dependencies = Reference.DEPENDENCIES, guiFactory = Reference.GUI_FACTORY_CLASS)
public class MineLegendsMod
{
	
	@Instance
	public static MineLegendsMod instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@EventHandler
	public void invalidFingerPrint(FMLFingerprintViolationEvent event)
	{
		
		if(Reference.FINGERPRINT.equals("@FINGERPRINT@"))
		{
			
			LogHelper.info(Messages.NO_FINGERPRINT_MESSAGE);
			
		} else
		{
			
			LogHelper.warn(Messages.INVALID_FINGERPRINT_MESSAGE);
			
		}
		
	}
	
	@EventHandler
	public void onConstruction(FMLConstructionEvent event)
	{
		
		
		
	}
	
	@EventHandler
	public void onPreInitialization(FMLPreInitializationEvent event)
	{
		
		
		
	}
	
	@EventHandler
	public void onInitialization(FMLInitializationEvent event)
	{
		
		
		
	}
	
	@EventHandler
	public void onPostInitialization(FMLPostInitializationEvent event)
	{
		
		
		
	}
	
	@EventHandler
	public void onServerAboutToStart(FMLServerAboutToStartEvent event)
	{
		
		
		
	}
	
	@EventHandler
	public void onServerStarting(FMLServerStartingEvent event)
	{
		
		
		
	}
	
	@EventHandler
	public void onServerStarted(FMLServerStartedEvent event)
	{
		
		
		
	}
	
	@EventHandler
	public void onServerStopping(FMLServerStoppingEvent event)
	{
		
		
		
	}
	
	@EventHandler
	public void onServerStopped(FMLServerStoppedEvent event)
	{
		
		
		
	}
	
}
