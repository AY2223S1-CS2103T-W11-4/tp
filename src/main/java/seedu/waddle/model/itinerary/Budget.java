package seedu.waddle.model.itinerary;

import static java.util.Objects.requireNonNull;
import static seedu.waddle.commons.util.AppUtil.checkArgument;

/**
 * Represents an Itinerary's budget.
 */
public class Budget {
    public static final String MESSAGE_CONSTRAINTS =
            "Budget should only contain numbers.";
    public static final String VALIDATION_REGEX = "\\d+([.][0-9]+)?$";
    private float initialBudget;
    private float spending;

    /**
     * Constructs a {@code Budget}.
     *
     * @param budgetStr A valid value.
     */
    public Budget(String budgetStr) {
        requireNonNull(budgetStr);
        checkArgument(isValidBudget(budgetStr), MESSAGE_CONSTRAINTS);
        this.initialBudget = Float.parseFloat(budgetStr);
        this.spending = 0;
    }

    /**
     * Returns true if a given string is a valid budget.
     */
    public static boolean isValidBudget(String test) {
        if (!test.matches(VALIDATION_REGEX)) {
            return false;
        }
        float budget;
        try {
            budget = Float.valueOf(test);
        } catch (NumberFormatException e) {
            return false;
        }
        return budget >= 0;
    }


    @Override
    public String toString() {
        return String.valueOf(this.initialBudget);
    }

    public float getValue() {
        return this.initialBudget;
    }

    public void updateSpending(float amount) {
        this.spending += amount;
    }

    public float calculateLeftOverBudget() {
        return this.initialBudget - this.spending;
    }

    public float getSpending() {
        return this.spending;
    }

    public void setSpending(float amt) {
        this.spending = amt;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Budget // instanceof handles nulls
                && this.initialBudget == (((Budget) other).getValue())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

}
