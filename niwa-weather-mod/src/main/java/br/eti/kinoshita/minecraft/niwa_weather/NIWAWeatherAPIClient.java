package br.eti.kinoshita.minecraft.niwa_weather;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.Level;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class NIWAWeatherAPIClient implements Runnable {

    // TODO: make it a configuration
    private String url = "http://weather.niwa.co.nz/data/hourly/";
    // TODO: make it a configuration
    private String place = "Auckland";
    // TODO: make it a configuration
    private int timeout = 5 * 1000;

    @Override
    public void run() {
        if (NIWAWeatherMod.logger.isDebugEnabled()) {
            NIWAWeatherMod.logger.log(Level.DEBUG,
                    String.format("Getting weather for %s using base URL: %s", this.place, this.url));
        }

        final CloseableHttpClient httpclient = HttpClients.createDefault();
        final HttpGet httpGet = new HttpGet(this.url + this.place);
        final RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(timeout)
                .setConnectTimeout(timeout).setSocketTimeout(timeout).build();
        httpGet.setConfig(requestConfig);

        CloseableHttpResponse response = null;

        String jsonResponse = null;
        try {
            response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            //EntityUtils.consume(entity);
            jsonResponse = EntityUtils.toString(entity);
            if (NIWAWeatherMod.logger.isDebugEnabled()) {
                NIWAWeatherMod.logger.log(Level.DEBUG, String.format("NIWAWeather JSON response: [%s]", jsonResponse));
            }
        } catch (IOException ioe) {
            NIWAWeatherMod.logger.log(Level.WARN, "Failed to execute GET: " + ioe.getMessage(), ioe);
        } finally {
            if (httpclient != null) {
                try {
                    response.close();
                    response = null;
                    // httpclient.close(); // TBD: necessary?
                } catch (IOException ioe) {
                    NIWAWeatherMod.logger.log(Level.WARN, "Failed to close connection: " + ioe.getMessage(), ioe);
                }
            }
        }

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        final String date = sdf.format(Calendar.getInstance().getTime());

        if (StringUtils.isNotBlank(jsonResponse)) {
            final Gson gson = new Gson();
            final JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(jsonResponse).getAsJsonObject();
            String summaries = jsonObject.get("summaries").getAsJsonArray().toString();
            NIWAWeatherResponse[] weatherList = gson.fromJson(summaries, NIWAWeatherResponse[].class);

            for (NIWAWeatherResponse niwaWeatherResponse : weatherList) {
                if (niwaWeatherResponse.getDate().equals(date)) {
                    NIWAWeatherMod.logger.log(Level.INFO, String.format("NIWAWeather summary for %s: [%s]", date,
                            niwaWeatherResponse.toString()));
                    
                    NIWAWeatherMod mod = NIWAWeatherMod.instance;
                    if (mod != null) {
                        mod.weatherToday = niwaWeatherResponse;
                    }
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        NIWAWeatherAPIClient apiClient = new NIWAWeatherAPIClient();
        apiClient.run();
    }

}
