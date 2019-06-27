import java.io.*;
import java.io.FileWriter;

//***************************************************************************************
//***************************************************************************************
//                                File Writer class                                    //
//***************************************************************************************
//***************************************************************************************

class FileWritersException extends RuntimeException 
{ 
    //private static final long serialVersionUID = 1L;

	private static final long serialVersionUID = 1L;

	public FileWritersException(String s) 
    { 
		System.out.println(s);
		// Call constructor of parent Exception 
        //super(s); 

    } 
} 

class FileWriters {
	private static boolean firstrun;

	private FileWriters(){}

	public static void puttofileln(String str){
		if (!firstrun){
			try{
				FileWriter fw=new FileWriter("simulation.txt");    
				fw.flush();//write("Welcome to javaTpoint.");    
				fw.close();
			}catch (Exception e){
				throw new FileWritersException("Unable clear file");
			}
			firstrun = true;
		}
		try{
		BufferedWriter FileDis = new BufferedWriter(
			new FileWriter("simulation.txt", true)); 
			FileDis.write(str + "\n"); 
			FileDis.close(); 
		}catch (Exception e){
			throw new FileWritersException("Unable To Open file");
		}
	}

	public static void puttofile(String str){
		if (!firstrun){
			try{
				FileWriter fw=new FileWriter("simulation.txt");    
				fw.flush();//write("Welcome to javaTpoint.");    
				fw.close();
			}catch (Exception e){
				throw new FileWritersException("Unable clear file");
			}
			firstrun = true;
		}
		try{
			BufferedWriter FileDis = new BufferedWriter(
			new FileWriter("simulation.txt", true)); 
			FileDis.write(str); 
			FileDis.close(); 
		}catch (Exception e){
			throw new FileWritersException("Unable To Open file");
		}
	}
}
