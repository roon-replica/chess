package roon.game.chess.exception;

public class InvalidCommandException extends RuntimeException{
    private String msg;

    public InvalidCommandException(String msg){
        this.msg = msg;
    }
}
