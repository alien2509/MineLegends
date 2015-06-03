package alien2509.mods.minelegends.util;

import java.util.HashMap;

public class Date
{
	
	String name;
	public HashMap<String, Integer> Months = new HashMap<String, Integer>();
	
	public long totalTicks;
	
	public int dayLength;
	public int weekLength;
	public int monthLength;
	public int yearLength;
	
	public int day;
	public int oldDay;
	public int week;
	public int oldWeek;
	public String month;
	public String oldMonth;
	public int year;
	public int oldYear;
	
	public Date(String name, int dayLength, String[] weekNames, int weekLength, HashMap<String, Integer> months, int yearLength)
	{
		
		
		
	}
	
	public void setDate(long totalTicks)
	{
		
		
		
	}
	
	public void setDate(int day, int week, int month, int year)
	{
		
		
		
	}
	
	public String getName()
	{
		
		return this.name;
		
	}
	
	public void onTick()
	{
		
		this.totalTicks += 1;
		if(this.totalTicks % this.dayLength == 0 || this.totalTicks % this.dayLength > this.dayLength)
		{
			
			this.day += 1;
			if(this.day > Months.get(this.month) || this.month == null)
			{
				
				this.day = 1;
				this.month = null;
				if(this.month == null)
				{
					
					
					
				}
				
			}
			
		} else if(this.totalTicks % this.dayLength > 0 && this.totalTicks % this.dayLength <= this.dayLength)
		{
			
			return;
			
		}
		
	}
	
}
