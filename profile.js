// Toggle notification dropdown
document.addEventListener("DOMContentLoaded", function () {
  const notifyBtn = document.getElementById("notifyBtn");
  const dropdown = document.getElementById("notificationDropdown");

  notifyBtn.addEventListener("click", function () {
    dropdown.classList.toggle("hidden");
  });

  // Simulated user data
  const user = {
    name: "Aparna Sathya",
    email: "aparna123@example.com",
    department: "Electronics and Communication",
    events: [
      "Tech Fest 2025",
      "Cultural Night",
      "Entrepreneurship Summit"
    ]
  };

  // jQuery part
  $(document).ready(function () {
    // Load profile data
    $('#userName').text(user.name);
    $('#userEmail').text(`📧 ${user.email}`);
    $('#userDept').text(`🎓 Department: ${user.department}`);

    // Load event list
    user.events.forEach(event => {
      $('#eventList').append(`<li>✔️ ${event}</li>`);
    });

    // Edit profile action
    $('#editProfile').on('click', function () {
      alert("Edit profile feature coming soon!");
    });
  });
});
