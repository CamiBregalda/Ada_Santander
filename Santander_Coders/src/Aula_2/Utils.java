package Aula_2;

import java.util.Scanner;

public class Utils {
    
    public static int lerInt(){
        Scanner scanner = new Scanner(System.in);
        
        String msg = scanner.nextLine();
        int num = Integer.parseInt(msg);
        
        return num;
    }
    
}
