package org.example.TaskManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(1, "Принять заявку");

        String[] subtasks = {"Принять заявку", "Отработать заявку", "Выставить счет", "Подписать документы", "Отправить заказчику"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Работа с документами",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetSubtasks() {

        String[] subtasks = {"Принять заявку", "Отработать заявку", "Выставить счет", "Подписать документы", "Отправить заказчику"};
        Epic epic = new Epic(31, subtasks);

        String[] expected = subtasks;
        String[] actual = epic.getSubtasks();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetID() {

        String[] subtasks = {"Принять заявку", "Отработать заявку", "Выставить счет", "Подписать документы", "Отправить заказчику"};
        Epic epic = new Epic(31, subtasks);
        Task task = new Task(31);


        int expected = epic.getId();
        int actual = task.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchInTodos() {
        SimpleTask simpleTask = new SimpleTask(1, "Принять заявку");

        String[] subtasks = {"Принять заявку", "Отработать заявку", "Выставить счет", "Подписать документы", "Отправить заказчику"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Работа с документами",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search(" ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInSimpleTaskEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Принять заявку");

        String[] subtasks = {"Принять заявку", "Отработать заявку", "Выставить счет", "Подписать документы", "Отправить заказчику"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Работа с документами",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search(simpleTask.getTitle());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInMeetingEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Принять заявку");

        String[] subtasks = {"Принять заявку", "Отработать заявку", "Выставить счет", "Подписать документы", "Отправить заказчику"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Работа с документами",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("документ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Принять заказы");

        String[] subtasks = {"Принять заказ", "Отработать заявку", "Выставить счет", "Подписать документы", "Отправить заказчику"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Работа с документами",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("заказы");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchInEpic() {
        SimpleTask simpleTask = new SimpleTask(1, "Принять заявку");

        String[] subtasks = {"Принять заказ", "Отработать заявку", "Выставить счет", "Подписать документы", "Отправить заказчику"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Работа с документами",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("счет");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldInMeetingFirst() {
        SimpleTask simpleTask = new SimpleTask(1, "Принять заявку");

        String[] subtasks = {"Принять заказ", "Отработать заявку", "Выставить счет", "Подписать документы", "Отправить заказчику"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Работа с документами",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getTopic());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldInMeetingSecond() {
        SimpleTask simpleTask = new SimpleTask(1, "Принять заявку");

        String[] subtasks = {"Принять заказ", "Отработать заявку", "Выставить счет", "Подписать документы", "Отправить заказчику"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Работа с документами",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getProject());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldInMeetingThird() {
        SimpleTask simpleTask = new SimpleTask(1, "Принять заявку");

        String[] subtasks = {"Принять заказ", "Отработать заявку", "Выставить счет", "Подписать документы", "Отправить заказчику"};
        Epic epic = new Epic(31, subtasks);

        Meeting meeting = new Meeting(
                17,
                "Работа с документами",
                "Планировщик задач",
                "в 9:00 утра по МСК"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search(meeting.getStart());

        Assertions.assertArrayEquals(expected, actual);
    }


}