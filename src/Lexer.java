/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emmanuel Valentín Granados López
 * 
 */
public class Lexer 
{
    static final int ERROR = -1;
    static final int ACEPTAR = 0;
    
    private String cadena = "";
    private int cont = 0;
    
    
    public void setCadena(String cadena) 
    {
        this.cadena = cadena; 
        cont = 0;
    }
    
    char obtenerCaracter()
    {
        char c = (cont >= cadena.length()) ? 'z' : cadena.charAt(cont);
        cont++;
        return c;
    }
    
    int edo0()
    {
        char c = obtenerCaracter();
        switch(c)
        {
            case '0': return edo1();
            case '1': return edo1();
            case '2': return edo1();
            case '3': return edo1();
            case '4': return edo1();
            case '5': return edo1();
            case '6': return edo1();
            case '7': return edo1();
            case '8': return edo1();
            case '9': return edo1();
            default: return ERROR;
        }
    }
    
    int edo1()
    {
 	
        char c = obtenerCaracter();
          
       switch(c)
        {
       		
        	case '0': return edo1();
    		case '1': return edo1();
    		case '2': return edo1();
    		case '3': return edo1();
    		case '4': return edo1();
    		case '5': return edo1();
    		case '6': return edo1();
    		case '7': return edo1();
    		case '8': return edo1();
    		case '9': return edo1();
       
            case '+': return edo2();
            case '-': return edo2();
            case '*': return edo2();
            case '/': return edo2();
           
            
        }
       
       return ACEPTAR;
       
    
    }
    
    int edo2()
    {
        char c = obtenerCaracter();
        switch(c)
        {
        case '0': return edo1();
    	case '1': return edo1();
    	case '2': return edo1();
    	case '3': return edo1();
    	case '4': return edo1();
    	case '5': return edo1();
    	case '6': return edo1();
    	case '7': return edo1();
    	case '8': return edo1();
    	case '9': return edo1();
        default: return ERROR;
        }
    }
    
   
       
   
}
