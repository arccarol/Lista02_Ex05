package controller;


import java.util.List;

public class PlayerController {
    public void adicionaMusica(List<Musica> lista, String musica) {
        String[] campos = musica.split(";");
        Musica novaMusica = new Musica(campos[0], campos[1], Integer.parseInt(campos[2]));

        if (lista.isEmpty()) {
            lista.add(novaMusica);
        } else {
            lista.add(lista.size(), novaMusica);
        }
    }

    public void removeMusica(List<Musica> lista, int posicao) {
        if (lista.isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }

        lista.remove(posicao);
    }

    public void executaPlaylist(List<Musica> lista) {
        if (lista.isEmpty()) {
            throw new RuntimeException("Lista vazia");
        }

        for (Musica musica : lista) {
            System.out.println("[Música: " + musica.getNome() +
                    " - Artista: " + musica.getNomeArtista() +
                    " - Duração: " + musica.getDuracao() + "]");

            try {
                Thread.sleep(musica.getDuracao() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}