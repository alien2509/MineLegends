package alien2509.mods.minelegends.client.util;

import alien2509.mods.minelegends.util.ResourceLocationHelper;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraftforge.fml.client.FMLClientHandler;

public class ClientSoundHelper
{
	
	public static void playSound(String soundName, float xCoord, float yCoord, float zCoord, float volume, float pitch)
	{
		
		FMLClientHandler.instance().getClient().getSoundHandler().playSound(new PositionedSoundRecord(ResourceLocationHelper.getResourceLocation(soundName), volume, pitch, xCoord, yCoord, zCoord));
		
	}
	
}
