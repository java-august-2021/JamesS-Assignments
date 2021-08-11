import java.util.HashMap;
public class SongHash {
    public static void main(String[] args) {
        HashMap<String, String> songMap = new HashMap<String, String>();
        songMap.put("Rock Song","'I love rock and roll!'");
        songMap.put("Love Song","'Have you ever wanted to fall in love?'");
        songMap.put("Sad Song","'No one likes to be sad and cry over a song.'");
        songMap.put("Fun Song","'Shake it like you mean it!'");

        // Challange: One
        System.out.println(songMap.get("Rock Song"));
        
        // Challange: Two
        for(String song : songMap.keySet()){
            System.out.println(song + " : " + songMap.get(song));
        }
    }
    
}
