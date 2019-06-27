//***************************************************************************************
//***************************************************************************************
//                                Helicopter machine class                                 //
//***************************************************************************************
//***************************************************************************************

class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public Helicopter(String name, Coordinates coordinates){super(name, coordinates);}

	public void updateCondition(){
		String weather = this.weatherTower.getWeather(this.coordinates);
		//FileWriters fileWriter = FileWriters.getWriter();
		//FileWriters.getWriter();
		int longitude = 0;
		int latitude = 0;
		int height = 0;
		
		FileWriters.puttofile("Helicopter#"+this.name+"("+this.id+") : ");
		switch(weather) {
			case "SUN":
				longitude = this.coordinates.getLongitude();
				latitude = this.coordinates.getLatitude() + 10;
				height = this.coordinates.getHeight() + 2;
				//if(fileWriter != null)
				FileWriters.puttofile("the sun is shining your cool.");
				//else FileWriters.puttofileln("the sun is shining you're cool.");
			break;
			case "RAIN":
				longitude = this.coordinates.getLongitude();
				latitude = this.coordinates.getLatitude() + 5;
				height = this.coordinates.getHeight();
				//if(fileWriter != null)
				FileWriters.puttofile("i hope you have doors on that thing.");
				//else FileWriters.puttofileln("i hope you have doors on that thing.");
			break;
			case "FOG":
				longitude = this.coordinates.getLongitude();
				latitude = this.coordinates.getLatitude() + 1;
				height = this.coordinates.getHeight();
				//if(fileWriter != null)
				FileWriters.puttofile("I JUST GOT A MIND FOG.");
				//else FileWriters.puttofileln("I JUST GOT A MIND FOG.");
			break;
			case "SNOW":
				longitude = this.coordinates.getLongitude();
				latitude = this.coordinates.getLatitude();
				height = this.coordinates.getHeight() - 7;
				//if(fileWriter != null)
				FileWriters.puttofile("HAVE YOU TRAID YELLOW SNOW.");
				//else FileWriters.puttofileln("HAVE YOU TRAID YELLOW SNOW.");
			break;
		}
		if (height > 100)height = 100;
		if (height < 1){
			FileWriters.puttofileln("\nHelicopter#"+name+"("+id+") : Landing");
			this.weatherTower.unregister(this);
			return ;}
		FileWriters.puttofileln(" weather condition : weather");
		this.coordinates = new Coordinates(longitude, latitude, height);	
	}

	public void registerTower(WeatherTower weatherTower){
		this.weatherTower = weatherTower;
		FileWriters.puttofile("Helicopter#"+name+"("+id+") : ");
	}

}