package alien2509.mods.minelegends;

import org.spongepowered.api.Game;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.state.ConstructionEvent;
import org.spongepowered.api.event.state.InitializationEvent;
import org.spongepowered.api.event.state.LoadCompleteEvent;
import org.spongepowered.api.event.state.PostInitializationEvent;
import org.spongepowered.api.event.state.PreInitializationEvent;
import org.spongepowered.api.event.state.ServerAboutToStartEvent;
import org.spongepowered.api.event.state.ServerStartedEvent;
import org.spongepowered.api.event.state.ServerStartingEvent;
import org.spongepowered.api.event.state.ServerStoppedEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;

import org.spongepowered.api.plugin.Plugin;

import com.google.inject.Inject;

@Plugin(id = "minelegends", name = "MineLegends Sponge plugin", version = "0.0.1")
public class MineLegendsPlugin
{
	
	@Inject
	Game game;
	
	/*
	 * During this state the @Plugin class instance for each plugin is triggered
	 */
	@Subscribe
	public void onConstruction(ConstructionEvent event)
	{
		
		
		
	}
	
	/*
	 * During this state the plugin gets ready for initialization. 
	 * Access to a default logger and access to information regarding 
	 * preferred configuration file locations is available.
	 */
	@Subscribe
	public void onPreInitialization(PreInitializationEvent event)
	{
		
		
		
	}
	
	/*
	 * During this state the plugin should finish any work needed 
	 * in order to be functional. Global event handlers and command 
	 * registration are handled during initialization.
	 */
	@Subscribe
	public void onInitialization(InitializationEvent event)
	{
		
		
		
	}
	
	/*
	 * During this state inter-plugin communication should occur. 
	 * Plugins providing an API should be ready to accept basic requests.
	 */
	@Subscribe
	public void onPostInitialization(PostInitializationEvent event)
	{
		
		
		
	}
	
	/*
	 * During this state all plugin initialization should be completed
	 */
	@Subscribe
	public void onLoadComplete(LoadCompleteEvent event)
	{
		
		
		
	}
	
	/*
	 * The server instance exists, but worlds are not yet loaded.
	 */
	@Subscribe
	public void onServerAboutToStart(ServerAboutToStartEvent event)
	{
		
		
		
	}
	
	/*
	 * The server instance exists, and worlds are loaded.
	 */
	@Subscribe
	public void onServerStarting(ServerStartingEvent event)
	{
		
		
		
	}
	
	/*
	 * The server instance exists, and worlds are loaded.
	 */
	@Subscribe
	public void onServerStarted(ServerStartedEvent event)
	{
		
		
		
	}
	
	/*
	 * This state occurs immediately before the final tick,
	 *  before the worlds are saved.
	 */
	@Subscribe
	public void onServerStopping(ServerStoppingEvent event)
	{
		
		
		
	}
	
	/*
	 * Suring this state, no players are connected and
	 *  no changes to worlds are saved.
	 */
	@Subscribe
	public void onServerStopped(ServerStoppedEvent event)
	{
		
		
		
	}
	
}
