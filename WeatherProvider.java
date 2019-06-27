import java.util.Random;

//***************************************************************************************
//***************************************************************************************
//                               Weather provider class                                //
//***************************************************************************************
//***************************************************************************************

class WeatherProvider {
	private static WeatherProvider weatherprovider = null;
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider(){}

	public static WeatherProvider getProvider(){
		if (weatherprovider == null)
			weatherprovider = new WeatherProvider();
		return weatherprovider;
	}

	public String getCurrentWeather(Coordinates coordinates){
		Random SpicySeed = new Random();
		int longitude = coordinates.getLongitude();
		int latitude = coordinates.getLatitude();
		int height = coordinates.getHeight();
		long weatherseed = longitude * latitude * height *
		SpicySeed.nextInt(500);

		Random rand = new Random(weatherseed);
		int n = rand.nextInt(4);
		return (weather[n]);
	}
}