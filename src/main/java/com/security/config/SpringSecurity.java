package com.security.config;


import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Slf4j
public class SpringSecurity  {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

        security.csrf(AbstractHttpConfigurer::disable);
        return security.authorizeHttpRequests(request ->
                request.requestMatchers("/addPage").authenticated().anyRequest().permitAll())
                .formLogin( formLogin -> formLogin.loginPage("/login")
                        .loginProcessingUrl("/do-login")
                        .successForwardUrl("/addPage")
                        .permitAll()
                        ).logout(logout -> logout.logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()).build();



        /* security
                      .csrf(AbstractHttpConfigurer::disable);
             return    security.authorizeHttpRequests(httpRequest->
                                      httpRequest.requestMatchers("/login")
                              .permitAll()
                                              .requestMatchers("/addPage").authenticated().anyRequest().permitAll())
                      .formLogin(formlogin -> formlogin
                              .loginPage("/login")
                              //.loginProcessingUrl("/login")
                              .successForwardUrl("/addPage")
                              .permitAll()).build();

*/
        //return security.build();

    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
