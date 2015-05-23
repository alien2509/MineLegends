package alien2509.mods.minelegends.util;

import java.io.File;

import net.minecraftforge.fml.relauncher.FMLInjectionData;

public class Constants
{
	
	public static File MinecraftDir = null;
	
	public static void init()
	{
		
		MinecraftDir = (File)FMLInjectionData.data()[6];
		
	}
	
}
