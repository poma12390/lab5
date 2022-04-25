package lab5.server.setters;

import lab5.common.Coordinates;
import lab5.common.Worker;
import lab5.common.exceptions.InvalidCoordinatesException;

public class SetCordinates {
    public static void setcordinates(String x, String y, Worker bum) throws InvalidCoordinatesException {
        if (x.isEmpty() | y.isEmpty()) {
            throw new InvalidCoordinatesException();
        } else {
            long x1 = Long.parseLong(x);
            int y1 = Integer.parseInt(y);
            if (x1 == 0 | y1 == 0 | y1 < 0) {
                throw new InvalidCoordinatesException();
            } else {
                Coordinates pCord = new Coordinates();
                pCord.setXY(x1, y1);
                bum.setCoordinates(pCord);
            }
        }
    }


}
