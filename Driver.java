import java.io.*;
import java.util.*;

public class Driver {
	public static void main(String[] args) throws FileNotFoundException{
		try {
			System.out.println(""+bronze("field.dat"));
		}
		catch (FileNotFoundException e){
			System.out.println("somethign really bad hapoepn");
		}
	}
}