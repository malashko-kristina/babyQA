package org.example.ui.datas;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankAccount {
    @Builder.Default
    private String firstName = "";
    @Builder.Default
    private String lastName = "";
    @Builder.Default
    private String address = "";
    @Builder.Default
    private String city = "";
    @Builder.Default
    private String state = "";
    @Builder.Default
    private String zipCode = "";
    @Builder.Default
    private String ssn = "";
    @Builder.Default
    private String username = "";
    @Builder.Default
    private String password = "";
    @Builder.Default
    private String passwordConfirmation = "";
}

