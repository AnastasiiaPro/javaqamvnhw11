package ru.netology.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchesQueryTask() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(13, "Оплатить кварплату"));
        todos.add(new Epic(6, new String[]{"Подработка", "Отправить портфолио", "Уточнить место"}));
        todos.add(new Meeting(77,
                "Окультуривание",
                "Театр Красный факел",
                "Вторник"));
        Task[] expected = {new SimpleTask(13, "Оплатить кварплату")};
        Task[] actual = todos.search("Оплатить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchesQueryTask() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(13, "Оплатить кварплату"));
        todos.add(new Epic(6, new String[]{"Подработка", "Отправить портфолио", "Уточнить место"}));
        todos.add(new Meeting(77,
                "Окультуривание",
                "Театр Красный факел",
                "Вторник"));
        Task[] expected = {};
        Task[] actual = todos.search("Среда");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchesQueryThreeTasks() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(13, "Оплатить кварплату"));
        todos.add(new Epic(6, new String[]{"Подработка", "Оплатить студию", "Уточнить место"}));
        todos.add(new Meeting(77,
                "Окультуривание",
                "Оплатить билеть в тетр",
                "Вторник"));
        Task[] expected = {new SimpleTask(13, "Оплатить кварплату"),
                new Epic(6, new String[]{"Подработка", "Оплатить студию", "Уточнить место"}),
                new Meeting(77,
                        "Окультуривание",
                        "Оплатить билеть в тетр",
                        "Вторник")};
        Task[] actual = todos.search("Оплатить");
        Assertions.assertArrayEquals(expected, actual);
    }
//    @Test
//    public void shouldMatchesQueryIdTask() {
//        Todos todos = new Todos();
//        SimpleTask simpleTask = new SimpleTask(13, "Оплатить кварплату");
//
//        String[] subtasks = new String[]{"Подработка", "Отправить портфолио", "Уточнить место"};
//        Epic epic = new Epic(6, subtasks);
//
//        Meeting meeting = new Meeting(
//                77,
//                "Окультуривание",
//                "Театр Красный факел",
//                "Вторник");
//
//        int Id = 77;
//
//        boolean expected = true;
//        boolean actual = int.hashCode(id);
//        Assertions.assertEquals(expected, actual);
//    }
}
