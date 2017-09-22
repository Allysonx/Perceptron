package ia.perceptron;

import ia.perceptron.rede.Perceptron;

/*
 * @author Allyson Costa
 * @version 1.0
 * @description Rede Neural Perceptron com 1 Neurônio na Camada de Saída
 */

public class Principal {

	private static final double TAXA_DE_APRENDIZAGEM = 1.0;
	private static final int NUMERO_DE_CICLOS = 50;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Perceptron p = new Perceptron(Principal.TAXA_DE_APRENDIZAGEM, Principal.NUMERO_DE_CICLOS);
		
		/**Problema 1**/
		/**
		Problema para Classificar a função lógica "AND"
		 
		Entradas
		X1 = 0 0 1 1
		X2 = 0 1 0 1
		Saídas = 0 0 0 1
		
		double[][] conjuntoTreinamento = {{1,0,0},{1,0,1},{1,1,0},{1,1,1}};
		double[] saidasDesejadas = {0,0,0,1};
		double[] conjuntoTeste1 = {1,0,0};
		double[] conjuntoTeste2 = {1,0,1};
		double[] conjuntoTeste3 = {1,1,0};
		double[] conjuntoTeste4 = {1,1,1};
		
		p.inicializarRede(conjuntoTreinamento, saidasDesejadas2);
		p.classificar(conjuntoTeste1);
		p.classificar(conjuntoTeste2);
		p.classificar(conjuntoTeste3);
		p.classificar(conjuntoTeste4);  
		    
		**/
		
		/**Problema 2**/
		/**
		Problema para Classificar as letras T e H
		 
		Entradas
		T = 1,1,1,1,0,1,0,0,1,0
		H = 1,1,0,1,1,1,1,1,0,1
		Saídas = 1,0 
		    
		**/
		
		double[][] conjuntoTreinamento = {
				{1,1,1,1,0,1,0,0,1,0}, // Letra T
				{1,1,0,1,1,1,1,1,0,1}  // Letra H
		};
		
		double[] saidasDesejadas = {1,0};
		//double[] pesosIniciais = {0,0,0,0,0,0,0,0,0,0};
		
		double[] conjuntoTesteT = {1,1,1,1,1,1,1,0,1,0}; // Letra T Modificada
		double[] conjuntoTesteH = {1,1,0,0,1,1,1,1,0,1}; // Letra H Modificada
		
		//p.inicializarRede(conjuntoTreinamento, saidasDesejadas, pesosIniciais);
		p.inicializarRede(conjuntoTreinamento, saidasDesejadas);
		p.classificar(conjuntoTesteT);
		p.classificar(conjuntoTesteH);
		

		
		
	}

}
