
import java.util.ArrayList;
import java.util.*;
public class Validacao_Saida 
{

    public static String Conversao_Final(ArrayList<Integer>entrada){

        //arrays para troca
        String [] simbolos = {"A","B","C","D","E","F"};
        String [] numeros = {"10","11","12","13","14","15"};

        //intanciacao de array de int com tamanho do arralist de entrada
        int [] arrayIntTemporario = new int [entrada.size()];

        //intanciacao de array de string com tamanho do array de int
        String[] strArray = new String[arrayIntTemporario.length];

        //for loop para adicionar os elementos do arraylist de integers
        //no array de int
        for(int i = 0; i < entrada.size(); i++){
            arrayIntTemporario[i] = entrada.get(i);
        }

        //for loop para converter de array de int para array de string
        for (int i = 0; i < arrayIntTemporario.length; i++) {
            strArray[i] = String.valueOf(arrayIntTemporario[i]);

        }

        //troca dos numeros encontrados no array numeros pelos elementos de mesmo index no array simbolos
        for(int i = 0; i<strArray.length; i++){
            for(int e = 0; e<numeros.length; e++){
                if(strArray[i].equals(numeros[e])){
                    strArray[i] = simbolos[e];
                }
            }   
        }

        String resposta = Arrays.toString(strArray);
        return resposta;
    }

  
}

