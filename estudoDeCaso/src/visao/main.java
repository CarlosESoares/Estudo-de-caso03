package visao;

import java.util.ArrayList;
import java.util.Scanner;
import Control.ProdutoDAO;
import model.Produto;

public class main {

    public static void main(String[] args) {
        ProdutoDAO dao = ProdutoDAO.getInstancia();

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

        while (op >= 1 && op <= 5) {
            System.out.println("Escolha uma opcao");
            System.out.println("(1) Adicionar");
            System.out.println("(2) Listar");
            System.out.println("(3) Excluir");
            System.out.println("(4) Pesquisar");
            System.out.println("(5) Editar");
            System.out.println("Qualquer opcao diferente ira encerrar");
            int opcao = Integer.valueOf(leitor.nextLine());

            switch (opcao) {
                case 1: {
                    // Obtendo a instância única de ProdutoDAO
                    ProdutoDAO produtoDAO = ProdutoDAO.getInstancia();
                    // Criando um novo produto
                    Produto novoProduto = new Produto();
                    // Defina os atributos do novo produto conforme necessário
                    int id = produtoDAO.inserir(novoProduto);
                    if (id != -1) {
                        System.out.println("Produto adicionado com sucesso. ID do Produto: " + id);
                    } else {
                        System.out.println("Falha ao adicionar o produto.");
                    }
                    break;
                }
                case 2: {
                    ProdutoDAO produtoDAO = ProdutoDAO.getInstancia();
                    ArrayList<Produto> produtos = produtoDAO.listar();
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto no estoque.");
                    } else {
                        for (Produto produto : produtos) {
                            System.out.println("Data de Chegada: " + produto.getDataChegada());
                            System.out.println("Data de Validade: " + produto.getDataValidade());
                            System.out.println("Fabricante: " + produto.getFabricante());
                            System.out.println("Nome: " + produto.getNome());
                            System.out.println("Qualidade: " + produto.getQualidade());
                            System.out.println("Preço de Mercado: " + produto.getPrecoMercado());
                            System.out.println("Quantidade: " + produto.getQuantidade());
                            System.out.println("Id do Produto: " + produto.getProdutoID());
                        }
                    }
                    break;
                }
                case 3: {
                    ProdutoDAO produtoDAO = ProdutoDAO.getInstancia();
                    System.out.println("Informe o ID do produto que deseja excluir:");
                    int idProduto = Integer.parseInt(leitor.nextLine());
                    boolean removido = produtoDAO.remover(idProduto);
                    if (removido) {
                        System.out.println("Produto removido com sucesso.");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                }
                case 4: {
                    ProdutoDAO produtoDAO = ProdutoDAO.getInstancia();
                    System.out.println("Informe o ID do produto que deseja pesquisar:");
                    int idProduto = Integer.parseInt(leitor.nextLine());
                    Produto produtoEncontrado = produtoDAO.buscarPorId(idProduto);
                    if (produtoEncontrado != null) {
                        System.out.println("Produto encontrado:");
                        System.out.println("Data de Chegada: " + produtoEncontrado.getDataChegada());
                        System.out.println("Data de Validade: " + produtoEncontrado.getDataValidade());
                        System.out.println("Fabricante: " + produtoEncontrado.getFabricante());
                        System.out.println("Nome: " + produtoEncontrado.getNome());
                        System.out.println("Qualidade: " + produtoEncontrado.getQualidade());
                        System.out.println("Preço de Mercado: " + produtoEncontrado.getPrecoMercado());
                        System.out.println("Quantidade: " + produtoEncontrado.getQuantidade());
                        System.out.println("Id do produto: " + produtoEncontrado.getId());
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                }
                case 5: {
                    ProdutoDAO produtoDAO = ProdutoDAO.getInstancia();
                    System.out.println("Informe o ID do produto que deseja editar:");
                    int idProduto = Integer.parseInt(leitor.nextLine());
                    Produto produtoExistente = produtoDAO.buscarPorId(idProduto);
                    if (produtoExistente != null) {
                        System.out.println("Produto encontrado. Escolha o atributo que deseja editar:");
                        System.out.println("1. Data de Chegada");
                        System.out.println("2. Data de Validade");
                        System.out.println("3. Fabricante");
                        System.out.println("4. Nome");
                        System.out.println("5. Preço de Mercado");
                        System.out.println("6. Qualidade");
                        System.out.println("7. Quantidade");
                        System.out.println("8. Cancelar");
                        int subOpcao = Integer.parseInt(leitor.nextLine());
                        switch (subOpcao) {
                            case 1:
                                System.out.println("Informe a nova Data de Chegada:");
                                String newDataChegada = leitor.nextLine();
                                produtoExistente.setDataChegada(newDataChegada);
                                break;
                            case 2:
                                System.out.println("Informe a nova Data de Validade:");
                                String newDataValidade = leitor.nextLine();
                                produtoExistente.setDataValidade(newDataValidade);
                                break;
                            case 3:
                                System.out.println("Informe o novo Fabricante:");
                                String newFabricante = leitor.nextLine();
                                produtoExistente.setFabricante(newFabricante);
                                break;
                            case 4:
                                System.out.println("Informe o novo Nome:");
                                String newNome = leitor.nextLine();
                                produtoExistente.setNome(newNome);
                                break;
                            case 5:
                                System.out.println("Informe o novo Preço de Mercado:");
                                float newPrecoMercado = Float.parseFloat(leitor.nextLine());
                                produtoExistente.setPrecoMercado(newPrecoMercado);
                                break;
                            case 6:
                                System.out.println("Informe a nova Qualidade:");
                                String newQualidade = leitor.nextLine();
                                produtoExistente.setQualidade(newQualidade);
                                break;
                            case 7:
                                System.out.println("Informe a nova Quantidade:");
                                int newQuantidade = Integer.parseInt(leitor.nextLine());
                                produtoExistente.setQuantidade(newQuantidade);
                                break;
                            case 8:
                                System.out.println("Operação cancelada.");
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                }
            }
        }
    }
}