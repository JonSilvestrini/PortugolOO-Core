/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonatas
 */
public class TokensGenBasico {
    private List<Token> tokens = new ArrayList();
    private Token token;
    
    public List getTokens(){
        token = new Token("metodo publico Principal()", "||203|", "public static void main(String args[])");
        tokens.add(token);
        token = new Token("classe publica", "||0| ||1|", "public class");
        tokens.add(token);
        token = new Token("publica", "||0|", "public");
        tokens.add(token);
        token = new Token("publico", "||0|", "public");
        tokens.add(token);
        token = new Token("classe", "||1|", "class");
        tokens.add(token);
        token = new Token("escreva", "||4|", "System.out.print");
        tokens.add(token);
        token = new Token("escrevaln", "||5|", "System.out.println");
        tokens.add(token);
        token = new Token("texto", "||6|", "String");
        tokens.add(token);
        token = new Token("inteiro", "||7|", "int");
        tokens.add(token);
        token = new Token("real", "||8|", "double");
        tokens.add(token);
        token = new Token("caractere", "||9|", "char");
        tokens.add(token);
        token = new Token("logico", "||10|", "boolean");
        tokens.add(token);
        token = new Token("verdadeiro", "||11|", "true");
        tokens.add(token);
        token = new Token("falso", "||12|", "false");
        tokens.add(token);
        token = new Token("nulo", "||13|", "null");
        tokens.add(token);
        token = new Token("vazio", "||14|", "void");
        tokens.add(token);
        token = new Token("caso", "||15|", "case");
        tokens.add(token);
        token = new Token("escolha", "||16|", "switch");
        tokens.add(token);
        token = new Token("para", "||17|", "for");
        tokens.add(token);
        token = new Token("enquanto", "||18|", "while");
        tokens.add(token);
        token = new Token("faca", "||19|", "do");
        tokens.add(token);
        token = new Token("estatico", "||20|", "static");
        tokens.add(token);
        token = new Token("constante", "||21|", "final");
        tokens.add(token);
        token = new Token("retorne", "||22|", "return");
        tokens.add(token);
        token = new Token("este.", "||23|.", "this.");
        tokens.add(token);
        token = new Token("super", "||24|", "super");
        tokens.add(token);
        return tokens;
    }
    
}
