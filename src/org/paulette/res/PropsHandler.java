package org.paulette.res;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class PropsHandler {

    public static void createProperties(String token, boolean logUser){
        Properties props = new Properties();

        try{
            props.setProperty("bot_token", token);
            props.setProperty("LogUserMessages", String.valueOf(logUser));

            File configFile = new File("config.properties");
            FileWriter writer = new FileWriter(configFile);
            props.store(writer, "server settings");
            System.out.println("created config file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readToken(){
        String token = "";
        File configFile = new File("config.properties");
        try{
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
            token = props.getProperty("bot_token");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return token;
    }

    public static boolean readLogUser(){
        boolean logUser = false;
        File configFile = new File("config.properties");
        try{
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
            logUser = Boolean.parseBoolean(props.getProperty("LogUserMessages"));
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return logUser;
    }
}
