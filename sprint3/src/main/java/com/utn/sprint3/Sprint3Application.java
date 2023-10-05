package com.utn.sprint3;

import com.utn.sprint3.entidades.*;
import com.utn.sprint3.enumeraciones.*;
import com.utn.sprint3.repositorios.ClienteRepository;
import com.utn.sprint3.repositorios.RubroArticuloRepository;
import com.utn.sprint3.repositorios.UnidadMedidaRepository;
import com.utn.sprint3.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class Sprint3Application {

	@Autowired
	RubroArticuloRepository rubroArticuloRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	UnidadMedidaRepository unidadMedidaRepository;


	public static void main(String[] args) {
		SpringApplication.run(Sprint3Application.class, args);
		System.out.println("Iniciando...");
	}

	@Bean
	CommandLineRunner init(RubroArticuloRepository rubroRepository1, ClienteRepository clienteRepository1,
						   UsuarioRepository usuarioRepository1, UnidadMedidaRepository unidadMedidaRepository1) {
		return args -> {
			System.out.println("----------------ESTOY----FUNCIONANDO---------------------");
			Usuario usuario = Usuario.builder()
					.password("contrasena123")
					.rol(Rol.ADMINISTRADOR)
					.username("usuarioPrueba")
					.fechaAlta(new Date())
					.build();

			usuario.setFechaModificacion(new Date());
			usuario.setFechaBaja(null);

			System.out.println("Usuario:");
			System.out.println("Username: " + usuario.getUsername());
			System.out.println("Rol: " + usuario.getRol());
			System.out.println("Fecha de alta: " + usuario.getFechaAlta());


			Cliente cliente = Cliente.builder()
					.nombre("John")
					.apellido("Doe")
					.telefono("123456789")
					.email("john.doe@example.com")
					.usuario(usuario)
					.fechaAlta(new Date())
					.build();

			System.out.println("-----------------------------");
			System.out.println("Cliente:");
			System.out.println("Nombre: " + cliente.getNombre());
			System.out.println("Apellido: " + cliente.getApellido());
			System.out.println("Teléfono: " + cliente.getTelefono());
			System.out.println("Email: " + cliente.getEmail());
			System.out.println("Fecha de alta: " + cliente.getFechaAlta());
			System.out.println("Usuario asociado:");
			System.out.println("Username: " + cliente.getUsuario().getUsername());
			System.out.println("Rol del usuario: " + cliente.getUsuario().getRol());


			// Crear un domicilio asociado al cliente
			Domicilio domicilio = Domicilio.builder()
					.calle("Calle Principal")
					.numero(123)
					.codigoPostal(12345)
					.localidad("Ciudad")
					.numeroDpto(2)
					.pisoDpto(3)
					.fechaAlta(new Date())
					.build();

			cliente.setDomicilios(Collections.singletonList(domicilio)); //lo paso como único elemento de una lista

			System.out.println("-----------------------------");
			System.out.println("Domicilio del cliente:");
			System.out.println("Calle: " + domicilio.getCalle());
			System.out.println("Número: " + domicilio.getNumero());
			System.out.println("Código Postal: " + domicilio.getCodigoPostal());
			System.out.println("Localidad: " + domicilio.getLocalidad());
			System.out.println("Número de Departamento: " + domicilio.getNumeroDpto());
			System.out.println("Piso de Departamento: " + domicilio.getPisoDpto());

			ArticuloManufacturado articuloManufacturado = ArticuloManufacturado.builder()
					.denominacion("Hamburguesa")
					.descripcion("Deliciosa hamburguesa")
					.tiempoEstimadoCocina(15)
					.precioVenta(8.99f)
					.costo(4.50f)
					.fechaAlta(new Date())
					.build();

			System.out.println("-----------------------------");
			System.out.println("Articulo Manufacturado:");
			System.out.println("Denominación: " + articuloManufacturado.getDenominacion());
			System.out.println("Descripción: " + articuloManufacturado.getDescripcion());
			System.out.println("Tiempo Estimado Cocina: " + articuloManufacturado.getTiempoEstimadoCocina() + " minutos");
			System.out.println("Precio de Venta: $" + articuloManufacturado.getPrecioVenta());
			System.out.println("Costo: $" + articuloManufacturado.getCosto());

			UnidadMedida unidadMedida = UnidadMedida.builder()
					.denominacion("Kilogramo")
					.abreviatura("kg")
					.fechaAlta(new Date())
					.build();

			System.out.println("-----------------------------");
			System.out.println("Unidad de Medida:");
			System.out.println("Denominación: " + unidadMedida.getDenominacion());
			System.out.println("Abreviatura: " + unidadMedida.getAbreviatura());
			System.out.println("Fecha de alta: " + unidadMedida.getFechaAlta());

			ArticuloInsumo articuloInsumo = ArticuloInsumo.builder()
					.denominacion("Harina")
					.precioCompra(2.50f)
					.stockActual(100.0f)
					.stockMinimo(20.0f)
					.unidadMedida(unidadMedida)
					.fechaAlta(new Date())
					.build();


			System.out.println("-----------------------------");
			System.out.println("Articulo Insumo:");
			System.out.println("Denominación: " + articuloInsumo.getDenominacion());
			System.out.println("Precio de Compra: $" + articuloInsumo.getPrecioCompra());
			System.out.println("Stock Actual: " + articuloInsumo.getStockActual());
			System.out.println("Stock Mínimo: " + articuloInsumo.getStockMinimo());
			System.out.println("Unidad de Medida: " + articuloInsumo.getUnidadMedida().getDenominacion());
			System.out.println("Fecha de alta: " + articuloInsumo.getFechaAlta());


			RubroArticulo rubroPrincipal = RubroArticulo.builder()
					.denominacion("Alimentos")
					.fechaAlta(new Date())
					.build();

			RubroArticulo subRubro1 = new RubroArticulo("Bebidas", rubroPrincipal);
			RubroArticulo subRubro2 = new RubroArticulo("Snacks", rubroPrincipal);

			List<RubroArticulo> subRubros = new ArrayList<>();
			subRubros.add(subRubro1);
			subRubros.add(subRubro2);

			rubroPrincipal.setSubRubros(subRubros);

			rubroPrincipal.getArticuloInsumos().add(articuloInsumo);
			rubroPrincipal.getArticuloManufacturados().add(articuloManufacturado);


			System.out.println("-----------------------------");
			System.out.println("Rubro de Articulo Principal:");
			System.out.println("Denominación: " + rubroPrincipal.getDenominacion());
			System.out.println("Fecha de alta: " + rubroPrincipal.getFechaAlta());

			System.out.println("Subrubros:");
			for (RubroArticulo subRubro : rubroPrincipal.getSubRubros()) {
				System.out.println("- " + subRubro.getDenominacion());
			}

			System.out.println("Articulos Insumos:");
			for (ArticuloInsumo ai : rubroPrincipal.getArticuloInsumos()) {
				System.out.println("- " + ai.getDenominacion());
			}

			System.out.println("Articulos Manufacturados:");
			for (ArticuloManufacturado am : rubroPrincipal.getArticuloManufacturados()) {
				System.out.println("- " + am.getDenominacion());
			}

			DetallePedido detallePedidoInsumo = DetallePedido.builder()
					.cantidad(2)
					.subtotal(5.0f)
					.subtotalCosto(3.0f)
					.articuloInsumo(articuloInsumo)
					.build();

			DetallePedido detallePedidoManufacturado = DetallePedido.builder()
					.cantidad(1)
					.subtotal(8.99f)
					.subtotalCosto(4.50f)
					.articuloManufacturado(articuloManufacturado)
					.build();


			System.out.println("-----------------------------");
			System.out.println("Detalle Pedido con ArticuloInsumo:");
			System.out.println("Cantidad: " + detallePedidoInsumo.getCantidad());
			System.out.println("Subtotal: $" + detallePedidoInsumo.getSubtotal());
			System.out.println("Subtotal Costo: $" + detallePedidoInsumo.getSubtotalCosto());
			System.out.println("Articulo Insumo: " + detallePedidoInsumo.getArticuloInsumo().getDenominacion());


			System.out.println("-----------------------------");
			System.out.println("Detalle Pedido con ArticuloManufacturado:");
			System.out.println("Cantidad: " + detallePedidoManufacturado.getCantidad());
			System.out.println("Subtotal: $" + detallePedidoManufacturado.getSubtotal());
			System.out.println("Subtotal Costo: $" + detallePedidoManufacturado.getSubtotalCosto());
			System.out.println("Articulo Manufacturado: " + detallePedidoManufacturado.getArticuloManufacturado().getDenominacion());


			DetalleFactura detalleFacturaInsumo = DetalleFactura.builder()
					.cantidad(2)
					.subtotal(5.0f)
					.articuloInsumo(articuloInsumo)
					.build();

			DetalleFactura detalleFacturaManufacturado = DetalleFactura.builder()
					.cantidad(1)
					.subtotal(8.99f)
					.articuloManufacturado(articuloManufacturado)
					.build();

			System.out.println("-----------------------------");
			System.out.println("Detalle Factura con ArticuloInsumo:");
			System.out.println("Cantidad: " + detalleFacturaInsumo.getCantidad());
			System.out.println("Subtotal: $" + detalleFacturaInsumo.getSubtotal());
			System.out.println("Articulo Insumo: " + detalleFacturaInsumo.getArticuloInsumo().getDenominacion());

			System.out.println("-----------------------------");
			System.out.println("Detalle Factura con ArticuloManufacturado:");
			System.out.println("Cantidad: " + detalleFacturaManufacturado.getCantidad());
			System.out.println("Subtotal: $" + detalleFacturaManufacturado.getSubtotal());
			System.out.println("Articulo Manufacturado: " + detalleFacturaManufacturado.getArticuloManufacturado().getDenominacion());


			Factura factura = Factura.builder()
					.fechaFacturacion(new Date())
					.formaPago(FormaPago.MERCADO_PAGO)
					.totalVenta(new BigDecimal("13.99"))
					.detalleFacturas(List.of(detalleFacturaInsumo, detalleFacturaManufacturado))
					.build();

			System.out.println("-----------------------------");
			System.out.println("Factura:");
			System.out.println("Fecha de Facturación: " + factura.getFechaFacturacion());
			System.out.println("Forma de Pago: " + factura.getFormaPago());
			System.out.println("Total Venta: $" + factura.getTotalVenta());

			System.out.println("\nDetalle Facturas:");
			for (DetalleFactura detalle : factura.getDetalleFacturas()) {
				if (detalle.getArticuloInsumo() != null) {
					System.out.println("- Cantidad: " + detalle.getCantidad() + ", Subtotal: $" + detalle.getSubtotal()
							+ ", Articulo Insumo: " + detalle.getArticuloInsumo().getDenominacion());
				} else if (detalle.getArticuloManufacturado() != null) {
					System.out.println("- Cantidad: " + detalle.getCantidad() + ", Subtotal: $" + detalle.getSubtotal()
							+ ", Articulo Manufacturado: " + detalle.getArticuloManufacturado().getDenominacion());
				}
			}


			Pedido pedido = Pedido.builder()
					.fechaPedido(new Date())
					.horaEstimadaFinalizacion(new Date())
					.total(13.99f)
					.totalCosto(7.50f)
					.estado(EstadoPedido.PAGADO)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.formaPago(FormaPago.MERCADO_PAGO)
					.domicilioEntrega(domicilio)
					.factura(factura)
					.detallePedidos(List.of(detallePedidoInsumo, detallePedidoManufacturado))
					.build();

			System.out.println("-----------------------------");
			System.out.println("Pedido:");
			System.out.println("Fecha de Pedido: " + pedido.getFechaPedido());
			System.out.println("Hora Estimada de Finalización: " + pedido.getHoraEstimadaFinalizacion());
			System.out.println("Total: $" + pedido.getTotal());
			System.out.println("Total Costo: $" + pedido.getTotalCosto());
			System.out.println("Estado: " + pedido.getEstado());
			System.out.println("Tipo de Envío: " + pedido.getTipoEnvio());
			System.out.println("Forma de Pago: " + pedido.getFormaPago());
			System.out.println("Domicilio de Entrega: " + pedido.getDomicilioEntrega().getCalle() + " " + pedido.getDomicilioEntrega().getNumero());

			System.out.println("Detalle Pedidos:");
			for (DetallePedido detalle : pedido.getDetallePedidos()) {
				if (detalle.getArticuloInsumo() != null) {
					System.out.println("- Cantidad: " + detalle.getCantidad() + ", Subtotal: $" + detalle.getSubtotal()
							+ ", Articulo Insumo: " + detalle.getArticuloInsumo().getDenominacion());
				} else if (detalle.getArticuloManufacturado() != null) {
					System.out.println("- Cantidad: " + detalle.getCantidad() + ", Subtotal: $" + detalle.getSubtotal()
							+ ", Articulo Manufacturado: " + detalle.getArticuloManufacturado().getDenominacion());
				}
			}

			System.out.println("\nFactura del Pedido:");
			System.out.println("Fecha de Facturación: " + pedido.getFactura().getFechaFacturacion());
			System.out.println("Forma de Pago: " + pedido.getFactura().getFormaPago());
			System.out.println("Total Venta: $" + pedido.getFactura().getTotalVenta());

			usuarioRepository.save(usuario);
			clienteRepository.save(cliente);
			unidadMedidaRepository.save(unidadMedida);
			rubroArticuloRepository.save(rubroPrincipal);
		};
	}
}