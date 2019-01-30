/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.portal.controller;

import domain.entity.Produto;
import domain.entity.Projecto;
import domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author pauloborges
 */
@Controller
@RequestMapping("/produtos")
public class ProdutosController {
    
    private final ProdutoRepository produtoRepository;
    
    @Autowired
    public ProdutosController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }
    
    @RequestMapping(value = "/listar1", method = RequestMethod.GET)
    public String listarProjectosPage(Pageable pageable, Model model) {
        Page<Produto> projectos = produtoRepository.findAll(pageable);

        int pageSize = pageable.getPageSize();
        int current = projectos.getNumber() + 1;
        int begin = Math.max(1, current * pageSize);
        int end = Math.min(begin + pageSize, projectos.getTotalPages());

        model.addAttribute("produtos", projectos.getContent());
        model.addAttribute("beginIndex", begin);                        //paginBeginIndex
        model.addAttribute("endIndex", end);                            //paginEndIndex
        model.addAttribute("currentIndex", current);                    //paginCurrentIndex
        model.addAttribute("totalPages", projectos.getTotalPages());    //paginTotalPages

        return "produtos/listar_produtos";
    }
}
