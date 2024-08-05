package co.za.wethinkcode.wethinkcode.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ApplicationConfiguration {


    /*
    Bean for password encoding.
     */
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /*
    UserDetailsService that returns hardcoded user details
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> HardcodedUserDetails.getUserDetails();
    }

    /*
    Configures the authManager using AuthenticationConfiguration.
     */
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//
//        return authConfig.getAuthenticationManager();
//    }


    /*
    Setting up the AuthenticationManagerBuilder with UserDetailsServices and the encoded password.
//     */
//    @Bean
//    public AuthenticationManagerBuilder configureAuthenticationManagerBuilder(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService())
//                .passwordEncoder(passwordEncoder());
//        return auth;
//    }

}
