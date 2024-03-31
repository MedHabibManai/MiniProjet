package Main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TaskListImpl extends UnicastRemoteObject implements TaskList {
    private List<String> tasks;

    public TaskListImpl() throws RemoteException {
        tasks = new ArrayList<>();
    }

    @Override
    public synchronized void addTask(String task) throws RemoteException {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    @Override
    public synchronized void removeTask(int index) throws RemoteException {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask);
        }
    }

    @Override
    public synchronized List<String> getTaskList() throws RemoteException {
        return new ArrayList<>(tasks);
    }

    public static void main(String[] args) {
        try {
            TaskList taskList = new TaskListImpl();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry();
            registry.rebind("TaskList", taskList);
            System.out.println("Server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
