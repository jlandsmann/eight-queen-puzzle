package de.jlandsmann.eightQueenPuzzle;

public class ChessBoard {

    private final int size;
    private final Integer[] board;

    public ChessBoard(int boardSize) {
        this.size = boardSize;
        this.board = new Integer[boardSize];
    }

    public int getSize() {
        return this.size;
    }

    public boolean hasQueen(int x, int y) {
        return this.board[x] == y;
    }

    public boolean canSetQueen(int x, int y) {
        for (int i = 0; i < this.size; i++) {
            if (this.board[i] == null) {
                continue;
            }

            if (this.board[i] == y) {
                return false;
            }
            int diff = x - i;
            int forbiddenYBelow = y - diff;
            int forbiddenYAbove = y + diff;
            if (this.board[i] == forbiddenYBelow || this.board[i] == forbiddenYAbove) {
                return false;
            }
        }
        return true;
    }

    public void setQueen(int x, int y) {
        this.board[x] = y;
    }

    public void removeQueen(int x) {
        this.board[x] = null;
    }

    public void print() {
        String format = "| %s ";
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                String queen = this.hasQueen(x, y) ? "Q" : " ";
                System.out.printf(format, queen);
            }
            System.out.print("|\n");
        }

    }
}
