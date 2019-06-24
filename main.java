import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//***************************************************************************************
//***************************************************************************************
//                                Coordinate class                                     //
//***************************************************************************************
//***************************************************************************************
class Coordinates {
	private int Longitude;
	private int Latitude;
	private int Height;

	public Coordinates(int longitude, int  latitude, int height){
		Longitude = longitude;
		Latitude = latitude;
		Height = height;
	}

	public int getLongitude(){return (Longitude);}
	public int getLatitude(){return (Latitude);}
	public int getHeight(){return (Height);}
}

//***************************************************************************************
//***************************************************************************************
//                                AirCraft class                                       //
//***************************************************************************************
//***************************************************************************************

class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter;

	protected Aircraft(String name, Coordinates coordinates){
		this.name = name;
		this.coordinates = coordinates;
		id = nextid();
	}

	private long nextid(){return (idCounter++);}
}

//***************************************************************************************
//***************************************************************************************
//                                flyable class                                        //
//***************************************************************************************
//***************************************************************************************

interface Flyable {

	public void updateCondition();
	public void registerTower(WeatherTower WeatherTower);

}



//***************************************************************************************
//***************************************************************************************
//                                flying machine class                                 //
//***************************************************************************************
//***************************************************************************************

class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	public Helicopter(String name, Coordinates coordinates){super(name, coordinates);}

	public void updateCondition(){};
	public void registerTower(WeatherTower weatherTower){
		this.weatherTower = weatherTower;
		System.out.println("Helicopter#"+name+"("+id+") registered to weather tower.");
	}

}

class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	public JetPlane(String name, Coordinates coordinates){super(name, coordinates);}

	public void updateCondition(){}
	public void registerTower(WeatherTower weatherTower){
		this.weatherTower = weatherTower;
		System.out.println("JetPlane#"+name+"("+id+") registered to weather tower.");
	}

}

class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	public Baloon(String name, Coordinates coordinates){super(name, coordinates);}

	public void updateCondition(){}
	public void registerTower(WeatherTower weatherTower){
		this.weatherTower = weatherTower;
		System.out.println("Baloon#"+name+"("+id+") registered to weather tower.");
	}

}

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


//***************************************************************************************
//***************************************************************************************
//                                   Tower class                                       //
//***************************************************************************************
//***************************************************************************************

class Tower{
	private ArrayList<Flyable> observers;

	public void register(Flyable Flyable){
		if (observers == null)
			observers = new ArrayList<Flyable>();
		observers.add(Flyable);
		System.out.print("Tower Says: ");
//			WeatherTower hold = new WeatherTower();
		if (Flyable != null)
			Flyable.registerTower((WeatherTower)this);
	}
	public void unregister(Flyable Flyable){}
	protected void conditionChanged(){}
}

//***************************************************************************************
//***************************************************************************************
//                               Weather Tower class                                   //
//***************************************************************************************
//***************************************************************************************

class WeatherTower extends Tower{
	
	public String getWeather(Coordinates coordinates){

	   return ("hello");
	}


}

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
		Random rand = new Random();
		int n = rand.nextInt(4);
		return (weather[n]);
	}

}

//***************************************************************************************
//***************************************************************************************
//                                   sorted data class                                 //
//***************************************************************************************
//***************************************************************************************


class SortData{
	private String AirCraftType;
	private String AirCraftName;
	private int Longitude;
	private int Latitude;
	private int Height;

	private int isDigitElseError(String NumberToString){
		NumberToString = NumberToString.trim(); 
		for (char ch: NumberToString.toCharArray())
			if (!Character.isDigit(ch))
				throw new IllegalStateException("Invalid File Format");
		return Integer.parseInt(NumberToString);
	}

	public SortData(String FileLine){
		String[] HoldFileData = FileLine.split(" ");
	//	System.out.println(HoldFileData[1]);
		if (HoldFileData.length != 5)
			throw new IllegalStateException("Invalid File Format");
		if (HoldFileData[0].equals("Helicopter") 
			|| HoldFileData[0].equals("JetPlane")
			|| HoldFileData[0].equals("Baloon")){
				AirCraftType = HoldFileData[0];
			}
		AirCraftName = HoldFileData[1];
		Longitude = isDigitElseError(HoldFileData[2]);
		Latitude = isDigitElseError(HoldFileData[3]);
		Height = isDigitElseError(HoldFileData[4]);

	}

	public String getAirCraftType(){return (AirCraftType);}
	public String getAirCraftName(){return (AirCraftName);}
	public int getLongitude(){return (Longitude);}
	public int getLatitude(){return (Latitude);}
	public int getHeight(){return (Height);}
}


//***************************************************************************************
//***************************************************************************************
//                                         main class                                  //
//***************************************************************************************
//***************************************************************************************


public class main {

	public static Stack<String>  ReadFileData(String[] args) {
		Stack<String> FileData = new Stack<String>();
		String HoldString;

		if (args.length == 0 || args[0].isEmpty())
			throw new IllegalStateException("No File Inputed");

		File InFile = new File(args[0]);
		try{Scanner FileReader = new Scanner(InFile);
			while (FileReader.hasNextLine()){
				HoldString = FileReader.nextLine();
				HoldString = HoldString.trim();
				FileData.push(HoldString);
			}
		}catch (FileNotFoundException e){
			throw new IllegalStateException("Invalid File Inputed");
		}
		return (FileData);
	}

	public static ArrayList<SortData> ReadAndAddData(Stack<String> src){
		String HoldString;
		SortData HoldSortedData;
		ArrayList<SortData> ReturnSortedData = new ArrayList<SortData>();
		Iterator<String> HoldFileIter = src.iterator();
//		System.out.println(HoldFileIter.next());
		HoldFileIter.next();
//		for (String HoldString :  
		while (HoldFileIter.hasNext()){
//			HoldString = FileIter.
			HoldSortedData = new SortData(HoldFileIter.next());
			ReturnSortedData.add(HoldSortedData);
		}
		return ReturnSortedData;
	}
	
	public static int getRunTime(Stack<String> src){
		String HoldString;
		Iterator<String> HoldFileIter = src.iterator();
		HoldString = HoldFileIter.next();
//		System.out.println(HoldString);
//		HoldString = HoldString.trim();
		for (char ch: HoldString.toCharArray())
			if (!Character.isDigit(ch))
				throw new IllegalStateException("Invalid RunTime Inputed");
		return Integer.parseInt(HoldString);
	}

	public static void main(String[] args)  {
		int RunTime = 0;
		Stack<String> FileData = ReadFileData(args);
		ArrayList<SortData> InPutData;// = new ArrayList<SortData>();
		WeatherTower WeatherTower = new WeatherTower();
		AircraftFacroty MakeClass = new AircraftFacroty();
		RunTime = getRunTime(FileData);
		InPutData = ReadAndAddData(FileData); 
//		System.out.println(FileData);
		System.out.println("RunTime : "+RunTime);		

		for (SortData i : InPutData) {
			WeatherTower.register(MakeClass.newAircraft(i.getAirCraftName()
						,i.getAirCraftType(),i.getLongitude(),i.getLatitude(),i.getHeight()));}
	}
}
