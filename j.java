import java.util.Scanner;

public class j {

	static int[] dx = {2,-2,0,0,-2,2};
	static int[] dy = {0,0,-2,2,-2,2};

	static int[][] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		board = new int[5][];
		for (int i =0; i < 5; i++) {
			board[i] = new int[i+1];
		}
		for (int i = 0; i < 5; i++) {
			for (int j =0; j < board[i].length; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		//ein li havera
		//kms
		// _____
		//   |
		//   |
		//   0
		//  /|\
		//   |
		//  / \
		System.out.println(rec(14, true));
	}

	public static long rec(int pegs, boolean jm) {
		if (pegs == 1) return 0;
		long best = Long.MIN_VALUE;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < board[i].length; j++) {

				for (int t =0 ; t < dx.length; t++) {
					int ni = i + dx[t];
					int nj = j + dy[t];

					if (ni >= 0 && ni < 5 && nj >=0 && nj < board[ni].length) {
						if (board[i][j] != 0 && board[ni][nj] == 0 && board[i+dx[t]/2][j+dy[t]/2] != 0) {
							int tempog= board[i][j];
							int tempremed = board[i+dx[t]/2][j+dy[t]/2];
							board[i][j] = 0;
							board[i+dx[t]/2][j+dy[t]/2] = 0;
							board[ni][nj] = tempog;

							if (best == Long.MIN_VALUE) {
								if (jm) {
									best = tempog*tempremed + rec(pegs-1, !jm);
								}else {
									best = -1*tempog*tempremed + rec(pegs-1, !jm);
								}
							}else {
								if (jm)
									best = Math.max(best, tempog*tempremed + rec(pegs-1, !jm));
								else
									best = Math.min(best, -1*tempog*tempremed + rec(pegs-1, !jm));
							}

							board[i][j] = tempog;
							board[i+dx[t]/2][j+dy[t]/2] = tempremed;
							board[ni][nj] = 0;
						}
					}
				}

			}
		}
		if (best == Long.MIN_VALUE) {
			best = 0;
		}
		return best;
	}

}

/*

3
1 6
1 7 8
5 0 3 4
9 3 2 1 9

1
2 3
4 5 6
7 8 9 10
11 12 0 13 14

100
1 17
99 3 4
0 76 33 42
12 13 14 15 16

 */