package ru.netology.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldMatchesQuerySimpleTaskPlus() {
        SimpleTask simpleTask = new SimpleTask(6, "Оплатить кварплату");

        String query = "Оплатить кварплату";

        boolean expected = true;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesQuerySimpleTaskMinus() {
        SimpleTask simpleTask = new SimpleTask(6, "Оплатить кварплату");

        String query = "7";

        boolean expected = false;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldMatchesQueryEpicPlus() {
        String[] subtasks = {"Подработка", "Отправить портфолио", "Уточнить место"};
        Epic epic = new Epic(13, subtasks);

        String query = "Подработка";

        boolean expected = true;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesQueryEpicMinus() {
        String[] subtasks = {"Подработка", "Отправить портфолио", "Уточнить место"};
        Epic epic = new Epic(13, subtasks);

        String query = "Отправить фото";

        boolean expected = false;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldMatchesQueryMeetingProjectPlus() {
        Meeting meeting = new Meeting(
                77,
                "Окультуривание",
                "Театр Красный факел",
                "Вторник");

        String query = "Красный факел";

        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldMatchesQueryMeetingProjectMinus() {
        Meeting meeting = new Meeting(
                77,
                "Окультуривание",
                "Театр Красный факел",
                "27.05. в 15:00");

        String query = "Белый факел";

        boolean expected = false;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesQueryMeetingTopicPlus() {
        Meeting meeting = new Meeting(
                77,
                "Окультуривание в столице Сибири",
                "Театр Красный факел",
                "Вторник");

        String query = "Окультуривание";

        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldMatchesQueryMeetingTopicMinus() {
        Meeting meeting = new Meeting(
                77,
                "Окультуривание в столице Сибири",
                "Театр Красный факел",
                "Вторник");

        String query = "hhhhhhhhhhh";

        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldMatchesQueryMeetingStartPlus() {
        Meeting meeting = new Meeting(
                77,
                "Окультуривание в столице Сибири",
                "Театр Красный факел",
                "Вторник");

        String query = "Вт";

        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldMatchesQueryMeetingStartMinus() {
        Meeting meeting = new Meeting(
                77,
                "Окультуривание в столице Сибири",
                "Театр Красный факел",
                "Вторник");

        String query = "02";

        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

}
