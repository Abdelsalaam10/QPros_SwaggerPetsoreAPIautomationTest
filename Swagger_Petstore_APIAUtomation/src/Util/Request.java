package Util;
import org.json.JSONException;
import org.json.JSONObject;

public class Request {




    public static String CreateUser(String Username,int Id, String Firstname, String Lastname, String Email, String Password, String Phone)
            throws JSONException {

        JSONObject requestBodyJson = new JSONObject();

        requestBodyJson.put("id", Id);
        requestBodyJson.put("username", Username);
        requestBodyJson.put("firstName", Firstname);
        requestBodyJson.put("lastName", Lastname);
        requestBodyJson.put("email", Email);
        requestBodyJson.put("password", Password);
        requestBodyJson.put("phone", Phone);

        return requestBodyJson.toString();
    }

    public static String UpdateUser(String Username,int Id, String UpdatedFirstname, String UpdatedLastname, String UpdatedEmail, String UpdatedPassword, String UpdatedPhone)
            throws JSONException {

        JSONObject updateRequestBodyJson = new JSONObject();
        updateRequestBodyJson.put("id", 1);
        updateRequestBodyJson.put("username", Username);
        updateRequestBodyJson.put("firstName", UpdatedFirstname);
        updateRequestBodyJson.put("lastName", UpdatedLastname);
        updateRequestBodyJson.put("email", UpdatedEmail);
        updateRequestBodyJson.put("password", UpdatedPassword);
        updateRequestBodyJson.put("phone", UpdatedEmail);

        return updateRequestBodyJson.toString();
    }

}
