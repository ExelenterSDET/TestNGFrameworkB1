package com.exelenter.utils;

public class Constants {
    public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver";
    public static final String GECKO_DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver";
    public static final String CONFIGURATION_FILEPATH = System.getProperty("user.dir") + "/src/test/resources/configs/configuration.properties";
    public static final int IMPLICIT_WAIT_TIME = 15;
    public static final int EXPLICIT_WAIT_TIME = 40;
    public static final String TESTDATA_FILEPATH = System.getProperty("user.dir") + "/src/test/resources/testdata/ExelenterEmployeesList.xlsx";

}
