package com.hackerRank.pacman;
import java.io.*;
import java.util.*;
class Node {
	public int[] position;
	public String direction;
	public String encode;

	Node(String direction, int[] position) {
		this.position = position;
		this.direction = direction;
		int rowPos = position[0];
		int colPos = position[1];
		encode = direction + ":" + rowPos + ":" + colPos;
	}

	public String getEncode() {
		return encode;
	}

	public int[] getPosition() {
		return position;
	}

	public String getDirection() {
		return direction;
	}
	public static Node decode(String str) {
		String[] strs = str.split(":");
		if (strs.length == 3) {
			int[] position = { Integer.parseInt(strs[1]), Integer.parseInt(strs[2]) };
			return new Node(strs[0], position);
		}
		return null;
	}

}
public class Pacman1 {

	static char[][] grid;
	static int[] pacman = new int[2];
	static int[] food = new int[2];
	static Stack<String> stack = new Stack<String>();
	private static Scanner scanner = new Scanner(System.in);
	static String[] dirPriority = new String[4];

	

	public static void main(String[] args) {

		scanProcess();
		setDirPriority();
		 String previousDirection = "";
		print(pacman);
		while(!isFoodPosition(pacman)) {
			addValidNodeForNextStep(pacman,previousDirection);
			Node node = Node.decode(stack.pop());
			pacman = node.getPosition();
			previousDirection = node.getDirection();
			print(pacman);
		}
		
	}

	private static void scanProcess() {
		
		// row
		pacman[0] = scanner.nextInt();
		// col
		pacman[1] = scanner.nextInt();
		food[0] = scanner.nextInt();
		food[1] = scanner.nextInt();
		
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		scanner.nextLine();
		grid = new char[row][col];
		for (int i = 0; i < row; i++) {
			String str = scanner.nextLine();
			for (int j = 0; j < col; j++) {
				grid[i][j] = str.charAt(j);
			}
		}
	}
	private static void setDirPriority() {
		int[] dif = new int[2];
		dif[0] = food[0] - pacman[0];
		dif[1] = food[0] - pacman[1];
		if (dif[0] >= 0) {
			dirPriority[0] = "down";
			dirPriority[1] = "up";
		} else {
			dirPriority[0] = "up";
			dirPriority[1] = "down";
		}
		if (dif[1] >= 0) {
			dirPriority[2] = "right";
			dirPriority[3] = "left";
		} else {
			dirPriority[2] = "left";
			dirPriority[3] = "right";
		}
	}
	private static boolean isFoodPosition(int[] position) {
		return (food[0] == position[0] && food[1] == position[1]);

	}

	private static void addValidNodeForNextStep(int[] position, String previousDirection) {
		for (String dir : dirPriority) {
			if (!dir.equalsIgnoreCase(getReverseDirection(previousDirection)) && checkNextValidNode(position, dir)) {
				pushNodeToStack(new Node(dir, goOneStep(dir, position)));
			}
		}

	}

	private static boolean pushNodeToStack(Node node) {
		String encode = node.getEncode();
		if (stack.contains(encode)) {
			return false;
		} else {
			stack.push(encode);
			return true;
		}
	}

	private static String getReverseDirection(String direction) {
		String result = "";
		switch (direction) {
		case "up":
			result = "down";
			break;
		case "down":
			result = "up";
			break;
		case "left":
			result = "right";
			break;
		case "right":
			result = "left";
			break;
		}
		return result;
	}

	private static boolean checkNextValidNode(int[] position, String direction) {
		int[] nextPos = goOneStep(direction, position);
		if (grid[nextPos[0]][nextPos[1]] == '-'|| grid[nextPos[0]][nextPos[1]] == '.') {
			return true;
		} else {
			return false;
		}

	}

	private static int[] goOneStep(String direction, int[] position) {
		int[] result = new int[2];
		switch (direction) {
		case "up":
			result = up(position);
			break;
		case "down":
			result = down(position);
			break;
		case "left":
			result = left(position);
			break;
		case "right":
			result = right(position);
			break;
		}
		return result;
	}

	private static int[] up(int[] position) {
		int[] result = { position[0] - 1, position[1] };
		return result;
	}

	private static int[] down(int[] position) {
		int[] result = { position[0] + 1, position[1] };
		return result;
	}

	private static int[] left(int[] position) {
		int[] result = { position[0], position[1] - 1 };
		return result;
	}

	private static int[] right(int[] position) {
		int[] result = { position[0], position[1] + 1 };
		return result;
	}

	private static void print(int[] position) {
		System.out.printf("%d %d", position[0], position[1]);
		System.out.println();
	}

}
