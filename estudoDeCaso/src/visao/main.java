package visao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Control.ProdutoDAO;
import model.Produto;

public class main {

	public static void main(String[] args) {

		Produto AddProt = new Produto();
		AddProt.setDataChegada("28/06/2020");
		AddProt.setDataValidade("29/06/2023");
		AddProt.setFabricante("Gustavo");
		AddProt.setNome("Lombra");
		AddProt.setPrecoMercado((float) 24.90);
		AddProt.setQualidade("Duvidosa");
		AddProt.setQuantidade(20);

		Scanner leitor = new Scanner(System.in);
		int op = 1;

		ArrayList<Produto> estoque = new ArrayList<>();
		estoque.add(AddProt);

		String sair = "legal";

		while (op >= 1 && op <= 5) {
			System.out.println("Escolha uma opcao");
			System.out.println("(1) Adicionar");
			System.out.println("(2) Listar");
			System.out.println("(3) Excluir");
			System.out.println("(4) Pesquisar");
			System.out.println("(5) Editar");
			System.out.println("Qualquer opcao diferente ira encerrar");
			String leia = leitor.nextLine();
			op = Integer.valueOf(leia);

			switch (op) {
			case 1: {
				while (!sair.equals("sair")) {

				Produto p = new Produto();
				p.setNome("Lucas");
				
				ProdutoDAO dao = new ProdutoDAO();
				dao.inserir(p);
					System.out.println("Desejas adicionar algo mais?(Digite sair para sair)");
					sair = leitor.nextLine();
					break;
				}
			}

			case 2: {
				for (Produto produto : estoque) {
					System.out.println("Data de Chegada: " + produto.getDataChegada());
					System.out.println("Data de Validade: " + produto.getDataValidade());
					System.out.println("Fabricante: " + produto.getFabricante());
					System.out.println("Nome: " + produto.getNome());
					System.out.println("Qualidade: " + produto.getQualidade());
					System.out.println("Preço de Mercado: " + produto.getPrecoMercado());
					System.out.println("Quantidade: " + produto.getQuantidade());
					System.out.println("Id do Produto:" + produto.getProdutoID());
				}
				break;
			}

			case 3: {
				System.out.println("Informe o nome do produto que deseja excluir:");
				String ProdutoID = leitor.nextLine();
				for (Iterator<Produto> iterator = estoque.iterator(); iterator.hasNext();) {
					Produto produto = iterator.next();
					if (produto.getProdutoID().equals(ProdutoID)) {
						iterator.remove();
						System.out.println("Produto removido com sucesso.");
						break;
					}
				}
				break;
			}
			case 4: {
				System.out.println("Informe o nome do produto que deseja pesquisar:");
				String nomeProduto = leitor.nextLine();
				boolean produtoEncontrado = false;
				for (Produto produto : estoque) {
					if (produto.getNome().equals(nomeProduto)) {
						System.out.println("Produto encontrado:");
						System.out.println("Data de Chegada: " + produto.getDataChegada());
						System.out.println("Data de Validade: " + produto.getDataValidade());
						System.out.println("Fabricante: " + produto.getFabricante());
						System.out.println("Nome: " + produto.getNome());
						System.out.println("Qualidade: " + produto.getQualidade());
						System.out.println("Preço de Mercado: " + produto.getPrecoMercado());
						System.out.println("Quantidade: " + produto.getQuantidade());
						System.out.println("Id do produto" + produto.getProdutoID());
						produtoEncontrado = true;
						break;
					}
				}
				if (!produtoEncontrado) {
					System.out.println("Produto não encontrado.");
				}
				break;
			}

			case 5: {

				System.out.println("Informe o nome do produto que deseja editar:");
				String newProduto = leitor.nextLine();

				for (Produto produto : estoque) {
					if (produto.getNome().equals(newProduto)) {
						System.out.println("Produto encontrado. Informe os novos dados.");

						System.out.println("Data de Chegada:");
						String NewDataChegada = leitor.nextLine();
						produto.setDataChegada(NewDataChegada);

						System.out.println("Data de Validade:");
						String NewDataValidade = leitor.nextLine();
						produto.setDataValidade(NewDataValidade);

						System.out.println("Fabricante:");
						String NewFabricante = leitor.nextLine();
						produto.setFabricante(NewFabricante);

						System.out.println("Nome:");
						String NewNome = leitor.nextLine();
						produto.setNome(NewNome);

						System.out.println("Preço de Mercado:");
						Float NewPrecoMercado = Float.valueOf(leitor.nextLine());
						produto.setPrecoMercado(NewPrecoMercado);

						System.out.println("Qualidade:");
						String NewQualidade = leitor.nextLine();
						produto.setQualidade(NewQualidade);

						System.out.println("Quantidade:");
						Integer NewQuantidade = Integer.valueOf(leitor.nextLine());
						produto.setQuantidade(NewQuantidade);
						
						System.out.println("Id do produto");
						String NewIdProduto = leitor.nextLine();
						produto.setProdutoID(NewIdProduto);
						System.out.println("Produto editado com sucesso.");
						break;
					}
				}
				break;
			}

			default:

			}

		}
	}
}
