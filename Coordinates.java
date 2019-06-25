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