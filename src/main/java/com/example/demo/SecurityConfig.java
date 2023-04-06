package com.example.demo;

import com.example.demo.service.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {return PasswordEncoderFactories.createDelegatingPasswordEncoder();}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/api/free/**").permitAll()
                .antMatchers("/api/user/**").permitAll()//hasRole("USER")
                .anyRequest().authenticated();

        http.formLogin()
                //.loginPage("/signin.do")
                .defaultSuccessUrl("/")
                //.failureUrl("/signin")
                //.successHandler(authenticationSuccessHandler())
                .permitAll();


        http.httpBasic();

        // for developing
        //http.addFilterBefore(new EasyAuthenticationFilter(customUserDetailsService), UsernamePasswordAuthenticationFilter.class);

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/signout.do"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");


        return http.build();
    }

}