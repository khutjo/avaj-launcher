
class InFile {

	String InFileName;

public InFile(String infile){
	InFileName = infile;
}

String get(){return InFileName;}

}


public class main{

public static void main (String[] args){


//	System.out.println(args[0].isEmpty());
if (args[0].isEmpty()){
	System.out.println("No File To Read Form");
	return ;
}
	InFile FileToRead = new InFile(args[0]);
	//	InFile FileToRead;// = InFile(args[0]);
System.out.println("hello world!");
//System.out.println(FileToRead.get());
return;
}


}
