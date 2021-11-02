import java.util.ArrayList;
import java.lang.Math;
public class Conversao_Decimal
{

    //metodo para converter nimeros em todas as bases para base decimal (excepto ela mesma)
    public int Transmudar(ArrayList<Integer>arrayNr,int base){
        int resultado = 0, index = 0;

        for(int i = arrayNr.size() - 1; i >= 0; i-- ){
            resultado += arrayNr.get(index++) * Math.pow(base,i);
        }
        return resultado;
    }

}
