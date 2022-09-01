package case_study.utils;

import ulti_exception.NameFormatException;

public class CheckName {
    public boolean checkName(String name){
        if (!name.matches("\\D{5,50}")) {
            return false;
        }
        if (!name.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
            return false;
        }
        return name.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$");
    }
}
