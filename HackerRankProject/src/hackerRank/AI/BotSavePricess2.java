package hackerRank.AI;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BotSavePricess2 {

static void nextMove(int n, int r, int c, String [] grid){
    int[] botPos = new int[2];
    int[] princessPos = new int[2];
    botPos[0] = r;
    botPos[1] = c;
    for (int i=0; i<n;i++) {
            String str = grid[i];
            char s;
            for (int j=0; j<n;j++) {
                s = str.charAt(j);
                if (s == 'p') {
                    princessPos[0] = i;
                    princessPos[1] = j;
                }
            }
    }
    int[] dis = new int[2];
        dis[0] = princessPos[0]-botPos[0];
        dis[1] = princessPos[1]-botPos[1];
    boolean flag = false;
    if (!flag && dis[1]>0) {
            for (int right = 0; right < dis[1]; right ++) {
                System.out.println("RIGHT");
                flag = true;
                break;
            }
        } else {
            for (int left = 0; left < Math.abs(dis[1]); left ++) {
                System.out.println("LEFT");
                flag = true;
                break;
            }
        }
    if (!flag && dis[0]>0) {
            for (int down = 0; down < dis[0]; down ++) {
                System.out.println("DOWN");
                flag = true;
                break;
            }
        } else if (!flag){
            for (int up = 0; up < Math.abs(dis[0]); up ++) {
                System.out.println("UP");
                flag = true;
                break;
            }
        }
  }

public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,r,c;
        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        in.useDelimiter("\n");
        String grid[] = new String[n];


        for(int i = 0; i < n; i++) {
            grid[i] = in.next();
        }

    nextMove(n,r,c,grid);
    }
}