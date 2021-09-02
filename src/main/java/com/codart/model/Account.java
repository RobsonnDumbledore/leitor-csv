package com.codart.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 *
 * @author Robson
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private String agency;
    private String account;
    private double balance;
    private String status;
}
