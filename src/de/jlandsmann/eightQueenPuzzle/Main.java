package de.jlandsmann.eightQueenPuzzle;

public class Main {

    public static void main(String[] args) {
        int n = 16;
	    PuzzleSolver solver = new PuzzleSolver(n);
	    solver.solve();
    }
}
