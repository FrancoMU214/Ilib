package com.mycompany.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Utils {
    
    private static final long serialVersionUID = 1L;
    private String email;
    private String subject;
    private String message;
    
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }
    
    //Diferencias entre dos fechas
    //@param fechaInicial La fecha de inicio
    //@param fechaFinal  La fecha de fin
    //@return Retorna el numero de dias entre dos fechas
    public static synchronized int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) throws ParseException {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        fechaFinal = df.parse(fechaFinalString);

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }

    //Devuele un java.util.Date desde un String en formato dd-MM-yyyy
    //@param La fecha a convertir a formato date
    //@return Retorna la fecha en formato Date
    public static synchronized java.util.Date stringToDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
     public void sendEmail() {
    // Configuración de las propiedades para la conexión con el servidor SMTP
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com"); // Cambia "smtp.example.com" por tu servidor SMTP
    props.put("mail.smtp.port", "587"); // Puerto SMTP
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");

    // Credenciales de autenticación
    String username = "bibliotecatrinity0@gmail.com"; // Cambia por tu dirección de correo electrónico
    String password = "srus nnqo tjng hvkf"; // Cambia por tu contraseña

    // Creación de la sesión
    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    try {
        // Creación del mensaje
        Message emailMessage = new MimeMessage(session);
        emailMessage.setFrom(new InternetAddress(username));
        emailMessage.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email));
        emailMessage.setSubject(subject);
        emailMessage.setText(message);

        // Envío del mensaje
        Transport.send(emailMessage);

        JOptionPane.showMessageDialog(null, "Correo electrónico enviado correctamente.");

    } catch (AuthenticationFailedException ex) {
        JOptionPane.showMessageDialog(null, "Error de autenticación al enviar el correo electrónico: " + ex.getMessage());
    } catch (MessagingException ex) {
        JOptionPane.showMessageDialog(null, "Error al enviar el correo electrónico: " + ex.getMessage());
    }
}
    
}