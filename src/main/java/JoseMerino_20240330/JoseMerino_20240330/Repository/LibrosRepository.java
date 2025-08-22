package JoseMerino_20240330.JoseMerino_20240330.Repository;

import JoseMerino_20240330.JoseMerino_20240330.Entity.LibrosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrosRepository extends JpaRepository<LibrosEntity, Long> {
}
