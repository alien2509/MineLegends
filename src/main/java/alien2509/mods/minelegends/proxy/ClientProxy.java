package alien2509.mods.minelegends.proxy;

import alien2509.mods.minelegends.client.util.ClientParticleHelper;
import alien2509.mods.minelegends.client.util.ClientSoundHelper;

public class ClientProxy extends CommonProxy
{
	
	@Override
	public void registerEventHandlers()
	{
		
		super.registerEventHandlers();
		// Register them either via FML or Forge depending on the event
		// FMLCommonHandler.instance().bus().register();
		// MinecraftForge.EVENT_BUS.register();
		
	}
	
	@Override
	public void registerKeybindings()
	{
		
		
		
	}
	
	@Override
	public void playSound(String soundName, float xCoord, float yCoord, float zCoord, float volume, float pitch)
	{
		
		ClientSoundHelper.playSound(soundName, xCoord, yCoord, zCoord, volume, pitch);
		
	}
	
	@Override
	public void spawnParticle(String particleName, double xCoord, double yCoord, double zCoord, double xVelocity, double yVelocity, double zVelocity)
	{
		
		ClientParticleHelper.spawnParticleAtLocation(particleName, xCoord, yCoord, zCoord, xVelocity, yVelocity, zVelocity);
		
	}
	
	@Override
	public ClientProxy getClientProxy()
	{
		
		return this;
		
	}
	
	@Override
	public void initRenderingAndTextures()
	{
		
		
		
	}
	
}
