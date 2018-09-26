/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portugoloo.interpretador;

import java.util.List;
import java.util.regex.Matcher;

/**
 *
 * @author root
 */
public class interprete {
	StringBuilder codigoFinal;

	public interprete(){
		codigoFinal = new StringBuilder();
	}

	/* "gerarCodigo" está retornando uma string temporariamente para testes,
	 * futuramente ela irá gerar um arquivo java
	 */
	public String gerarCodigo(List<String> lista) {

		for(final String item :lista) {

			codigoFinal.append(translate(item));

		}
			
		return codigoFinal.toString();
	}
	
	private static String translate(String input) {
		
		
		
		String output = input;

		output=output.replace("||0|", "public");
		output=output.replace("||1|", "class");
		output=output.replace("||2|", "method");
		output=output.replace("||3|", "main");
		output=output.replace("||4|", "System.out.print");
		output=output.replace("||5|", "System.out.println");
		output=output.replace("||6|", "String");
		output=output.replace("||7|", "int");
		output=output.replace("||8|", "double");
		output=output.replace("||9|", "char");
		output=output.replace("||10|", "boolean");
		output=output.replace("||11|", "true");
		output=output.replace("||12|", "false");
		output=output.replace("||13|", "null");
		output=output.replace("||14|", "void");
		output=output.replace("||15|", "case");
		output=output.replace("||16|", "switch");
		output=output.replace("||17|", "for");
		output=output.replace("||18|", "while");
		output=output.replace("||19|", "do");
		output=output.replace("||20|", "static");
		output=output.replace("||21|", "final");

		return output;
	}
}
