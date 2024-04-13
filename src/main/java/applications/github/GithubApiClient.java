package applications.github;

import applications.ApiClient;
import config.Config;

import java.net.HttpURLConnection;

public class GithubApiClient extends ApiClient {
    public GithubApiClient(Config configProvider) {
        super(configProvider);
    }

    public String getToken(){
        return ""; //current approach with my own token
        //rewrite
    }

    protected void setRequestHeaders(HttpURLConnection connection){
        connection.setRequestProperty("Accept", "application/vnd.github+json");
        connection.setRequestProperty("X-GitHub-Api-Version", "2022-11-28");
    }

    //TODO
    //create sub classes for each object (repository, user etc)
}
