package mvc;

import CALab.GridPanel;
import life.LifeFactory;

import java.util.*;

public interface AppFactory {
    public Model makeModel();
    public View makeView(Model model);
    public String getTitle();
    public String[] getHelp();
    public String about();
    public String[] getEditCommands();
    public Command makeEditCommand(Model mode, String type, Object source);
}