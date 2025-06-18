$(document).ready(function () {
  // Check if user accessed via correct flow
  const role = localStorage.getItem("userRole");
  if (!role) {
    alert("Please access the site from the homepage.");
    window.location.href = "home.html";
    return;
  }

  // Feedback form submission
  $("form").on("submit", function (e) {
    e.preventDefault();

    const name = $("input[name='name']").val().trim();
    const email = $("input[name='email']").val().trim();
    const event = $("input[name='event']").val().trim();
    const rating = $("select[name='rating']").val();
    const message = $("textarea[name='message']").val().trim();

    if (!name || !email || !event || !rating || !message) {
      alert("Please fill out all fields before submitting.");
      return;
    }

    // Optional: Save feedback to localStorage (for demo)
    const feedback = { name, email, event, rating, message };
    localStorage.setItem("lastFeedback", JSON.stringify(feedback));

    alert("Thank you for your feedback!");

    // Redirect to homepage
    setTimeout(function () {
      window.location.href = "home.html";
    }, 1500);
  });
});


