package es.albarregas.models;

import org.apache.commons.beanutils.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConverter implements Converter {

    // Define el formato de fecha esperado
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Object convert(Class type, Object value) {
        if (value == null) {
            return null;
        }

        // Verifica que el valor sea un String
        if (value instanceof String) {
            String dateString = (String) value;
            try {
                // Intenta convertir la cadena a un objeto Date
                return sdf.parse(dateString);
            } catch (ParseException e) {
                // Si la conversión falla, puedes lanzar una excepción o retornar null
                e.printStackTrace();
                return null;
            }
        }
        
        // Si el valor no es una cadena, no hace nada y retorna null
        return null;
    }
}
