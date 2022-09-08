package roon.game.chess.pieces;

import lombok.Builder;
import roon.game.chess.board.Board;
import roon.game.chess.board.PieceColor;

public class Bishop extends AbstractPiece {

    @Builder
    public Bishop(PieceColor pieceColor, char file, char rank) {
        this.pieceColor = pieceColor;
        this.file = file;
        this.rank = rank;
        this.symbol = Symbol.B;
        this.score = 3;
    }

    @Override
    public String toString() {
        var ret = pieceColor.name() + " " + this.symbol.name();
        return decoratePrint(ret);
    }

    @Override
    public void move(char prevFile, char prevRank, char nextFile, char nextRank, Board board) {
        boolean canmove = this.validate(prevFile, prevRank, nextFile, nextRank, board);
        if (canmove == false) {
            System.out.println("can not move");
            return;
        }

        this.file = nextFile;
        this.rank = nextRank;
    }

    @Override
    protected boolean validate(char prevFile, char prevRank, char nextFile, char nextRank, Board board) {
        if (board.isEmpty(prevFile, prevRank) || board.isEmpty(nextFile, nextRank) == false) {
            return false;
        }

        for (int add = -8; add <= 8; add++) {
            char file = (char) (this.file + add);
            char rank = (char) (this.rank + add);

            if (file == nextFile && rank == nextRank) {
                return true;
            }
        }

        for (int rankAdd = 8, fileAdd = -8; fileAdd <= 8; rankAdd--, fileAdd++) {
            char file = (char) (this.file + fileAdd);
            char rank = (char) (this.rank + rankAdd);

            if (file == nextFile && rank == nextRank) {
                return true;
            }
        }

        return false;

    }
}
