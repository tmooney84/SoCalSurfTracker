package dev.group.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {



    private JpaDetailsService jpaDetailsService;

    SecurityConfig(JpaDetailsService jpaDetailsService){
        this.jpaDetailsService = jpaDetailsService;

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/register").permitAll();
                    auth.anyRequest().authenticated();
                })
                .userDetailsService(jpaDetailsService)
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/users")
                        .failureUrl("/login-error")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")  // Specify the logout URL (default is /logout)
                        .logoutSuccessUrl("/login?logout") // Redirect to the login page with a logout parameter
                        .invalidateHttpSession(true) // Invalidate the session
                        .deleteCookies("JSESSIONID") // Delete cookies
                )
                .build();

    }
    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                new AuthenticationManagerBuilder(http.getSharedObject(BeanFactory.class));
//
//        authenticationManagerBuilder
//                .userDetailsService(jpaDetailsService)
//                .passwordEncoder(enc);
//
//        return authenticationManagerBuilder.build();
//    }


}












//    @Bean
//    public static PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }