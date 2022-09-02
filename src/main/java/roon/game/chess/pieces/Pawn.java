package roon.game.chess.pieces;

import lombok.Builder;
import roon.game.chess.board.PieceColor;

public class Pawn extends AbstractPiece{

    @Builder
    public Pawn(PieceColor pieceColor, char file, char rank) {
        this.pieceColor = pieceColor;
        this.file = file;
        this.rank = rank;
        this.symbol = Symbol.P;
        this.score = 1;
    }

    @Override
    public String toString(){
        var ret = pieceColor.name() +" "+ this.symbol.name();
        return decoratePrint(ret);
    }
}
