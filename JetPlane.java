//***************************************************************************************
//***************************************************************************************
//                                Helicopter machine class                                 //
//***************************************************************************************
//***************************************************************************************

class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	public JetPlane(String name, Coordinates coordinates){super(name, coordinates);}

	public void updateCondition(){
		String weather = this.weatherTower.getWeather(this.coordinates);
		int longitude = 0;
		int latitude = 0;
		int height = 0;

		FileWriters.puttofile("JetPlane#"+this.name+"("+this.id+") : ");
		switch(weather) {
			case "SUN":
				longitude = this.coordinates.getLongitude() + 10;
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight() + 2;
				FileWriters.puttofile("Im am cutting through the sky.");
			break;
			case "RAIN":
				longitude = this.coordinates.getLongitude() + 5;
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight();
				FileWriters.puttofile("Im cutting through water i am like a dolphin.");
			break;
			case "FOG":
				longitude = this.coordinates.getLongitude() + 1;
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight();
				FileWriters.puttofile("I can't see shit i hope there are no idiots fling in baloon.");
			break;
			case "SNOW":
				longitude = this.coordinates.getLongitude();
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight() - 12;
				FileWriters.puttofile("i blame amarica for this design flaw.");
			break;
		}
		if (height > 100)height = 100;
		if (height < 1){
			FileWriters.puttofileln("\nJetPlane#"+name+"("+id+") Landing");
			this.weatherTower.unregister(this);
			return ;}
		FileWriters.puttofileln(" weather condition : weather");
		this.coordinates = new Coordinates(longitude, latitude, height);
	}

	public void registerTower(WeatherTower weatherTower){
		this.weatherTower = weatherTower;
		FileWriters.puttofile("JetPlane#"+name+"("+id+") : ");
	}

}