package csed18.assignment.one;

import java.util.ArrayList;

public class KMeanHillClimber extends HillClimbing {

	private int K = 10; // default beams

	public KMeanHillClimber(int kbeams) {
		K = kbeams;
	}

	@Override
	boolean isSolved(Board board, int steps) {
		ArrayList<Board> curKBoards = getRandomKBoards();
		ArrayList<Board> allNeighbors;
		for (int i = 0; i < steps; i++) {

			allNeighbors = new ArrayList<Board>();

			for (int beam = 0; beam < K; beam++) {
				// adding all 56 * k neighbors
				allNeighbors.addAll(getNeighbors(curKBoards.get(beam)));
			}

			allNeighbors = getBestK(allNeighbors, K);

			if (allNeighbors.get(0).numAttacks > curKBoards.get(0).numAttacks) {

				return false;
			}

			curKBoards = allNeighbors;
			curKBoards.get(0).printBoardStep(i + 1);
			if (curKBoards.get(0).numAttacks == 0)
				return true;

		}
		return false;
	}

	private ArrayList<Board> getRandomKBoards() {
		ArrayList<Board> initialBeams = new ArrayList<Board>();

		for (int i = 0; i < K; i++) {
			initialBeams.add(new Board());
		}
		return initialBeams;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int M = 50, N = 100;
		int count = 0;
		int k = 10;
		HillClimbing kmhc = new KMeanHillClimber(k);

		for (int i = 0; i < N; i++) {

			boolean solved = kmhc.isSolved(null, M);
			if (solved)
				count++;
			System.out.println("Solved " + solved);
			System.out.println("__________________");
		}

		System.out.println("out of  " + N + " trails " + count
				+ " correct within " + M + " steps with " + k + " beam(s)");

	}

}
