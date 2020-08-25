package by.rymko.designpatterns.creational.c03_builder.builder;

import by.rymko.designpatterns.creational.c03_builder.website.Website;

public abstract class WebsiteBuilder {

    Website website;

    public void createWebsite() {
        website = new Website();
    }

    public abstract void buildName();

    public abstract void buildCms();

    public abstract void buildPrice();

    public Website getWebsite() {
        return website;
    }
}
