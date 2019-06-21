import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.*; 
//import filess.InFile;

//******************************************************************************************************
// aircraft class
//******************************************************************************************************

class AirCraftData {
	private String AirCraftType;
	private String AirCraftName;
	private int Latitude;
	private int Longitude;
	private int Height;

	public AirCraftData(){
		AirCraftType = "NULL";
		AirCraftName = "NULL";
		Longitude = 0;
		Latitude = 0;
		Height = 0;
	}

	public void GetAirCraftData(String line) throws Exception{

		String[] LineData = line.split(" ");
		if (LineData.length != 5)
			throw new IllegalStateException("hold my phone");

		AirCraftType = LineData[0];
		AirCraftName = LineData[1];
		Longitude = Integer.parseInt(LineData[2]);
		Latitude = Integer.parseInt(LineData[3]);
		Height = Integer.parseInt(LineData[4]);
	}

}


//******************************************************************************************************
// file reading class
//******************************************************************************************************



class InFile {

	private String InFileName;
	Stack<String> FileContent;



	private void ReadFromFile() throws Exception {

		File file = new File(InFileName);
		Scanner sc = new Scanner(file);


		while (sc.hasNextLine()){
			FileContent.push(sc.nextLine() + "\n");
		}
			}

	public InFile(String infile) throws Exception
	{
		InFileName = infile;
		FileContent = new Stack<String>();
		ReadFromFile();
 	}

	public int GetFileData(ArrayList<AirCraftData> src) throws Exception {
		Iterator<String> FileIter = FileContent.iterator();
		AirCraftData HoldAirCraftData;
		String HoldString;
		int RunTime = 0;
		boolean IsFirst = true;

		while(FileIter.hasNext()){
			HoldString = FileIter.next();
			HoldString = HoldString.trim();
			if (IsFirst){
				for (int i = 0; i < HoldString.length(); i++){
					if (!Character.isDigit(HoldString.charAt(i)))
						throw new IllegalStateException("Invalid file");
					}
				IsFirst = !IsFirst;
				RunTime = Integer.parseInt(HoldString);
			System.out.println(HoldString);
			}else{
				HoldAirCraftData = new AirCraftData();
				HoldAirCraftData.GetAirCraftData(HoldString);
			src.add(HoldAirCraftData);
			System.out.println(HoldString);
			}
		}


		return (RunTime);
	}

	public String GetFileName(){return InFileName;}

}


//******************************************************************************************************
//  main file
//******************************************************************************************************


public class main{

	public static void main (String[] args){
	int RunTime = 0;
	ArrayList<AirCraftData> ListOfAirCraft = new ArrayList<AirCraftData>();

	//file to read input protaction
	if (args.length == 0 || args[0].isEmpty()){
		System.out.println("No File To Read Form");
		return ;
	}
	//read file protaction
	try{
		//read file data
		InFile FileToRead = new InFile(args[0]);
		System.out.println(FileToRead.GetFileData(ListOfAirCraft));//FileToRead.GetFileName());
		//put data somewere
	}catch (Exception e){
		//it failed
		System.out.println("Unable to read from file");
		return ;
	}


	System.out.println("hello world!");
	return;
	}
}
