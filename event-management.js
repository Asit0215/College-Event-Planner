$(document).ready(function () {
  const userData = JSON.parse(localStorage.getItem("loggedInUser"));

  // Allow only admin users to access this page
  if (!userData || !userData.role || userData.role.toLowerCase() !== "admin") {
    alert("Access denied! Only admins can access this page.");
    window.location.href = "login.html"; // Redirect to login
  }
});
