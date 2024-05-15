package Control;

import model.Produto;
import java.util.ArrayList;

public class ProdutoDAO {

	private ArrayList<Produto> estoque;
	private int geradorId;
	private static ProdutoDAO instancia;

	public static ProdutoDAO getInstancia() {
		if (instancia == null) {
			instancia = new ProdutoDAO();
		}

		return instancia;
	}

	private ProdutoDAO() {
		this.estoque = new ArrayList<>();
		this.geradorId = 0;
	}

	public int inserir(Produto produto) {
		if (produto != null) {
			produto.setId(geradorId);
			geradorId++;
			estoque.add(produto);
			return produto.getId();
		}
		return -1;
	}

	public ArrayList<Produto> listar() {
		return this.estoque;
	}

	public boolean remover(int id) {
		for (Produto produto : estoque) {
			if (produto.getId() == id) {
				estoque.remove(produto);
				return true;
			}
		}
		return false;
	}

	public Produto buscarPorId(int id) {
		for (Produto produto : estoque) {
			if (produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}

	public boolean editar(Produto novoProduto) {
		for (Produto produto : estoque) {
			if (produto.getId() == novoProduto.getId()) {
				produto.setDataChegada(novoProduto.getDataChegada());
				produto.setDataValidade(novoProduto.getDataValidade());
				produto.setFabricante(novoProduto.getFabricante());
				produto.setNome(novoProduto.getNome());
				produto.setPrecoMercado(novoProduto.getPrecoMercado());
				produto.setQualidade(novoProduto.getQualidade());
				produto.setQuantidade(novoProduto.getQuantidade());
				return true;
			}
		}
		return false;
	}
}
