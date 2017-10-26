package csed18.assignment.one;

import java.util.ArrayList;

public abstract class HillClimbing {

	public final int MAX = 8;

	abstract boolean isSolved(Board board, int steps);

	public ArrayList<Board> getNeighbors(Board mainboard) {
		ArrayList<Board> all = new ArrayList<Board>();

		// for all queens
		for (int queen = 0; queen < MAX; queen++) {
			for (int i = 0; i < MAX; i++) {
				Board b = new Board(mainboard);
				if (i == mainboard.state[queen])
					continue;
				b.state[queen] = i;
				b.calculateAttacks();
				all.add(b);
			}
		}
		return all;
	}

	public ArrayList<Board> getBestK(ArrayList<Board> all, int k) {
		ArrayList<Board> best = new ArrayList<Board>();
		int minAttacks = Integer.MAX_VALUE;
		Board bestBoard = null;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < all.size(); j++) {
				if (all.get(j).numAttacks < minAttacks) {
					minAttacks = all.get(j).numAttacks;
					bestBoard = all.get(j);
				}
			}

			best.add(bestBoard);

			all.remove(bestBoard);

			minAttacks = Integer.MAX_VALUE;

			bestBoard = null;

		}

		return best;
	}
}
