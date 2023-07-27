package Aula_7;

public class Exercicio_2 {
    public static void main(String[] args) {
        System.out.println(somar(5));
        System.out.println(multiplicar(6));
    }
    
    public static int somar(int limite){
        if (limite == 0){
            return 0;
        }
        
        return limite + somar(limite - 1);
    }
    
    public static int multiplicar(int limite){
        if (limite == 0){
            return 1;
        }
        
        return limite * multiplicar(limite - 1);
    }
}
