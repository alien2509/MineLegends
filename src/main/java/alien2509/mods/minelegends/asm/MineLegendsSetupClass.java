package alien2509.mods.minelegends.asm;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;

import alien2509.mods.minelegends.util.Constants;
import alien2509.mods.minelegends.util.LogHelper;
import net.minecraftforge.fml.relauncher.IFMLCallHook;

public class MineLegendsSetupClass implements IFMLCallHook
{

	@Override
	public Void call() throws Exception
	{
		
		Constants.init();
		File file = new File(Constants.MinecraftDir + "/mods/H2DB.jar");
		if(file.exists()) LogHelper.info("The H2DB jar file already exists");
		if(!file.exists())
		{
			
			LogHelper.info("The H2DB jar file does not exist, downloading now...");
			URL downloadLocation = new URL("https://repo1.maven.org/maven2/com/h2database/h2/1.4.187/h2-1.3.176.jar");
			ReadableByteChannel rbc = Channels.newChannel(downloadLocation.openStream());
			FileOutputStream fos = new FileOutputStream(Constants.MinecraftDir + "/mods/H2DB.jar");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
			LogHelper.info("Download of H2DB.jar complete");
			
		}
		return null;
		
	}

	@Override
	public void injectData(Map<String, Object> data)
	{
		
	}
	
}
