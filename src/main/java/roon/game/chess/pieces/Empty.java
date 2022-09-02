package roon.game.chess.pieces;

import lombok.Builder;

public class Empty extends AbstractPiece {

    @Builder
    public Empty(char file, char rank) {
        this.file = file;
        this.rank = rank;
        this.score = 0;
    }

    @Override
    public String toString() {
        var ret = this.getClass().getSimpleName()+" "+file+rank;
        return decoratePrint(ret);
    }
}
