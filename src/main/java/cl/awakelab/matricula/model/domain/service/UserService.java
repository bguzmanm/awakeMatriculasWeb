package cl.awakelab.matricula.model.domain.service;

import cl.awakelab.matricula.model.domain.dto.RolDTO;
import cl.awakelab.matricula.model.domain.dto.UserDTO;
import cl.awakelab.matricula.model.domain.repository.UserDTORepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserDTORepository repository;

    public UserService(UserDTORepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //return new User("brian", "{noop}kupita", new ArrayList<>());
        UserDTO user = repository.findById(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return new User(user.getUsername()
                , user.getPassword()
                , user.isEnabled()
                , true
                , true
                , true
                , mapperRols(user.getRols()));
    }

    private Collection<? extends GrantedAuthority> mapperRols(List<RolDTO> rols){
        return rols.stream()
                .map(rolDTO -> new SimpleGrantedAuthority(rolDTO.getRolName()))
                .collect(Collectors.toList());
    }
}
