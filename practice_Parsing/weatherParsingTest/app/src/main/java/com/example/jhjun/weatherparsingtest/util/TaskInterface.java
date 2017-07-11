package com.example.jhjun.weatherparsingtest.util;

/**
 * Created by jhjun on 2017-07-11.
 */

public interface TaskInterface {  // Remote.class 에서 네트워킹 작업을 수행한 결과를 MainActivity.class 에서 사용하기 위한 인터페이스 -> 중간다리 역할.

    public String getUrl();
    public void postExecute(String url);
}
