import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;


public class Glossary {

    public URL getUrl(String message) throws MalformedURLException {
        String begin = "https://docs.google.com/spreadsheets/d/e/2PACX-1vQ02zFoTmSVTeZD8SZ24ocWAVhKbTjn2qlVXyJsK5kFMns06nFzcd9d4yLnqcsKig/pub?gid=";
        String end = "&single=true&output=csv";
        String middle = "";
        switch (message){
            case "verb": middle = "1824750361"; break;
            case "adjectives": middle = "15517525"; break;
            case "adverb": middle = "1049149030"; break;
            case "pretext": middle = "1125540101"; break;
            case "conjuction": middle = "871500860"; break;
            default: middle = "893384538"; break;
        }
        return new URL(begin + middle + end);
    }

    public HashMap<String, Integer> getThemes(URL doc) throws IOException {
        HashMap<String, Integer> themes = new HashMap<>();
        URLConnection b = doc.openConnection();
        BufferedReader c = new BufferedReader(new InputStreamReader(b.getInputStream()));
        String str = "";
        String temp = "";
        Integer begin = 0;
        Integer end = 0;
        while ((str = c.readLine()) != null){
            String[] arr = str.split(",");
            if (arr[1].equals("") && end > 0){
                themes.put(temp, end-begin);
                temp = arr[0];
                begin = end + 2;
            }
            if (arr[1].equals("")){
                temp = arr[0];
                begin = end + 2;
            }
            end++;
        }
        return themes;
    }
}
