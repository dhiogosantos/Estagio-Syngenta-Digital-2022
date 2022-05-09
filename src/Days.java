
public enum Days {
	
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

	public static Days getDayByName(String c){	
		
		if(c.equals("sun")) {
			return Days.SUNDAY;
		}
		
		if(c.equals("mon")) {
			return Days.MONDAY;
		}
		
		if(c.equals("tues")) {
			return Days.TUESDAY;
		}
		
		if(c.equals("wed")) {
			return Days.WEDNESDAY;
		}
		
		if(c.equals("thur")) {
			return Days.THURSDAY;
		}
		
		if(c.equals("fri")) {
			return Days.FRIDAY;
		}
		
		else {
			return Days.SATURDAY;
		}			
	}		
}
