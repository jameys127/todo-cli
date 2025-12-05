package com.jamey.ToDo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Delete {
    private final String jsonPath;
    private BufferedWriter writer;
    public Delete(){
        String appdata = System.getenv("APPDATA");
        String folder = appdata + File.separator + "ToDoCLI";
        String jsonPath = folder + File.separator + "tasks.json";
        this.jsonPath = jsonPath;
    }
    public void deleteTask(int id) throws IOException{
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
        List<Task> listOfTasks = new ArrayList<>();
        if(tasks != null){
            for(Task todo : tasks){
                listOfTasks.add(todo);
            }
        }
        for(int i = 0; i < listOfTasks.size(); i++){
            if(listOfTasks.get(i).getId() == id){
                listOfTasks.remove(i);
                writer = new BufferedWriter(new FileWriter(jsonPath));
                writer.write("[");
                for(int j = 0; j < listOfTasks.size(); j++){
                    String jsonTask = listOfTasks.get(j).toJson();
                    writer.write(jsonTask);
                    if(j != listOfTasks.size() - 1){
                        writer.write(",");
                    }
                }
                writer.write("]");
                writer.close();
                System.out.println("\nSuccessfully deleted task with id: " + id + "\n");
                return;
            }
        }
        System.out.println("\nNo such task with id: " + id + "\n");

    }
}
