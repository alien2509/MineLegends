package alien2509.mods.minelegends.handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import alien2509.mods.minelegends.data.DataBaseHandler;
import alien2509.mods.minelegends.util.Constants;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.MultiPlaceEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockEventHandler
{
	
	@SubscribeEvent
	public void onBreakBlock(BreakEvent event) throws SQLException
	{
		
		/*
		 * info necessary:
		 * 	- BlockName			String
		 * 	- PlayerName		UUID
		 * 	- Time				Long
		 * 	- XCoord			int
		 * 	- YCoord			int
		 * 	- ZCoord			int
		 * 	- DimID				int
		 */
		
		
		
	}
	
	@SubscribeEvent
	public void onPlaceBlock(PlaceEvent event) throws SQLException
	{
		
		/*
		 * info necessary:
		 * 	- BlockName			String
		 * 	- PlayerName		UUID
		 * 	- Time				Long
		 * 	- XCoord			int
		 * 	- YCoord			int
		 * 	- ZCoord			int
		 * 	- DimID				int
		 */
		
		Connection conn = DataBaseHandler.getDataBaseHandler().getDataSource("jdbc:h2:" + Constants.MinecraftDir + "/mods/MineLegends.db").getConnection();
		try
		{
			String sql = "INSERT INTO BLOCKCHANGES(BlockName, PlayerName, Time, XCoord, YCoord, ZCoord, DimID, Break) values(?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, event.blockSnapshot.blockIdentifier.toString());
			pstmt.setObject(2, event.player.getGameProfile().getId());
			pstmt.setObject(3, TimeHandler.getCurrentDateInTicks());
			pstmt.setObject(4, event.pos.getX());
			pstmt.setObject(5, event.pos.getY());
			pstmt.setObject(6, event.pos.getZ());
			pstmt.setObject(7, event.player.dimension);
			pstmt.setObject(8, false);
			pstmt.executeUpdate();
		} finally
		{
			conn.close();
		}
		
	}
	
	@SubscribeEvent
	public void onPlaceMultiBlock(MultiPlaceEvent event) throws SQLException
	{
		
		/*
		 * info necessary:
		 * 	- BlockName			String[]
		 * 	- PlayerName		UUID
		 * 	- Time				Long
		 * 	- XCoord			int[]
		 * 	- YCoord			int[]
		 * 	- ZCoord			int[]
		 * 	- DimID				int
		 */
		
	}
	
}
