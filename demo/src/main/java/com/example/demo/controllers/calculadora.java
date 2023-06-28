package com.example.demo.controllers;

import com.example.demo.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;



@RestController
public class calculadora {


    @GetMapping("/sum/{num1}/{num2}")
    public BigDecimal sum(@PathVariable String num1, @PathVariable String num2 ){
        if(!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedMathOperationException("Um dos valores digitados não é um numero");
        }
        return convertToBigDecimal(num1).add(convertToBigDecimal(num2));
    }


    @GetMapping("/sub/{num1}/{num2}")
    public BigDecimal sub(@PathVariable String num1, @PathVariable String num2){
        if(!isNumeric(num2) || !isNumeric(num2)) {
            throw new UnsupportedMathOperationException("Um dos valores digitados não é um numero");
        }
        return convertToBigDecimal(num1).subtract(convertToBigDecimal(num2));
    }

    @GetMapping("mult/{num1}/{num2}")
    public BigDecimal mult(@PathVariable String num1, @PathVariable String num2){
        if(!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedMathOperationException("Um dos valores digitados não é um numero");
        }
        return convertToBigDecimal(num1).multiply(convertToBigDecimal(num2));
    }

    @GetMapping("div/{num1}/{num2}")
    public BigDecimal div(@PathVariable String num1, @PathVariable String num2){
        if(!isNumeric(num1) || !isNumeric(num2)){
            throw new UnsupportedMathOperationException("Um dos valores digitados não é um numero");
        }
        return convertToBigDecimal(num1).divide(convertToBigDecimal(num2));
    }

    @GetMapping("media/{num1}/{num2}/{num3}")
    public BigDecimal media(@PathVariable String num1, @PathVariable String num2, @PathVariable String num3){
        if(!isNumeric(num1) || !isNumeric(num2) || !isNumeric(num3)){
            throw new UnsupportedMathOperationException("Um dos valores digitados não é um numero");
        }
        return (convertToBigDecimal(num1).add(convertToBigDecimal(num2)).divide(convertToBigDecimal(num3)));
    }

    @GetMapping("potencia/{num1}/{num2}")
    public BigDecimal potencia(@PathVariable String num1, @PathVariable String num2){
        if (!isNumeric(num1) || !isNumeric(num2)){
            throw  new UnsupportedMathOperationException("Um dos valores digitados não é um numero");
        }
        return convertToBigDecimal(num1).pow(convertToInt(num2));
    }

    private BigDecimal convertToBigDecimal(String num) {
        if(num == null)return BigDecimal.valueOf(0);
        String number = num.replace(",", ".");
        if(isNumeric(number)) return new BigDecimal(number);
        return null;
    }

    private Integer convertToInt(String num) {
        if(num == null)return 0;
        String number = num.replace(",", ".");
        if(isNumeric(number)) return Integer.parseInt(num);
        return null;
    }


    private boolean isNumeric(String num) {
        if(num == null) return false;
        String number = num.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
