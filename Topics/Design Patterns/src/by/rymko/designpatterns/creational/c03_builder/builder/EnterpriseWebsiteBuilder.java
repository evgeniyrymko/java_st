package by.rymko.designpatterns.creational.c03_builder.builder;

import by.rymko.designpatterns.creational.c03_builder.website.Cms;

public class EnterpriseWebsiteBuilder extends WebsiteBuilder {

    @Override
    public void buildName() {
        website.setName("Enterprise");
    }

    @Override
    public void buildCms() {
        website.setCms(Cms.ALIFRESCO);
    }

    @Override
    public void buildPrice() {
        website.setPrice(10000);
    }
}
