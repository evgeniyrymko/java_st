package by.rymko.designpatterns.structural.s_07_proxy.project;

public class ProjectImpl implements Project {

    private String url;

    private void load() {
        System.out.printf("Loading project from %s.%n", url);
    }

    public ProjectImpl(String url) {
        this.url = url;
        this.load();
    }

    @Override
    public void run() {
        System.out.println("Running real project.");
    }
}
