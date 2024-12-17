package com.javaakademi.ecommerce_homework.security;

import com.javaakademi.ecommerce_homework.domain.user.impl.User;
import com.javaakademi.ecommerce_homework.domain.user.impl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    AuthenticationManager authManager;

    //Şifreyi kriptolamak
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); //12. seviyeden bi kriptolana işlemi

    public void register(User user) {
        user.setUserpassword(encoder.encode(user.getUserpassword()));//kriptolanacak şifreyi böylece userdan kendi alacak. Security config dosyasında 52. satıra bak.
        repository.save(user);
    }

    public String verify(User user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getUserpassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateJwtToken(authentication);
        } else {
            return "fail";
        }
    }

}
