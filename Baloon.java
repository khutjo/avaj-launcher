//***************************************************************************************
//***************************************************************************************
//                                Helicopter machine class                                 //
//***************************************************************************************
//***************************************************************************************

class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	public Baloon(String name, Coordinates coordinates){super(name, coordinates);}

	public void updateCondition(){
		String weather = this.weatherTower.getWeather(this.coordinates);
		int longitude = 0;
		int latitude = 0;
		int height = 0;

		FileWriters.puttofile("Baloon#"+this.name+"("+this.id+") : ");
		switch(weather) {
			case "SUN":
				longitude = this.coordinates.getLongitude() + 2;
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight() + 4;
				FileWriters.puttofile("OK i get it i cant afford a JetPlane or a Helicopter but it i a nice day.");
			break;
			case "RAIN":
				longitude = this.coordinates.getLongitude() - 5;
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight();
				FileWriters.puttofile("a little bit of rain never hurts.");
			break;
			case "FOG":
				longitude = this.coordinates.getLongitude() - 1;
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight();
				FileWriters.puttofile("this is not that bad whats the worst thing that can heppen");
				break;
			case "SNOW":
				longitude = this.coordinates.getLongitude();
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight() - 15;
				FileWriters.puttofile("aaaaawwwww shit oh shit oh shit oh shit!!!!!!");
			break;
		}
		if (height > 100)height = 100;
		if (height < 1){
			FileWriters.puttofileln("\nBaloon#"+name+"("+id+") Landing");
			this.weatherTower.unregister(this);
			return ;}
		FileWriters.puttofileln(" weather condition : weather");
		this.coordinates = new Coordinates(longitude, latitude, height);
}

	public void registerTower(WeatherTower weatherTower){
		this.weatherTower = weatherTower;
//		FileWriters.puttofileln(
		FileWriters.puttofile("Baloon#"+name+"("+id+") : ");
	}
}