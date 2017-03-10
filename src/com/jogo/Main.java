package com.jogo;

import java.util.Scanner;

public class Main {

	private static Scanner Leitor;

	public static void main(String[] args) {

		Leitor = new Scanner(System.in);
		boolean jogar = true;
		Jogador aux;

		System.out.println("=============================================");
		System.out.println("SEJA BEM-VINDO AO JOGO DA FORCA");
		System.out.println("*** Jogo Multiplayer ***");
		System.out.println("=============================================");

		System.out.print("\nDigite o nome do primeiro jogador: ");
		Jogador jog1 = new Jogador(Leitor.next());

		System.out.print("\nDigite o nome do segundo jogador: ");
		Jogador jog2 = new Jogador(Leitor.next());
		
		while(jogar){
			System.out.println("\n=============================================");

			System.out.println("\nSua vez: "+jog1.name);
			System.out.print("Digite uma palavra, que contemple apenas letras: ");
			Palavra esc = new Palavra(Leitor.next());

			System.out.println("\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n");
			
			while((jog2.acertos < esc.palavra.length()) && (jog2.erros < 10)){
				System.out.println("\n" + esc.newPalavra);
				System.out.print(jog2.name + ", digite uma letra: ");
				esc.chute(Leitor.next(), jog2);
			}
			if(jog2.erros >= 10){
				System.out.format("\nQue pena %s, você extourou o número de erros\n", jog2.name);
				jog1.vitorias++;
			}else{
				System.out.format("\nMuito bem %s, você adivinhou\n", jog2.name);
				jog2.vitorias++;
			}
			
			jog1.totErros = jog1.erros;
			jog2.totErros = jog2.erros;
			
			jog1.erros = 0;
			jog2.erros = 0;
			jog1.acertos = 0;
			jog2.acertos = 0;
			
			System.out.print("\nVOCÊS DESEJAM JOGAR NOVAMENTE: (digite s OU n) ");
			if(!Leitor.next().toLowerCase().equals("s")){
				jogar = false;
			}else{				
				aux = jog1;
				jog1 = jog2;
				jog2 = aux;
			}
		}
		
		System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("FIM DA PARTIDA\n");
		if(jog1.vitorias > jog2.vitorias){
			System.out.format("\nParabéns %s, você foi o VENCEDOR, pois teve mais vitórias", jog1.name);
		}else if(jog1.vitorias == jog2.vitorias){
			if(jog1.totErros < jog2.totErros){
				System.out.format("\nParabéns %s, você foi o VENCEDOR, pois teve menos erros", jog1.name);
			}else if(jog1.totErros > jog2.totErros){
				System.out.format("\nParabéns %s, você foi o VENCEDOR, pois teve menos erros", jog2.name);
			}else{
				System.out.println("A partida terminou empatada.");
			}
		}else{
			System.out.format("Parabéns %s, você foi o VENCEDOR, pois teve mais vitórias", jog2.name);
		}
		
	}

}
