package JoseMerino_20240330.JoseMerino_20240330.Repository;

import JoseMerino_20240330.JoseMerino_20240330.Entity.AutoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoresRepository extends JpaRepository<AutoresEntity, Long> {
}
