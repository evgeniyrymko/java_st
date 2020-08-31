package by.rymko.designpatterns.structural.s_05_facade;

public class Program {
    public static void main(String[] args) {

        Facade facade = new Facade();
        facade.doComplexProcessViaFacade();
    }
}
