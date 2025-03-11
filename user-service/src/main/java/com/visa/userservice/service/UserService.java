package com.visa.userservice.service;

/**
 * @author : L.H.J
 * @File: UserService
 * @mailto : lharshana2002@gmail.com
 * @created : 2025-03-10, Monday
 **/
import com.visa.userservice.entity.User;
import com.visa.userservice.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User registerUser(User user) {
        user.setPassword_hash(passwordEncoder.encode(user.getPassword_hash()));
        return userRepository.save(user);
    }

    public Optional<User> authenticate(String email, String rawPassword) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && passwordEncoder.matches(rawPassword, user.get().getPassword_hash())) {
            return user;
        }
        return Optional.empty();
    }
}
