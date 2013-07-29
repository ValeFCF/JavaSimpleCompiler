/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
* @author Emmanuel Valentín Granados López
 * 
 */
public class Parser 
{
    enum Tokens
    {
        ACEPTADA,
        INVALIDA,
        PUNTOYCOMA,
        EOF
    }
    
    public void parse(String secuencia, char delimitador)
    {
        Lexer lex = new Lexer();
        Tokens token = Tokens.EOF;
        String buffer = "";
        int pos = 0;
        
        do
        {
            if (pos < secuencia.length())
            {
                while(secuencia.charAt(pos) != delimitador)
                {
                    buffer+= secuencia.charAt(pos);
                    pos++;
                    if (pos >= secuencia.length()) break;
                }
                
                if(!buffer.equals(""))
                {
                    lex.setCadena(buffer);
                    if(lex.edo0() == 0)
                        token = Tokens.ACEPTADA;
                    else
                        token = Tokens.INVALIDA;
                    buffer = "";

                }
                else if(secuencia.charAt(pos) == ';')
                {
                    token = Tokens.PUNTOYCOMA;
                    pos++;
                }
            }
            else
                token = Tokens.EOF;
            
            System.out.println(token.name());
            
        }while(token != Tokens.EOF);
    }
    
}

