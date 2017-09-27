import org.paulette.res.PropsHandler;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.File;

public class Main {

    public static void main (String[] args){
        ApiContextInitializer.init();
        initializeServer();
        registerBots();
    }

    private static void initializeServer(){

        if(new File("config.properties").isFile()){
            System.out.println("Welcome Back");
        }else{
            PropsHandler.createProperties("", false);
            System.out.println("Created config.properties.... Please enter BotToken to connect to Telegram");
            System.exit(0);
        }
    }

    private static void registerBots(){
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try{
            botsApi.registerBot(new Paulette());
            System.out.println("Success! BotServer connected to Telegram Server");
        } catch (TelegramApiException e) {
            System.out.println("Unable to connect to Telegram Server. Please check BotToken and Internet Settings");
        }
    }
}
