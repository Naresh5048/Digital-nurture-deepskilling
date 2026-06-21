package com.cts.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class SpringExercisesTestSuite {

    @Test
    public void testCalculatorServiceAdd() {
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.add(10, 20);
        assertEquals(30, result);
    }

    @Test
    public void testUserServiceGetUserById() {
        UserRepository mockRepo = mock(UserRepository.class);
        User mockUser = new User(1L, "Naresh Challa");
        when(mockRepo.findById(1L)).thenReturn(Optional.of(mockUser));

        UserService userService = new UserService(mockRepo);
        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("Naresh Challa", result.getName());
    }
    @Test
    public void testUserControllerGetEndpoint() throws Exception {
        UserRepository mockRepo = mock(UserRepository.class);
        User mockUser = new User(1L, "Naresh Challa");
        when(mockRepo.findById(1L)).thenReturn(Optional.of(mockUser));

        UserService userService = new UserService(mockRepo);
        UserController userController = new UserController(userService);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Naresh Challa"));
    }

    @Test
    public void testUserControllerPostEndpointAndFullFlow() throws Exception {
        UserRepository mockRepo = mock(UserRepository.class);
        User incomingUser = new User(2L, "Aditya");
        when(mockRepo.save(any(User.class))).thenReturn(incomingUser);

        UserService userService = new UserService(mockRepo);
        UserController userController = new UserController(userService);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":2,\"name\":\"Aditya\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Aditya"));
    }

    @Test
    public void testUserServiceThrowsExceptionOnMissingUser() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById(99L)).thenReturn(Optional.empty());

        UserService userService = new UserService(mockRepo);

        assertThrows(NoSuchElementException.class, () -> {
            userService.getUserById(99L);
        });
    }

    @Test
    public void testCustomRepositoryQueryByName() {
        UserRepository mockRepo = mock(UserRepository.class);
        List<User> mockList = Collections.singletonList(new User(1L, "Naresh"));
        when(mockRepo.findByName("Naresh")).thenReturn(mockList);

        List<User> results = mockRepo.findByName("Naresh");
        assertEquals(1, results.size());
        assertEquals("Naresh", results.get(0).getName());
    }

    @Test
    public void testControllerAdviceExceptionHandling() throws Exception {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById(55L)).thenReturn(Optional.empty());

        UserService userService = new UserService(mockRepo);
        UserController userController = new UserController(userService);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();

        mockMvc.perform(get("/users/55"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found"));
    }
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "5, 5, 10",
            "12, 12, 24"
    })
    public void testCalculatorWithMultipleInputs(int a, int b, int expected) {
        CalculatorService calculatorService = new CalculatorService();
        assertEquals(expected, calculatorService.add(a, b));
    }
}