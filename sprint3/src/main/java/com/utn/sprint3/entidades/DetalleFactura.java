package com.utn.sprint3.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DetalleFactura extends BaseEntidad {

    @NotNull
    private Integer cantidad;

    @NotNull
    private float subtotal;

    @ManyToOne()
    @JoinColumn(name = "id_articulo_insumo")
    private ArticuloInsumo articuloInsumo;

    @ManyToOne()
    @JoinColumn(name = "id_articulo_manufacturado")
    private ArticuloManufacturado articuloManufacturado;

}
