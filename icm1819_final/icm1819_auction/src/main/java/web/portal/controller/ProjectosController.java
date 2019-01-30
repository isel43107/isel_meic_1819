/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.portal.controller;

import domain.entity.Projecto;
import domain.repository.ProjectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author pauloborges
 */
@Controller
@RequestMapping("/projectos")
public class ProjectosController {

    
    private final ProjectoRepository projectoRepository;
    
    @Autowired
    public ProjectosController(ProjectoRepository projectoRepository){
        this.projectoRepository = projectoRepository;
    }
    

    @RequestMapping(method = RequestMethod.GET)
    public String paginaInicial(Model model) {
        return "redirect:/projectos/listar";
    }

    @GetMapping("/listar")
    public String listarProjectos(
            @RequestParam(value = "q", required = false) String searchQuery, 
            Pageable pageable,
            Model model) {

        //Obter todos os projecto registados na base de dados
        Iterable<Projecto> projectosList = projectoRepository.findAll();
        
        final Page<Projecto> projectosListPage = projectoRepository.findAll(pageable);
        /*
        projectosListPage.getTotalPages();
        projectosListPage.getNumber();
        projectosListPage.getNumberOfElements();
        projectosListPage.getSize();
        projectosListPage.getContent();*/
        /*
        List<Projecto> projectosList = new ArrayList<Projecto>();
        for (Projecto item : projectos) {
            projectosList.add(item);
        }*/
        
        //TODO remover esta codifo antes de commit
        /*
        if(SecurityUtils.isUserInRole(SecurityUtils.Roles.TECNICO.toString())){
        
            projectos = projectoRepository.findByProjectoStatus(Projecto.ProjectoStatus.CANDIDATURA);
            for (Projecto item : projectos) {
                projectosList.add(item);
            }
        }else if(SecurityUtils.isUserInRole(SecurityUtils.Roles.GESTFINANCEIRO.toString())){
            projectos = projectoRepository.findByProjectoStatus(Projecto.ProjectoStatus.ABERTO);
            for (Projecto item : projectos) {
                projectosList.add(item);
            }
        }else if(SecurityUtils.isUserInRole(SecurityUtils.Roles.COMIFINANCEIRO.toString())){
            projectos = projectoRepository.findByProjectoStatus(Projecto.ProjectoStatus.AGUARDA_DESPACHO_ABERTURA);
            
            for (Projecto item : projectos) {
                projectosList.add(item);
            }
            projectos = projectoRepository.findByProjectoStatus(Projecto.ProjectoStatus.AGUARDA_DESPACHO_FINANCEIRO);

            for (Projecto item : projectos) {
                projectosList.add(item);
            }
        }*/

        model.addAttribute("projectos", projectosList);
        return "projectos/listar_projectos";
    }
    
    @RequestMapping(value = "/listar1", method = RequestMethod.GET)
    public String listarProjectosPage(Pageable pageable, Model model) {
        Page<Projecto> projectos = projectoRepository.findAll(pageable);

        int pageSize = pageable.getPageSize();
        int current = projectos.getNumber() + 1;
        int begin = Math.max(1, current * pageSize);
        int end = Math.min(begin + pageSize, projectos.getTotalPages());

        model.addAttribute("projectos", projectos.getContent());
        model.addAttribute("beginIndex", begin);                        //paginBeginIndex
        model.addAttribute("endIndex", end);                            //paginEndIndex
        model.addAttribute("currentIndex", current);                    //paginCurrentIndex
        model.addAttribute("totalPages", projectos.getTotalPages());    //paginTotalPages

        return "projectos/listar_projectos_1";
    }

    @GetMapping("/registar")
    public String registarProjecto(Model model) {
        // Inicia um projeco vazio para que as varias do form fiquem vazias
        Projecto projecto = new Projecto();
        projecto.setProjectoCodigo("0");
        model.addAttribute("projecto", projecto);
        model.addAttribute("registarProjecto_Status", "");
        return "projectos/registar_projecto";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String registarProjectoPost(@ModelAttribute("projecto") Projecto projecto,
            BindingResult result, Model model) {

        projecto.setProjectoStatus(Projecto.ProjectoStatus.AGUARDA_DESPACHO_ABERTURA);

        //Se projecto tiver codigo/id faz update, senão insere novo na BD
        projectoRepository.save(projecto);
        model.addAttribute("registarProjecto_Status", "");
        model.addAttribute("projecto", projecto);
        return "projectos/registar_projecto";
    }

    @GetMapping("/editar/{projectoId}")
    public String editarProjecto(@PathVariable("projectoId") int projectoId, Model model) {

        //devera Obter o projecto da DB
        Projecto projecto = new Projecto();

        model.addAttribute("projecto", projecto);
        return "projectos/editar_projecto";
    }

}
