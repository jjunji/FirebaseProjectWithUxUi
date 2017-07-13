package com.example.jhjun.clook.util;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by jhjun on 2017-07-11.
 */

public class Remote {

    public static String[] getData(String url, String url2) throws IOException {
        String gg[] = new String[2];

        String result = "";
        String result2 = "";

        URL serverUrl = new URL(url);
        URL serverUrl2 = new URL(url2);

        HttpURLConnection con = (HttpURLConnection) serverUrl.openConnection();
        HttpURLConnection con2 = (HttpURLConnection) serverUrl2.openConnection();

        con.setRequestMethod("GET"); // 요청 방식 정의.
        con.setRequestProperty("appKey","d0e28214-c90f-3321-90df-937a16c25fa7"); // RequestProperty : 헤더 정의

        con2.setRequestMethod("GET"); // 요청 방식 정의.
        con2.setRequestProperty("appKey","d0e28214-c90f-3321-90df-937a16c25fa7"); // RequestProperty : 헤더 정의

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(con2.getInputStream()));

            String temp = null;
            String temp2 = null;

            while ((temp = br.readLine()) != null) {
                result += temp;  // result에는
            }

            while((temp2 = br2.readLine()) != null){
                result2 += temp2;
            }

            gg[0] = result;
            gg[1] = result2;

        } else {
            Log.e("NETWORK", "Error_code" + responseCode);
        }

        return gg;
    }



    public static void newTask(final TaskInterface taskInterface) {

        new AsyncTask<String, Void, String>() {  // 2. 첫번째 인자로 주소가 들어간다. / 3번째 인자는 Background작업후 반환 값

            String result[] = new String[2];

            @Override
            protected String doInBackground(String... params) {

                Log.i("getUrl","getUrl : ============================" + params[0]);
                Log.i("getUrl","getUrl : ============================" + params[1]);
                Log.i("getUrl","getUrl : ============================" + params[2]);
                Log.i("getUrl","getUrl : ============================" + params[3]);
                //String[] result = new String[4];
                //String result2 = "";
                //String result = "";
                try {                           // params[0] = 요청 주소.
                    result = getData(params[0],params[1]);  // 3. 위에 getData() 메소드 결과를 result 변수에 저장.
                    // result[1] = getData(params[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }

//                Log.e("return","return============" + result[0] + "/" +result[2]);
                return result[0] + "/" + result[1];
            }

            @Override
            protected void onPostExecute(String result) {
                taskInterface.postExecute(result);  // 4. result를 MainActivity클래스에서 사용할 수 있게 됨. -> jsonString 변수로 받음.
            }
        }.execute(taskInterface.getUrl()); // 1. MainActivity 클래스에서 getUrl() 하여 API 요청 주소를 가져온다.
    }  //
}