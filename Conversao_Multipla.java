
import java.util.ArrayList;
import java.util.*;
public class Conversao_Multipla
{

    public static ArrayList<Integer> Transmudar_Final(int decimal,int base){
        ArrayList<Integer>resultado = new ArrayList<Integer>();

        for(int i = decimal; i > 0; i/=base){
            resultado.add( i % base);
        }
        Collections.reverse(resultado);
        return resultado;  
    }


}
