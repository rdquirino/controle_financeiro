package br.com.geradorDeclasses;

import java.io.File;
import java.io.IOException;

public class BaseDeArquivo {

	String java;
	String html;
	String css;
	
	
	
	/**
	 * 
	 * @param:
	 * java ==> pacote para os arquivos Java
	 * html ==> pacote para os arquivos html
	 * css ==> pacote para os arquivos css
	 * 
	 */
	public String criaPacote(String java, String html, String css){
		
		if(java != null){
			
			this.java ="C://Ambiente Java//repositorio-java//ControleFinanceiro//src//br//com//java//kernel//"+java;
			File file = new File(this.java);
			boolean teste = file.mkdirs();
		}
		
		if(html != null){
			
			this.html ="C://Ambiente Java//repositorio-java//ControleFinanceiro//WebContent//paginas//"+html;
			File file = new File(this.html);
			boolean teste = file.mkdirs();
		}
		
		if(css != null){
			
			this.css ="C://Ambiente Java//repositorio-java//ControleFinanceiro//WebContent//resources//css//"+css;
			File file = new File(this.css);
			boolean teste = file.mkdirs();
		}
		
		return null;
		
	}
	
	/**
	 * 
	 * @param pacote
	 * @throws IOException 
	 */
	public String criaArquivo(String arquivo) throws IOException{
		File file = new File(arquivo);
		
		boolean teste = file.createNewFile();
		
		return arquivo;
	}
	
	
}