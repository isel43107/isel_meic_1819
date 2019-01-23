/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.services;

import domain.entity.Projecto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author pauloborges
 */
public interface ProjectoService {
    
    public Page<Projecto> getProjectos(Pageable pageable);
}
