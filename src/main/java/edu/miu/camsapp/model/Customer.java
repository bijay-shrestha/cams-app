package edu.miu.camsapp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author bijayshrestha on 7/12/22
 * @project cams-app
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotNull(message = "First name cannot be null.")
    @NotEmpty(message = "First name cannot be empty.")
    @NotBlank(message = "First name cannot be blank")
    @Column(nullable = false)
    private String firstName;

    @NotNull(message = "Last name cannot be null.")
    @NotEmpty(message = "Last name cannot be empty.")
    @NotBlank(message = "Last name cannot be blank")
    @Column(nullable = false)
    private String lastName;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
