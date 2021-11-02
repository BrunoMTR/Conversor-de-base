
import java.util.ArrayList;
import java.util.*;
public class Validacao_Entrada 
{

    public static ArrayList<Integer> Conversao(String entrada){
        String [] simbolos = {"A","B","C","D","E","F"};
        String [] numeros = {"10","11","12","13","14","15"};
        //criei e instanciei ArrayLists
        ArrayList<Character> caracteres = new ArrayList<Character>();
        ArrayList<String> arraySrt = new ArrayList<String>();

        //adiciona os caracteres do argumento entrada no arraylist de caracteres
        for (char c : entrada.toCharArray()){
            caracteres.add(c);
        }
        //converti arraylist de caracteres a array de caracteres
        Character[] arrayCaracteres = caracteres.toArray(new Character[0]);

        //adicionei os elementos do array de caracteres ao arraylist de strings
        for(int i = 0; i<arrayCaracteres.length;i++){

            arraySrt.add(arrayCaracteres[i].toString());

        }

        //COMPARA CADA ELEMENTO DO AARAYLIST DE STRINGS
        //COM TODOS OS ELEMENTOS DO ARRAY DE STRINGS COM LETRAS
        //E ALTERA CASO ENCONTRE O ELEMENTO PROCURADO PELO ELEMENTO DESEJADO NO ARRAY DE STRINGS COM NUMEROS E REPETE O CICLO
        for(int i = 0; i<arraySrt.size(); i++){
            for(int e = 0; e<simbolos.length; e++){
                if(arraySrt.get(i).equals(simbolos[e])){
                    arraySrt.set(i,numeros[e]);
                }
            }   
        }
        //crio e instancio um arraylist de integers
        ArrayList<Integer> arrayNr = new ArrayList<Integer>();
        //converter o arraylist de strings em arraylist de integers
        for(int i = 0; i < arraySrt.size(); i++) {
            arrayNr.add(Integer.parseInt(arraySrt.get(i)));   
        }

        return arrayNr;
    }

}
