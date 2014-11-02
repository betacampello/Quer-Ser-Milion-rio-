package com.example.quersermilionario;

import java.util.ArrayList;
import java.util.Random;

public class Perguntas {
	
		Random aleatorio;
		//perguntaFase é a variavel onde vou armazenar todas as perguntas de cada fase. Vou criar um objeto que no construtor vai me passar as perguntas da fase X
		private ArrayList<String[]> perguntasFase;
		//em perguntasEscolhidas, vou armazenar as 5 perguntas da fase X depois de fazer o radom
		private ArrayList<String[]> perguntasEscolhidas;
		int contador = 0;
		private String[] pergunta;
	     
		public Perguntas(){
			
		}
		
	    public Perguntas(ArrayList<String[]> perguntasFase){
	    	
	    	this.perguntasFase = perguntasFase;	
	    	this.perguntasEscolhidas =  new ArrayList<String[]>();
	    	this.aleatorio  = new Random();
	    	
		}
	    //a função escolheperguntas vai selecionar aleatoriamente 5 perguntas do txt atraves do radom
	    public ArrayList<String[]> escolhePerguntas() {   	
	    	
	    	while (perguntasEscolhidas.size() < 5) {  
	    		//em numero, estou escolhendo um numero aleatorio de 0 a 9
	    		int numero = aleatorio.nextInt(9);
	    		//estou colocando a pergunta com o numero aleatorio com as 4 respostas em uma string pergunta
	    		String[] pergunta = perguntasFase.get(numero);    		
	    		//estou vendo se a pergunta de cima já está no meu array perguntasescolhidas que começa vazio
	    		boolean repetido = perguntasEscolhidas.contains(pergunta);
	    		// se minha variavel repetido for verdadeiro, eu simplesmente repito o while
	    		if (repetido) {    		
	    			continue;
	    		//no caso que não seja true, ou seja, a pergunta selecionada não esteja no array perguntasescolhidas, entao eu adiciono ao array	
	    		} else {
		    		perguntasEscolhidas.add(pergunta);   		
		       	}
	    	
	    	}
	    	//no arraylist perguntasEscolhidas tenho um array de arrays. tenho todas as perguntas e respostas incluida a resposta correta. 
	    	
			return perguntasEscolhidas;
	    }
	    
	    //a função getPerguntaEscolhida tem como parametro um inteiro que escolhe qual pergunta do array de arrays vai mostrar
	    public String[] getPerguntaEscolhida (int numeroPergunta){
	    	//vou passar ao array pergunta uma das perguntas que tenho no meu array de arrays perguntasEscolhidas
	    	pergunta = this.perguntasEscolhidas.get(numeroPergunta);
	    	int tamanho = pergunta.length;
	    	System.out.println(tamanho);
	    	//vou passar ao array PerguntaSemResposta a pergunta e as 4 possiveis respostas, não vou passar a resposta correta, ela vai ficar guardada no array pergunta
	    	String [] PerguntaSemResposta = new String[5];    	
	    	for(int i = 0; i < 5; i ++){
	    		PerguntaSemResposta[i] = (pergunta[i]);
	        }
	    	
	    	return PerguntaSemResposta;
	    }
	    
	    //meu metodo comprova resposta recebera de parametro a resposta escolhida pelo usuario e comprovara se é a correta, se for, o metodo retorna true
	    public boolean comprovaResposta (String respostaEscolhida) {
	    	
	    	String respostaCerta = pergunta[5];
	    	boolean certo = respostaEscolhida.equals(respostaCerta);
	    	
			return certo;
	    	
	    }
	    
	    

}
