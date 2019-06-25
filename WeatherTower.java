//***************************************************************************************
//***************************************************************************************
//                               Weather Tower class                                   //
//***************************************************************************************
//***************************************************************************************

class WeatherTower extends Tower{
	
	public String getWeather(Coordinates coordinates){
		WeatherProvider Weather = WeatherProvider.getProvider();
		return (Weather.getCurrentWeather(coordinates));
	}
}