package com.jamey.ToDo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private static int lastId = 0;
    private int id;
    private String description;
    private Status status;
    private String createdAt;
    private String updtatedAt;

    public Task(String description){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter nowFormatted = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = now.format(nowFormatted);

        this.id = lastId++;
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = formattedDate;
        this.updtatedAt = formattedDate;
    }

    public String toJson(){
        return "{ \"id\": \"" + id + "\", \"description\": \"" + description + "\", \"status\": \"" + status.getStatus() + "\", \"createdAt\": \"" + createdAt + "\", \"updatedAt\": \"" + updtatedAt + "\" }";
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status.getStatus();
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdtatedAt() {
        return updtatedAt;
    }


}
