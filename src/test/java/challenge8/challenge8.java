package challenge8;


import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pagesObject.homePage;


import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class challenge8 {

    @BeforeSuite
    public void startSuite() throws Exception {
    }

    @AfterSuite
    public void stopSuite() throws Exception {

    }

    @BeforeClass
    public void startClass() throws Exception {


    }

    @AfterClass
    public void stopClass() {

    }

    @BeforeMethod()
    public void beforeMethod() throws Exception {
    }

    @AfterMethod()
    public void afterMethod() {
    }

    @Test()
    public void Challenge8() throws Exception {
//        HttpURLConnection connection = null;
//        try {
//            //Create connection
//            URL url = new URL("https://www.copart.com/public/lots/search");
//            CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
//
//            connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("query", "Toyota camry");
//
//            connection.setRequestProperty("Content-Length", "");
//            connection.setRequestProperty("Content-Language", "en-US");
//            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");
//            connection.setUseCaches(false);
//            connection.setDoOutput(true);
//
//            //Send request
//            DataOutputStream wr = new DataOutputStream (
//                    connection.getOutputStream());
//
//            wr.close();
//
//            //Get Response
//            InputStream is = connection.getInputStream();
//            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
//            String line;
//            while ((line = rd.readLine()) != null) {
//                response.append(line);
//                response.append('\r');
//            }
//            rd.close();
//            String data = response.toString();
//            System.out.println("All done!!!");
//            //JSONObject jsonObj = new JSONObject(data);
//            System.out.println(data);
//             String rwefdg;
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(e.toString());
//        }
//       }
        var values = new HashMap<String, String>() {{
            put("query", "toyota");
        }};

        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(values);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.copart.com/public/lots/search"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());




    }
}
