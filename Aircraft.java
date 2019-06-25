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