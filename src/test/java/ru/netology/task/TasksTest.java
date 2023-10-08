package ru.netology.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldMatchesQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(6, "Оплатить кварплату");

        Todos todos = new Todos();

        todos.add(simpleTask);


       expected = {true};
       actual = ;

        Assertions.assertArrayEquals(expected, actual);
    }
}
