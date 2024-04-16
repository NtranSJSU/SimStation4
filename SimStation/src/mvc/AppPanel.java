package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AppPanel extends JPanel implements Subscriber, ActionListener {

    // app panel has a pointer to appfactory
    // app panel has a pointer to model
    //app panel has pointer to view
    public void display(){frame.setVisible(true);}
    public Model getModel(){return model;}
    protected Model model;
    protected AppFactory factory;
    protected View view;
    protected JPanel controlPanel;
    private JFrame frame;
    public static int FRAME_WIDTH = 500;
    public int count;
    public static int FRAME_HEIGHT = 300;
    public void setModel(Model newModel){
        this.model.unsubscribe(this);
        this.model = newModel;
        this.model.subscribe(this);
        view.setModel(this.model);
        model.changed();
    }
    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        JMenu fileMenu = Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this);
        result.add(fileMenu);
        JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditCommands(), this);
        result.add(editMenu);
        JMenu helpMenu = Utilities.makeMenu("Help", new String[]{"About", "Help"}, this);
        result.add(helpMenu);
        return result;
    }
    public AppPanel(AppFactory factory){
        this.factory = factory;
        model = factory.makeModel();
        view = factory.makeView(model);
        view.setBackground((Color.GRAY));

        controlPanel = new JPanel();
        controlPanel.setBackground((Color.PINK));
        setLayout(new GridLayout(1,2));
        add(controlPanel);
        add(view);

        model.subscribe(this);

        frame = new SafeFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setJMenuBar(this.createMenuBar());
        frame.setTitle(factory.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            String cmmd = ae.getActionCommand();
            if(cmmd.equals("Save")){
                Utilities.save(model, false);
            }
            else if(cmmd.equals("SaveAs")){
                Utilities.save(model, true);
            }
            else if(cmmd.equals("Open")){
                Model newModel = Utilities.open(model);
                if(newModel != null){ setModel(newModel);}
            }
            else if(cmmd.equals("New")){
                model.setUnsavedChanges(true);
                Utilities.saveChanges(model);
                setModel(factory.makeModel());
            }
            else if(cmmd.equals("Quit")){
                Utilities.saveChanges(model);
                System.exit(0);
            }
            else if(cmmd.equals("About")){
                Utilities.inform(factory.about());
            }
            else if(cmmd.equals("Help")){
                Utilities.inform(factory.getHelp());
            }
            else{
                Command c = factory.makeEditCommand(model, cmmd, ae.getSource());
                c.execute();
            }
        }
        catch (Exception ex) {
            Utilities.error(ex);
        }
    }

    public void update(){}
}
