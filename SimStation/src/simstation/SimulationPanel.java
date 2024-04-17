package simstation;

import mvc.AppFactory;
import mvc.AppPanel;
import mvc.Model;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/*
Date: 4/15/2024
Name: Nhat Tran
Update: Fixed Panel to show buttons in a straight column
 */
public class SimulationPanel extends AppPanel {
    private JButton start, suspend, resume, stop, stats;

    public SimulationPanel(AppFactory factory) {
        super(factory);

        controlPanel.setLayout(new GridLayout(5,1));

        JPanel startPanel = new JPanel();
        start = new JButton("Start");
        start.addActionListener(this);
        startPanel.add(start);
        controlPanel.add(startPanel);

        JPanel suspendPanel = new JPanel();
        suspend = new JButton("Suspend");
        suspend.addActionListener(this);
        suspendPanel.add(suspend);
        controlPanel.add(suspendPanel);

        JPanel resumePanel = new JPanel();
        resume = new JButton("Resume");
        resume.addActionListener(this);
        resumePanel.add(resume);
        controlPanel.add(resumePanel);

        JPanel stopPanel = new JPanel();
        stop = new JButton("Stop");
        stop.addActionListener(this);
        stopPanel.add(stop);
        controlPanel.add(stopPanel);

        JPanel statsPanel = new JPanel();
        stats = new JButton("Stats");
        stats.addActionListener(this);
        statsPanel.add(stats);
        controlPanel.add(statsPanel);
    }

    public void setModel(Model m) {
        super.setModel(m); // calling AppPanel.setModel(m)
        Simulation s = (Simulation)m;
        Iterator<Agent> it = s.agents.iterator();
        while(it.hasNext()) {
            Thread t = new Thread(it.next());
            t.start(); // this will call Agent.run (see below)
        }
    }

}
