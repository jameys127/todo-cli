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
                    break;
                case "mark-done":
                    break;
                case "mark-in-progress":
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
