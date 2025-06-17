// Wait for the document to load
$(document).ready(function () {

  // Check login and role from localStorage
  const user = JSON.parse(localStorage.getItem("loggedInUser"));

  if (!user || user.role !== "admin") {
    alert("Access Denied! Only admins can create events.");
    window.location.href = "home.html";
    return;
  }

  // Handle form submission
  $('form').on('submit', function (e) {
    e.preventDefault();

    // Collect field values
    const title = $('input[name="title"]').val().trim();
    const description = $('textarea[name="description"]').val().trim();
    const date = $('input[name="date"]').val();
    const time = $('input[name="time"]').val();
    const venue = $('input[name="venue"]').val().trim();
    const department = $('input[name="department"]').val().trim();
    const amount = parseFloat($('input[name="amount"]').val());

    // Basic validation
    if (!title || !description || !date || !time || !venue || !department) {
      alert("Please fill in all required fields.");
      return;
    }

    if (amount < 0 || isNaN(amount)) {
      alert("Amount should be a non-negative number.");
      return;
    }

    // Optional fields
    const speakers = $('input[name="speakers"]').val().trim();
    const posterFile = $('input[name="poster"]')[0].files[0];

    // Simulate event submission (you can replace this with server logic)
    console.log("Event Created:", {
      title,
      description,
      date,
      time,
      venue,
      department,
      speakers,
      posterFile,
      amount
    });

    alert("Event created successfully!");
    $('form')[0].reset(); // Clear the form
  });

});
