package ge.ani.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.*;

public class GetUsers {
    private final SendRequest sendRequest = new SendRequest();

    public HashMap<String,Object> get_user(String id) throws IOException {
        String response = sendRequest.send_get_request("users/"+id,false);
        JSONObject obj = new JSONObject(response);
        int user_id = obj.getInt("id");
        String name = obj.getString("name");
        String email = obj.getString("email");
        String gender = obj.getString("gender");
        String status = obj.getString("status");
        System.out.println("ID: "+user_id+" Name: "+name+" Email"+email);
        HashMap<String,Object> user = new HashMap<>();
        user.put("name",name);
        user.put("id",user_id);
        user.put("email",email);
        user.put("gender",gender);
        user.put("status",status);
        return user;
    }
    public ArrayList<HashMap<String,Object>>get_users(int page) throws IOException {
        ArrayList<HashMap<String,Object>> users = new ArrayList<>();
        String response = sendRequest.send_get_request("users?page="+page,false);
        JSONArray obj = new JSONArray(response);
        for (int i = 0; i < obj.length(); i++){
            HashMap<String,Object> user = new HashMap<>();
            JSONObject user_obj = obj.getJSONObject(i);
            int user_id = user_obj.getInt("id");
            String name = user_obj.getString("name");
            String email = user_obj.getString("email");
            String gender = user_obj.getString("gender");
            String status = user_obj.getString("status");
            user.put("name",name);
            user.put("id",user_id);
            user.put("email",email);
            user.put("gender",gender);
            user.put("status",status);
            users.add(user);
        }
        return users;
    }
}
