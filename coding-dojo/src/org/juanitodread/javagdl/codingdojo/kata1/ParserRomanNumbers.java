package org.juanitodread.javagdl.codingdojo.kata1;

/**
 * @author juanitodread
 * date: 3/14/12
 */
public class ParserRomanNumbers {
    public static int[] arabigos = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


    public static String parserNaturalToRoman(int natural){
        if(natural > 3999 || natural < 1){
            return "Número fuera de rango :(";
        }
        String romano = "";
        int denominador, residuo,   repetir;
        for(int base = 0; base < arabigos.length; base++){
            if(natural >= arabigos[base]){
                residuo = natural % arabigos[base];
                denominador = natural - residuo;
                repetir = denominador / arabigos[base];
                for(int i = 0; i < repetir; i++){
                    romano = romano.format("%s%s", romano, romanos[base]);
                }
                natural = residuo;
            }
        }

        return romano;
    }
}
