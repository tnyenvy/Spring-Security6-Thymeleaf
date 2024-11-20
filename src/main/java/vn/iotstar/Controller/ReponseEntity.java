package vn.iotstar.Controller;

@PostMapping("/signup")
public ReponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {
    // Check if username exists
    if (userRepository.existsByUsername(signUpDto.getUsername())) {
        return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
    }

    // Check if email exists
    if (userRepository.existsByEmail(signUpDto.getEmail())) {
        return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
    }

    // Create new user
    Users user = new Users();
    user.setName(signUpDto.getName());
    user.setUsername(signUpDto.getUsername());
    user.setEmail(signUpDto.getEmail());
    user.setEnabled(true);
    user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

    // Assign role to user
    Role roles = roleRepository.findByName("USER").get();
    user.setRoles(Collections.singleton(roles));

    userRepository.save(user);

    return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
}
