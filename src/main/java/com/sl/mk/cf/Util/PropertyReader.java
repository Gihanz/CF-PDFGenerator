package com.sl.mk.cf.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class PropertyReader
{/*
  String appPath;
  
  public PropertyReader()
    throws Exception
  {
    this.appPath = getAppPath();
  }
  
  public String getAppPath()
  {
    return "C:/Users/gihanli/Desktop/CreatePDF/config.properties";
  }
  
  public Properties loadPropertyFile()
    throws Exception
  {
    try
    {
      Properties props = new Properties();
      FileInputStream fis = new FileInputStream(this.appPath);
      props.load(fis);
      fis.close();
      return props;
    }
    catch (Exception e)
    {
      e.fillInStackTrace();
      throw new Exception(e);
    }
  }
  
  public static String getProperty(Properties props, String propertyName)
    throws Exception
  {
    try
    {
      String propertyValue = (String)props.get(propertyName);
      if (propertyValue == null) {
        throw new Exception("Property " + propertyName + " is not define in loaded *.properties file");
      }
      return propertyValue;
    }
    catch (Exception e)
    {
      throw e;
    }
  }
  
  public static void loadLogConfiguration(String logPropertyFile, String logFilePath)
  {
    Properties logProperties = new Properties();
    try
    {
      FileInputStream fis = new FileInputStream(logPropertyFile);
      logProperties.load(fis);
      fis.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Warning : " + e);
    }
    catch (IOException e)
    {
      System.out.println("Warning : " + e);
    }
    logProperties.setProperty("log4j.appender.A1.File", logFilePath);
    PropertyConfigurator.configure(logProperties);
  }
  
  public static void loadLogConfiguration(String logPropertyFile, String logFilePath, String logFileName)
  {
    Properties logProperties = new Properties();
    try
    {
      FileInputStream fis = new FileInputStream(logPropertyFile);
      logProperties.load(fis);
      fis.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Warning : " + e);
    }
    catch (IOException e)
    {
      System.out.println("Warning : " + e);
    }
    File file = new File(logFilePath);
    file.mkdirs();
    String logFile = logFilePath + "\\" + logFileName;
    logProperties.setProperty("log4j.appender.A1.File", logFile);
    PropertyConfigurator.configure(logProperties);
  }
  
  public static void loadLogConfiguration(String logPropertyFile)
  {
    Properties logProperties = new Properties();
    try
    {
      FileInputStream fis = new FileInputStream(logPropertyFile);
      logProperties.load(fis);
      fis.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Warning : " + e);
    }
    catch (IOException e)
    {
      System.out.println("Warning : " + e);
    }
    PropertyConfigurator.configure(logProperties);
  }
  
  public static void main(String[] args)
  {
    try
    {
      PropertyReader propReader = new PropertyReader();
      propReader.loadPropertyFile();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
*/}

