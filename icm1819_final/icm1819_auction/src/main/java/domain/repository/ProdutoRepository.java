/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.repository;

import domain.entity.Produto;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pauloborges
 */
@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long>{
    
    public List<Produto> findByTitle(String title);

    //public List<Projecto> findByCategoria(Projecto.ProjectoStatus projectoStatus);
}
