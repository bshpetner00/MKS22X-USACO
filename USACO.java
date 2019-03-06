import java.io.*;
import java.util.*;



public class USACO {
	public static int bronze(String filename) throws FileNotFoundException{
		private int[][] field;
		File text = new File(filename);
		Scanner inf = new Scanner(text);
		int lines = 0;
		int maxChars = 0;
		while (inf.hasNextLine()) {
			String line = inf.nextLine();
			lines++;
			if(maxChars < line.length()) {
				maxChars = line.length();
			}
		}
		Scanner inf2 = new Scanner(text);
		field = new char[lines][maxChars];
		for (int r = 0; r < lines; r++) {
			String s = inf2.nextLine();
			for (int c = 0; c < maxChars; c++) {
				if (c < maxChars - 4) {
					if (s.charAt(c+1) == ' ') {
						field[r][c] = (int) s.charAt(c);
						c+=1;
					}
					else if (s.charAt(c+2) == ' ') {
						field[r][c] = (int) s.subString(c,c+2);
						c+=2;
					}
					else if (s.charAt(c+3) == ' ') {
						field[r][c] = (int) s.subString(c,c+3);
						c+=3;
					}
					else if (s.charAt(c+4) == ' ') {
						field[r][c] = (int) s.subString(c,c+4);
						c+=4;
					}
				}
				else {
					//do the thing for the last 4
				}
			}
		}

		int lowerBound = 0;
		int upperBound = 0;
		String toAdd = "";
		for (int c = 0; c < maxChars; c++) {
			if (s.charAt(c) = ' ') {
				field[r][c] = (int) toAdd;
				toAdd = "";
			}
			else {
				toAdd += (String) s.charAt(c);
			}
		}
	}

	public static int silver(String filename) {

	}
}