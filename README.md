# JavaGuard

## Summary
JavaGuard library allows developers to use Swift-like guard function. The guard function distinct from the classic 'if(false) throw new Exception()' pattern by the way the condition is handled.

The guard function executes the exception when the condition is not met. This implies that the condition can be formulated in a positive way; e.g. the condition can be formulated in a way that it describes what is expected.

This is just the way Shift-way :-)

### Example
The guard function throws a RuntimeException when the age is 17 or less.

    function(int age) {
        guard(age>17, UnderEightteenNotAllowedException.class);
        ...
     }
  
