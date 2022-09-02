package roon.game.chess.pieces;

public enum Symbol {
    K("King"), Q("Queen"), B("Bishop"), N("Knight"), R("Rook"),
    P("Pawn");  // 실제로 pawn은 기호에 없지만 일단 만들어 놓음

    private final String fullName;

    Symbol(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName(){
        return fullName;
    }
}
