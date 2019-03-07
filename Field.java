import java.io.*;
import java.util.*;

	public class Field {
		private int[][] field;
		public Field(String filename) throws FileNotFoundException {
			try {
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
			field = new int[lines][maxChars];
			for (int r = 0; r < lines; r++) {
				String s = inf2.nextLine();
				for (int c = 0; c < maxChars; c++) {
					if (c < maxChars - 4) {
						if (s.charAt(c+1) == ' ') {
							field[r][c] = (int) s.charAt(c);
							c+=1;
						}
						else if (s.charAt(c+2) == ' ') {
							field[r][c] = Integer.parseInt( s.substring(c,c+2) );
							c+=2;
						}
						else if (s.charAt(c+3) == ' ') {
							field[r][c] = Integer.parseInt(s.substring(c,c+3));
							c+=3;
						}
						else if (s.charAt(c+4) == ' ') {
							field[r][c] = Integer.parseInt(s.substring(c,c+4));
							c+=4;
						}
					}
					else {
						//do the thing for the last 4
					}
				}
			}
}
			catch (FileNotFoundException e) {
				System.out.println("oh noo");
			}	
		}

		public String toString() {
			String x = "";
    		for (int i = 0; i < field.length; i++) {
    			for (int j = 0; j < field[i].length; j++) {
    				if (j + 1 == field[i].length) {
    					x = x + field[i][j] + "\n";
    				}
    				else {
    					x = x + field[i][j] + " ";
    				}
    			}
    		}
    		return x;
		}
	}