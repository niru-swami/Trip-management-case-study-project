package com.example.TripManagementApplication.controller;


import com.example.TripManagementApplication.model.User;
import com.example.TripManagementApplication.payload.request.LoginRequest;
import com.example.TripManagementApplication.payload.request.SignupRequest;
import com.example.TripManagementApplication.payload.response.MessageResponse;
import com.example.TripManagementApplication.repository.UserRepository;
//import com.example.BusManagementProject.security.jwt.JwtUtils;
//import com.example.BusManagementProject.security.services.UserDetailsImpl;
import com.example.TripManagementApplication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
//  @Autowired AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserService userService;
//
//  @Autowired PasswordEncoder encoder;
//
//  @Autowired
//  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    String token = userService.login(loginRequest.getUsername(), loginRequest.getPassword());

    return  ResponseEntity.ok(
            new MessageResponse(token)
    );

//    Authentication authentication =
//        authenticationManager.authenticate(
//            new UsernamePasswordAuthenticationToken(
//                loginRequest.getUsername(), loginRequest.getPassword()));
//
//    SecurityContextHolder.getContext().setAuthentication(authentication);
//    String jwt = jwtUtils.generateJwtToken(authentication);
//
//    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//    List<String> roles =
//        userDetails.getAuthorities().stream()
//            .map(GrantedAuthority::getAuthority)
//            .collect(Collectors.toList());
//
//    return ResponseEntity.ok(
//        new JwtResponse(
//            jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }
    User user =
        new User(
            signUpRequest.getUsername(),
            signUpRequest.getEmail(),
            signUpRequest.getRole(),
            signUpRequest.getPassword(),
                null);

    if (signUpRequest.getRole() == null || signUpRequest.getRole().equalsIgnoreCase("user")) {
      user.setRole("USER");
    } else if (signUpRequest.getRole().equalsIgnoreCase("admin")) {
      user.setRole("ADMIN");
    } else {
      throw new RuntimeException("Role Not Found!");
    }
    userRepository.save(user);
    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}
