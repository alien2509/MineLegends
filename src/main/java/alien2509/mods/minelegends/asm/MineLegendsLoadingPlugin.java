package alien2509.mods.minelegends.asm;

import java.util.Map;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

public class MineLegendsLoadingPlugin implements IFMLLoadingPlugin
{

	@Override
	public String[] getASMTransformerClass()
	{
		return null;
	}

	@Override
	public String getModContainerClass()
	{
		return new String("alien2509.mods.minelegends.asm.MineLegendsModContainer");
	}

	@Override
	public String getSetupClass()
	{
		return new String("alien2509.mods.minelegends.asm.MineLegendsSetupClass");
	}

	@Override
	public void injectData(Map<String, Object> data)
	{
		
	}

	@Override
	public String getAccessTransformerClass()
	{
		return null;
	}
	
}
