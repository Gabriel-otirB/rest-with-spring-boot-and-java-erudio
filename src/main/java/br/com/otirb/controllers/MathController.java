package br.com.otirb.controllers;

import br.com.otirb.exception.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.NoSuchFileException;

@RestController
@RequestMapping("/math")
public class MathController {

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{number1}/{number2}")
    public Double sum(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2
    ) throws Exception {
        if (!isNumeric(number1) || !isNumeric(number2)) throw new UnsuportedMathOperationException("Please set a numeric value!");
        return convertToDouble(number1) + convertToDouble(number2);
    }

    // http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{number1}/{number2}")
    public Double subtraction(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2
    ) throws Exception {
        if (!isNumeric(number1) || !isNumeric(number2)) throw new UnsuportedMathOperationException("Please set a numeric value!");
        return convertToDouble(number1) - convertToDouble(number2);
    }

    // http://localhost:8080/math/multiplication/3/5
    @RequestMapping("/multiplication/{number1}/{number2}")
    public Double multiplication(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2
    ) throws Exception {
        if (!isNumeric(number1) || !isNumeric(number2)) throw new UnsuportedMathOperationException("Please set a numeric value!");
        return convertToDouble(number1) * convertToDouble(number2);
    }

    // http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{number1}/{number2}")
    public Double division(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2
    ) throws Exception {
        if (!isNumeric(number1) || !isNumeric(number2)) throw new UnsuportedMathOperationException("Please set a numeric value!");
        return convertToDouble(number1) / convertToDouble(number2);
    }

    // http://localhost:8080/math/square root/3/5
    @RequestMapping("/square_root/{number}")
    public Double square_root(
            @PathVariable("number") String number
    ) throws Exception {
        if (!isNumeric(number)) throw new UnsuportedMathOperationException("Please set a numeric value!");
        return Math.sqrt(convertToDouble(number));
    }

    // http://localhost:8080/math/average/3/5
    @RequestMapping("/average/{number1}/{number2}")
    public Double average(
            @PathVariable("number1") String number1,
            @PathVariable("number2") String number2
    ) throws Exception {
        if (!isNumeric(number1) || !isNumeric(number2)) throw new UnsuportedMathOperationException("Please set a numeric value!");
        return (convertToDouble(number1) + convertToDouble(number2)) / 2;
    }

    private Double convertToDouble(String strNumber) throws Exception {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsuportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
