package by.rymko.designpatterns.creational.c03_builder;

import by.rymko.designpatterns.creational.c03_builder.builder.EnterpriseWebsiteBuilder;
import by.rymko.designpatterns.creational.c03_builder.builder.VisitCardWebsiteBuilder;
import by.rymko.designpatterns.creational.c03_builder.director.Director;
import by.rymko.designpatterns.creational.c03_builder.website.Website;

public class Program {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new VisitCardWebsiteBuilder());
        Website website = director.buildWebsite();
        System.out.println(website);

        director.setBuilder(new EnterpriseWebsiteBuilder());
        Website website1 = director.buildWebsite();
        System.out.println(website1);
    }
}
