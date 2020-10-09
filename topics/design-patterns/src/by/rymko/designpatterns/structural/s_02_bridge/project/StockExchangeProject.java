package by.rymko.designpatterns.structural.s_02_bridge.project;

import by.rymko.designpatterns.structural.s_02_bridge.developer.Developer;

public class StockExchangeProject extends Project {

    public StockExchangeProject(Developer developer) {
        super(developer);
    }

    @Override
    public void developProject() {
        System.out.println("Developing Stock Exchange Project.");
        developer.writeCode();
    }
}
