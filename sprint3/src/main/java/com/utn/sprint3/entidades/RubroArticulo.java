package com.utn.sprint3.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rubro_articulo")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RubroArticulo extends BaseEntidad {
    @ManyToOne()
    @JoinColumn(name = "id_rubro_padre")
    private RubroArticulo rubroPadre;

    @OneToMany(mappedBy = "rubroPadre")
    private List<RubroArticulo> subRubros;

    @NotNull
    private String denominacion;

    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id-rubro")
    @Builder.Default
    private List<ArticuloInsumo> articuloInsumos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id-rubro")
    @Builder.Default
    private List<ArticuloManufacturado> articuloManufacturados = new ArrayList<>();


    public RubroArticulo(String denominacion, RubroArticulo rubroPadre) {
        this.denominacion = denominacion;
        this.rubroPadre = rubroPadre;
    }

    public void setSubRubros(List<RubroArticulo> subRubros) {
        this.subRubros = subRubros;

    }

}
