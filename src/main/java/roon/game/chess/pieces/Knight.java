package roon.game.chess.pieces;

import lombok.Builder;
import roon.game.chess.board.PieceColor;

public class Knight extends AbstractPiece{

    @Builder
    public Knight(PieceColor pieceColor, char file, char rank) {
        this.pieceColor = pieceColor;
        this.file = file;
        this.rank = rank;
        this.symbol = Symbol.N;
        this.score = 3;
    }

    @Override
    public String toString(){
        var ret = pieceColor.name() +" "+ this.symbol.name();
        return decoratePrint(ret);
    }
}
