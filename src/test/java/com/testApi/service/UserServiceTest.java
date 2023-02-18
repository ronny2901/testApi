package com.testApi.service;

import com.testApi.api.error.NotFoundException;
import com.testApi.persistence.repository.UserRepository;
import com.testApi.service.integrations.UserComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@DisplayName("UserService Tests")
public class UserServiceTest {

    private MockMvc mockMvc;
    @InjectMocks
    private UserComponent userComponent;

    @Mock
    private UserRepository userRepository;

    @Spy
    private ModelMapper modelMapper;

    @Mock
    Environment env;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Test
    @DisplayName("tests find user by login with not found")
    void shouldThrowExceptionWhenNotFoundUser() {
        var id = 10L;
        when(userRepository.findByLogin(anyString())).thenThrow(new NotFoundException("User not found"));
        assertThrows(NotFoundException.class, () -> userComponent.getProfileFromGithub(anyString()));
    }
}
