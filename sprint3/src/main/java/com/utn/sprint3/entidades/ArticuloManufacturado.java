package com.utn.sprint3.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "articulo_manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ArticuloManufacturado extends BaseEntidad {

    @NotNull
    private String denominacion;

    @NotNull
    @Column(length = 1000)
    private String descripcion;

    @NotNull
    private Integer tiempoEstimadoCocina;

    @NotNull
    private float precioVenta;

    private float costo;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;

}