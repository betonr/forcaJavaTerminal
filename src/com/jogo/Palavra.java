package com.jogo;

public class Palavra {
	
	String palavra;
	String newPalavra = "";
	int tamanho;
	
	String chutes = "";
	Jogador jog;
	
	Palavra(String esc){
		palavra = esc;
		tamanho = palavra.length();
		controiPalavra();
	}
	
	void controiPalavra(){
		int i;
		for(i=0;i<tamanho; i++){
			newPalavra+=" _"; 
		}
	}
	
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
			jog.erros++;
		}else{
			chutes += c;
			jog.erros++;
		}
	}
	
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
			jog.acertos++;
			
		}while(p.indexOf(letra)>=0 && !p.equals(""));
	}
	
	
	
}
