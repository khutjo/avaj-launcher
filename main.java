import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

//***************************************************************************************
//***************************************************************************************
//                                         main class                                  //
//***************************************************************************************
//***************************************************************************************

class MainclassException extends RuntimeException 
{ 
    //private static final long serialVersionUID = 1L;

	private static final long serialVersionUID = 1L;

	public MainclassException(String s) 
    { 
        // Call constructor of parent Exception 
		System.out.println(s);
        //super(s); 
    } 
} 

public class Main extends AircraftFacroty {

	public static Stack<String>  ReadFileData(String[] args) {
		Stack<String> FileData = new Stack<String>();
		String HoldString;

		if (args.length == 0 || args[0].isEmpty())
			throw new MainclassException("No File Inputed");

		File InFile = new File(args[0]);
		try{Scanner FileReader = new Scanner(InFile);
			while (FileReader.hasNextLine()){
				HoldString = FileReader.nextLine();
				HoldString = HoldString.trim();
				FileData.push(HoldString);
			}
			FileReader.close();
		}catch (FileNotFoundException e){
			throw new MainclassException("Invalid File Inputed");
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
				throw new MainclassException("Invalid RunTime Inputed");
		return Integer.parseInt(HoldString);
	}

	public static void main(String[] args)  {
		int RunTime = 0;
		Stack<String> FileData = ReadFileData(args);
		ArrayList<SortData> InPutData;// = new ArrayList<SortData>();
		try {
		WeatherTower WeatherTower = new WeatherTower();
		//Main Makeaircraft = new Main();
		RunTime = getRunTime(FileData);
		InPutData = ReadAndAddData(FileData); 
//		FileWriters.puttofileln(FileData);
		FileWriters.puttofileln("RunTime : "+RunTime);		
		for (SortData i : InPutData) {
			WeatherTower.register(newAircraft(i.getAirCraftName()
						,i.getAirCraftType(),i.getLongitude(),i.getLatitude(),i.getHeight()));}
		while (0 < RunTime--){
			WeatherTower.conditionChanged();
		}
	}catch (Exception e){
		return ;
	}
	}
}
