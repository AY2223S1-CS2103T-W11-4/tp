package seedu.waddle.model.item;

import static java.util.Objects.requireNonNull;
import static seedu.waddle.commons.util.AppUtil.checkArgument;

/**
 * Represents the estimated cost of an Item in the Itinerary.
 */
public class Cost {
    public static final String MESSAGE_CONSTRAINTS =
            "Cost should only contain a positive number.";
    private final float cost;

    /**
     * Constructs a {@code Cost}.
     *
     * @param cost A valid cost.
     */
    public Cost(String cost) {
        requireNonNull(cost);
        checkArgument(isValidCost(cost), MESSAGE_CONSTRAINTS);
        this.cost = Float.valueOf(cost);
    }

    /**
     * Returns true if a given string is a valid Cost
     */
    public static boolean isValidCost(String test) {
        float value;
        try {
            value = Float.valueOf(test);
        } catch (NumberFormatException e) {
            return false;
        }
        return value >= 0;
    }

    public float getValue() {
        return this.cost;
    }

    @Override
    public String toString() {
        return String.valueOf(cost);
    }
}
