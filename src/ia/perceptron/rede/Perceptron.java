package ia.perceptron.rede;

import java.util.Random;

/*
 * @author Allyson Costa
 * @version 1.0
 * @description Rede Neural Perceptron com 1 Neurônio na Camada de Saída
 */

public class Perceptron {
	
	private double taxaDeAprendizagem;
	private int numeroDeCiclos;
	private double[] pesosSinapticos;
	
	public Perceptron(double taxaDeAprendizagem, int numeroDeCiclos){
		this.taxaDeAprendizagem = taxaDeAprendizagem;
		this.numeroDeCiclos = numeroDeCiclos;
	}

	public void inicializarRede(double[][] entradas, double[] saidaDesejada){
		// Iniciando a rede utilizando os pesos aleatórios para a rede
		
		double erro = 1.0; // sem uso por enquanto
		int num = 0;
		
		pesosSinapticos = gerarPesosIniciais(entradas[0].length);
		
		while(num < this.numeroDeCiclos){
			
			for(int i = 0; i < entradas.length; i++){
				
				double saida = funcaoAvaliacaoDegrau(calcularEntradaLiquida(entradas[i], pesosSinapticos));
				
				if(saida != saidaDesejada[i]){
					
					pesosSinapticos = this.atualizarPesos(entradas[i], pesosSinapticos, saidaDesejada[i] - saida);
				}
			}
			
			num++;
		}
		System.out.println("Rede Treinada em " + num + " Ciclos!");
	}
	
	public void inicializarRede(double[][] entradas, double[] saidaDesejada, double[] pesosSinapticosIniciais){
		// Iniciando a rede utilizando como parâmetro adicional os pesos iniciais
		
		double erro = 1.0; // sem uso por enquanto
		int num = 0;
		
		pesosSinapticos = pesosSinapticosIniciais;
		
		while(num < this.numeroDeCiclos){
			
			for(int i = 0; i < entradas.length; i++){
				
				double saida = funcaoAvaliacaoDegrau(calcularEntradaLiquida(entradas[i], pesosSinapticos));
				
				if(saida != saidaDesejada[i]){
					
					pesosSinapticos = this.atualizarPesos(entradas[i], pesosSinapticos, saidaDesejada[i] - saida);
				}
			}
			
			num++;
		}
		System.out.println("Rede Treinada em " + num + " Ciclos!");
	}
	
	public void classificar(double[] entradas){
		
		double resultado = funcaoAvaliacaoDegrau(calcularEntradaLiquida(entradas, pesosSinapticos));
		
		System.out.println("Resultado: " + resultado);
	}
	
	private double[] gerarPesosIniciais(int tamanho){
		
		Random gerador = new Random();
		double[] pesosIniciais = new double[tamanho];
		
		for(int i = 0; i < pesosIniciais.length; i++){
			pesosIniciais[i] = gerador.nextDouble();
		}
		
		return pesosIniciais;
	}
	
	private double [] atualizarPesos(double[] entradas, double[] pesos, double erro){

		double [] pesosAux = new double[pesos.length];
		
		for(int i = 0; i < pesos.length; i++){
			pesosAux[i] = pesos[i] + this.taxaDeAprendizagem * erro * entradas[i];
		}
		
		return pesosAux;
	}
	
	private double[] ajustarEntradas(double [] entradas){
		// Adiciona ao Vetor de Entradas a Entrada X0 = + 1.0
		double [] entradasAux = new double[entradas.length + 1];
		
		entradasAux[0] = 1.0;
		
		for(int i = 0, j = 1; i < entradas.length; i++, j++){
			entradasAux[j] = entradas[i];
		}
		
		return entradasAux;
	}
	
	private double[][] ajustarEntradas(double [][] entradas){
		// Adiciona à Matriz de Entradas o Valor X0 = + 1.0 a cada Linha da Matriz
		double [][] entradasAux = new double[entradas.length][entradas[0].length + 1];
		
		for(int i = 0; i < entradas.length; i++){
			entradasAux[i][0] = 1.0;
		}
		
		for(int i = 0; i < entradas.length; i++){
			
			for(int j = 0; j < entradas[0].length; j++){
				entradasAux[i][j+1] = entradas[i][j];
			}
		}
		
		return entradasAux;
	}
	
	private double calcularEntradaLiquida(double[] entradas, double[] pesos){
		
		double net = 0;
		
		for(int i = 0; i < entradas.length; i++){
			net += entradas[i] * pesos[i];
		}
		
		return net;
	}
	
	private int funcaoAvaliacaoDegrau(double net){
		
		if(net >= 0){
			return 1;
		} else {
			return 0;
		}
	}

}
