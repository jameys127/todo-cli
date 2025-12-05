package com.jamey.ToDo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.google.gson.Gson;

public class ListTask {
    private final String jsonPath;
    public ListTask(){
        String path = System.getenv("APPDATA");
        String folder = path + File.separator + "ToDoCLI";
        String jsonPath = folder + File.separator + "tasks.json";
        this.jsonPath = jsonPath;
    }

    public void listAll() throws IOException{
        if(!Files.exists(new File(jsonPath).toPath())){
            System.out.println("\nJSON file does not exist\n");
            return;
        }
        String json = Files.readString(new File(jsonPath).toPath());
        if(json.isEmpty() || json.equals("[]") || json == null){
            System.out.println("\nCurrently 0 tasks in file\n");
            return;
        }
        Gson gson = new Gson();
        Task tasks[] = gson.fromJson(json, Task[].class);
        for(Task todo : tasks){
            System.out.println("\n'" + todo.getDescription() + "' | Status: " + todo.getStatus() + " | id: " + todo.getId() + "\n");
        }
    }

    public void listDone() throws IOException{
        if(!Files.exists(new File(jsonPath).toPath())){
            System.out.println("\nJSON file does not exist\n");
            return;
        }
        String json = Files.readString(new File(jsonPath).toPath());
        if(json.isEmpty() || json.equals("[]") || json == null){
            System.out.println("\nCurrently 0 tasks in file\n");
            return;
        }
        Gson gson = new Gson();
        Task tasks[] = gson.fromJson(json, Task[].class);
        int counter = 0;
        for(Task todo : tasks){
            if(todo.getStatus() == Status.DONE){
                counter++;
                System.out.println("\n'" + todo.getDescription() + "' | Status: " + todo.getStatus() + " | id: " + todo.getId() + "\n");
            }
        }
        if(counter == 0){
            System.out.println("\nNo tasks with status: DONE\n");
        }
    }
    public void listInProgress() throws IOException{
        if(!Files.exists(new File(jsonPath).toPath())){
            System.out.println("\nJSON file does not exist\n");
            return;
        }
        String json = Files.readString(new File(jsonPath).toPath());
        if(json.isEmpty() || json.equals("[]") || json == null){
            System.out.println("\nCurrently 0 tasks in file\n");
            return;
        }
        Gson gson = new Gson();
        Task tasks[] = gson.fromJson(json, Task[].class);
        int counter = 0;
        for(Task todo : tasks){
            if(todo.getStatus() == Status.IN_PROGRESS){
                counter++;
                System.out.println("\n'" + todo.getDescription() + "' | Status: " + todo.getStatus() + " | id: " + todo.getId() + "\n");
            }
        }
        if(counter == 0){
            System.out.println("\nNo tasks with status: IN_PROGRESS\n");
        }
    }
    public void listToDo() throws IOException{
        if(!Files.exists(new File(jsonPath).toPath())){
            System.out.println("\nJSON file does not exist\n");
            return;
        }
        String json = Files.readString(new File(jsonPath).toPath());
        if(json.isEmpty() || json.equals("[]") || json == null){
            System.out.println("\nCurrently 0 tasks in file\n");
            return;
        }
        Gson gson = new Gson();
        Task tasks[] = gson.fromJson(json, Task[].class);
        int counter = 0;
        for(Task todo : tasks){
            if(todo.getStatus() == Status.TODO){
                counter++;
                System.out.println("\n'" + todo.getDescription() + "' | Status: " + todo.getStatus() + " | id: " + todo.getId() + "\n");
            }
        }
        if(counter == 0){
            System.out.println("\nNo tasks with status: TODO\n");
        }
    }
}
