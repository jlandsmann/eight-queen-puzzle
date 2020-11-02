package de.jlandsmann.eightQueenPuzzle;

public class PuzzleSolver {

    private final ChessBoard board;

    public PuzzleSolver(int boardSize) {
        this.board = new ChessBoard(boardSize);
    }

    public void solve() {
        this.solveFromColumn();
    }

    private void solveFromColumn() {
        try {
            this.solveFromColumn(0);
            this.board.print();
        } catch (IllegalStateException e) {
            System.out.println("Es konnte keine Position gefunden werden");
        }
    }

    private void solveFromColumn(int x) {
        for (int y = 0; y < this.board.getSize(); y++) {
            if (this.board.canSetQueen(x, y)) {
                this.board.setQueen(x, y);
                if ((x + 1) < this.board.getSize()) {
                    try {
                        this.solveFromColumn(x + 1);
                        return;
                    } catch (IllegalStateException e) {
                        this.board.removeQueen(x);
                    }
                } else {
                    return;
                }
            }
        }

        throw new IllegalStateException();
    }
}
