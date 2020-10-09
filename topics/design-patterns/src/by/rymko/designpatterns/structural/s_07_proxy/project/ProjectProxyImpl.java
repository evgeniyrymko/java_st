package by.rymko.designpatterns.structural.s_07_proxy.project;

public class ProjectProxyImpl implements Project {

    private String url;

    private ProjectImpl project;

    public ProjectProxyImpl(String url) {
        this.url = url;
    }


    @Override
    public void run() {
        if (project == null) project = new ProjectImpl(url);
        project.run();
    }
}
