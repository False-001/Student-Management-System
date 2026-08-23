package School_Management_System;

import java.security.*;
import java.util.Base64;
public class PasswordUtils 
{
    // Method to hash the password with a salt
    public static String hashPassword(String password) throws NoSuchAlgorithmException
    {
        // Create a salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        // Hash the password with the salt
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(salt); // Salt
        byte[] hashedPassword = digest.digest(password.getBytes());
        // Convert the hashed password to a Base64 string for storage
        String hashedPasswordString = Base64.getEncoder().encodeToString(hashedPassword);
        String saltString = Base64.getEncoder().encodeToString(salt);
        // Return a combination of the salt and hashed password to store in the DB
        return saltString + ":" + hashedPasswordString;
    }
    // Method to check if the password matches
    public static boolean verifyPassword(String storedPassword,String originalPassword ) throws NoSuchAlgorithmException {
    // Check if storedPassword contains a colon
    if (storedPassword == null || !storedPassword.contains(":")) {
        throw new IllegalArgumentException("Stored password format is invalid. It should be in the format: salt:hashedPassword");
    }
    String[] parts = storedPassword.split(":");
    if (parts.length != 2) {
        throw new IllegalArgumentException("Stored password format is incorrect. It should be in the format: salt:hashedPassword");
    }
    String saltString = parts[0];
    String hashedPasswordString = parts[1];
    // Convert the salt back from Base64
    byte[] salt = Base64.getDecoder().decode(saltString);
    // Hash the original password with the same salt
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    digest.update(salt);
    byte[] hashedPassword = digest.digest(originalPassword.getBytes());
    // Compare the hashed password
    String hashedOriginalPasswordString = Base64.getEncoder().encodeToString(hashedPassword);
    return hashedOriginalPasswordString.equals(hashedPasswordString);
}
}