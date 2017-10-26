package csed18.assignment.one;

public class NaiveHillClimber extends HillClimbing {

	@Override
	boolean isSolved(Board curBoard, int steps) {

		curBoard.printBoardStep(0);

		Board bestNeighBoard;

		for (int i = 0; i < steps; i++) {

			bestNeighBoard = getBestK(getNeighbors(curBoard), 1).get(0);

			if (curBoard.numAttacks <= bestNeighBoard.numAttacks) {
				curBoard.printBoardStep(i + 1);
				return false;
			}

			curBoard = bestNeighBoard;

			if (curBoard.numAttacks == 0) {
				curBoard.printBoardStep(i + 1);
				return true;
			}

		}
		curBoard.printBoardStep(steps);
		return false;
	}

	public static void main(String[] args) {
		final int M = 50, N = 100;
		int count = 0;
		HillClimbing nhc = new NaiveHillClimber();

		for (int i = 0; i < N; i++) {
			Board b = new Board();
			boolean solved = nhc.isSolved(b, M);
			if (solved)
				count++;
			System.out.println("Solved " + solved);
			System.out.println("__________________");
		}

		System.out.println("out of  " + N + " trails " + count
				+ " correct within " + M + " steps with Naive approach");

	}

}
