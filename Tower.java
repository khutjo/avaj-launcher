import java.util.*;

//***************************************************************************************
//***************************************************************************************
//                                   Tower class                                       //
//***************************************************************************************
//***************************************************************************************

public abstract class Tower{
	private ArrayList<Flyable> observers;

	public void register(Flyable Flyable){
		if (observers == null)
			observers = new ArrayList<Flyable>();
		observers.add(Flyable);
		FileWriters.puttofile("Tower Says : ");
//			WeatherTower hold = new WeatherTower();
		if (Flyable != null)
			Flyable.registerTower((WeatherTower)this);
		FileWriters.puttofileln(" registered to weather tower.");
	}

	public void unregister(Flyable Flyable){
//Flyable.getname();
//		FileWriters.puttofileln(Flyable.getname());
		FileWriters.puttofile("Tower Says : ");
		if (Flyable != null)
			Flyable.registerTower((WeatherTower)this);
		FileWriters.puttofileln(" unregisterd");
		ArrayList<Flyable> HoldObservers = this.observers;
		this.observers = new ArrayList<Flyable>();
		for (Flyable Fly : HoldObservers)
			if (Fly != Flyable)
				this.observers.add(Fly);
	}
	protected void conditionChanged(){
		FileWriters.puttofileln("");
		for (Flyable Fly : this.observers){
			Fly.updateCondition();
		}
	}
}