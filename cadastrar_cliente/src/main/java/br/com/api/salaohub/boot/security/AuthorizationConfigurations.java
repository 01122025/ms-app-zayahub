package br.com.api.salaohub.boot.security;//package br.com.api.salaohub.boot.security;
//
//import br.com.api.salaohub.adapter.out.jpaRepository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class AuthorizationConfigurations implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findByLogin(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
//    }
//}
