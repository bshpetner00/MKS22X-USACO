import java.io.*;
import java.util.*;

public class USACO {
	public static int bronze(String filename) throws FileNotFoundException{
		try {
			File text = new File(filename);
			Scanner inf = new Scanner(text);
			int r = inf.nextInt();
			int c = inf.nextInt();
			int e = inf.nextInt();
			int n = inf.nextInt();
			
			int[][]field = new int[r][c];
			int[][]orders = new int[n][3];
			int[][]moves = {
				{-1,1},
				{0,1},
				{1,1},
				{-1,0},
				{0,0},
				{1,0},
				{-1,-1},
				{0,-1},
				{1,-1}
			};

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					field[i][j] = inf.nextInt();
				}
			}

			for (int k = 0; k < n; k++) {
				orders[k][0] = inf.nextInt();
				orders[k][1] = inf.nextInt();
				orders[k][2] = inf.nextInt();
			}

			

			for (int a = 0; a < orders.length; a++) {
				int arr = orders[a][0];
				int see = orders[a][1];
				int maxElevation = 0;
				for (int[]move: moves) {
					int newArr = arr + move[0];
					int newSee = see + move[1];
					if (newArr >= 0 && newArr < orders.length && newSee >= 0 && newSee <= field[0].length 
						&& field[newArr][newSee] > maxElevation) {
						maxElevation = field[newArr][newSee];
					}
				}
				for (int b = 0; b < orders[a][2] && maxElevation > 0; b++) {
					for (int[]mover : moves) {
						int newArr = arr + mover[0];
						int newSee = see + mover[1];
						if (newArr >= 0 && newArr < orders.length && newSee >= 0 && newSee <= field[0].length 
						&& field[newArr][newSee] > maxElevation) {
							field[newArr][newSee]--;
						}
					}
					maxElevation--;
				}
			}
			int sumbler = 0;
			for (int m = 0; m < field.length; m++) {
				for (int o = 0; o < field[0].length; o++) {
					if (0 < e - field[m][o]) {
						sumbler += e - field[m][o];
					}
				}
			}
			sumbler *= 5184;
			return sumbler;
		}

		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}

		return 0;
	}

	public static int silver(String filename) throws FileNotFoundException{
		try {
			File text = new File(filename);
			Scanner inf = new Scanner(text);
			int Rows = Integer.parseInt(inf.next());
			int Cols = Integer.parseInt(inf.next());
			int Time = Integer.parseInt(inf.next());
			char[][] data = new char[Rows][Cols];
			String line;
			for (int i = 0; i < data.length; i++){
				line = inf.next();
				for (int j = 0; j < data[i].length; j++){
					data[i][j] = line.charAt(j);
				}
			}
			int Fracas = 0;
			int startingRow = Integer.parseInt(inf.next());
			int startingCol = Integer.parseInt(inf.next());
			int endingRow = Integer.parseInt(inf.next());
			int endingCol = Integer.parseInt(inf.next());

			int[][] choices = {
				{1, 0},
				{0, 1},
				{-1, 0},
				{0, -1},
			};

			int[][] paths = new int[Rows][Cols];
			int[][] temp = new int[Rows][Cols];

			for (int[] row : choices){
				int newRow = startingRow + row[0];
				int newCol = startingCol + row[1];
				if (newRow >= 0 && newRow < Rows && newCol >= 0 && newCol < Cols &&  data[newRow][newCol] != '*'){
					paths[newRow][newCol] = 1;
					temp[newRow][newCol] = 1;
				}
			}

			while (Time > 0) {
				for (int r = 0; r < Rows; r++){
					for (int c = 0; c < Cols; c++){
						int sum = 0;
						for (int[] row : choices){
							int newRow = r + row[0];
							int newCol = c + row[1];
							if (newRow >= 0 && newRow < Rows && newCol >= 0 && newCol < Cols &&  data[newRow][newCol] != '*'){
								sum = sum + paths[newRow][newCol];
							}
						}
						if (data[r][c] != '*'){
							temp[r][c] = sum;
						}
					}
				}
				for (int r = 0; r < Rows; r++){
					for (int c = 0; c < Cols; c++){
						paths[r][c] = temp[r][c];
					}
				}
				Time--;
			}

			return paths[endingRow][endingCol];
		}catch (FileNotFoundException e){
			System.out.println("file not valid");
			return -1;
		}

	}

	public static void main(String[] args) throws FileNotFoundException{
		try {  
			System.out.println(""+bronze("field.dat"));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}
}