package roon.game.chess.demo;

import roon.game.chess.Command;
import roon.game.chess.board.Board;
import roon.game.chess.board.PieceColor;
import roon.game.chess.board.Player;
import roon.game.chess.pieces.Queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) throws IOException {
//        var queen = new Queen(PieceColor.BLACK, 'd', '8');
//        var command = new Command("Qc1");
//        queen.move(command.getFile(), command.getRank());
//        System.out.println(queen.getFile()+" "+queen.getRank());

        var whitePlayer = new Player(PieceColor.WHITE);
        var blackPlayer = new Player(PieceColor.BLACK);

        var board = new Board(whitePlayer, blackPlayer);
        board.printBoard();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int sequence = 0; ; sequence++) {
            System.out.println("type command. format: {prev file}{prev rank}{next file}{next rank}");
            System.out.println("type 'quit' if you want to quit");

            String rawCommand = reader.readLine();

            if (rawCommand.equals("quit")) {
                break;
            }

            try{
                var command = new Command(rawCommand);

                if (sequence % 2 == 0) {
                    whitePlayer.move(command, board);
                } else {
                    blackPlayer.move(command, board);
                }

            }catch (Exception e){
                e.printStackTrace();
            }


            board.printBoard();
        }


    }
}
