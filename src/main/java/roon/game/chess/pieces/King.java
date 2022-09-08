package roon.game.chess.pieces;

import lombok.Builder;
import roon.game.chess.board.Board;
import roon.game.chess.board.PieceColor;

public class King extends AbstractPiece{

    private static int[][] canMoves = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};

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
        var ret = pieceColor.name() +" "+ this.symbol.name();
        return decoratePrint(ret);
    }

    @Override
    public void move(char nextFile, char nextRank, Board board) {
        boolean canmove = this.validate(nextFile, nextRank, board); //todo:  this필요?
        if(canmove == false){
            System.out.println("can not move");
            return;
        }

        this.file = nextFile;
        this.rank = nextRank;
    }

    @Override
    protected boolean validate(char nextFile, char nextRank, Board board) {
        if (board.isEmpty(nextFile, nextRank) == false) {
            return false;
        }

        for(var canMove : canMoves){
            char file = (char)(this.file + canMove[0]);
            char rank = (char)(this.rank + canMove[1]);

            if(file == nextFile && rank == nextRank){
                return true;
            }
        }

        return false;

    }
}
