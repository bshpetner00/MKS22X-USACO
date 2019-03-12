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

	public static void silver(String filename) {
		 
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