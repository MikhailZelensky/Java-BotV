import java.util.HashMap;

public class Player {
    Integer point;
    String expectedAnswer;
    String lastQuestion;
    String partOfSpeech;
    String theme;
    String lastProgramMessage;
    HashMap<String, String> currentGloss;

    Player(){
        this.point = 0;
        this.expectedAnswer = "";
        this.lastQuestion = "";
        this.theme = "";
        this.partOfSpeech = "";
        this.lastProgramMessage = "";
        this.currentGloss =
    }
}