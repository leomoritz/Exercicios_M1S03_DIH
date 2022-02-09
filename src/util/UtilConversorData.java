package util;

import java.time.LocalDate;

import javafx.util.converter.LocalDateStringConverter;

public class UtilConversorData {

    public static LocalDate converteStringParaData(String data) {

        LocalDate dataAux = LocalDate.parse(data);

        return dataAux;

    }

    public static String converteDataParaString(LocalDate data) {

        LocalDateStringConverter converter = new LocalDateStringConverter();

        String dataAux = converter.toString(data);

        return dataAux;

    }

}
