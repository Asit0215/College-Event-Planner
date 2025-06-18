$(document).ready(function () {
  $("form").submit(function (e) {
    e.preventDefault(); // stop actual form submission

    // Get values
    const fullName = $('input[name="name"]').val().trim();
    const email = $('input[name="email"]').val().trim();
    const password = $('input[name="password"]').val();
    const confirmPassword = $('input[name="confirm_password"]').val();

    // Regular expressions
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,}$/;

    // Clear red borders
    $("input").removeClass("border-red-500");

    // Validate Full Name
    if (fullName === "") {
      alert("Please enter your full name.");
      $('input[name="name"]').addClass("border-red-500");
      return;
    }

    // Validate Email
    if (!emailPattern.test(email)) {
      alert("Please enter a valid email address.");
      $('input[name="email"]').addClass("border-red-500");
      return;
    }

    // Validate Password
    if (!passwordPattern.test(password)) {
      alert("Password must be at least 8 characters long and include uppercase, lowercase, number, and special character.");
      $('input[name="password"]').addClass("border-red-500");
      return;
    }

    // Validate Confirm Password
    if (password !== confirmPassword) {
      alert("Passwords do not match.");
      $('input[name="confirm_password"]').addClass("border-red-500");
      return;
    }

    // If all validations pass
const user = {
  name: fullName,
  email: email,
  status: "Pending" // status used in event registration page
};

// Save user to localStorage
let students = JSON.parse(localStorage.getItem("students")) || [];
students.push(user);
localStorage.setItem("students", JSON.stringify(students));

alert("Account created successfully!");
window.location.href = "login.html"; // redirect to login page

  });
});
