package co.za.wethinkcode.wethinkcode.configs;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;

public class HardcodedUserDetails {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public static UserDetails getUserDetails() {
        return new User(
                "user",
                encoder.encode("password"),
                Collections.emptyList()
        );
    }
}
