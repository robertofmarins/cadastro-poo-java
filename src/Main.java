import java.util.Scanner;
import model.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        int opcao;

        do {
            System.out.println("\n=================================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("=================================");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Tipo (F - Física | J - Jurídica): ");
                    String tipo = scanner.nextLine();

                    if (tipo.equalsIgnoreCase("F")) {

                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();

                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();

                        PessoaFisica pf = new PessoaFisica(id, nome, cpf, idade);
                        repoFisica.inserir(pf);

                        System.out.println("Pessoa Física incluída com sucesso.");

                    } else if (tipo.equalsIgnoreCase("J")) {

                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();

                        PessoaJuridica pj = new PessoaJuridica(id, nome, cnpj);
                        repoJuridica.inserir(pj);

                        System.out.println("Pessoa Jurídica incluída com sucesso.");

                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;
                case 2:
                    System.out.print("Tipo (F - Física | J - Jurídica): ");
                    String tipoAlt = scanner.nextLine();

                    System.out.print("ID: ");
                    int idAlt = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoAlt.equalsIgnoreCase("F")) {
                        PessoaFisica pf = repoFisica.obter(idAlt);
                        if (pf != null) {
                            pf.exibir();

                            System.out.print("Novo nome: ");
                            String nome = scanner.nextLine();

                            System.out.print("Novo CPF: ");
                            String cpf = scanner.nextLine();

                            System.out.print("Nova idade: ");
                            int idade = scanner.nextInt();
                            scanner.nextLine();

                            PessoaFisica novaPf = new PessoaFisica(idAlt, nome, cpf, idade);
                            repoFisica.alterar(novaPf);

                            System.out.println("Pessoa Física alterada com sucesso.");
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }

                    } else if (tipoAlt.equalsIgnoreCase("J")) {
                        PessoaJuridica pj = repoJuridica.obter(idAlt);
                        if (pj != null) {
                            pj.exibir();

                            System.out.print("Novo nome: ");
                            String nome = scanner.nextLine();

                            System.out.print("Novo CNPJ: ");
                            String cnpj = scanner.nextLine();

                            PessoaJuridica novaPj = new PessoaJuridica(idAlt, nome, cnpj);
                            repoJuridica.alterar(novaPj);

                            System.out.println("Pessoa Jurídica alterada com sucesso.");
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }

                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 3:
                    System.out.print("Tipo (F - Física | J - Jurídica): ");
                    String tipoExc = scanner.nextLine();

                    System.out.print("ID: ");
                    int idExc = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoExc.equalsIgnoreCase("F")) {
                        PessoaFisica pf = repoFisica.obter(idExc);
                        if (pf != null) {
                            repoFisica.excluir(idExc);
                            System.out.println("Pessoa Física excluída com sucesso.");
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }

                    } else if (tipoExc.equalsIgnoreCase("J")) {
                        PessoaJuridica pj = repoJuridica.obter(idExc);
                        if (pj != null) {
                            repoJuridica.excluir(idExc);
                            System.out.println("Pessoa Jurídica excluída com sucesso.");
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }

                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 4:
                    System.out.print("Tipo (F - Física | J - Jurídica): ");
                    String tipoId = scanner.nextLine();

                    System.out.print("ID: ");
                    int idBusca = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoId.equalsIgnoreCase("F")) {
                        PessoaFisica pf = repoFisica.obter(idBusca);
                        if (pf != null) {
                            pf.exibir();
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }

                    } else if (tipoId.equalsIgnoreCase("J")) {
                        PessoaJuridica pj = repoJuridica.obter(idBusca);
                        if (pj != null) {
                            pj.exibir();
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }

                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 5:
                    System.out.print("Tipo (F - Física | J - Jurídica): ");
                    String tipoExibir = scanner.nextLine();

                    if (tipoExibir.equalsIgnoreCase("F")) {
                        if (repoFisica.obterTodos().isEmpty()) {
                            System.out.println("Nenhuma Pessoa Física cadastrada.");
                        } else {
                            for (PessoaFisica pf : repoFisica.obterTodos()) {
                                pf.exibir();
                                System.out.println("-------------------");
                            }
                        }

                    } else if (tipoExibir.equalsIgnoreCase("J")) {
                        if (repoJuridica.obterTodos().isEmpty()) {
                            System.out.println("Nenhuma Pessoa Jurídica cadastrada.");
                        } else {
                            for (PessoaJuridica pj : repoJuridica.obterTodos()) {
                                pj.exibir();
                                System.out.println("-------------------");
                            }
                        }

                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 6:
                    try {
                        System.out.print("Prefixo do arquivo: ");
                        String prefixo = scanner.nextLine();

                        repoFisica.persistir(prefixo + ".fisica.bin");
                        repoJuridica.persistir(prefixo + ".juridica.bin");

                        System.out.println("Dados salvos com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar os dados.");
                    }
                    break;

                case 7:
                    try {
                        System.out.print("Prefixo do arquivo: ");
                        String prefixo = scanner.nextLine();

                        repoFisica.recuperar(prefixo + ".fisica.bin");
                        repoJuridica.recuperar(prefixo + ".juridica.bin");

                        System.out.println("Dados recuperados com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro ao recuperar os dados.");
                    }
                    break;

                case 0:
                    System.out.println("Sistema finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
