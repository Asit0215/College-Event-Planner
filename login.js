$(document).ready(function () {
    $('#loginForm').on('submit', function (e) {
        e.preventDefault(); // Prevent default form submission

        const email = $('#username').val().trim();
        const password = $('#password').val().trim();
        const errorMsg = $('#error');

        errorMsg.text(''); // Clear previous error

        // Email format validation
        const emailPattern = /^[^@\s]+@[^@\s]+\.[^@\s]+$/;
        if (!emailPattern.test(email)) {
            errorMsg.text('Please enter a valid email address.');
            return;
        }

        // Password validation: at least 6 characters, 1 uppercase, 1 number, 1 special character
        const passwordPattern = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*]).{6,}$/;
        if (!passwordPattern.test(password)) {
            errorMsg.text('Password must be at least 6 characters long and include 1 uppercase letter, 1 number, and 1 special character.');
            return;
        }

        // If both validations pass
       // Set role based on email (you can customize this)
let role = "user";
if (email === "admin@example.com") {
    role = "admin";
}

// Store user info in localStorage
localStorage.setItem("loggedInUser", JSON.stringify({
    email: email,
    role: role
}));

alert('Login successful!');
window.location.href = 'homepage.html'; // Redirect to homepage

    });
});
