package roon.game.chess;

import lombok.Getter;
import roon.game.chess.exception.InvalidCommandException;
import roon.game.chess.pieces.Symbol;

import java.util.Arrays;

@Getter
public class Command {
    private String rawCommand;

    private char file;
    private char rank;

    public Command(String rawCommand) {
        validate(rawCommand);

        this.rawCommand = rawCommand;
        this.file = rawCommand.charAt(1);
        this.rank = rawCommand.charAt(2);
    }

    private void validate(String rawCommand) {
        // {piece} {file} {rank}

        if (rawCommand.length() != 3) {
            throw new InvalidCommandException("command length != 3");
        }

        String symbolStr = rawCommand.substring(0,1);
        char file = rawCommand.charAt(1);
        char rank = rawCommand.charAt(2);

        Arrays.stream(Symbol.values())
                .filter(symbol -> symbol.name().equals(symbolStr))
                .findAny()
                .orElseThrow(() -> new InvalidCommandException("invalid symbol"));

        if (!(file >= 'a' && file <= 'h')) {
            throw new InvalidCommandException("invalid file(column)");
        }

        if (!(rank >= '1' && rank <= '8')) {
            throw new InvalidCommandException("invalid rank(row)");
        }
    }
}
