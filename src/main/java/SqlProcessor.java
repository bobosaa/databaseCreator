/**
 * Created by heymn on 14.07.2019.
 */
class SqlProcessor {

    static String biggerOwnersAge(String changeStringToSql, String age){

        int dayInYear = 365*Integer.parseInt(age);

        return concatinationStringToSql(changeStringToSql, "AND (CURRENT_TIMESTAMP - owner.age) > ", dayInYear + " ");
    }


    static String biggerOwnCost(String changeStringToSql, String price){

        return concatinationStringToSql(changeStringToSql, "AND own.price >", price+ " ");
    }


    static String ownerName(String changeStringToSql, String name){

        return concatinationStringToSql(changeStringToSql, "AND owners.owners_name LIKE '", name + "' ");
    }


    static String propertyName(String changeStringToSql, String name){

        return concatinationStringToSql(changeStringToSql, "AND own.own_name LIKE '", name + "' ");
    }


    private static String concatinationStringToSql(String changeStringToSql, String command, String argument){

        return changeStringToSql + command + argument + " ";
    }
}

