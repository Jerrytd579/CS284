/*
 * RockBand.java
 * Andrew Chuah
 * I pledge my honor that I have abided by the Stevens Honor System.
 */

package assign3;
import cos126.StdDraw;
import cos126.StdAudio;
import java.io.IOException;
import java.util.ArrayList;

public class RockBand {

    String guitarBassKeyboard ="`1234567890-=qwertyuiop[]\\asdfghjkl;'";
    String pianoKeyboard = "~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"";
    String drumKeyboard = "ZXCVBNM<>?zxcvbnm,.";
  
    public static void main(String[] args) {
        Instrument[] orchestra = new Instrument[4];
        orchestra[0] = new Guitar(37);
        orchestra[1] = new Piano(37);
        orchestra[2] = new Bass(37);
        orchestra[3] = new Drum(19);

        RockBand string = new RockBand();
        boolean LowMode = false;

        while(true){
            if(StdDraw.hasNextKeyTyped()){
                char key = StdDraw.nextKeyTyped();
                int GBK = string.guitarBassKeyboard.indexOf(key);
                int DK = string.drumKeyboard.indexOf(key);
                int PK = string.pianoKeyboard.indexOf(key);

                if(Character.toString(key).equals("\n"))
                    LowMode = !LowMode;

                if(GBK != -1 && DK == -1 && PK == -1){
                    if(LowMode == true) {
                        orchestra[2].playNote(GBK);
                    }
                    else {
                        orchestra[0].playNote(GBK);
                    }
                }
                else if(GBK == -1 && DK != -1 && PK == -1){
                    orchestra[3].playNote(DK);
                }
                else if(GBK == -1 && DK == -1 && PK != -1){
                    orchestra[1].playNote(PK);
                }
            }
            double sumOfAllInstrumentSamples = 0;
            sumOfAllInstrumentSamples += orchestra[2].ringNotes();
            sumOfAllInstrumentSamples += orchestra[0].ringNotes();
            sumOfAllInstrumentSamples += orchestra[3].ringNotes();
            sumOfAllInstrumentSamples += orchestra[1].ringNotes();

            StdAudio.play(sumOfAllInstrumentSamples);
        }
    }
}
