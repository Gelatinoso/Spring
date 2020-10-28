package com.ivan.utils;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;

public class PropertiesReader {

    @Autowired
    Environment environment;

    public String HTTP_URL = "";
    public String SERVICE_NAME = environment.getProperty("service_name");

}
