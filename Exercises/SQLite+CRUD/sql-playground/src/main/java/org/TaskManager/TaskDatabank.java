package org.TaskManager;

import java.sql.*;

public class TaskDatabank {

    public void connect(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:tasks.db");

            String sql = """
                    
                    CREATE TABLE IF NOT EXISTS tasks(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    title TEXT NOT NULL,
                    done BOOLEAN NOT NULL
                    );
                    """;

            connection.createStatement().execute(sql);
            System.out.println("Successfully connected");
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void saveTask(Task task){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:tasks.db");
            String sql = """
                    INSERT INTO tasks(title, done)
                    VALUES (?,?)
                    """;
            PreparedStatement statement =
                    connection.prepareStatement(sql);
            statement.setString(1, task.getName());
            statement.setBoolean(2, task.isDone());
            statement.executeUpdate();
            connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
    }

    public void getAllTasks(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:tasks.db");
            String sql ="""
                    SELECT * FROM tasks
                    """;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                String title = result.getString("title");
                boolean done = result.getBoolean("done");
                System.out.println(title + " - " + done);
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getSpecificTask(Task task){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:tasks.db");

            String sql = """
                SELECT * FROM tasks
                WHERE title = ?
                """;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task.getName());
            ResultSet result = statement.executeQuery();
            if(result.next()){
                String title = result.getString("title");
                boolean done = result.getBoolean("done");
                System.out.println(title + " - " + done);
            } else {
                System.out.println("Task not found");
            }
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();

        }
    }

    public void updateTasks(Task task){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:tasks.db");
            String sql = """
                    UPDATE tasks
                    SET done = ?
                    WHERE title = ?
                    """;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1, true);
            statement.setString(2, task.getName());

            int rowsAffected  = statement.executeUpdate();
            if (rowsAffected > 0){
                System.out.println("Task updated!");
            } else {
                System.out.println("Task not found");
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteTask(Task task){
        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:tasks.db");
            String sql = """
                    DELETE FROM tasks
                    WHERE title = ?
                    """;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task.getName());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected != 0){
                System.out.println("Successfully deleted" +
                        "");
            } else {
                System.out.println("No change was made");
            }
            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Task findTaskByTitle(String title){
        try{
            Connection connection =
                    DriverManager.getConnection("jdbc:sqlite:tasks.db");

            String sql = """
                SELECT * FROM tasks
                WHERE title = ?
                """;

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, title);

            ResultSet result = statement.executeQuery();

            if(result.next()){

                String taskTitle =
                        result.getString("title");

                boolean done =
                        result.getBoolean("done");

                connection.close();

                return new Task(taskTitle, done);
            }

            connection.close();
            return null;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }


}