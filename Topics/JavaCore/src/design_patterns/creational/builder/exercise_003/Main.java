package design_patterns.creational.builder.exercise_003;

public class Main {
    public static void main(String[] args) {
        WebsiteBuilder websiteBuilder = new VisitCardWebsiteBuilder();
        Director director = new Director();
        director.setWebsiteBuilder(websiteBuilder);
        Website website = director.buildWebsite();
        System.out.println(website);
    }
}
