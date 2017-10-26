package csed18.assignment.one;

public class RandomRestartHillClimber extends HillClimbing {

	private int restarts = 5;

	public RandomRestartHillClimber(int res) {
		restarts = res;
	}

	@Override
	boolean isSolved(Board curBoard, int steps) {

		for (int i = 0; i < restarts; i++) {
			Board randomBoard = new Board();
			randomBoard.printBoardStep(0);
			if (solved(randomBoard, steps))
				return true;
		}

		return false;
	}

	private boolean solved(Board curBoard, int steps) {

		Board bestNeighBoard;

		for (int i = 0; i < steps; i++) {

			bestNeighBoard = getBestK(getNeighbors(curBoard), 1).get(0);

			if (curBoard.numAttacks <= bestNeighBoard.numAttacks) {
				return false;
			}

			curBoard = bestNeighBoard;

			if (curBoard.numAttacks == 0) {
				curBoard.printBoardStep(i + 1);
				return true;
			}

		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int M = 50, N = 100;
		int count = 0;
		int restarts = 5;
		HillClimbing rrhc = new RandomRestartHillClimber(restarts);

		for (int i = 0; i < N; i++) {
			boolean solved = rrhc.isSolved(null, M);
			if (solved)
				count++;
			System.out.println("Solved " + solved);
			System.out.println("__________________");
		}

		System.out.println("out of  " + N + " trails " + count
				+ " correct within " + M + " steps with " + restarts
				+ " restarts");

	}

}
