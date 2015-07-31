package br.com.geradorDeclasses;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
	    BaseDeArquivo base = new BaseDeArquivo();
	    
	    String pacoteJava = null;
	    String pacoteHtml = null;
	    String pacoteCss = null;
	    
	    base.criaPacote(pacoteJava, pacoteHtml, pacoteCss);
	}
	
}
