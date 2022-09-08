package roon.game.chess.board;

import roon.game.chess.pieces.AbstractPiece;
import roon.game.chess.pieces.Empty;
import roon.game.chess.pieces.Symbol;

public class Board {
    private final char FILE_MAX = 'h';
    private final char FILE_MIN = 'a';

    private final char RANK_MAX = '8';
    private final char RANK_MIN = '1';

    private final int SIZE = 8;

    private final AbstractPiece[][] board;

    private Player whitePlayer;
    private Player blackPlayer;

    public Board(Player whitePlayer, Player blackPlayer) {
        board = new AbstractPiece[SIZE][SIZE];

        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
    }

    private void writeBoard() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                board[r][c] = Empty.builder()
                        .file((char) ('A' + r))
                        .rank((char) ('1' + c))
                        .build();
            }
        }

        for (var piece : whitePlayer.getPieces()) {
            var file = piece.getFile();
            var rank = piece.getRank();
            board[rank - '1'][file - 'A'] = piece;
        }

        for (var piece : blackPlayer.getPieces()) {
            var file = piece.getFile();
            var rank = piece.getRank();
            board[rank - '1'][file - 'A'] = piece;
        }
    }

    public void printBoard() {
        writeBoard();
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    public boolean isEmpty(char file, char rank) {
        var toMove = board[rank - '1'][file - 'A'];
        return toMove.getSymbol().equals(Symbol.E);
    }

    public AbstractPiece getPiece(char file, char rank) {
        return board[rank - '1'][file - 'A'];
    }

    public void update(char prevFile, char prevRank, char nextFile, char nextRank) {
        var prev = board[prevRank - '1'][prevFile - 'A'];
//        var next = board[nextRank - '1'][nextFile - 'A'];

        board[nextRank - '1'][nextFile - 'A'] = prev;
        board[prevRank - '1'][prevFile - 'A'] = Empty.builder().file(prevFile).rank(prevRank).build();
    }

}
