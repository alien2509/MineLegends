package alien2509.mods.minelegends.data;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import org.spongepowered.api.service.sql.SqlService;
import org.spongepowered.common.Sponge;

import alien2509.mods.minelegends.util.Constants;

public class DataBaseHandler
{
	
	public static DataBaseHandler dataBaseHandler = new DataBaseHandler();
	
	public static DataBaseHandler getDataBaseHandler()
	{
		return DataBaseHandler.dataBaseHandler;
	}
	
	private SqlService sql;
	public javax.sql.DataSource getDataSource(String jdbcUrl) throws SQLException
	{
		if(sql == null)
		{
			sql = Sponge.getGame().getServiceManager().provide(SqlService.class).get();
		}
		return sql.getDataSource(jdbcUrl);
	}
	
	/*
	 *  Example:
	 * 	public void myMethodThatQueries() throws SQLException {
     *		Connection conn = getDataSource("jdbc:h2:imalittledatabaseshortandstout.db").getConnection();
     *		try {
     *   		conn.prepareStatement("SELECT * FROM test_tbl").execute();
     *		} finally {
     *   		conn.close();
     *		}
	 *	}
	 */
	
	public static void init() throws SQLException
	{
		
		File DataBaseLocation = new File(Constants.MinecraftDir +"/mods/MineLegends/MineLegends.db");
		if(DataBaseLocation.exists() == false)
		{
			
			Connection conn = DataBaseHandler.getDataBaseHandler().getDataSource("jdbc:h2:"+ Constants.MinecraftDir +"/mods/MineLegends.db").getConnection();
			try
			{
				conn.prepareStatement("CREATE DATABASE MineLegends").execute();
				conn.prepareStatement("").execute();
			} finally
			{
				conn.close();
			}
		
		}
		
	}
	
}