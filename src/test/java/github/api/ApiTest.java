package github.api;

import applications.github.GithubApiClient;
import config.Config;
import org.junit.jupiter.api.Test;

import javax.xml.transform.Result;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiTest {
    private Config provider = new Config();
    private GithubApiClient githubApiClient = new GithubApiClient(provider);

    @Test
    public void testSearchRepositories() throws IOException {
        String response = githubApiClient.sendGet("https://api.github.com/search/repositories?q=Q"); //need to rewrite to not call sendGet
        assertTrue(response.contains("OK"));
    }
}
