package com.codart.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 *
 * @author Robson
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private String agencia;
    private String conta;
    private double saldo;
    private String status;
    private String synchronizer;

}
