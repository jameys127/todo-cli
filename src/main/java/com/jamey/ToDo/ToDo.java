package com.jamey.ToDo;

import java.io.IOException;

public class ToDo {
    public static int lastId;
    public static void main(String[] args) throws IOException {
        if( ( args.length < 2 && (!args[0].equals("list") && !args[0].equals("help")) ) || (args.length > 4)){
            invalid();
        }else{
            switch (args[0]){

                case "help":
                    System.out.println(lastId);
                    lastId++;
                    usage();
                    break;

                case "add":
                    if(args.length >= 3){
                        invalid();
                        return;
                    }
                    Add add = new Add();
                    add.addTask(args[1]);
                    break;

                case "update":
                    if(args.length >= 4 || args.length <= 2){
                        invalid();
                        return;
                    }
                    Update update = new Update();
                    try{
                        update.updateTask(Integer.parseInt(args[1]), args[2]);
                    }catch(NumberFormatException e){
                        invalid();
                    }
                    break;

                case "delete":
                    if(args.length >= 3){
                        invalid();
                        return;
                    }
                    Delete delete = new Delete();
                    try{
                        delete.deleteTask(Integer.parseInt(args[1]));
                    }catch(NumberFormatException e){
                        invalid();
                    }
                    break;

                case "list":
                    if(args.length == 1){
                        ListTask list = new ListTask();
                        list.listAll();
                    }else if(args.length == 2 && args[1].equals("done")){
                        ListTask list = new ListTask();
                        list.listDone();
                    }else if(args.length == 2 && args[1].equals("in-progress")){
                        ListTask list = new ListTask();
                        list.listInProgress();
                    }else if(args.length == 2 && args[1].equals("todo")){
                        ListTask list = new ListTask();
                        list.listToDo();
                    }else{
                        invalid();
                    }
                    break;

                case "mark-done":
                    if(args.length >= 3){
                        invalid();
                        return;
                    }
                    Mark mark = new Mark();
                    try{
                        mark.markDone(Integer.parseInt(args[1]));
                    }catch(NumberFormatException e){
                        invalid();
                    }
                    break;

                case "mark-in-progress":
                    if(args.length >= 3){
                        invalid();
                        return;
                    }
                    Mark mark2 = new Mark();
                    try{
                        mark2.markInProgress(Integer.parseInt(args[1]));
                    }catch(NumberFormatException e){
                        invalid();
                    }
                    break;
                    
                default:
                    invalid();
            }
        }
    }

    public static void invalid(){
        System.out.println("\nInvalid Input\nEnter: 'todo-cli help' for list of commands\n");
    }

    public static void usage(){
        System.out.println("\nTakes:");
        System.out.println("-Command | add, update, delete, list, mark-done, mark-in-progress, help");
        System.out.println("-Parameter | add 'description' | update {id} 'description' |\ndelete {id} | mark-done {id} | mark-in-progress {id} | list {'done', 'todo', 'in-progress'}");
        System.out.println("\n'list' is the only command that doesn't require a parameter\n");
    }
}
