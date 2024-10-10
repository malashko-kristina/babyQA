package org.example.hometask2.task4;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
    }
}
