package ShirleyYoung;

import java.util.*;

public class SnakeNLadder {
	public static int roles(Struct[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0
				|| board.length != board[0].length)
			return 0;
		int n = board.length;
		int[] roles = new int[n * n];
		for (int i = 0; i < n * n; i++) {
			int x = i / n;
			int y = (x % 2 != 0) ? (n - 1 - i % n) : i % n;
			System.out.println("..i.."+ i);
			System.out.println("(X, Y) ("+x+", "+y+")");
			if (i < 6) {
				System.out.println("i<6......i="+i);
				roles[i] = board[x][y].s.equals("SU") ? Integer.MAX_VALUE / 2
						: 1;
				System.out.println("i<6 END... SU..+ roles "); printRoles(roles);
			} else {
				roles[i] = Integer.MAX_VALUE;
				System.out.println("i>6");
				System.out.println("..for loop.....i="+i +"..j.."+ (i-6));
				for (int j = i - 6; j < i; j++) {
					System.out.println("..i.."+i+"..j.."+j +"Min of roles["+i+"] "+roles[i]+ "..roles["+j+"]+1 "+roles[j]);
					roles[i] = Math.min(roles[i], roles[j] + 1);
				}
				if (board[x][y].s.equals("LU"))
					// in case the lower end of the ladder is the upper end of
					// the
					// snake
					roles[i] = Math.min(ladder(board, x, y, roles), roles[i]);
				else if (board[x][y].s.equals("SU"))
					roles[i] = Integer.MAX_VALUE / 2;
			}
		}

		return roles[n * n - 1];
	}
	
	public static void printRoles(int[] roles){
		System.out.println("{");
		for(int i: roles){
			System.out.print(" "+ i);
		}
		System.out.println("}");
	}

	private static int ladder(Struct[][] board, int x, int y, int[] roles) {
		int n = board.length;
		int xc = board[x][y].x;
		return xc % 2 != 0 ? roles[xc * n + (n - 1 - board[x][y].y)] : roles[xc
				* n + board[x][y].y];
	}

	/**
	 * consists the string which represents the status of the square: "SU":
	 * snake upper side "SL": snake lower side "LU": ladder upper side "LL":
	 * ladder lower side as well as the coordinates of its corresponding end
	 * e.g., "SU", 1, 1 indicates the lower side of the snake is at x = 1, y = 1
	 * 
	 * @author shirleyyoung
	 * 
	 */
	private static class Struct {
		String s;
		// the coordinate of the corresponding square
		int x;
		int y;

		public Struct(String s, int x, int y) {
			this.s = s;
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Struct[][] board = new Struct[4][4];
		for (int i = 0; i < 4; i++)
			// indicate nothing in the square
			Arrays.fill(board[i], new Struct("", -1, -1));
		board[0][1] = new Struct("SL", 1, 2);
		board[1][2] = new Struct("SU", 0, 1);
		board[0][3] = new Struct("LL", 2, 3);
		board[2][3] = new Struct("LU", 0, 3);
		board[1][1] = new Struct("SL", 3, 2);
		board[3][2] = new Struct("SU", 1, 1);
		board[1][0] = new Struct("LL", 2, 0);
		board[2][0] = new Struct("LU", 1, 0);
		System.out.println(roles(board));
	}
}