package com.example.jhjun.clook.util;

import android.os.AsyncTask;
import android.util.Log;

import com.example.jhjun.clook.UrlSettingPack.UrlSetting;

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

    public static String getData(String url, String method, String appKey ) throws IOException {

        StringBuilder result =  new StringBuilder();
        URL serverUrl = new URL(url);
        HttpURLConnection con = (HttpURLConnection) serverUrl.openConnection();

        con.setRequestMethod(method); // 요청 방식 정의.
        con.setRequestProperty("appKey",appKey); // RequestProperty : 헤더 정의

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String temp = null;
            while ((temp = br.readLine()) != null) {
                result.append(temp);  // result에는
            }
        } else {
            Log.e("NETWORK", "Error_code" + responseCode);
        }
        return result.toString();
    }



    public static void newTask(final String url, final TaskInterface taskInterface) {

        new AsyncTask<String, Void, String>() {  // 2. 첫번째 인자로 주소가 들어간다. / 3번째 인자는 Background작업후 반환 값

            @Override
            protected String doInBackground(String... params) {
                String result1 = "";
                try {                           // params[0] = 요청 주소.
                    result1 = getData(params[0],"GET","d0e28214-c90f-3321-90df-937a16c25fa7");  // 3. 위에 getData() 메소드 결과를 result 변수에 저장.
                    // result[1] = getData(params[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return result1;   // String AsyncTask<> 인자에 정의되있음.
            }

            @Override
            protected void onPostExecute(String result) {
                taskInterface.execute(result, url);  // 4. result를 MainActivity클래스에서 사용할 수 있게 됨. -> jsonString 변수로 받음.
            }
        }.execute(url); // 1. MainActivity 클래스에서 getUrl() 하여 API 요청 주소를 가져온다.
    }  //
}