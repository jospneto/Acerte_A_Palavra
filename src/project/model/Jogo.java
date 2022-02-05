package project.model;

import project.controller.ConexaoBancoDados;

import java.util.*;

public class Jogo {
    private String[] palavras = {"Avião", "Elefante", "Bola", "Bebê", "Peixe", "Futebol", "Beliscão",
            "Basquete", "Controle", "Triste", "Gato", "Golfe", "Tesoura", "Colher", "Pular", "Galinha",
            "Sapo", "Espirro", "Martelo"};

    public Jogo(){

    }

    public Jogo(String[] palavras) {
        this.palavras = palavras;
    }

    public String[] getPalavras() {
        return palavras;
    }

    public void setPalavras(String[] palavras) {
        this.palavras = palavras;
    }

    public String busca(String palpite){
        String palavra = "";
        for(int i = 0; i < this.palavras.length; i++){
            if(palpite.equalsIgnoreCase(this.palavras[i])) {
                palavra = this.palavras[i];
            }
        }

        return palavra;
    }

    public String embaralhar(){
        Random rdm = new Random();
        int indicePalavra = rdm.nextInt(this.palavras.length);
        String palavraGerada = this.palavras[indicePalavra];

        char[] palavraArray = palavraGerada.toCharArray();
        List palavraCaracter = new ArrayList(palavraArray.length);

        for(char caracter : palavraArray){
            palavraCaracter.add(caracter);
        }

        Collections.shuffle(palavraCaracter);

        for(int i = 0; i < palavraArray.length; i++){
            palavraArray[i] = (char) palavraCaracter.get(i);
        }

        String palavra = new String(palavraArray);

        return palavra;
    }
}
