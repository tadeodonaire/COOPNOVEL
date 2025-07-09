package pe.edu.upc.coopnovel.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.coopnovel.entities.Usuarios;
import pe.edu.upc.coopnovel.repositories.IUsuariosRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUsuariosRepository repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios user = repo.findOneByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s not exists", username));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        // Como ahora es solo un rol
        if (user.getRole() != null) {
            authorities.add(new SimpleGrantedAuthority(user.getRole().getRol()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getUsEnable(),
                true, true, true,
                authorities
        );
    }

    public Usuarios getUsuarioByUsername(String username) {
        return repo.findOneByUsername(username);
    }

}
