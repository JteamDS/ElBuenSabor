package com.utn.sprint3.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ArticuloInsumo extends BaseEntidad {

    @NotNull
    private String denominacion;

    @NotNull
    private float precioCompra;

    @NotNull
    private float stockActual;

    @NotNull
    private float stockMinimo;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedida unidadMedida;

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
}
