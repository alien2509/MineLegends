package alien2509.mods.minelegends.util;

public class DateTime
{
	
	public long totalTicks;
	public String name;
	
	public int secLength;
	public int sec;
	public int minLength;
	public int min;
	public int hourLength;
	public int hour;
	public int dayLength;
	public int day;
	public int weekLength;
	public int week;
	public int weekDay;
	public String[] weekdayNames = new String[weekLength];
	public String weekDayName;
	public int monthLength;
	public int month;
	public String[] monthNames;
	public String monthName;
	public int yearLength;
	public int year;
	
	
	public DateTime(int secLength, int minLength, int hourLength, int dayLength, int weekLength, int weekDay, String[] weekdayNames, int monthLength, String[] monthNames, int yearLength)
	{
		
		this.secLength = secLength;
		this.minLength = minLength;
		this.hourLength = hourLength;
		this.dayLength = dayLength;
		this.weekLength = weekLength;
		this.weekDay = weekDay;
		this.weekdayNames = weekdayNames;
		this.monthLength = monthLength;
		this.monthNames = monthNames;
		this.yearLength = yearLength;
		
	}
	
	public void setTime(long ticks)
	{
		this.totalTicks = ticks;
	}
	
	public void setTime(int sec, int min, int hour, int day, int week, int month, int year)
	{
		this.sec = sec;
		this.min = min;
		this.hour = hour;
		this.day = day;
		this.week = week;
		this.month = month;
		this.year = year;
	}
	
	public void saveTime()
	{
		
		
		
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void onTick()
	{
		this.totalTicks += 1;
		if(this.totalTicks % this.secLength == 0 && this.totalTicks / this.secLength > this.sec)
		{
			this.sec += 1;
			if(this.sec == this.minLength)
			{
				this.sec = 0;
				this.min += 1;
				if(this.min ==  this.hourLength)
				{
					this.min = 0;
					this.hour += 1;
					if(this.hour == this.dayLength)
					{
						this.hour = 0;
						this.day += 1;
						this.weekDay += 1;
						if(this.weekDay > this.weekLength)
						{
							this.weekDay = 1;
							this.week += 1;
							if(this.week % this.monthLength == 0 && this.week / this.monthLength > month)
							{
								this.month += 1;
								if(this.month > this.yearLength)
								{
									this.month = 1;
									this.week = 1;
									this.year += 1;
								}
							}
						}
					}
				}
			}
		}
	}
}
