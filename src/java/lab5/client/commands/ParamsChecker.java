package lab5.client.commands;

import lab5.common.exceptions.MissedCommandArgumentException;

import java.util.List;

public class ParamsChecker {
    public static void checkParams(int count, List<String> params){
        if (params.size()!=count){
            throw new MissedCommandArgumentException();
        }
    }
}
