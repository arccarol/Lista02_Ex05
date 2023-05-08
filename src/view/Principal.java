package view;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import controller.Musica;
import controller.PlayerController;

public class Principal {
    public static void main(String[] args) {
    	
        List<Musica> lista = new LinkedList<>();
        PlayerController player = new PlayerController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Digite a opção desejada:");
            System.out.println("1 - Adicionar música");
            System.out.println("2 - Remover música");
            System.out.println("3 - Executar playlist");
            System.out.println("4 - Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome da música:");
                    String nome = sc.nextLine();
                    System.out.println("Digite o nome do artista:");
                    String nomeArtista = sc.nextLine();
                    System.out.println("Digite a duração da música (em segundos):");
                    int duracao = sc.nextInt();
                    sc.nextLine();

                    String novaMusica = nome + ";" + nomeArtista + ";" + duracao;
                    player.adicionaMusica(lista, novaMusica);
                    break;
                case 2:
                    System.out.println("Digite a posição da música a ser removida:");
                    int posicao = sc.nextInt();
                    sc.nextLine();

                    player.removeMusica(lista, posicao);
                    break;
                case 3:
                    player.executaPlaylist(lista);
                    break;
                case 4:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
}
}