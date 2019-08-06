/**
 * Created by heymn on 14.07.2019.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

public class Main {

    //это стартовые записи, появляющиеся при старте приложения
    private static void firstPrintln() {
        System.out.println("-----------------------------------------------");
        System.out.println("Введите цифру варианта для фильтра владельцев:");
        System.out.println("ownerAge - возраст больше чем указанный");
        System.out.println("propertyCost - имущество дороже чем указанное");
        System.out.println("ownerName - по имени владельца");
        System.out.println("propertyName - по имени собственности");
        System.out.println("exit - выйти из программы");
        System.out.println("-----------------------------------------------");
    }

    private static String commandParcer(String stringToSql) {

        stringToSql = stringToSql.trim();
        stringToSql = stringToSql.toLowerCase();

        String changeStringToSql = "SELECT owners.* FROM owners JOIN own ON (owners.owners_name = own.owners_name) WHERE ";

        if (!"".equals(stringToSql)) {
            String[] words = stringToSql.split(" ");


            if (words[0].equals("exit")) {
                changeStringToSql = words[0];

            } else {

                for (String word : words) {

                    if ("".equals(word)) {
                        break;
                    }

                    if (word.contains("=")){

                        /*String command = word.replaceAll("[^a-zA-Z]","");
                        String argument = word.replaceAll("[\\D]","");*/

                        String command = word.substring(0,word.indexOf("="));
                        String argument = word.substring(word.indexOf("=")+2);

                        switch (command){

                            case "ownername":
                                changeStringToSql = SqlProcessor.propertyName(changeStringToSql, argument);
                                break;

                            case "propertyname":
                                changeStringToSql = SqlProcessor.propertyName(changeStringToSql, argument);
                                break;

                            case "ownerage":
                                changeStringToSql = SqlProcessor.biggerOwnersAge(changeStringToSql, argument);
                                break;

                            case "propertycost":
                                changeStringToSql = SqlProcessor.biggerOwnCost(changeStringToSql, argument);
                                break;


                        }
                    }
                }
            }
        }

        return changeStringToSql;
    }




    private static String secondPrintln() throws IOException {
        System.out.println("Введите команду");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stringToSql = reader.readLine();

        return commandParcer(stringToSql);
    }





    public static void main(String[] args) throws IOException {

        String strToSql = "";


        while (!"exit".equals(strToSql)){

            firstPrintln();

            strToSql = secondPrintln();

            System.out.println(strToSql);
            System.out.println("-----------------------------------------------");


        }
    }




}