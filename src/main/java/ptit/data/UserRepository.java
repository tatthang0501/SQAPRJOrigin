package ptit.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ptit.models.ThanhVien;


@Repository
public interface UserRepository extends JpaRepository<ThanhVien, Integer> {
	Optional<ThanhVien> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
}
