package com.jamey.ToDo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    public static int lastId = 0;
    private int id;
    private String description;
    private Status status;
    private String createdAt;
    private String updatedAt;

    public Task() {}

    public Task(String description){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter nowFormatted = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = now.format(nowFormatted);

        this.id = ++lastId;
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = formattedDate;
        this.updatedAt = formattedDate;
    }

    public String toJson(){
        return "{ \"id\": \"" + id + "\", \"description\": \"" + description + "\", \"status\": \"" + status + "\", \"createdAt\": \"" + createdAt + "\", \"updatedAt\": \"" + updatedAt + "\" }";
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

}
