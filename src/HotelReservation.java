import java.util.ArrayList;
import java.util.List;

public class HotelReservation {
	
	private static ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
	
	//construtor da classe HotelReservation
	public HotelReservation() {
		Hotel h1 = new Hotel("Lakewood", 3, 110, 80, 90, 80);		
		Hotel h2 = new Hotel("Bridgewood", 4, 160, 110, 60, 50);		
		Hotel h3 = new Hotel("Ridgewood", 5, 220, 100, 150, 40);		
		hotelList.add(h1);
		hotelList.add(h2);
		hotelList.add(h3);		
	}
	
	//formata a entrada de dados e retorna o hotel com o menor preco
	public String getCheapestHotel (String input) {
		try {
			
			input = input.replace(" ","");
			String[] split0 = input.split(":");			
			String clientType = split0[0];
		
			Reservation reservation = new Reservation(clientType);
			String[] splitDataStrings = split0[1].split(",");			
			for(int i = 0; i < splitDataStrings.length; i++) {
				if(splitDataStrings[i] != null && !splitDataStrings[i].isEmpty()) {
					
				String[] split = splitDataStrings[i].split("\\(");
				String s = split[1].replace(")", "");
				Days d = Days.getDayByName(s);
				reservation.addDay(d);
				
				}
			}		
			
			float minorPrice = hotelList.get(0).calculateReservation(reservation);
			int minorPosition = 0;			
			for (int i = 1; i < hotelList.size(); i++) {
				float price = hotelList.get(i).calculateReservation(reservation);
				int hotelClass = hotelList.get(i).getHotelClassification();				
				if( price < minorPrice) {
					minorPrice = price;
					minorPosition = i;
				} else if(price == minorPrice && hotelClass > hotelList.get(minorPosition).getHotelClassification()) {
					minorPrice = price;
					minorPosition = i;
				}			
			}
			return hotelList.get(minorPosition).getName();			
			
		} catch(Exception e) {
			
			return "Wrong input";
		}        
    }
}
