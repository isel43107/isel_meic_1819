/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author pauloborges
 */
@Entity
@Table(name = "projecto")
public class Projecto  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "projectoid")
    private Long projectoId;
    
    @Column(name = "projectocodigo")
    private String projectoCodigo;
    
    @Column(name = "projectonome")
    private String projectoNome;
    
    @Column(name = "projectodescription", length = 512)
    private String projectoDescription;
    
    @Column(name = "projectovalor")
    private double projectoValor;
    
    @Column(name = "projectopromotornome")
    private String projectoPromotorNome;
    
    @Column(name = "projectopromotoremail")
    private String projectoPromotorEmail;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "projectostatus")
    private ProjectoStatus projectoStatus;
//    private Date projectoDataSubmissao;
//    private String projectFileAtach;

    public String getProjectoCodigo() {
        return projectoCodigo;
    }

    public void setProjectoCodigo(String projectoCodigo) {
        this.projectoCodigo = projectoCodigo;
    }

    public String getProjectoNome() {
        return projectoNome;
    }

    public void setProjectoNome(String projectoNome) {
        this.projectoNome = projectoNome;
    }
    
    public String getProjectoDescription() {
        return projectoDescription;
    }

    public void setProjectoDescription(String projectoDescription) {
        this.projectoDescription = projectoDescription;
    }

    public double getProjectoValor() {
        return projectoValor;
    }

    public void setProjectoValor(double projectoValor) {
        this.projectoValor = projectoValor;
    }

    public String getProjectoPromotorNome() {
        return projectoPromotorNome;
    }

    public void setProjectoPromotorNome(String projectoPromotorNome) {
        this.projectoPromotorNome = projectoPromotorNome;
    }

    public String getProjectoPromotorEmail() {
        return projectoPromotorEmail;
    }

    public void setProjectoPromotorEmail(String projectoPromotorEmail) {
        this.projectoPromotorEmail = projectoPromotorEmail;
    }

    public ProjectoStatus getProjectoStatus() {
        return projectoStatus;
    }

    public void setProjectoStatus(ProjectoStatus projectoStatus) {
        this.projectoStatus = projectoStatus;
    }

    public Long getProjectoId() {
        return projectoId;
    }

    public void setProjectoId(Long projectoId) {
        this.projectoId = projectoId;
    }
    
    public static enum ProjectoStatus{
        CANDIDATURA,
        AGUARDA_DESPACHO_ABERTURA,
        ABERTO,
        ARQUIVADO,
        ANALISE_TECNICO,
        AGUARDA_DESPACHO_FINANCEIRO,
        FINANCIAMENTO
    }
    
}
