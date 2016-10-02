package com.epam.pos.com.epam.pos.comands;

import com.epam.pos.BeverageMachine;

public abstract class Command {
    private static BeverageMachine machine;

    public Command(BeverageMachine machine){
        this.machine = machine;
    }

    public abstract void doAction();

    protected static BeverageMachine getMachine(){
        return machine;
    }
}