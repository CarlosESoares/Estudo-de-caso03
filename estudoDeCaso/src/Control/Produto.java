package Control;

public class Produto {


	private String DataChegada;

	private Float PrecoMercado;

	private String Qualidade;

	private String DataValidade;

	private String Nome;

	private String Fabricante;

	private Integer Quantidade;
	
	private String ProdutoID;

	


	public String getProdutoID() {
		return ProdutoID;
	}

	public void setProdutoID(String produtoID) {
		ProdutoID = produtoID;
	}

	public Float getPrecoMercado() {
		return PrecoMercado;
	}

	public void setPrecoMercado(Float precoMercado) {
		PrecoMercado = precoMercado;
	}

	public String getQualidade() {
		return Qualidade;
	}

	public void setQualidade(String qualidade) {
		Qualidade = qualidade;
	}

	public String getDataValidade() {
		return DataValidade;
	}

	public void setDataValidade(String dataValidade) {
		DataValidade = dataValidade;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getFabricante() {
		return Fabricante;
	}

	public void setFabricante(String fabricante) {
		Fabricante = fabricante;
	}

	public Integer getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		Quantidade = quantidade;
	}

	public String getDataChegada() {
		return DataChegada;
	}

	public void setDataChegada(String dataChegada) {
		DataChegada = dataChegada;
	}


}
