package com.jamey.ToDo;

public class ToDo {
    public static void main(String[] args) {
        if(args.length != 2 && !args[0].equals("list")){
            usage();
        }else{

        }
    }

    public static void usage(){
        System.out.println("Invalid Input");
        System.out.println("Takes:");
        System.out.println("-Command | Ex: add, delete, etc..");
        System.out.println("-Parameter | 'description', id, etc..");
        System.out.println("\n'list' is the only command that doesn't require a parameter\n");
    }
}
