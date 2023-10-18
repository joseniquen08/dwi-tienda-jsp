package proyecto_final.beans;

public class PedidoArticulo {
	private Long id;
	private int cantidad;
	private Long pedidoCod;
	private Long articuloId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Long getPedidoCod() {
		return pedidoCod;
	}
	public void setPedidoCod(Long pedidoCod) {
		this.pedidoCod = pedidoCod;
	}
	public Long getArticuloId() {
		return articuloId;
	}
	public void setArticuloId(Long articuloId) {
		this.articuloId = articuloId;
	}

}
