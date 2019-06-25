import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;







//***************************************************************************************
//***************************************************************************************
//                                         main class                                  //
//***************************************************************************************
//***************************************************************************************


public class Simulation {

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
			FileReader.close();
		}catch (FileNotFoundException e){
			throw new IllegalStateException("Invalid File Inputed");
		}
		return (FileData);
	}

	public static ArrayList<SortData> ReadAndAddData(Stack<String> src){
		SortData HoldSortedData;
		ArrayList<SortData> ReturnSortedData = new ArrayList<SortData>();
		Iterator<String> HoldFileIter = src.iterator();
//		FileWriters.puttofileln(HoldFileIter.next());
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
//		FileWriters.puttofileln(HoldString);
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
//		FileWriters.puttofileln(FileData);
		FileWriters.puttofileln("RunTime : "+RunTime);		
		for (SortData i : InPutData) {
			WeatherTower.register(MakeClass.newAircraft(i.getAirCraftName()
						,i.getAirCraftType(),i.getLongitude(),i.getLatitude(),i.getHeight()));}
			FileWriters.puttofileln("");
		while (0 < RunTime--){
			WeatherTower.conditionChanged();
			FileWriters.puttofileln("");
		}
	}
}
