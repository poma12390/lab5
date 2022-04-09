package lab5.runners;

import lab5.exceptions.MissedCommandArgumentException;

import java.util.List;

public class ParamsChecker {
    public static void checkParams(int count, List<String> params){
        if (params.size()!=count){
            throw new MissedCommandArgumentException();
        }
    }
}
