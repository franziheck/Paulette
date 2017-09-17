import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Main {

    public static void main (String[] args){
        ApiContextInitializer.init();
        registerBots();
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
