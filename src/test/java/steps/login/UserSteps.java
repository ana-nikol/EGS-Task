package steps.login;

import ge.ani.services.SendRequest;

import java.io.IOException;

public class UserSteps {
    SendRequest sendRequest = new SendRequest();
    public void get_users() throws IOException {
        sendRequest.send_get_request("users",true);
    }
}
