package org.example.TaskManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void shouldFindQueryInSimpleTaskTrue() {
        Task simpleTask = new SimpleTask(1, "Принять заявку");

        boolean expected = true;
        boolean actual = simpleTask.matches("Принять");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInSimpleTaskFalse() {
        Task simpleTask = new SimpleTask(1, "Принять заявку");

        boolean expected = false;
        boolean actual = simpleTask.matches("принять");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpicTrue() {
        String[] subtasks = {"Принять заявку", "Отработать заявку", "Выставить счет", "Подписать документы", "Отправить заказчику"};
        Task epic = new Epic(31, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("заявку");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInEpicFalse() {
        String[] subtasks = {"Принять заявку", "Отработать заявку", "Выставить счет", "Подписать документы", "Отправить заказчику"};
        Task epic = new Epic(31, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("задач");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMeetingTrue() {
        Task meeting = new Meeting(
                17,
                "Работа с документами",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        boolean expected = true;
        boolean actual = meeting.matches(" с ");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInMeetingFalse() {
        Task meeting = new Meeting(
                17,
                "Работа с документами",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        boolean expected = false;
        boolean actual = meeting.matches("утра");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryInTaskFalse() {
        Task task = new Task(31);

        boolean expected = false;
        boolean actual = task.matches("счет");

        Assertions.assertEquals(expected, actual);
    }


}
