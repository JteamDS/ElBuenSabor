package com.utn.sprint3.entidades;

import com.utn.sprint3.enumeraciones.FormaPago;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Factura extends BaseEntidad {

    @NotNull
    @Column(name = "fecha_facturacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFacturacion;

    @Column(name = "mp_payment_id")
    private Long mpPaymentId;

    @Column(name = "mp_payment_type")
    private String mpPaymentType;

    @NotNull
    private FormaPago formaPago;

    @NotNull
    @Column(name = "total_venta", precision = 10, scale = 2)
    private BigDecimal totalVenta;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id-factura")
    private List<DetalleFactura> detalleFacturas = new ArrayList<>();
}
