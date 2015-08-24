package rest.api;

import org.json.JSONObject;

/**
 * Created by root on 24/08/15.
 */
public class APIResponse {

    private JSONObject response;

    public APIResponse(String response){
        this.response = new JSONObject(response);
    }

    public JSONObject getResponse() {
        return response;
    }

    public String toString(){
        return response.toString();
    }

}
