package com.jamey.ToDo;

public class ToDo {
    public static void main(String[] args) {
        if( ( args.length < 2 && (!args[0].equals("list") && !args[0].equals("help")) ) || (args.length > 4)){
            invalid();
        }else{
            switch (args[0]){
                case "help":
                    usage();
                    break;
                case "add":
                    break;
                case "update":
                    break;
                case "delete":
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
