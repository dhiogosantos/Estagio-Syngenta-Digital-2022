import java.util.Map;

public class Hotel {
	
	private String name;
	private int hotelClassification;
	private float regularWeekTax;
	private float rewardWeekTax;	
	private float regularWeekendTax;
	private float rewardWeekendTax;
	
	//construtor da classe Hotel
	public Hotel (String n, int hClassification, float regWeek, float rewWeek, float regWeekend, float rewWeekend){
		setName(n);
		setHotelClassification(hClassification);
		setRegularWeekTax(regWeek);
		setRewardWeekendTax(rewWeek);
		setRegularWeekendTax(regWeekend);
		setRewardWeekendTax(rewWeekend);				
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHotelClassification() {
		return hotelClassification;
	}

	public void setHotelClassification(int hotelClassification) {
		this.hotelClassification = hotelClassification;
	}

	public float getRegularWeekTax() {
		return regularWeekTax;
	}

	public void setRegularWeekTax(float regularWeekTax) {
		this.regularWeekTax = regularWeekTax;
	}

	public float getRewardWeekTax() {
		return rewardWeekTax;
	}

	public void setRewardWeekTax(float rewardWeekTax) {
		this.rewardWeekTax = rewardWeekTax;
	}

	public float getRegularWeekendTax() {
		return regularWeekendTax;
	}

	public void setRegularWeekendTax(float regularWeekendTax) {
		this.regularWeekendTax = regularWeekendTax;
	}

	public float getRewardWeekendTax() {
		return rewardWeekendTax;
	}

	public void setRewardWeekendTax(float rewardWeekendTax) {
		this.rewardWeekendTax = rewardWeekendTax;
	}
	
	//verifica o tipo do cliente (Regular ou Rewards)
	public float calculateReservation(Reservation r) {
		if(r.getClientType().equals("Regular")) {
			return calculateReservationRegular(r);
		} else {
			return calculateReservationReward(r);
		}
	}	
	
	//calcula o preco da estadia para clientes Regulares
	private float calculateReservationRegular(Reservation r) {
		float sum = 0f;
		for (Map.Entry <Days, Integer> entry : r.getQuantityDaysWeek().entrySet()) {
		    Days key = entry.getKey();
		    Integer value = entry.getValue();		        
		    
		    if(key == Days.FRIDAY || key == Days.SATURDAY || key == Days.SUNDAY) {
		    	sum += regularWeekendTax * value;
		    	
		    } else {
		    	sum += regularWeekTax * value;
		    }		    
		}
		return sum;
	}
	
	//calcula o preco da estadia para clientes Rewards
	private float calculateReservationReward(Reservation r) {
		float sum = 0f;
		for (Map.Entry <Days, Integer> entry : r.getQuantityDaysWeek().entrySet()) {
		    Days key = entry.getKey();
		    Integer value = entry.getValue();
		    
		    if(key == Days.FRIDAY || key == Days.SATURDAY || key == Days.SUNDAY) {
		    	sum += rewardWeekendTax * value;
		    	
		    } else {
		    	sum += rewardWeekTax * value;
		    }
		    
		}
		return sum;
	}
	
}
