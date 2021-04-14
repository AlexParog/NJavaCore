import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTask2Test {

    @Test
    void givenString_whenConditions_thenCorrect() {
        String string = "new_data.json";
        assertThat(string, anyOf(containsString("new_data"), endsWith(".json")));
    }

    @Test
    void whenNotNull_thenCorrect() {
        String expected = new String();
        assertThat(expected, notNullValue());
    }

    @Test
    public void whenSameObject_thenCorrect() {
        Object object = new String();
        assertThat(object, sameInstance(object));
    }

    @Test
    public void givenList_whenCheck_thenNotEmpty() {
        Employee employeeFirst = new Employee(1, "John", "Smith", "USA", 25);
        Employee employeeSecond = new Employee(2, "Inav", "Petrov", "RU", 23);
        List<Employee> list = new ArrayList<>();
        list.add(employeeFirst);
        list.add(employeeSecond);
        assertThat(list, is(not(empty())));
    }
}