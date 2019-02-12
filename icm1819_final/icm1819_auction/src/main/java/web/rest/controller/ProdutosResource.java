/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.rest.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import domain.entity.Produto;
import domain.repository.ProdutoRepository;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import web.rest.exception.ResourceNotFoundException;

/**
 *
 * @author IberISEL
 */
@RestController()
@RequestMapping("/rest/produtos")
public class ProdutosResource {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutosResource(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("")
    public List<Produto> retrieveAllStudents() {

        Iterator<Produto> prodsIterator = produtoRepository.findAll().iterator();
        
        List<Produto> list = new ArrayList<Produto>();
        prodsIterator.forEachRemaining(list::add);
        
        return list;
    }

    @GetMapping("{id}")
    public Resource<Produto> retrieveStudent(@PathVariable long id) {
        Optional<Produto> prods = produtoRepository.findById(id);

        if (!prods.isPresent()) {
            throw new ResourceNotFoundException("id-" + id);
        }

        Resource<Produto> resource = new Resource<>(prods.get());

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllStudents());

        resource.add(linkTo.withRel("all-produtos"));

        return resource;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        produtoRepository.deleteById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> createStudent(@RequestBody Produto student) {
        Produto savedStudent = produtoRepository.save(student);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Produto> update(@RequestBody Produto prod, @PathVariable long id) {

        Optional<Produto> studentOptional = produtoRepository.findById(id);

        if (!studentOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        prod.setId(id);

        produtoRepository.save(prod);

        return ResponseEntity.noContent().build();
    }
}
