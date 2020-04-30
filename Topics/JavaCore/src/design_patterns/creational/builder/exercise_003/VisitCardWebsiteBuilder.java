package design_patterns.creational.builder.exercise_003;

public class VisitCardWebsiteBuilder extends WebsiteBuilder {

    @Override
    public void buildName() {
        website.setName("Visit Card");
    }

    @Override
    public void buildCms() {
        website.setCms(Cms.WORDPRESS);
    }

    @Override
    public void buildPrice() {
        website.setPrice(1000);
    }
}
