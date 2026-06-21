package com.cts.structures.exercise05;

class Task {
    String taskId;
    String taskName;
    String status;
    Task next;
    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
    @Override
    public String toString() {
        return "Task [ID=" + taskId + ", Title=" + taskName + ", Status=" + status + "]";
    }
}

class TaskLinkedList {
    private Task headNode = null;

    public void addTask(String id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (headNode == null) {
            headNode = newTask;
        } else {
            Task activeNode = headNode;
            while (activeNode.next != null) {
                activeNode = activeNode.next;
            }
            activeNode.next = newTask;
        }
        System.out.println("Enqueued Task Item: " + name);
    }
    public Task searchTask(String id) {
        Task activeNode = headNode;
        while (activeNode != null) {
            if (activeNode.taskId.equalsIgnoreCase(id)) {
                return activeNode;
            }
            activeNode = activeNode.next;
        }
        return null;
    }
    public void traverseTasks() {
        System.out.println("\nActive Task Queue Structure:");
        Task activeNode = headNode;
        while (activeNode != null) {
            System.out.println(activeNode);
            activeNode = activeNode.next;
        }
    }
    public void deleteTask(String id) {
        if (headNode == null) return;
        if (headNode.taskId.equalsIgnoreCase(id)) {
            headNode = headNode.next;
            System.out.println("Removed Task with ID: " + id);
            return;
        }
        Task activeNode = headNode;
        while (activeNode.next != null && !activeNode.next.taskId.equalsIgnoreCase(id)) {
            activeNode = activeNode.next;
        }
        if (activeNode.next != null) {
            activeNode.next = activeNode.next.next; // Unlink target node from reference chain [cite: 74]
            System.out.println("Removed Task with ID: " + id);
        } else {
            System.out.println("Task target matching verification context not found.");
        }
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        System.out.println("Task Management Pipeline Base \n");
        TaskLinkedList pipeline = new TaskLinkedList();
        pipeline.addTask("T01", "Setup Jenkins Pipeline", "In Progress");
        pipeline.addTask("T02", "Configure Docker Engine", "Pending");
        pipeline.traverseTasks();
        System.out.println("\nQueue Modification Operations ");
        pipeline.deleteTask("T02");
        pipeline.traverseTasks();
    }
}