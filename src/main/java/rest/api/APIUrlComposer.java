package rest.api;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by root on 24/08/15.
 */
public class APIUrlComposer {

    private HashMap<String, String> params;
    private String baseUrl = "http://api.ean.com/ean-api/rs/hotel/v3/";
    private final String CID = "495351", API_KEY = "5on9p6ih77nlsnbo8kaqfe6rrq", SECRET = "108nu97uahnhd";
    private String requestType = "";

    public APIUrlComposer(String requestType){
        this.requestType = requestType;
        this.params = new HashMap<String, String>();
        this.params.put("locale", "es_MX");
    }

    public void addParam(String key, String value){
        this.params.put(key, value);
    }

    public String getUrl() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        APISignature signature = new APISignature();
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%s?cid=%s&apiKey=%s&sig=%s",
                this.baseUrl + this.requestType, this.CID, this.API_KEY, signature.getSignature(this.API_KEY, this.SECRET)));

        Set<String> keys = this.params.keySet();
        for(String key : keys){
            builder.append(String.format("&%s=%s", key, this.params.get(key)));
        }
        return builder.toString();
    }

}
