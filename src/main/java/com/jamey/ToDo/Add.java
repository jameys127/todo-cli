package com.jamey.ToDo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Add {
    private BufferedWriter writer;
    private final String jsonPath;
    public Add() throws IOException{
        String appdata = System.getenv("APPDATA");
        String folder = appdata + File.separator + "ToDoCLI";
        if(!Files.exists(new File(folder).toPath())){
            new File(folder).mkdir();
        }
        String jsonPath = folder + File.separator + "tasks.json";
        if(!Files.exists(new File(jsonPath).toPath())){
            BufferedWriter temp = new BufferedWriter(new FileWriter(jsonPath));
            temp.write("[]");
            temp.close();
        }
        this.jsonPath = jsonPath;

    }
    public void addTask(String task) throws IOException{
        String json = Files.readString(new File(jsonPath).toPath());
        Gson gson = new Gson();
        Task tasks[] = gson.fromJson(json, Task[].class);
        List<Task> listOfTasks = new ArrayList<>();
        if(tasks != null){
            for(Task todo : tasks){
                listOfTasks.add(todo);
            }   
        }
        if(!listOfTasks.isEmpty()){
            Task.lastId = listOfTasks.get(listOfTasks.size() - 1).getId();
        }
        Task newTask = new Task(task);
        listOfTasks.add(newTask);

        writer = new BufferedWriter(new FileWriter(jsonPath));
        writer.write("[");
        for(int i = 0; i < listOfTasks.size(); i++){
            String jsonTask = listOfTasks.get(i).toJson();
            writer.write(jsonTask);
            if(i != listOfTasks.size() - 1){
                writer.write(",");
            }
        }
        writer.write("]");
        writer.close();
        System.out.println("\nSuccessfully added task with id: " + newTask.getId() + "\n");
    }
}
