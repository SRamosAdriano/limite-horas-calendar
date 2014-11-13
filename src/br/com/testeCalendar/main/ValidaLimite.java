package br.com.testeCalendar.main;

import java.util.Calendar;

public class ValidaLimite {

	public static final int TEMPO_BLOQUEIO = 30;
	
	public static void main(String[] args) {
		int ano = 2013;
		int mes = 04;
		int dia = 27;
		int hora = 12;
		int minuto = 50;
		
		Calendar dtOcorencia = Calendar.getInstance();
		dtOcorencia.set(ano, mes - 1, dia, hora, minuto);
		
		ValidaLimite validaLimite = new ValidaLimite();
		
		validaLimite.limiteExedido(dtOcorencia);
	}
	
	public boolean limiteExedido(Calendar dtCalendar){
		
		if(tempoExedido(dtCalendar, TEMPO_BLOQUEIO)){
			return true;
		}else{
			return false;
		}
		
	}
	
	public boolean tempoExedido(Calendar dtCalendar, int limiteEmMinutos){
		boolean retorno;
		Calendar dtAtual = Calendar.getInstance();
		dtCalendar.add(Calendar.MINUTE, limiteEmMinutos);
		
		if(dtAtual.getTimeInMillis() < dtCalendar.getTimeInMillis()){
			System.out.println("Limite NÃO Exedido!!!!");
			retorno = false;
		}else{
			System.out.println("Limite Exedido!!!");
			retorno = true;
		}
		return retorno;	
	}
}
