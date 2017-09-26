import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Paulette extends TelegramLongPollingBot{

    /*
    * onUpdateReceived(Update update) ist die Methode, die aufgerufen wird, wenn Paulette eine Nachricht empfängt.
    */
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            //TODO
        }
    }

    @Override
    public String getBotUsername() {
        return "Paulette";
    }

    /*
    * botToken muss, wie der Name schon andeutet, den BotToken deines Bots speichern.
    * BotToken gibt es beim Botfather
    *
    */

    @Override
    public String getBotToken() {
        //TODO
        String botToken = "";
        return botToken;
    }

    /*
    * Hab dir hier noch ne Methode implementiert dir eine neue Nachricht versendet
    * @param chat_id ChatId, an die die Nachricht verschickt werden soll
    * @param text Der Text, den die Nachricht enthalten soll
    */

    private void sendMessage(long chat_id, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chat_id);
        message.setText(text);
        try{
            sendMessage(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
