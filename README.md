# To Do CLI App
This simple To Do app was something fun to do as I try out project ideas that I find online. I made this in a couple of hours, mainly so that I could work more with .json files. I also made a batch file that I put in my PATH environment variable so that I can use this anywhere.

## Features
- Add a task --- `add "Description of Task"`
- Delete a task --- `delete {id}`
- Update a task --- `update {id} "New Description"`
- Mark as TODO | IN_PROGRESS | DONE --- `mark-in-progress {id}` | `mark-done {id}` | `mark-todo {id}`
- List all tasks | List TODO tasks | List IN_PROGRESS tasks | List DONE tasks --- `list` | `list todo` | `list in-progress` | `list done`

## If you want to use this
You can clone this repo and build it using Maven. Maven is required to build the .jar file so you would need to download it first.
1. Clone the repo
```
git clone https://github.com/jameys127/todo-cli.git
cd todo-cli
```
2. Build the .jar
```
mvn clean verify
```
3. Move into the `target` directory and run the program using the different commands and arguments (run the command `help` with no argument for a list)
```
cd target
java -cp todo-cli-1.0.0.jar com.jamey.ToDo.ToDo <command> [argument]
```
4. Example
```
java -cp todo-cli-1.0.0.jar com.jamey.ToDo.ToDo add "Do the dishes"
```

## Batch file
I made a super simple batch file so that I can use this without having to go to the specific directory.
1. Follow the directions above to build the .jar file
2. Create a folder anywhere and copy & paste the `todo-cli-1.0.0.jar` file and the `todo.bat` file inside (The .jar file is in the `target` directory after you build it)
3. Add the folder that you made to your environment variable `PATH` and restart any command lines you have open
4. Now from any directory you can run `todo` command to use this app

## Example
```
todo add "Do the dishes"
# Adds the task to the list

todo list
# Shows a list of all tasks

```
