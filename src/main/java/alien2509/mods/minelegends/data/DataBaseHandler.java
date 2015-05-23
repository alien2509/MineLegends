package alien2509.mods.minelegends.data;

import java.sql.Connection;
import java.sql.SQLException;

import org.spongepowered.api.service.sql.SqlService;
import org.spongepowered.common.Sponge;

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
		
		Connection conn = DataBaseHandler.getDataBaseHandler().getDataSource("jdbc:h2:MineLegends.db").getConnection();
		try
		{
			conn.prepareStatement("sql").execute();
		} finally
		{
			conn.close();
		}
		
	}
	
}