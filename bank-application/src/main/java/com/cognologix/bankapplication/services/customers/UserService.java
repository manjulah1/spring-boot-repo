package com.cognologix.bankapplication.services.customers;

import com.cognologix.bankapplication.dto.AccountCreationResponse;
import com.cognologix.bankapplication.models.User;
import com.cognologix.bankapplication.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    AccountCreationResponse createUserAccount(User user);
}
