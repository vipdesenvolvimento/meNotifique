//package com.dev.vip.menotifique.provider;
//
//import com.dev.vip.menotifique.model.Tokens;
//import com.dev.vip.menotifique.service.TokensService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class CustomProvider implements AuthenticationProvider {
//
//    @Autowired
//    private TokensService tokensService;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        try {
//            authentication.setAuthenticated(false);
//            String username = authentication.getName();
//            String password = authentication.getCredentials().toString();
//
//            List<Tokens> tokens = tokensService.findByToken(username);
//            if (tokens.stream().count() == 1 && tokens != null) {
////                System.out.println(tokens.get(0).getToken());
//                List<GrantedAuthority> authorities = new ArrayList<>();
//                authorities.add(new SimpleGrantedAuthority("ADMIN")); // description is a string
//
//                return new UsernamePasswordAuthenticationToken(username, password, authorities);
//            } else {
//                //            throw new BadCredentialsException("1000");
//                throw new UsernameNotFoundException(String.format("Invalid credentials", authentication.getPrincipal()));
//            }
//        }catch (NullPointerException e){
//            throw new BadCredentialsException("1000");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
