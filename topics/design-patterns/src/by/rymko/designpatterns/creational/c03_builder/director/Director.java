package by.rymko.designpatterns.creational.c03_builder.director;

import by.rymko.designpatterns.creational.c03_builder.builder.WebsiteBuilder;
import by.rymko.designpatterns.creational.c03_builder.website.Website;

public class Director {

    private WebsiteBuilder builder;

    public void setBuilder(WebsiteBuilder builder) {
        this.builder = builder;
    }

    public Website buildWebsite() {
        builder.createWebsite();
        builder.buildName();
        builder.buildCms();
        builder.buildPrice();
        Website website = builder.getWebsite();
        return website;
    }
}
