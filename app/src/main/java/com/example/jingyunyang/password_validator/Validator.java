package com.example.jingyunyang.password_validator;

/**
 * Created by JingyunYang on 2018/2/9.
 */

public class Validator {
        static int[] getArrary(String inputPassword){
            int correctRuleArray[] = {0, 0, 0, 0, 0};               // array storing whether rule is correct
            int passedRules = 0;
            if (!inputPassword.equals( "password"))               // rule 1: check if password is "password"
                correctRuleArray[0] = 1;
            if(inputPassword.length() >= 8)                         //rule 2: check if length of password >= 8
                correctRuleArray[1] = 1;
            if(!inputPassword.equals(inputPassword.toLowerCase()))  //rule 3: check if contains an upper case letter
                correctRuleArray[2] = 1;
            if(!inputPassword.equals(inputPassword.toUpperCase()))  //rule 4: check if contains a lower case letter
                correctRuleArray[3] = 1;
            //if(inputPassword.matches(".*\\d+.*"))           //rule 5: check if contains a digit
            if(!inputPassword.equals(inputPassword.replaceAll("[*0-9]", "")))
                correctRuleArray[4] = 1;
            return correctRuleArray;
        }
        // count the correct rules
        static int validate(int[] array){
            int count = 0;
            for(int i=0; i< array.length;i++)
                count += array[i];
            return count;
        }



    }
