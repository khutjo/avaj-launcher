import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.*; 

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
			throw new IllegalStateException("Object not initialised");

		AirCraftType = LineData[0];
		AirCraftName = LineData[1];
		Longitude = Integer.parseInt(LineData[2]);
		Latitude = Integer.parseInt(LineData[3]);
		Height = Integer.parseInt(LineData[4]);
	}
}

class InFile {

	private String InFileName;
	Stack<String> FileContent;




private void ReadFromFile() throws Exception {

File file = new File(InFileName);
Scanner sc = new Scanner(file);
List<AirCraftData> ListOfAirCraft;


while (sc.hasNextLine()){
	FileContent.push(sc.nextLine() + "\n");
}
	Iterator<String> hold = FileContent.iterator();
	while(hold.hasNext()){
	System.out.println(hold.next());
	}
//	System.out.println(FileContent); 

}

public InFile(String infile) throws Exception
{
	InFileName = infile;
	FileContent = new Stack<String>();
	List<AirCraftData> ListOfAirCraft = new ArrayList<AirCraftData>();
	ReadFromFile();
 }

public String get(){return InFileName;}

}


public class main{

public static void main (String[] args){

if (args.length == 0 || args[0].isEmpty()){
	System.out.println("No File To Read Form");
	return ;
}
try{InFile FileToRead = new InFile(args[0]);}
catch (Exception e){
	System.out.println("Unable to read from file");
	return ;
}
	//	InFile FileToRead;// = InFile(args[0]);
	//
System.out.println("hello world!");
//System.out.println(FileToRead.get());
return;
}


}
