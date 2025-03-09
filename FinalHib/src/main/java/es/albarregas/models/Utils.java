package es.albarregas.models;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author sarap
 */
public class Utils {

    /**
     * Metodo que encripta una contraseña utilizando el algoritmo MD5
     *
     * @param input
     * @return la contraseña encriptada
     */
    public static String encriptarPassword(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static String comprobarCampos(Enumeration<String> campos, HttpServletRequest request, String opcional) {
        while (campos.hasMoreElements()) {
            String nombre = campos.nextElement();
            String valor = request.getParameter(nombre);
            if (nombre.equals("denominacion") && valor != null && !valor.trim().isEmpty()) {
                opcional = "denominacion";
            }

            if (!nombre.equalsIgnoreCase(opcional) && (valor == null || valor.trim().isEmpty())) {
                return "Todos los campos con * son obligatorios";
            }
        }
        return "";
    }
}
