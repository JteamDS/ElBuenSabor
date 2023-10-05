package com.utn.sprint3.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Domicilio extends BaseEntidad {

    @NotNull
    @Column(length = 500)
    private String calle;

    @NotNull
    @Column(precision = 5)
    private Integer numero;

    @NotNull
    @Column(precision = 4)
    private Integer codigoPostal;

    @NotNull
    private String localidad;

    @Column(name = "numero_departamento")
    private Integer numeroDpto;

    @Column(name = "piso_departamento")
    private Integer pisoDpto;

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