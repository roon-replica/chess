package roon.game.chess.pieces;

import lombok.Builder;
import roon.game.chess.board.PieceColor;

public class King extends AbstractPiece{

    @Builder
    public King(PieceColor pieceColor, char file, char rank) {
        this.pieceColor = pieceColor;
        this.file = file;
        this.rank = rank;
        this.symbol = Symbol.K;
        this.score = 0; // king은 점수가 따로 없어서..
    }

    @Override
    public String toString(){
        var ret = this.getClass().getSimpleName()+" "+file+rank;
        return decoratePrint(ret);
    }
}
