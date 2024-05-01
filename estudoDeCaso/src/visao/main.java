package visao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Control.Produto;

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

			Object vetor;
			switch (op) {
			case 1: {
				while (!sair.equals("sair")) {
					
//					// pegar via scanner tas as informacoes dos produtos
					System.out.println("Adicione os valor do produto");
					 String DataC = leitor.nextLine();
					 String DataValidade = leitor.nextLine();
					 String Fabricante = leitor.nextLine();
					 String Nome = leitor.nextLine();
					 String a = leitor.nextLine();
					 Float PrecoMercado = Float.valueOf(a);
					 String Qualidade = leitor.nextLine();
					 String B = leitor.nextLine();
					 Integer Quantidade = Integer.valueOf(B);
					 
					
					// criando o obj de produto
					Produto p = new Produto();
					p.setDataChegada(DataC);
					p.setDataValidade(DataValidade);
					p.setFabricante(Fabricante);
					p.setNome(Nome);
					p.setPrecoMercado(PrecoMercado);
					p.setQualidade(Qualidade);
					p.setQuantidade(Quantidade);
					
					// e adiciona o produto no arraylist
					estoque.add(p);

					System.out.println("Desejas adicionar algo mais?(Digite sair para sair)");
					sair = leitor.nextLine();
					break;
				}
			}

			case 2: {
			    for(Produto produto: estoque) {
			        System.out.println("Data de Chegada: " + produto.getDataChegada());
			        System.out.println("Data de Validade: " + produto.getDataValidade());
			        System.out.println("Fabricante: " + produto.getFabricante());
			        System.out.println("Nome: " + produto.getNome());
			        System.out.println("Qualidade: " + produto.getQualidade());
			        System.out.println("Preço de Mercado: " + produto.getPrecoMercado());
			        System.out.println("Quantidade: " + produto.getQuantidade());
			        System.out.println();
			    }
			    break;
			}
			
			case 3: {
			    System.out.println("Informe o nome do produto que deseja excluir:");
			    String nomeProduto = leitor.nextLine();
			    for (Iterator<Produto> iterator = estoque.iterator(); iterator.hasNext();) {
			        Produto produto = iterator.next();
			        if (produto.getNome().equals(nomeProduto)) {
			            iterator.remove();
			            System.out.println("Produto removido com sucesso.");
			            break;
			        }
			    }
			    break;
			}
			case 4: {
				for (int i = 0; i < vetor.length; i++) {
					System.out.println(vetor[i]);
				}
				System.out.println("Informe qual Produto desaja olhar");
				String procurar = leitor.nextLine();
				for (int i = 0; i < vetor.length; i++) {
					if (vetor[i] == procurar) {
						System.out.println(vetor[i]);
					}
					break;
				}

			}

			case 5: {
				while (!sair.equals("sair")) {
					for (int i = 0; i < vetor.length; i++) {
						System.out.println(vetor[i]);
					}
					System.out.println("Informe qual produto deseja alterar");
					String alterar = leitor.nextLine();
					for (int i = 0; i < vetor.length; i++) {
						if (vetor[i] == alterar) {
							System.out.println("Informe o qual sera o novo produto a ser armazenado	");
							String novo = leitor.nextLine();
							vetor[i] = novo;
						}

						System.out.println("Desejas adicionar algo mais?(Digite sair para sair)");
						sair = leitor.nextLine();
					}
					break;
				}

			}
			default:
			}
		}

	}
}
