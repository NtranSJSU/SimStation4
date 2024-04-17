package pdtournament;

import mvc.Utilities;

import java.io.Serializable;
/*
Date: 4/16/2024
Name: Nhat Tran
Update: Implementing Strategy.java
 */
abstract class Strategy implements Serializable {

    Prisoner prisoner;

    abstract boolean cooperate();

    void setPrisoner(Prisoner prisoner){
        this.prisoner = prisoner;
    }
}

class Cooperate extends Strategy{
    @Override
    boolean cooperate(){
        return true;
    }
}

class Cheat extends Strategy{
    @Override
    boolean cooperate(){
        return false;
    }
}

class RandomlyCooperate extends Strategy{
    @Override
    boolean cooperate(){
        int random = Utilities.rng.nextInt(2);
        return (random == 0);
    }
}

class Tit4Tat extends Strategy{
    @Override
    boolean cooperate(){
        return prisoner.cooperate();
    }
}
