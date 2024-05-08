package Control;

import java.util.ArrayList;

import model.Produto;

public class ProdutoDAO {
	
	private ArrayList<Produto> estoque;
	private int geradorId;
	
	public ProdutoDAO() {
		this.estoque = new ArrayList<>();
		this.geradorId = 0;
	}
	
	public int inserir(Produto produto) {
		if(produto!=null);
		produto.setId(geradorId);
			geradorId++;
			estoque.add(produto);
		
		
		return produto.getId();
	}
	
	public ArrayList<Produto> listar(){
		return this.estoque;
	}
}
