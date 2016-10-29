package nl.marcenschede.guard;

import org.junit.Test;

import static nl.marcenschede.guard.Guard.guard;

public class GuardTest {

    @Test
    public void shouldNotExecuteSupplier() {
        guard(true, () -> {
            throw new TestException();
        });
    }

    @Test(expected = TestException.class)
    public void shouldExecuteSupplier() {
        guard(false, () -> {
            throw new TestException();
        });
    }

    @Test
    public void shouldNotExcept() {
        guard(true, TestException.class);
    }

    @Test(expected = TestException.class)
    public void shouldExcept() {
        guard(false, TestException.class);
    }

}
