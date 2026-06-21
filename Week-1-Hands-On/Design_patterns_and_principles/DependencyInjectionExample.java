package com.cts.exercise11_di;

interface CustomerRepository {
    String findCustomerById(String customerId);
}

class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String customerId) {
        return "Customer Details Record for [" + customerId + "]: Name='Aditya Varma', Domain='Premium Account'";
    }
}

class CustomerService {
    private final CustomerRepository databaseRepository;

    // Implementation of Constructor Injection
    public CustomerService(CustomerRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    public void renderCustomerSummary(String targetId) {
        System.out.println("Service layer requested details payload...");
        String summary = databaseRepository.findCustomerById(targetId);
        System.out.println("[Output Feed]: " + summary);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        System.out.println("Dependency Injection Infrastructure Validation");
        CustomerRepository mockDbImplementation = new CustomerRepositoryImpl();
        
        CustomerService appBusinessService = new CustomerService(mockDbImplementation);

        appBusinessService.renderCustomerSummary("CTS-CLIENT-9901");
    }
}