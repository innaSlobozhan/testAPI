package applications;

import config.Config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class ApiClient {

    private Config configProvider;

    public ApiClient(Config configProvider) {
        this.configProvider = configProvider;
    }

    protected Config getConfigProvider(){
        return configProvider;
    }

    protected abstract String getToken(); //each app has its own auth

    public String sendGet(String givenUrl) throws IOException {
        URL url = new URL(givenUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        String token = getToken();
        connection.setRequestProperty("Authorization", "Bearer " + token);
        setRequestHeaders(connection);
        connection.setRequestMethod("GET");

        int status = connection.getResponseCode();

        if (status == 200){
            return connection.getResponseMessage(); //TODO deseriliaze getContent
        } else {
            return null;
        }
    }

    //same for POST and others
    protected void setRequestHeaders(HttpURLConnection connection){
        return;
    }
}
