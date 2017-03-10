package com.jogo;

/** Classe para objetos do tipo Palavra, essa fará a montagem de um palavra passada como parametro e
 * o tratamento das suposições de adivinhação da palavra escolhida
 * @author Carlos Alberto, Christian e Ricardo
 * @version 1.0
 * @since 2017-03-10
*/
public class Palavra {
	
	public String palavra;
	public String newPalavra = "";
	public int tamanho;
	
	public String chutes = "";
	public static Jogador jog;
	
	/**
	  * Construtor da classe.
	  * @param esc (obrigatório) Palavra inserida pelo jogador - type (String)
	 */
	Palavra(String esc){
		palavra = esc;
		tamanho = palavra.length();
		controiPalavra();
	}
	
	/** Construção de uma nova string, contendo um espaço e um underline (" _") para cada
	 * letra da palavra recebida no contrutor. 
	 * @return Void - null (print)
	*/	
	void controiPalavra(){
		int i;
		for(i=0;i<tamanho; i++){
			newPalavra+=" _"; 
		}
	}
	
	/** Função responsável por tratar a string passada por parametro,
	 * verificar se a mesma está dentro da palavra escolhida na classe pai
	 * e atribuir pontos ao jogador que informou a string passado como parametro.
	 * @param c (obrigatório) Uma letra - type (String)
	 * @param jog (obrigatório) extends class Jogador - type (Jogador)
	 * @return Void - null (print)
	*/	
	void chute(String c, Jogador jog){
		c = c.toLowerCase();
		String alfabeto = "abcdefghijklmnopqrstuvxwyz";
		
		if(c.length() > 1 || alfabeto.indexOf(c) < 0){
			System.out.println("=== Chute Inválido, é necessário digitar apenas um letra");
		}else if(newPalavra.indexOf(c) >= 0){
			System.out.println("=== Você já digitou essa letra correta");
		}else if(palavra.indexOf(c) >= 0){
			mudaNewPalavra(c, jog);
		}else if(chutes.indexOf(c) >= 0){
			System.out.println("=== Você já digitou essa letra incorreta");
			jog.setErros(jog.getErros() + 1);
		}else{
			chutes += c;
			jog.setErros(jog.getErros() + 1);
		}
	}
	
	/** Função responsável por tratar a nova string criada, 
	 * substituindo o underline pela letra correta submetida pelo usuário
	 * @param letra (obrigatório) Uma letra - type (String)
	 * @param jog (obrigatório) extends class Jogador - type (Jogador)
	 * @return Void - null (print)
	*/	
	void mudaNewPalavra(String letra, Jogador jog){
		String p = palavra;
		do{
			int pos = p.indexOf(letra);
			
			if(pos+1 == p.length()){
				newPalavra = newPalavra.substring(0, pos*2+1) + letra;
				p = "";
			}else if(pos == 0){
				newPalavra = " " + letra + newPalavra.substring(pos+2);
				p = " " + p.substring(pos+1);
			}else{
				newPalavra = newPalavra.substring(0, pos*2+1) + letra + newPalavra.substring(pos*2+2);
				p = p.substring(0, pos)+ " " + p.substring(pos+1);
			}
			jog.setAcertos(jog.getAcertos() + 1);
			
		}while(p.indexOf(letra)>=0 && !p.equals(""));
	}
	
	
	
}
