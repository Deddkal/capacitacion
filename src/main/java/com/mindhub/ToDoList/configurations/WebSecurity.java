package com.mindhub.ToDoList.configurations;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.WebAttributes;
//import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
//
//@EnableWebSecurity
//@Configuration
//public class WebSecurity {
//
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http.authorizeHttpRequests( authorizationManagerRequestMatcherRegistry ->
//                        authorizationManagerRequestMatcherRegistry.anyRequest().permitAll()  )
//                .headers(httpSecurityHeadersConfigurer ->
//                        httpSecurityHeadersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
//                .csrf(AbstractHttpConfigurer::disable)
//                .formLogin( httpSecurityFormLoginConfigurer ->
//                        httpSecurityFormLoginConfigurer.loginPage("/index.html")
//                                .loginProcessingUrl("/api/login")
//                                .usernameParameter("email")
//                                .passwordParameter("password")
//                                .successHandler((request, response, authentication) -> clearAuthenticationAttributes(request))
//                                .failureHandler((request, response, exception) -> response.sendError(401))
//                                .permitAll())
//                .rememberMe(Customizer.withDefaults());
//
//        http.logout(httpSecurityLogoutConfigurer ->
//                httpSecurityLogoutConfigurer
//                        .logoutUrl("/api/logout")
//                        .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
//                        .deleteCookies("JSESSIONID"));
//
//        http.exceptionHandling( exceptionHandlingConfigurer ->
//                exceptionHandlingConfigurer.authenticationEntryPoint((request, response, authException) -> response.sendError(403)));
//
//        return http.build();
//    }
//
//// flags
//    private void clearAuthenticationAttributes(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//        }
//    }
//
//}
