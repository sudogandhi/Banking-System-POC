package com.dbs.banking.poc.bankingdemo.jwt;

import com.dbs.banking.poc.bankingdemo.entities.Login;
import com.dbs.banking.poc.bankingdemo.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {
//    static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
//
//    static {
//        inMemoryUserList.add(new JwtUserDetails(1L, "user",
//                "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
//}

    @Autowired
    LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
//                .filter(user -> user.getUsername().equals(username)).findFirst();
//
//        if (!findFirst.isPresent()) {
//            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
//        }
//
//        return findFirst.get();
        Login login = loginRepository.findByUsername(username).orElse(null);

        if (login == null) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        } else {
            JwtUserDetails userDetails = new JwtUserDetails(
                    login.getId(),
                    login.getUsername(),
                    login.getPassword(),
                    login.getRole().getRole());
            return userDetails;
        }
    }
}
