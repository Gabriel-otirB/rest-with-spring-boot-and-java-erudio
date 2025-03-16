package br.com.otirb.utils;

import br.com.otirb.exception.UnsuportedMathOperationException;

public class MathUtils {

    public MathUtils(){}

     public static Double convertToDouble(String strNumber) throws Exception {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsuportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
