package simstation;

import java.io.Serializable;

import mvc.Utilities;
import java.awt.Color;
import java.awt.Graphics;

/*
Date: 4/13/2024
Name: Nhat Tran
Update: Implementing Agent.java without Simulation.java
 */
public abstract class Agent implements Serializable, Runnable {

    protected String name;
    protected int xcoord;
    protected int ycoord;
    protected Heading heading;
    protected boolean interrupted = false;
    protected boolean stopped = false;
    transient protected Thread currentThread;
    protected Simulation world;

    public Agent(){
        xcoord = Utilities.rng.nextInt(250);
        ycoord = Utilities.rng.nextInt(250);
    }

    public void setWorld(Simulation s){
       world = s;
    }
    
    public int getX(){
        return xcoord;
    }

    public int getY(){
        return ycoord;
    }

    public synchronized boolean isStopped(){
        return stopped;
    }

    public synchronized boolean isSuspended(){
        return interrupted;
    }

    public synchronized void checkSuspended() {
        try{
            while(!stopped && interrupted) {
                wait();
                interrupted = false;
            }
        } catch (InterruptedException e) {
            Utilities.error(e);
        }
    }

    @Override
    public void run() {
        currentThread = Thread.currentThread();
        checkSuspended();
        while ( !isStopped()){
            try {
                update();
                Thread.sleep(20);
                checkSuspended();
            } catch (InterruptedException e){
                Utilities.error(e);
            }
        }
    }

    public synchronized  void start() {
        interrupted = false;
        stopped = false;
    }
    public synchronized void interrupt(){
        interrupted = true;
    }

    public synchronized void resume(){
        notify();  
    }

    public synchronized void stop(){
        stopped = true;
    }

    public abstract void update();
    
    public synchronized void move(int steps) {
		switch(heading) {
			case NORTH:{
				ycoord -= steps;
				if (ycoord < 0) { ycoord += 250; }
				break;
			}
			case SOUTH:{
				ycoord += steps;
				if (ycoord > 250) { ycoord -= 250; }
				break;
			}
			case EAST: {
				xcoord += steps;
				if (xcoord > 250) { xcoord -= 250; }
				break;
			}
			case WEST:{
				xcoord -= steps;
				if (xcoord < 0) { xcoord += 250; }
				break;
			}
			case NORTHWEST:{
				ycoord -= steps;
				xcoord -= steps;
				if (ycoord < 0) { ycoord += 250; }
				if (xcoord < 0) { xcoord += 250; }
				break;
			}
			case NORTHEAST:{
				ycoord -= steps;
				xcoord += steps;
				if(ycoord < 0) { ycoord += 250; }
				if (xcoord > 250) { xcoord -= 250; }
				break;
			}
			case SOUTHWEST:{
				ycoord += steps;
				xcoord -= steps;
				if (ycoord > 250) { ycoord -= 250; }
				if (xcoord < 0) { xcoord += 250; }
				break;
			}
			case SOUTHEAST:{
				ycoord += steps;
				xcoord += steps;
				if (ycoord > 250) { ycoord -= 250; }
				if (xcoord > 250) { xcoord -= 250; }
				break;
			}
		}
		world.changed();
	}
    public synchronized void join() {
        try{
            if(currentThread != null) {
                currentThread.join();
            }
        } catch(InterruptedException e) {
            Utilities.error(e);
        }
    }

    public synchronized void draw (Graphics gc) {
		gc.setColor(Color.white);
		gc.drawRect(xcoord, ycoord, 2, 2);
	}
}
