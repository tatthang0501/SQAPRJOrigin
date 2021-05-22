package ptit.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ptit.data.UserRepository;
import ptit.models.ThanhVien;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UserRepository userRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        ThanhVien user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Khong tim thay username: " + username));
        return UserDetailsImpl.build(user);
    }
    
}
