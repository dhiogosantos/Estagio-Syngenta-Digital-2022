import java.util.HashMap;

public class Reservation {
	
	private String clientType;	
	private HashMap<Days, Integer> quantityDaysWeek;	
	
	public HashMap<Days, Integer> getQuantityDaysWeek() {
		return quantityDaysWeek;
	}

	public void setQuantityDaysWeek(HashMap<Days, Integer> quantityDaysWeek) {
		this.quantityDaysWeek = quantityDaysWeek;
	}

	public Reservation (String clientType){
		quantityDaysWeek = new HashMap();
		this.setClientType (clientType);			
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {		
		this.clientType = clientType;		
	}
	
	public void addDay(Days d) {
		if(quantityDaysWeek.get(d) == null) {
			quantityDaysWeek.put(d, 1);
		} else {
			Integer qtd = quantityDaysWeek.get(d) + 1;
			quantityDaysWeek.put(d, qtd);
		}
	}
}
