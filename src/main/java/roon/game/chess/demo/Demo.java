package roon.game.chess.demo;

import roon.game.chess.Command;
import roon.game.chess.board.Board;
import roon.game.chess.board.PieceColor;
import roon.game.chess.pieces.Queen;

public class Demo {
    public static void main(String[] args) {
//        var queen = new Queen(PieceColor.BLACK, 'd', '8');
//        var command = new Command("Qc1");
//        queen.move(command.getFile(), command.getRank());
//        System.out.println(queen.getFile()+" "+queen.getRank());

        var board = new Board();
        board.printBoard();

    }
}
