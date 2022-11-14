package com.cognologix.bankapplication.services.customers.impl;

import com.cognologix.bankapplication.dto.AccountCreationResponse;
import com.cognologix.bankapplication.exceptions.NullArgumentException;
import com.cognologix.bankapplication.models.User;
import com.cognologix.bankapplication.repositories.UserRepository;
import com.cognologix.bankapplication.services.customers.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AccountCreationResponse createUserAccount(User user) {
        if (user.getCustomerName() == null || user.getAadharNumber() == null || user.getCustomerCity() == null
                || user.getCustomerCountry() == null || user.getCustomerAddress() == null || user.getCustomerEmail() == null
                || user.getCustomerPincode() == null || user.getCustomerState() == null
                || user.getPanNumber() == null || user.getPhoneNumber() == null) {
            throw new NullArgumentException("Request object is null.");
        } else {
            User user1 = userRepository.save(user);
            AccountCreationResponse accountCreationResponse = new AccountCreationResponse();
            accountCreationResponse.setCustomer_id(user1.getCustomerId());
            accountCreationResponse.setSuccessMessage("Account successfully created.");
            accountCreationResponse.setAdditionalInformation("Your account details have been sent to your registered email address " + user1.getCustomerEmail());
            return accountCreationResponse;
        }
    }
}
