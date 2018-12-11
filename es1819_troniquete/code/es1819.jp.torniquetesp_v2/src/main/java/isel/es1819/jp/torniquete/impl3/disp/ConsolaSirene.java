/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.torniquete.impl3.disp;

import isel.es1819.jp.torniquete.impl3.utils.SoundUtils;
import java.awt.Toolkit;
import org.springframework.stereotype.Component;

/**
 *
 * @author pauloborges
 */
@Component
public class ConsolaSirene implements Sirene{

    @Override
    public void activarAlarme() {
        System.out.println("Activar Alarme"); 
        
        Toolkit.getDefaultToolkit().beep();
        SoundUtils.tone(1000, 1800);
    }

    @Override
    public void desactivarAlarme() {
        System.out.println("Desactivar Alarme"); 
    }
    
}
