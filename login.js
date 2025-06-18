document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("loginForm");

  form.addEventListener("submit", function (e) {
    e.preventDefault();

    const username = form.username.value.trim();
    const email = form.email.value.trim();
    const password = form.password.value;
    const role = form.role.value;

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d@$!%*?&]{8,}$/;

    if (!role) {
      alert("Please select your role.");
      return;
    }

    if (!emailRegex.test(email)) {
      alert("Please enter a valid email address.");
      return;
    }

    if (!passwordRegex.test(password)) {
      alert("Password must be at least 8 characters long and include an uppercase letter, a lowercase letter, and a number.");
      return;
    }

    // ✅ Store user data into localStorage as a student
    let students = JSON.parse(localStorage.getItem("students")) || [];
    students.push({
      name: username,
      email: email,
      status: "Pending"
    });
    localStorage.setItem("students", JSON.stringify(students));

    alert("Login successful!");
    window.location.href = "home.html";
  });
});
