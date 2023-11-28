package com.ant_storage.ANT.Storage.service;

import com.ant_storage.ANT.Storage.entity.User;
import com.ant_storage.ANT.Storage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {

        User encryptedUser = new
        User(user.getUsername(),encrypt(user.getPassword()), user.getRole(),user.getLastConnection());
        return userRepository.save(encryptedUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public String encryptText(String plainText) {
        return encrypt(plainText);
    }

    public Boolean userExists(String username, String password) {
        boolean exists = false;
        String hashedPassword = encryptText(password);
        List<User> result = userRepository.findByUsername(username);
        User user = null;
        if(!result.isEmpty()) {
            user = result.get(0);
            if(user.getPassword().equals(hashedPassword)) {
                exists = true;
            }
        }

        return exists;
    }

    // Utils
    public String encrypt(String input) {
        try {
            // Create a SHA-256 message digest
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Get the bytes of the input string
            byte[] encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Convert the byte array to a hexadecimal representation
            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle NoSuchAlgorithmException (should not occur for SHA-256)
            e.printStackTrace();
            return null;
        }
    }

}
