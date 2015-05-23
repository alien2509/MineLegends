package alien2509.mods.minelegends.asm;

import com.google.common.eventbus.EventBus;

import alien2509.mods.minelegends.reference.Reference;
import scala.actors.threadpool.Arrays;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;

public class MineLegendsModContainer extends DummyModContainer
{
	
	@SuppressWarnings("unchecked")
	public MineLegendsModContainer()
	{
		
		super(new ModMetadata());
		
		ModMetadata myMeta = super.getMetadata();
		myMeta.authorList = Arrays.asList(new String[] {
				"alien2509"
		});
		myMeta.description = "The MineLegends preloader part of the MineLegends mod.";
		myMeta.modId = Reference.MOD_ID;
		myMeta.version = Reference.MOD_VERSION;
		myMeta.name = Reference.MOD_NAME + " | Preloader";
		myMeta.url = "https://github.com/alien2509/MineLegends";
		
	}
	
	@Override
	public boolean registerBus(EventBus bus, LoadController controller)
	{
		
		bus.register(this);
		return true;
		
	}
	
}
