/**
 * ISEL - MEIC - Engenharia de Software 2018/2019
 * Trabalho 01 - Torniquete
 *
 * 44442 (João Costa)
 * 43107 (Paulo Borges)
 *
 * FONTE: https://stackoverflow.com/questions/3780406/how-to-play-a-sound-alert-in-a-java-application
 *
 */
package isel.es1819.jp.torniquete.impl3.utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

public class SoundUtils {

    public static float SAMPLE_RATE = 8000f;

    public static void tone(int hz, int msecs) {
        tone(hz, msecs, 1.0);
    }

    public static void tone(int hz, int msecs, double vol) {
        try {
            byte[] buf = new byte[1];
            AudioFormat af
                    = new AudioFormat(
                            SAMPLE_RATE, // sampleRate
                            8, // sampleSizeInBits
                            1, // channels
                            true, // signed
                            false);      // bigEndian
            SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
            sdl.open(af);
            sdl.start();
            for (int i = 0; i < msecs * 8; i++) {
                double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
                buf[0] = (byte) (Math.sin(angle) * 127.0 * vol);
                sdl.write(buf, 0, 1);
            }
            sdl.drain();
            sdl.stop();
            sdl.close();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void testarBIP(){
        try {
            SoundUtils.tone(1000, 100);
            Thread.sleep(1000);
            SoundUtils.tone(100, 1000);
            Thread.sleep(1000);
            SoundUtils.tone(5000, 100);
            Thread.sleep(1000);
            SoundUtils.tone(400, 500);
            Thread.sleep(1000);
            SoundUtils.tone(400, 500, 0.2);
        } catch (InterruptedException ex) {
            Logger.getLogger(SoundUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
