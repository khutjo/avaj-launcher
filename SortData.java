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
	//	FileWriters.puttofileln(HoldFileData[1]);
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