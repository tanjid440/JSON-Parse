/**
 * The constructor simply recieves the URL as argument and pass it to
 * jsonToString() method. This method fetches the json data from web
 * and stores the whole data as a single String in the global data 
 * variable. The constructor also creates an array named jsonObjects
 * containing the data of that json object and trims down all the special
 * characters. getData() method then recieves a string and finds it in the
 * array and immidiately returns the corresponding value.
 * 
 * @author: Tanjid Ahmed
 * @date: 28-08-2019
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonParse {
    
    private String json = "";
    private String[] jsonObjects;
    
    public JsonParse (String url) throws IOException {
        jsonToString(url);
        jsonObjects = json.split(",");
        for (int i = 0; i < jsonObjects.length; ++i) {
            String candidate = jsonObjects[i].replace("{","");
            candidate = candidate.replace("}","");
            candidate = candidate.replace("\"","");
            candidate = candidate.trim();
            jsonObjects[i] = candidate;
        }
    }
    
    private void jsonToString(String webURL) throws IOException {
        URL url = new URL(webURL);
        InputStream is =  url.openStream();
        try( BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                this.json += line+"\n";
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new MalformedURLException("URL is malformed!!");
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }
    }
    
    public String getData(String find) {
        String data = "";
        for (int i = 0; i < jsonObjects.length; ++i) {
            if (jsonObjects[i].contains(find)) {
                data = jsonObjects[i].substring(find.length()+1).trim();
                break;
            }
        }
        return data;
    }
    
}
