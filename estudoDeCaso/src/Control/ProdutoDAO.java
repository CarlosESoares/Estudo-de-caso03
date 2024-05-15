package Control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import model.Produto;

public class ProdutoDAO {
	
	private ArrayList<Produto> estoque;
	private int geradorId;
	private static ProdutoDAO instancia;
	Scanner leitor = new Scanner(System.in);

	public static ProdutoDAO getInstancia() {
		if(instancia == null) {
			instancia = new ProdutoDAO();
		}
		
		return instancia;
	}
	
	
	private ProdutoDAO() {
		this.estoque = new ArrayList<>();
		this.geradorId = 0;
	}
	
	public int inserir(Produto produto) {
		if(produto!=null);
		produto.setId(geradorId);
			geradorId++;
			estoque.add(produto);
			
			System.out.println("Adicione os valor do produto"); 
			
			System.out.println("data de chegada"); 
			String DataC = leitor.nextLine(); 
			
			System.out.println("Data de validade");
			String DataValidade = leitor.nextLine();
			
			System.out.println("Fabricante");
			String Fabricante = leitor.nextLine(); 
			
			System.out.println("Nome:");
			String Nome = leitor.nextLine(); 
			 
			System.out.println("Preço mercado");
			String a = leitor.nextLine(); 
			Float PrecoMercado = Float.valueOf(a); 
			 System.out.println("qualidade");
			String Qualidade = leitor.nextLine(); 
			 System.out.println("quantidade");
			String B = leitor.nextLine(); 
			 Integer Quantidade = Integer.valueOf(B); 

		
		return produto.getId();
	}
	
	public ArrayList<Produto> listar(){
		return this.estoque;
	}
	public boolean remover(int id) {
	    for (Iterator<Produto> iterator = estoque.iterator(); iterator.hasNext();) {
	        Produto produto = iterator.next();
	        if (produto.getId() == id) {
	            iterator.remove();
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
}
