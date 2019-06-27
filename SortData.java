//***************************************************************************************
//***************************************************************************************
//                                   sorted data class                                 //
//***************************************************************************************
//***************************************************************************************
class SortDataException extends RuntimeException 
{ 
    //private static final long serialVersionUID = 1L;

	private static final long serialVersionUID = 1L;

	public SortDataException(String s) 
    { 
		System.out.println(s);
        // Call constructor of parent Exception 
        //super(s); 
    } 
} 

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
				throw new SortDataException("Invalid File Format");
		return Integer.parseInt(NumberToString);
	}

	public SortData(String FileLine){
		String[] HoldFileData = FileLine.split(" ");
	//	FileWriters.puttofileln(HoldFileData[1]);
		if (HoldFileData.length != 5)
			throw new SortDataException("Invalid File Format");
		//System.out.println("--->"+HoldFileData[2]+"<---->"+HoldFileData[2].length()+"<----");
		for (int i = 0; i < 5; i++){
			if (HoldFileData[i].length() < 1){
				if (i == 0)
					throw new SortDataException("Invalid Type");
				else if (i == 1)
					throw new SortDataException("Invalid Name");
				else if (i == 2)
					throw new SortDataException("Invalid Longitude");
				else if (i == 3)
					throw new SortDataException("Invalid Latitude");
				else if (i == 4)
					throw new SortDataException("Invalid Height");
			}
		}	
		if (HoldFileData[0].trim().equals("Helicopter") 
			|| HoldFileData[0].trim().equals("JetPlane")
			|| HoldFileData[0].trim().equals("Baloon")){
				AirCraftType = HoldFileData[0].trim();
		}else{
			throw new SortDataException("Invalid aircraft type");}
		AirCraftName = HoldFileData[1].trim();
		Longitude = isDigitElseError(HoldFileData[2].trim());
		Latitude = isDigitElseError(HoldFileData[3].trim());
		Height = isDigitElseError(HoldFileData[4].trim());
		if (Height > 100)Height = 100;
	}

	public String getAirCraftType(){return (AirCraftType);}
	public String getAirCraftName(){return (AirCraftName);}
	public int getLongitude(){return (Longitude);}
	public int getLatitude(){return (Latitude);}
	public int getHeight(){return (Height);}
}