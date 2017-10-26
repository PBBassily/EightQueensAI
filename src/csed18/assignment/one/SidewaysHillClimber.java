package csed18.assignment.one;

public class SidewaysHillClimber extends HillClimbing {

	private int sideWaysTolerance = 5;

	public SidewaysHillClimber(int num) {

		sideWaysTolerance = num;
	}

	@Override
	boolean isSolved(Board curBoard, int steps) {

		curBoard.printBoardStep(0);

		Board bestNeighBoard;

		int sidewayWidth = 0;
		for (int i = 0; i < steps; i++) {

			bestNeighBoard = getBestK(getNeighbors(curBoard), 1).get(0);

			if (curBoard.numAttacks < bestNeighBoard.numAttacks) {
				curBoard.printBoardStep(i + 1);
				return false;
			}

			if (curBoard.numAttacks == bestNeighBoard.numAttacks) {
				if (sidewayWidth == sideWaysTolerance)
					return false;

				sidewayWidth++;

			} else {
				sidewayWidth = 0;
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
		int sidwaysTolerance = 5;
		HillClimbing swhc = new SidewaysHillClimber(sidwaysTolerance);

		for (int i = 0; i < N; i++) {
			Board b = new Board();
			boolean solved = swhc.isSolved(b, M);
			if (solved)
				count++;
			System.out.println("Solved " + solved);
			System.out.println("__________________");
		}

		System.out.println("out of  " + N + " trails " + count
				+ " correct within " + M + " steps with " + sidwaysTolerance
				+ " sidways tolerance ");

	}

}
