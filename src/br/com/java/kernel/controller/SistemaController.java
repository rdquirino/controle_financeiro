package br.com.java.kernel.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller(value="sistemaController")
@Scope("request")
public class SistemaController {

	private Date dataHora = new Date();
	
	
	public void relogio(){
		dataHora = Calendar.getInstance(new Locale("BR")).getTime();
	}


	 public void actionPerformed(){  
	       try{  
	            Runtime.getRuntime().exec("calc"); //assim  
	            Runtime.getRuntime().exec("C:\\Windows\\System32\\calc.exe"); //e assim  
	       }catch(Exception es){  
	            System.err.println("Deu pau!");  
	       }  
	 }  
	
	
	
	// ####################### GET e SET ###########################
	
	
	public Date getDataHora() {
		return dataHora;
	}


	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	
	
	
	
}
