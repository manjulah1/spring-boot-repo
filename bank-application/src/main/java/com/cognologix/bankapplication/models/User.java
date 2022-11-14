package com.cognologix.bankapplication.models;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_name",nullable = false)
    private String customerName;

    @Column(name = "customer_address",nullable = false)
    private String customerAddress;

    @Column(name = "customer_city",nullable = false)
    private String customerCity;

    @Column(name = "customer_state",nullable = false)
    private String customerState;

    @Column(name = "customer_country",nullable = false)
    private String customerCountry;

    @Column(name = "customer_pincode",nullable = false)
    private String customerPincode;

    @Column(name = "customer_email",nullable = false)
    private String customerEmail;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @Column(name = "aadhar_number",nullable = false)
    private String aadharNumber;

    @Column(name = "pan_number",nullable = false)
    private String panNumber;

}
