package csed18.assignment.one;

import java.util.Random;

public class Board {
	private final int MAX = 8;
	public int[] state = new int[8];
	public int numAttacks = -1;

	public Board() {
		randomize();
		calculateAttacks();
	}

	public Board(Board parent) {
		this.state = parent.state.clone();
		calculateAttacks();
	}

	public void calculateAttacks() {
		int h = 0;
		for (int i = 0; i < MAX; i++) {
			for (int j = i + 1; j < MAX; j++) {
				if (state[i] == state[j])
					h++;
				else if (Math.abs(state[i] - state[j]) == (j - i))
					h++;
			}
		}
		numAttacks = h;
	}

	private void randomize() {
		Random random = new Random();
		for (int i = 0; i < MAX; i++) {
			state[i] = random.nextInt(8);
		}
	}

	public void printBoardStep(int stepNumber) {
		System.out.print(stepNumber + ") ");
		for (int i : state)
			System.out.print(i + " ");

		System.out.println("attacks : " + numAttacks);
	}

}
