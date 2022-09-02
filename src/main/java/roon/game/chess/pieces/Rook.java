package roon.game.chess.pieces;

import lombok.Builder;
import lombok.Getter;
import roon.game.chess.board.PieceColor;

@Getter
public class Rook extends AbstractPiece{

    @Builder
    public Rook(PieceColor pieceColor, char file, char rank) {
        this.pieceColor = pieceColor;
        this.file = file;
        this.rank = rank;
        this.symbol = Symbol.R;
        this.score = 5;
    }

    @Override
    public String toString(){
        var ret = pieceColor.name() +" "+ this.symbol.name();
        return decoratePrint(ret);
    }
}
