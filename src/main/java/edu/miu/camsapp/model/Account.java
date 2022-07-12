package edu.miu.camsapp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author bijayshrestha on 7/12/22
 * @project cams-app
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @NotNull(message = "Account Number cannot be null.")
    @NotEmpty(message = "Account Number cannot be empty.")
    @NotBlank(message = "Account Number cannot be blank")
    @Column(unique = true, nullable = false)
    private String accountNumber;

    @NotNull(message = "Account Type cannot be null.")
    @NotEmpty(message = "Account Type cannot be empty.")
    @NotBlank(message = "Account Type cannot be blank")
    @Column(nullable = false)
    private String accountType;

    private LocalDate dateOpened;

    @NotNull(message = "Balance cannot be null or empty.")
    private double balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Account(String accountNumber,
                   String accountType,
                   LocalDate dateOpened,
                   double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.dateOpened = dateOpened;
        this.balance = balance;
    }
}
