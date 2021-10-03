package com.example.jobagapi;
import com.example.jobagapi.domain.model.Postulant;
import com.example.jobagapi.domain.model.User;
import com.example.jobagapi.domain.repository.PostulantRepository;
import com.example.jobagapi.domain.repository.UserRepository;
import com.example.jobagapi.domain.service.UserService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import com.example.jobagapi.service.PostulantServiceImpl;
import com.example.jobagapi.service.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
    public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void findByIdTest() throws Exception {
        Long id = 1L;

        User user = new User(1L,"firstname","lastname","email",123L,"password","document");

        given(userRepository.findById(id)).willReturn(Optional.of(user));

        User expected = userService.getUserById(id);

        Assertions.assertThat(expected).isNotNull();
    }

    @Test
    void findAllTest() throws Exception {

        Long id = 1L;

        User user = new User(1L,"firstname","lastname","email",123L,"password","document");

        List<User> users = new ArrayList<>();
        users.add(user);

        given(userRepository.findAll()).willReturn(users);

        List<User> expected = userRepository.findAll();
        assertEquals(expected, users);
    }
    }


