package com.surf.surftracker.config;


import com.surf.surftracker.service.JpaDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
                        .defaultSuccessUrl("/Home")
                        .failureUrl("/error")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true) // Invalidate the session
                        .deleteCookies("JSESSIONID") // Delete cookies
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login") // Redirect to the same custom login page
                        .defaultSuccessUrl("/Home")
                        .failureUrl("/error"))
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