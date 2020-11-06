package by.rymko.springasync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(AppRunner.class);

    private final GitHubLookupService gitHubLookupService;

    public AppRunner(GitHubLookupService gitHubLookupService) {
        this.gitHubLookupService = gitHubLookupService;
    }

    @Override
    public void run(String... args) throws Exception {
        long startTime = System.currentTimeMillis();

        CompletableFuture<User> user1 = gitHubLookupService.findUser("PivotalSoftware");
        CompletableFuture<User> user2 = gitHubLookupService.findUser("CloudFoundry");
        CompletableFuture<User> user3 = gitHubLookupService.findUser("Spring-Projects");

        CompletableFuture.allOf(user1, user2, user3);

        LOG.info("Elapsed time: " + (System.currentTimeMillis() - startTime));
        LOG.info("-->" + user1.get());
        LOG.info("-->" + user2.get());
        LOG.info("-->" + user3.get());
        System.out.println("Everything works OK.");
    }
}
