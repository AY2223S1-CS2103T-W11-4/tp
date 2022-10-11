package seedu.waddle.logic.parser;

import static seedu.waddle.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.waddle.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.waddle.commons.core.Messages.MESSAGE_UNKNOWN_STAGE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.waddle.logic.StageManager;
import seedu.waddle.logic.Stages;
import seedu.waddle.logic.commands.*;
import seedu.waddle.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class WaddleParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        Stages currStage = StageManager.getInstance().getCurrentStage();

        switch (currStage) {
        case HOME:
            return parseHomeCommand(commandWord, arguments);
        case WISH:
            return parseWishCommand(commandWord, arguments);
        case SCHEDULE:
            return parseScheduleCommand(commandWord, arguments);
        default:
            throw new ParseException(MESSAGE_UNKNOWN_STAGE);
        }
    }

    /**
     * Parses user input into command for execution.
     *
     * @param commandWord The command word.
     * @param arguments The arguments.
     * @return The command.
     * @throws ParseException ParseException.
     */
    public Command parseHomeCommand(String commandWord, String arguments) throws ParseException {
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case PlanCommand.COMMAND_WORD:
            return new PlanCommandParser().parse(arguments);

        case HomeCommand.COMMAND_WORD:
            return new HomeCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    /**
     * Parses user input into command for execution.
     *
     * @param commandWord The command word.
     * @param arguments The arguments.
     * @return The command.
     * @throws ParseException ParseException.
     */
    public Command parseWishCommand(String commandWord, String arguments) throws ParseException {
        switch (commandWord) {

        //TODO: ADD, DEL, EDIT, FIND, SORT, CLEAR (activities)

        case HomeCommand.COMMAND_WORD:
            return new HomeCommand();

        case StageCommand.COMMAND_WORD:
            return new StageCommandParser().parse(arguments);

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case AddItemCommand.COMMAND_WORD:
            return new AddItemCommandParser().parse(arguments);

        //TODO: help commands must change here
        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    /**
     * Parses user input into command for execution.
     *
     * @param commandWord The command word.
     * @param arguments The arguments.
     * @return The command.
     * @throws ParseException ParseException.
     */
    public Command parseScheduleCommand(String commandWord, String arguments) throws ParseException {
        switch (commandWord) {

        //TODO: need to discuss what commands should be available here

        case HomeCommand.COMMAND_WORD:
            return new HomeCommand();

        case StageCommand.COMMAND_WORD:
            return new StageCommandParser().parse(arguments);

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        //TODO: help commands must change here
        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }
}
