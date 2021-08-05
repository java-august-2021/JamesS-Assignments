public class AlfredTest {
    public static void main(String[] args) {
        AlfredQuotes alfredBot = new AlfredQuotes();
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("James Otis", "evening");
        String testDateAmmouncement = alfredBot.dateAnnouncement();
        String alexisTest = alfredBot.respondBeforeAlexis("Alexis! Plast some low-fi beats.");
        String alfredTest = alfredBot.respondBeforeAlexis("I Can't find my shoes.  Maybe Alfred will know where they are.");
        String notRelevantTest = alfredBot.respondBeforeAlexis("Maybe that's what Batman is about. Not winning, but failing..");
        System.out.println(testGreeting);
        System.out.println(testGuestGreeting);
        System.out.println(testDateAmmouncement);
        System.out.println(alexisTest);
        System.out.println(alfredTest);
        System.out.println(notRelevantTest);
    }
}
