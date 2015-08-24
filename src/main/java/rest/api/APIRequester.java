package rest.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by root on 24/08/15.
 */
public class APIRequester {

    public APIResponse doRequest(String stringUrl) throws IOException {
        URL url = new URL(stringUrl);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String temp;
        StringBuilder sb = new StringBuilder();
        while((temp =  br.readLine()) != null){
            sb.append(temp);
        }
        return new APIResponse(sb.toString());
    }

}
