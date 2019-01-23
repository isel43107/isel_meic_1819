/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.services.impl;

import domain.entity.Projecto;
import domain.repository.ProjectoRepository;
import domain.services.ProjectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pauloborges
 */
@Service
@Transactional
public class ProjectoServiceImpl implements ProjectoService{

    @Autowired
    private final ProjectoRepository projectoRepository;

    public ProjectoServiceImpl(ProjectoRepository projectoRepository) {
        this.projectoRepository = projectoRepository;
    }
    
    @Override
    public Page<Projecto> getProjectos(Pageable pageable) {
        return projectoRepository.findAll(pageable);
    }
    
}
