package design_patterns.creational.builder.exercise_003;

public class EnterpriseWebsiteBuilder extends WebsiteBuilder {
    @Override
    public void buildName() {
        website.setName("Enterprise project");
    }

    @Override
    public void buildCms() {
        website.setCms(Cms.ALIFRESCO);
    }

    @Override
    public void buildPrice() {
        website.setPrice(50000);
    }
}
