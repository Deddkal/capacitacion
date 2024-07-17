package com.mindhub.ToDoList.configurations;
//
//
//import com.mindhub.ToDoList.models.User;
//import com.mindhub.ToDoList.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//@Configuration
//public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public void init(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.userDetailsService( username ->{
//
//                    User user = userRepository.findByEmail(username);
//
//                    if(user != null){
//                        return new org.springframework.security.core.userdetails.User(
//                                user.getEmail(),
//                                user.getPassword(),
//                                AuthorityUtils.createAuthorityList("USER"));
//                    }else {
//                        throw new UsernameNotFoundException("No se encontre al hijo de su madre");
//                    }
//
//                });
//
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//
//}
