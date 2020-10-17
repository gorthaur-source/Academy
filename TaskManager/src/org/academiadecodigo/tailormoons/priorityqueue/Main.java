package org.academiadecodigo.tailormoons.priorityqueue;
import java.util.PriorityQueue;
import org.academiadecodigo.tailormoons.priorityqueue.ToDoList.*;

public class Main {

    public static void main(String[] args) {

        PriorityQueue<ToDo> todoList = new PriorityQueue<>();
        ToDo task1 = new ToDo(Importance.MEDIUM, 1, "Medium priority 1");
        ToDo task2 = new ToDo(Importance.LOW, 1, "Low priority 1");
        ToDo task3 = new ToDo(Importance.HIGH, 1, "High priority 1");
        ToDo task4 = new ToDo(Importance.LOW, 2, "Low priority 2");
        ToDo task5 = new ToDo(Importance.MEDIUM, 2, "Medium priority 2");
        ToDo task6 = new ToDo(Importance.HIGH, 2, "High priority 2");

        todoList.add(task1);
        todoList.add(task2);
        todoList.add(task3);
        todoList.add(task4);
        todoList.add(task5);
        todoList.add(task6);

        while(!todoList.isEmpty()) {
            System.out.println(todoList.remove());
        }

        ToDoList toDoList = new ToDoList();
        toDoList.add(Importance.HIGH, 2, "High 2");
        toDoList.add(Importance.MEDIUM, 2, "Medium 2");
        toDoList.add(Importance.LOW, 1, "Low priority 1");
        toDoList.add(Importance.LOW, 2, "Low priority 2");
        toDoList.add(Importance.MEDIUM, 3, "Medium 3");
        toDoList.add(Importance.LOW, 1, "Low priority 1");
        toDoList.add(Importance.LOW, 2, "Low priority 2");
        toDoList.add(Importance.HIGH, 1, "High 1");
        toDoList.add(Importance.MEDIUM, 1, "Medium priority 1");




        while(!toDoList.isEmpty()) {
            System.out.println(toDoList.remove());
        }
    }
}
