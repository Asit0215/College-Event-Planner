$(document).ready(function () {
  const students = JSON.parse(localStorage.getItem("students")) || [];

  // Display students dynamically
  students.forEach((student, index) => {
    $("#studentList").append(`
      <div class="student-card" data-index="${index}" style="margin-bottom: 20px; border: 1px solid #ccc; padding: 10px;">
        <p><strong>Name:</strong> ${student.name}</p>
        <p><strong>Email:</strong> ${student.email}</p>
        <button class="accept-btn">Accept</button>
        <button class="decline-btn">Decline</button>
        <div class="status" style="margin-top: 10px;">${student.status !== "Pending" ? student.status : ""}</div>
      </div>
    `);

    // Hide buttons if already accepted/declined
    if (student.status !== "Pending") {
      $(`.student-card[data-index="${index}"] .accept-btn`).hide();
      $(`.student-card[data-index="${index}"] .decline-btn`).hide();
    }
  });

  // Accept button handler
  $(document).on("click", ".accept-btn", function () {
    const card = $(this).closest(".student-card");
    const index = card.data("index");

    updateStatus(index, "✅ Accepted", card);
  });

  // Decline button handler
  $(document).on("click", ".decline-btn", function () {
    const card = $(this).closest(".student-card");
    const index = card.data("index");

    updateStatus(index, "❌ Declined", card);
  });

  // Update status function
  function updateStatus(index, newStatus, card) {
    let students = JSON.parse(localStorage.getItem("students")) || [];
    students[index].status = newStatus;
    localStorage.setItem("students", JSON.stringify(students));

    card.find(".status").html(newStatus);
    card.find(".accept-btn, .decline-btn").hide();
  }
});
