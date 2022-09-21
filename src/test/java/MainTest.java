import ge.ani.services.GetUsers;

import java.io.IOException;

public class MainTest {

    public static void main(String[] args) throws IOException {
        String data = "{\"name\":\"Tenali Ramakrishna\", \"gender\":\"male\", \"email\":\"tenali.ramakrishna@shshjaaa.com\", \"status\":\"active\"}";
        try {
            GetUsers getUsers = new GetUsers();
            System.out.println(getUsers.get_users(2));
        }catch (RuntimeException r) {
            System.out.println("Runtime Exception Occurred");
            throw r;
        }
     }
    }

