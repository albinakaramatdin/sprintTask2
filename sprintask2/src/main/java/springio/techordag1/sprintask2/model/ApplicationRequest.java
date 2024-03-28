package springio.techordag1.sprintask2.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "app_requests")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String courseName;

    @Column(name = "commentary", columnDefinition = "TEXT")
    private String commentary;

    @Column(name = "phoneNumber")
    private String phone;
    private boolean handled;
}
