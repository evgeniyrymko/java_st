package by.rymko.springasync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class GitHubLookupService {

    private static final Logger LOG = LoggerFactory.getLogger(GitHubLookupService.class);

    private final RestTemplate restTemplate;


    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<User> findUser(String user) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        LOG.info("Method start time: " + (System.currentTimeMillis() - startTime));
        LOG.info("Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        User results = restTemplate.getForObject(url, User.class);
        Thread.sleep(3000);
        LOG.info("Method finish time: " + (System.currentTimeMillis() - startTime));
        return CompletableFuture.completedFuture(results);

    }

}
