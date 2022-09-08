package roon.game.chess;

import lombok.Getter;
import roon.game.chess.exception.InvalidCommandException;

@Getter
public class Command {
    private String rawCommand;

    private final char prevFile, prevRank;
    private final char nextFile, nextRank;

    public Command(String rawCommand) {
        this.rawCommand = rawCommand;

        prevFile = rawCommand.charAt(0);
        prevRank = rawCommand.charAt(1);

        nextFile = rawCommand.charAt(2);
        nextRank = rawCommand.charAt(3);

        validate(rawCommand);
    }

    private void validate(String rawCommand) {
        // {file before} {rank before} {file after} {rank after}

        if (rawCommand.length() != 4) {
            throw new InvalidCommandException("command length != 4");
        }

        if (!(prevFile >= 'A' && prevFile <= 'H')) {
            throw new InvalidCommandException("invalid file(column)");
        }

        if (!(prevRank >= '1' && prevRank <= '8')) {
            throw new InvalidCommandException("invalid rank(row)");
        }

        if (!(nextFile >= 'A' && nextFile <= 'H')) {
            throw new InvalidCommandException("invalid file(column)");
        }

        if (!(nextRank >= '1' && nextRank <= '8')) {
            throw new InvalidCommandException("invalid rank(row)");
        }
    }
}
