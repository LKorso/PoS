package com.epam.pos.com.epam.pos.comands;

import com.epam.pos.BeverageMachine;

public class CancelSaleCommand extends Command {
    public CancelSaleCommand(BeverageMachine machine) {
        super(machine);
    }

    public void doAction() {
        getMachine().restartSale();
        System.out.println("Purchase was canceled!");
    }
}
