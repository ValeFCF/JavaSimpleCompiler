import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emmanuel Valentín Granados López
 * 
 */
public class CompiladorSimple 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
    	
    	String linea=""; 
    	
    	File f = new File( "C:\\ab.txt" ); 
    	BufferedReader entrada=null; 
    	try { 
    	entrada = new BufferedReader( new FileReader( f ) ); 
    	
    	while(entrada.ready()){ 
    	linea = entrada.readLine(); 
    	System.out.println(linea + " Esta linea se obtuvo desde un txt"); 
    	} 
    	}catch (IOException e) { 
    	e.printStackTrace(); 
    	} 
    	finally 
    	{ 
    	try{ 
    	entrada.close(); 
    	}catch(IOException e1){} 
    	} 
    	
	
        // Prueba del lexer
        
        String palabra1 = "-1/1-2*3+4";
        String palabra2 = "324+54+4567/4563-12345678900987654321*1";
        String palabra3 = "1/11*11+11-1P";
        
     
        Lexer lex = new Lexer();
        
        Parser parser = new Parser();
    
     // Prueba lexer para cadena obtenida en txt desde C:\\
        if (linea.matches ("[0-9(\\+|\\/|\\-|\\*)*]*")) {
        lex.setCadena(linea);
        System.out.println("Lexer Para txt: " + linea + " Token devuelto: " + ((lex.edo0() == 0) ? "ACEPTADA" : "INVALIDA"));
        System.out.println("Parser: txt");
        parser.parse(linea + ";",';');
        
        	}
        else {
           	System.out.println("error : se encontraron caracteres distintos a los permitidos");
           	}
        
        if (palabra1.matches ("[0-9(\\+|\\/|\\-|\\*)*]*")) {
        	lex.setCadena(palabra1);
            System.out.println("Lexer Para 1: " + palabra1 + " Token devuelto: " + ((lex.edo0() == 0) ? "ACEPTADA" : "INVALIDA"));
            System.out.println("Parser: palabra1");
            parser.parse(palabra1 + ";",';');
        	} 
        else {
       	System.out.println("error : se encontraron caracteres distintos a los permitidos");
       	}
        
        
        if (palabra2.matches ("[0-9(\\+|\\/|\\-|\\*)*]*")) {
        	lex.setCadena(palabra2);
            System.out.println("Lexer Para 2: " + palabra2 + " Token devuelto: " + ((lex.edo0() == 0) ? "ACEPTADA" : "INVALIDA"));
            System.out.println("Parser: palabra2");
            parser.parse(palabra2 + ";",';');
        	} 
        else {
       	System.out.println("error : se encontraron caracteres distintos a los permitidos");
       	}
        
        if (palabra3.matches ("[0-9(\\+|\\/|\\-|\\*)*]*")) {
        	lex.setCadena(palabra3);
            System.out.println("Lexer Para 3: " + palabra3 + " Token devuelto: " + ((lex.edo0() == 0) ? "ACEPTADA" : "INVALIDA"));
            System.out.println("Parser: palabra3");
            parser.parse(palabra3 + ";",';');
        	} 
        else {
       	System.out.println("error : se encontraron caracteres distintos a los permitidos");
       	}
        
   
        // Prueba del parser
        
       
        System.out.println("---------Solo");
        parser.parse("12+345*678/90;12++3432", ';');
        
    }
}
