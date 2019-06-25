//***************************************************************************************
//***************************************************************************************
//                                     Aircraft factory class                          //
//***************************************************************************************
//***************************************************************************************

class AircraftFacroty {
	
	public Flyable newAircraft(String name, String type, int longitude, int latitude, int height){
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		if (type.equals("Helicopter")){
			return new Helicopter(name, coordinates);
		}else if (type.equals("JetPlane")){
			return new JetPlane(name, coordinates);
		}else if (type.equals("Baloon")){
			return new Baloon(name, coordinates);
		}
		return null;
	}

}