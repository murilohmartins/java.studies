package org.TaskManager;

public class TaskSystem {

    TaskDatabank databank = new TaskDatabank();

    private void errorMessage(){
        System.out.println("Be sure to fulfill all blanks properly!");
    }

    private boolean checkIfBlank(String title){
        if(title.isBlank()){
            errorMessage();
            return true;
        }
        return false;
    }

    public void createTask(String title){
        if(checkIfBlank(title)){
            return;
        }
        Task task = new Task(title);
        databank.saveTask(task);
    }

    public void findTask(String title){
        if(checkIfBlank(title)){
            return;
        }
        Task task = databank.findTaskByTitle(title);
        if (task == null){
            errorMessage();
        } else {
            System.out.println(task.getName() + " - Done: "+task.isDone());
        }

    }

    public void updateToDone(String title){
        if(checkIfBlank(title)){
            return;
        }
        Task task = databank.findTaskByTitle(title);
        if (task==null){
            errorMessage();
            return;
        }
        databank.updateTasks(task);
    }

    public void deleteTask(String title){
        if(checkIfBlank(title)){
            return;
        }
        Task task = databank.findTaskByTitle(title);
        if (task == null){
            errorMessage();
            return;
        }
        databank.deleteTask(task);

    }

    public void getAllTasks(){
        databank.getAllTasks();
    }
}
