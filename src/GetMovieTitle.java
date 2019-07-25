//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//
//public class GetMovieTitle {
//    /*
//     * Complete the function below.
//     */
//
//    public static String[] getMovieTitles(String substr) {
//
//        String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";
//        List<String> movies = new ArrayList<>();
//        try {
//            String response = getResponseString(url + substr);
//            JsonParser jsonParser = new JsonParser();
//            JsonElement rootNode = jsonParser.parse(response);
//
//            JsonObject details = rootNode.getAsJsonObject();
//
//            JsonElement totalMovies = details.get("total");
//            System.out.println(totalMovies.toString());
//
//            JsonElement totalPages = details.get("total_pages");
//            System.out.println(totalPages.toString());
//
//            int currentPage = 0;
//            while (currentPage++ < Integer.parseInt(totalPages.toString())) {
//                nextPage(movies, currentPage, substr);
//            }
//            Collections.sort(movies);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String[] result = new String[movies.size()];
//        return movies.toArray(result);
//
//    }
//
//    public static void nextPage(List<String> movies, int currentPage, String substr) {
//        try {
//            final String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";
//            String response = getResponseString(url + substr + "&page=" + currentPage);
//            JsonParser parser = new JsonParser();
//            JsonElement rootNode = parser.parse(response);
//
//            JsonObject details = rootNode.getAsJsonObject();
//            JsonElement data = details.get("data");
//            JsonArray jsonArray = data.getAsJsonArray();
//            for (JsonElement each : jsonArray) {
//                JsonObject titleObject = each.getAsJsonObject();
//                String title = titleObject.get("Title").getAsString();
//                movies.add(title);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static String getResponseString(String url) {
//
//        StringBuffer response = new StringBuffer();
//        try {
//            URL url1 = new URL(url);
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();
//            httpURLConnection.setRequestMethod("GET");
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                response.append(line);
//            }
//            bufferedReader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return response.toString();
//    }
//
//    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//        String[] res;
//        String _substr;
//        try {
//            _substr = in.nextLine();
//        } catch (Exception e) {
//            _substr = null;
//        }
//
//        res = getMovieTitles(_substr);
//        for(int res_i=0; res_i < res.length; res_i++) {
//            bw.write(String.valueOf(res[res_i]));
//            bw.newLine();
//        }
//
//        bw.close();
//    }
//}
