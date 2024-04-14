package mvc;

import mvc.Subscriber;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class View extends JPanel implements Subscriber {
    protected Model model;


    public View(Model model) {
        super();
        this.model = model;
        model.subscribe(this);
        Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
        setBorder(blackLine);
    }
    public void setModel(Model newModel){
        if(model !=null){
            model.unsubscribe(this);
        }
        this.model = newModel;
        if(newModel != null){
            model.subscribe(this);
            update();
        }

    }
    @Override
    public void update() {
        this.repaint();
    }


}