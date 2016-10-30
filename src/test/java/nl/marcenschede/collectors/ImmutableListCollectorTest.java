package nl.marcenschede.collectors;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ImmutableListCollectorTest {

    @Test(expected = UnsupportedOperationException.class)
    public void shouldExceptOnAddingElementToImmutableList() {
        Integer[] inputData = new Integer[]{5, 4, 3};

        List<String> actualImmutableList = Arrays.stream(inputData).
                map(i -> i.toString()).
                collect(ImmutableListCollector.toImmutableList());

        actualImmutableList.add("Hallo");
    }

    @Test
    public void shouldReadFromImmutableLinkedList() {
        Integer[] inputData = new Integer[]{5, 4, 3};

        List<String> actualImmutableList = Arrays.stream(inputData).
                map(i -> i.toString()).
                collect(ImmutableListCollector.toImmutableList(LinkedList::new));

        assertThat(actualImmutableList.get(0), CoreMatchers.is("5"));
    }

    @Test
    public void shouldReadFromImmutableList() {
        Integer[] inputData = new Integer[]{5, 4, 3};

        List<String> actualImmutableList = Arrays.stream(inputData).
                map(i -> i.toString()).
                collect(ImmutableListCollector.toImmutableList());

        assertThat(actualImmutableList.get(0), CoreMatchers.is("5"));
    }

}