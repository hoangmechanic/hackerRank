package hackerRank.AI;

import java.io.*;
import java.util.*;

public class BotSavePrincess {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		//Get size of grid
		int n = scanner.nextInt();
		scanner.nextLine();
		int[] botPos = new int[2];
		int[] princessPos = new int[2];
		String str ;
		for (int i =0; i<n;i++) {
			str = scanner.nextLine();
			char s;
			for (int j=0; j<n;j++) {
				s = str.charAt(j);
				if (s == 'm') {
					botPos[0] = i;
					botPos[1] = j;
				} else if (s == 'p') {
					princessPos[0] = i;
					princessPos[1] = j;
				}
			}
		}

		// Recurse princess
		int[] dis = new int[2];
		dis[0] = princessPos[0]-botPos[0];
		dis[1] = princessPos[1]-botPos[1];

		if (dis[0]>0) {
			for (int down = 0; down < dis[0]; down ++) {
				System.out.println("DOWN");
			}
		} else {
			for (int up = 0; up < Math.abs(dis[0]); up ++) {
				System.out.println("UP");
			}
		}
		if (dis[1]>0) {
			for (int right = 0; right < dis[1]; right ++) {
				System.out.println("RIGHT");
			}
		} else {
			for (int left = 0; left < Math.abs(dis[1]); left ++) {
				System.out.println("LEFT");
			}
		}
	}

}
