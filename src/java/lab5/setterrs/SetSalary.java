package lab5.setterrs;

import lab5.runners.Worker;
import lab5.exceptions.InvalidSalaryException;

public class SetSalary {
    public static void setSalary(String salary, Worker bum) throws InvalidSalaryException, NumberFormatException{
        if (salary.isEmpty()) {
            throw new InvalidSalaryException();
        } else {
            float f = Float.parseFloat(salary);
            if (f == 0 | f < 0) {
                throw new InvalidSalaryException();
            } else {
                bum.setSalary(f);
            }
        }
    }
}
