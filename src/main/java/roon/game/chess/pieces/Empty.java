package roon.game.chess.pieces;

import lombok.Builder;
import roon.game.chess.board.Board;

public class Empty extends AbstractPiece {

    @Builder
    public Empty(char file, char rank) {
        this.file = file;
        this.rank = rank;
        this.symbol = Symbol.E;
        this.score = 0;
    }

    @Override
    public String toString() {
        var ret = this.getClass().getSimpleName();
        return decoratePrint(ret);
    }
}
