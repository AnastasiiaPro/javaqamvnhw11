package ru.netology.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldMatchesQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(6, "Оплатить кварплату");

        String query = "Оплатить кварплату";

        boolean expected = true;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchesQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(6, "Оплатить кварплату");

        String query = "7";

        boolean expected = false;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldMatchesQueryEpic() {
        String[] subtasks = {"Подработка", "Отправить портфолио", "Уточнить место"};
        Epic epic = new Epic(13, subtasks);

        String query = "Подработка";

        boolean expected = true;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchesQueryEpic() {
        String[] subtasks = {"Подработка", "Отправить портфолио", "Уточнить место"};
        Epic epic = new Epic(13, subtasks);

        String query = "Отправить фото";

        boolean expected = false;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldMatchesQueryMeetingProject() {
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
    public void shouldNotMatchesQueryMeetingProject() {
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
    public void shouldMatchesQueryMeetingTopic() {
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
    public void shouldNotMatchesQueryMeetingTopic() {
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
    public void shouldMatchesQueryMeetingStart() {
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
    public void shouldNoMatchesQueryMeetingStart() {
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
