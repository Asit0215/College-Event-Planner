$(document).ready(function () {
  // Redirect if role not set
  const role = localStorage.getItem("userRole");
  if (!role) {
    alert("Please access the site from the homepage.");
    window.location.href = "home.html";
    return;
  }

  // Form submit handler
  $("form").on("submit", function (e) {
    e.preventDefault();

    // Optional: Validate data (basic check)
    const name = $("input[name='name']").val().trim();
    const email = $("input[name='email']").val().trim();
    const card = $("input[name='card']").val().trim();
    const expiry = $("input[name='expiry']").val().trim();
    const cvv = $("input[name='cvv']").val().trim();

    if (!name || !email || !card || !expiry || !cvv) {
      alert("Please fill in all payment details.");
      return;
    }

    // Simulate payment success
    alert("Payment successful! Redirecting to feedback page...");

    // Redirect to feedback after short delay
    setTimeout(function () {
      window.location.href = "feedback.html";
    }, 1500);
  });
});
