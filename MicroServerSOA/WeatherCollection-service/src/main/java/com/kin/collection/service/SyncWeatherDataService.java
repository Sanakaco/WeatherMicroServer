package com.kin.collection.service;


import java.io.IOException;

public interface SyncWeatherDataService {
    void syncDataByCityid(String cityid) throws IOException;
}
