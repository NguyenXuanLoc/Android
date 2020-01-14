package com.example.locdaika.adidi.Direction;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TaskRequestDirection extends AsyncTask<String, Void, String> {
    private String requestDirection(String requrl) throws IOException {
        String reponseString = "";
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(requrl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            // Get Result
            inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            reponseString = stringBuffer.toString();
            inputStreamReader.close();

        } catch (java.io.IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            httpURLConnection.disconnect();
        }
        return reponseString;
    }

    @Override
    protected String doInBackground(String... strings) {
        String responString = "";
        try {
            responString = requestDirection(strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responString;
    }

    // Result Json
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }
}
