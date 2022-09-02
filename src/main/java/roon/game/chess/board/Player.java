package roon.game.chess.board;

import lombok.Getter;
import roon.game.chess.pieces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class Player {
    private List<String> history; // 기보
    private PieceColor pieceColor;

    private int totalScore;
    private List<AbstractPiece> pieces;

    public Player(PieceColor pieceColor) {
        this.pieceColor = pieceColor;

        if (this.pieceColor.equals(PieceColor.WHITE)) {
            this.pieces = initialWhitePieces();
        } else if (this.pieceColor.equals(PieceColor.BLACK)) {
            this.pieces = initialBlackPieces();
        }

        this.totalScore = 1 * 8 + 3 * 4 + 5 * 2 + 9;
    }

    private List<AbstractPiece> initialWhitePieces() {
        var pieces = Arrays.asList(
                King.builder().file('E').rank('1').pieceColor(PieceColor.WHITE).build(),
                Queen.builder().file('D').rank('1').pieceColor(PieceColor.WHITE).build(),
                Bishop.builder().file('C').rank('1').pieceColor(PieceColor.WHITE).build(),
                Bishop.builder().file('F').rank('1').pieceColor(PieceColor.WHITE).build(),
                Knight.builder().file('B').rank('1').pieceColor(PieceColor.WHITE).build(),
                Knight.builder().file('G').rank('1').pieceColor(PieceColor.WHITE).build(),
                Rook.builder().file('A').rank('1').pieceColor(PieceColor.WHITE).build(),
                Rook.builder().file('H').rank('1').pieceColor(PieceColor.WHITE).build(),

                Pawn.builder().file('E').rank('2').pieceColor(PieceColor.WHITE).build(),
                Pawn.builder().file('D').rank('2').pieceColor(PieceColor.WHITE).build(),
                Pawn.builder().file('C').rank('2').pieceColor(PieceColor.WHITE).build(),
                Pawn.builder().file('F').rank('2').pieceColor(PieceColor.WHITE).build(),
                Pawn.builder().file('B').rank('2').pieceColor(PieceColor.WHITE).build(),
                Pawn.builder().file('G').rank('2').pieceColor(PieceColor.WHITE).build(),
                Pawn.builder().file('A').rank('2').pieceColor(PieceColor.WHITE).build(),
                Pawn.builder().file('H').rank('2').pieceColor(PieceColor.WHITE).build()
        );

        return new ArrayList<>(pieces);

    }


    private List<AbstractPiece> initialBlackPieces() {
        var pieces = Arrays.asList(
                King.builder().file('E').rank('8').pieceColor(PieceColor.WHITE).build(),
                Queen.builder().file('D').rank('8').pieceColor(PieceColor.WHITE).build(),
                Bishop.builder().file('C').rank('8').pieceColor(PieceColor.WHITE).build(),
                Bishop.builder().file('F').rank('8').pieceColor(PieceColor.WHITE).build(),
                Knight.builder().file('B').rank('8').pieceColor(PieceColor.WHITE).build(),
                Knight.builder().file('G').rank('8').pieceColor(PieceColor.WHITE).build(),
                Rook.builder().file('A').rank('8').pieceColor(PieceColor.WHITE).build(),
                Rook.builder().file('H').rank('8').pieceColor(PieceColor.WHITE).build(),

                Pawn.builder().file('E').rank('7').pieceColor(PieceColor.WHITE).build(),
                Pawn.builder().file('D').rank('7').pieceColor(PieceColor.WHITE).build(),
                Pawn.builder().file('C').rank('7').pieceColor(PieceColor.WHITE).build(),
                Pawn.builder().file('F').rank('7').pieceColor(PieceColor.WHITE).build(),
                Pawn.builder().file('B').rank('7').pieceColor(PieceColor.WHITE).build(),
                Pawn.builder().file('G').rank('7').pieceColor(PieceColor.WHITE).build(),
                Pawn.builder().file('A').rank('7').pieceColor(PieceColor.WHITE).build(),
                Pawn.builder().file('H').rank('7').pieceColor(PieceColor.WHITE).build()
        );

        return new ArrayList<>(pieces);

    }


}
