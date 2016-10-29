package nl.marcenschede.guard;

import java.util.function.Supplier;

/**
 * The Guard class supplies Swift-like guard functions the validate conditions and
 * execute an exception function when the condition is not met
 *
 * @author Marc Enschede
 */
public class Guard {

    /**
     * Executes the supplier when the condition is not met
     *
     * @param condition Result of the condition validation
     * @param supplier Supplier that is executed if the validation is not met
     */
    public static void guard(Boolean condition, Supplier<Void> supplier) {
        if (!condition)
            supplier.get();
    }

    /**
     * Raises a runtime exception when the condition is not met
     *
     * @param condition Result of the condition validation
     * @param exceptionClass Exception that is raised if condition is not met
     */
    public static void guard(Boolean condition, Class<? extends RuntimeException> exceptionClass) {
        try {
            if (!condition)
                throw exceptionClass.newInstance();

        } catch (InstantiationException | IllegalAccessException e) {
        }
    }

}
