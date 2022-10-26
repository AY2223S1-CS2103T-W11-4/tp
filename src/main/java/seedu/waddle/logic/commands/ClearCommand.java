package seedu.waddle.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.waddle.model.Model;
import seedu.waddle.model.Waddle;

/**
 * Clears the Waddle of itineraries.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Waddle itineraries cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setWaddle(new Waddle());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
