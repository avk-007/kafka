package in.kafka.springboot.Repository;

import in.kafka.springboot.entity.wikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface wikimediaDataRepository extends JpaRepository<wikimediaData,Long> {
}
