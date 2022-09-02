package roon.game.chess.pieces;

import lombok.Builder;
import lombok.Getter;
import roon.game.chess.board.PieceColor;

@Getter
public class Queen extends AbstractPiece {

    @Builder
    public Queen(PieceColor pieceColor, char file, char rank) {
        this.pieceColor = pieceColor;
        this.file = file;
        this.rank = rank;
        this.symbol = Symbol.Q;
        this.score = 9;
    }

    @Override
    public String toString(){
        var ret = this.getClass().getSimpleName()+" "+file+rank;
        return decoratePrint(ret);
    }
}
