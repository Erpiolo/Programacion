package model.validations;

import exceptions.InvalidDNIException;
import exceptions.InvalidNameException;

    public class UserDataValidations {

  public static void checkId(int typeDoc, String id) throws InvalidDNIException {
    if (typeDoc != 1) {
        throw new InvalidDNIException("Tipo de documento no válido para DNI.");
    }
    if (id == null || !id.matches("^[0-9]{8}[A-Za-z]$")) {
        throw new InvalidDNIException("El DNI debe tener 8 dígitos seguidos de una letra.");
    }
}

    public static boolean checkFormatDate(String date) {
        if (date == null) return false;

        String[] parts = date.split("/");
        if (parts.length != 3) return false; 


        if (!isNumeric(parts[0]) || !isNumeric(parts[1]) || !isNumeric(parts[2])) {
            return false;
        }

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);


        return day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 1900 && year <= 2100;
    }

    public static int calculateAge(String birthDate) {
        if (!checkFormatDate(birthDate)) return -1;

        String[] parts = birthDate.split("/");
        int birthDay = Integer.parseInt(parts[0]);
        int birthMonth = Integer.parseInt(parts[1]);
        int birthYear = Integer.parseInt(parts[2]);

        java.util.Calendar today = java.util.Calendar.getInstance();
        int age = today.get(java.util.Calendar.YEAR) - birthYear;

        if (today.get(java.util.Calendar.MONTH) + 1 < birthMonth ||
            (today.get(java.util.Calendar.MONTH) + 1 == birthMonth && today.get(java.util.Calendar.DAY_OF_MONTH) < birthDay)) {
            age--;
        }

        return age;
    }

    public static boolean checkPostalCode(String zip) {
        return zip != null && zip.matches("^\\d{5}$");
    }


    public static boolean isNumeric(String str) {
        return str != null && str.matches("^\\d+$");
    }


    public static boolean isAlphabetic(String str) {
        return str != null && str.matches("^[A-Za-z]+$");
    }

    public static boolean checkEmail(String email) {
        if (email == null || email.isEmpty()) return false;


        String emailRegex = "^[^@\\s]+@[^@\\s]+\\.(com|es|net|org|edu)$";
        return email.matches(emailRegex);
    }
  public static void checkName(String name) throws InvalidNameException {
    if (name == null || name.isEmpty()) {
        throw new InvalidNameException("El nombre no puede estar vacío.");
    }
    if (name.length() <= 1 || name.length() > 50) {
        throw new InvalidNameException("El nombre debe tener entre 2 y 50 caracteres.");
    }
    if (!isAlphabetic(name)) {
        throw new InvalidNameException("El nombre solo debe contener letras.");
    }
}
}
