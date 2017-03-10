package com.jogo;

/** Classe para objetos do tipo Jogador, responsável por criar e
 * menusear as informaçẽos/pontuação de cada jogador
 * @author Carlos Alberto, Christian e Ricardo
 * @version 1.0
 * @since 2017-03-10
*/
public class Jogador {
	
	private String name;
	private int totErros;
	private int erros;
	private int acertos;
	private int vitorias;
	
	/**
	  * Construtor da classe.
	  * @param name (obrigatório) nome do jogador - type (String)
	  * seta a pontuação como zero
	 */
	Jogador(String name){
		this.setName(name);
		this.setErros(0);
		this.setAcertos(0);
		this.setVitorias(0);
		this.setTotErros(0);
	}

	/**
	 * @return o nnumero de vitórias
	 */
	public int getVitorias() {
		return vitorias;
	}

	/**
	 * @param vitorias, insere o número de vitórias
	 */
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	/**
	 * @return a quantidade de erros cometidos na partida
	 */
	public int getErros() {
		return erros;
	}

	/**
	 * @param erros, insere erros
	 */
	public void setErros(int erros) {
		this.erros = erros;
	}

	/**
	 * @return a quantidade total de erros desse jogador no jogo
	 */
	public int getTotErros() {
		return totErros;
	}

	/**
	 * @param totErros, insere no total de erros
	 */
	public void setTotErros(int totErros) {
		this.totErros = totErros;
	}

	/**
	 * @return o número de acertos
	 */
	public int getAcertos() {
		return acertos;
	}

	/**
	 * @param acertos, insere acertos
	 */
	public void setAcertos(int acertos) {
		this.acertos = acertos;
	}

	/**
	 * @return o nome do jogador
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name, insere/altera o nome do jogador
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return atualiza a pontuação total de erros desse jogador e zero os erros da partida atual
	 */
	public void atualizaPontuacao(){
		this.setTotErros(this.getErros());
		
		this.setErros(0);
		this.setAcertos(0);
	}

	
}
