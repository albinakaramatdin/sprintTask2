package springio.techordag1.sprintask2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springio.techordag1.sprintask2.model.ApplicationRequest;

@Repository
public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequest, Long> {
}
