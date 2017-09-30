package nl.marcenschede.guard;

import org.junit.Test;

import static nl.marcenschede.guard.Guard.guard;

public class GuardTest {

    @Test
    public void shouldNotExecuteSupplier() {
        guard(true, () -> {
            throw new GuardTest.TestException();
        });
    }

    @Test(expected = GuardTest.TestException.class)
    public void shouldExecuteSupplier() {
        guard(false, () -> {
            throw new GuardTest.TestException();
        });
    }

    @Test
    public void shouldNotExcept() {
        guard(true, GuardTest.TestException.class);
    }

    @Test(expected = GuardTest.TestException.class)
    public void expectException() {
        guard(false, GuardTest.TestException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentException() {
        guard(false);
    }

    public static class TestException extends RuntimeException {
    }

}
