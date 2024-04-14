package mvc;
import java.util.*;
public class CommandProcessor{
    private Stack<CommandInt> undoStack = new Stack<>();
    private Stack<CommandInt> redoStack = new Stack<>();
    public void execute(CommandInt cmmd){
        cmmd.execute();
        undoStack.push(cmmd);
        redoStack.clear();
    }

    public void undo(CommandInt cmmd){
        if(!undoStack.isEmpty()){
            redoStack.push(undoStack.pop());
            cmmd.undo();
        }
    }
    public void redo(){
        if (!redoStack.isEmpty()) {
            CommandInt command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }

    //if it doesn't work, replace CommandInt w/ Command

}
