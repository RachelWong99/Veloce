import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RequestTest {
    public static void main(String[] args) throws Exception {
        //System.out.println(getRides("Simonkrol11@gmail.com"));
        postRides("Simonkrol11@gmail.com", "Toronto", "2018-02-24 23:14:53", "Hyperloop");
    }

    public static String getRides(String email) throws Exception {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{ \n\t\"query\": \n\t\t\"{users{rides{startL endL startT endT transForm }}}\", \n\t\"variables\": \""+email+"\"\n}");
        Request request = new Request.Builder()
        .url("https://htvtest.herokuapp.com/query")
        .post(body)
        .addHeader("content-type", "application/json")
        .addHeader("cache-control", "no-cache")
        .addHeader("postman-token", "b254e35e-1fcc-086a-804b-127c70ac7de5")
        .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static void postRides(String email, String location, String time, String transForm) throws Exception {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{ \n\t\"user_email\": \""+email+"\",\n\t\"ride\": {\n                \"location\": \""+location+"\",\n                \"time\": \""+time+"\",\n                \"transForm\": \""+transForm+"\"\n            }\n}");
        Request request = new Request.Builder()
        .url("https://htvtest.herokuapp.com/api")
        .post(body)
        .addHeader("content-type", "application/json")
        .addHeader("cache-control", "no-cache")
        .addHeader("postman-token", "a847799f-4e16-27d9-7819-188268a18393")
        .build();

        Response response = client.newCall(request).execute();
    }
}