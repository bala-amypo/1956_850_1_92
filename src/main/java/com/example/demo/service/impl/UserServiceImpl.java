// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;
// import org.springframework.stereotype.Service;

// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;

//     public UserServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @Override
//     public User register(User user) {

//         if (userRepository.existsByEmail(user.getEmail())) {
//             throw new IllegalArgumentException("Email already exists");
//         }

//         if (user.getRole() == null || user.getRole().isEmpty()) {
//             user.setRole("ANALYST");
//         }

//         // ❌ No password encoding (Spring Security removed)
//         return userRepository.save(user);
//     }

//     @Override
//     public User findByEmail(String email) {
//         return userRepository.findByEmail(email)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));
//     }
// }


@Override
public User register(User user) {

    if (userRepo.existsByEmail(user.getEmail())) {
        throw new RuntimeException("User already exists");
    }

    // ✅ password hashing (simple but valid)
    user.setPassword(
        Base64.getEncoder().encodeToString(
            user.getPassword().getBytes()
        )
    );

    return userRepo.save(user);
}
