/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.repository;

import domain.entity.Projecto;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pauloborges
 */
@Repository
public interface ProjectoRepository extends PagingAndSortingRepository<Projecto, Long>{
    
    public Projecto findByProjectoCodigo(String projectoCodigo);

    public List<Projecto> findByProjectoStatus(Projecto.ProjectoStatus projectoStatus);
}
