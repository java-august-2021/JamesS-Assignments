import java.sql.Time;
import java.util.Date;

public class AlfredQuotes {
    public String basicGreeting() {
        return "Hello there, lovely to see you.  How are you?";
    }
    
    public String guestGreeting(String name, String dayperiod) {
        return String.format("Good %s %s, Lovely to see you!", dayperiod, name);
    }

    public String dateAnnouncement() {
        Date date = new Date();
        return "The current date is " + date;
    }

    public String respondBeforeAlexis(String conversation) {
        int a = conversation.indexOf("Alexis");
        int b = conversation.indexOf("Alfred");
        if(a >= 0) {
            return "Right away boss, she certainly isn't sophisticated enough for that.";
        }  else if(b >= 0 ) {
            return "At your service, naturally.";
        }  else {
            return "Right. And with that, I shall retire.";
        }
    }


}
