package roon.game.chess.pieces;

import lombok.Getter;
import lombok.ToString;
import roon.game.chess.board.Board;
import roon.game.chess.board.PieceColor;

@Getter
public abstract class AbstractPiece {
    PieceColor pieceColor;
    char file;    // 세로 (a,b,c,d,e,f,g,h)
    char rank;    // 가로 (1,2,3,4,5,6,7,8)
    Symbol symbol;  // K, Q, B, N, R, 폰은 없음..?

    int score;  // 기물 점수

    public void move(char file, char rank, Board board) {
        //validate(file, rank, board);
        boolean canmove = this.validate(file, rank, board);

        if(canmove == false){
            System.out.println("can not move");
            return;
        }

        this.file = file;
        this.rank = rank;
    }

    protected String decoratePrint(String str) {
        return "(" + str + ")";
    }

    protected boolean validate(char file, char rank, Board board) {
        return board.isEmpty(file, rank);
    }
}
