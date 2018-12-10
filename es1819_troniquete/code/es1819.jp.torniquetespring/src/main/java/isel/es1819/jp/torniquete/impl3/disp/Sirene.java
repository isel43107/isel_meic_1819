/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.torniquete.impl3.disp;

import org.springframework.stereotype.Service;

/**
 *
 * @author pauloborges
 */
@Service
public interface Sirene {
    
    public void activarAlarme();
    public void desactivarAlarme();
}
