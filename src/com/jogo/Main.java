package com.jogo;

import java.util.Scanner;

/** Classe Principal do jogo da forca no terminal, responsável pelo template do projeto
 * @author Carlos Alberto, Christian e Ricardo
 * @version 1.0
 * @since 2017-03-10
*/
public class Main {

	private static Scanner Leitor;

	public static void main(String[] args) {

		Leitor = new Scanner(System.in);
		boolean jogar = true;
		Jogador aux;
		
		/* prints iniciais do jogo */
		System.out.println("=============================================");
		System.out.println("SEJA BEM-VINDO AO JOGO DA FORCA");
		System.out.println("*** Jogo Multiplayer ***");
		System.out.println("=============================================");

		System.out.print("\nDigite o nome do primeiro jogador: ");
		/* criação de um novo jogador, com o nome estabelecido pelo usuário */
		Jogador jog1 = new Jogador(Leitor.next());

		System.out.print("\nDigite o nome do segundo jogador: ");
		/* criação de um novo jogador, com o nome estabelecido pelo usuário */
		Jogador jog2 = new Jogador(Leitor.next());
		
		/* inicio de uma partida no jogo, caso a variavel boolean estiver setado com TRUE */
		while(jogar){
			System.out.println("\n=============================================");

			System.out.println("\nSua vez: "+jog1.getName());
			System.out.print("Digite uma palavra, que contemple apenas letras: ");
			/* submissão de uma palavra ao jogo, essa que é digitada pelo jogador */
			Palavra esc = new Palavra(Leitor.next());
			
			/* popular linhas, para limpar a area de escrita do terminal */
			System.out.println("\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n");
			
			/* repetição da ação de solicitação de uma letra, desde que a palavra não tenha sido descoberta
			 * ou o usuário não tenha o número de submissões erradas, nessa palavra, igual a 10.
		    */
			while((jog2.getAcertos() < esc.palavra.length()) && (jog2.getErros() < 10)){
				System.out.println("\n" + esc.newPalavra);
				System.out.print(jog2.getName() + ", digite uma letra: ");
				esc.chute(Leitor.next(), jog2);
			}
			if(jog2.getErros() >= 10){
				System.out.format("\nQue pena %s, você extourou o número de erros\n", jog2.getName());
				jog1.setVitorias(jog1.getVitorias() + 1);
			}else{
				System.out.format("\nMuito bem %s, você adivinhou\n", jog2.getName());
				jog2.setVitorias(jog2.getVitorias() + 1);
			}
			
			/* chama uma função da classe Jogador, responsável por atualizar a pontuação dos jogadores */
			jog1.atualizaPontuacao();
			jog2.atualizaPontuacao();
			
			/* pergunta se os jogadores desejam continuar jogando
			 * resposta = s -> inverte a ordem de jogada dos jogadores
			 * resposta = n -> finaliza o jogo 
		    */
			System.out.print("\nVOCÊS DESEJAM CONTINUAR JOGANDO: (digite s OU n) ");
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
		
		/* definição do vencedor da partida, de acordo com a pontuação de cada jogador 
		 * fator de decisão: número de vitórias
		 * critério de desempate: número de submissões erradas
		*/
		if(jog1.getVitorias() > jog2.getVitorias()){
			System.out.format("\nParabéns %s, você foi o VENCEDOR, pois teve mais vitórias", jog1.getName());
		}else if(jog1.getVitorias() == jog2.getVitorias()){
			if(jog1.getTotErros() < jog2.getTotErros()){
				System.out.format("\nParabéns %s, você foi o VENCEDOR, pois teve menos erros", jog1.getName());
			}else if(jog1.getTotErros() > jog2.getTotErros()){
				System.out.format("\nParabéns %s, você foi o VENCEDOR, pois teve menos erros", jog2.getName());
			}else{
				System.out.println("A partida terminou empatada.");
			}
		}else{
			System.out.format("Parabéns %s, você foi o VENCEDOR, pois teve mais vitórias", jog2.getName());
		}
		
	}

}
