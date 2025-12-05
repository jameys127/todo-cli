package com.jamey.ToDo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Add {
    private final BufferedWriter writer;
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
            System.out.println("done it");
            temp.close();
        }

        writer = new BufferedWriter(new FileWriter(jsonPath));
    }
    public int addTask(String task) throws IOException{
        Task newTask = new Task(task);
        String jsonTask = newTask.toJson();
        writer.append(jsonTask);
        writer.close();
        return newTask.getId();
    }
}
