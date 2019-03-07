import java.io.*;
import java.util.*;

public class Driver {
	public static void main(String[] args) {
		try {
			Field f = new Field("field.dat");
			System.out.println(f);
		}
		catch (FileNotFoundException e){
			System.out.println("somethign really bad hapoepn");
		}
	}
}