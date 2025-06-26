$(document).ready(function () {
  const students = JSON.parse(localStorage.getItem("students")) || [];

  const studentListContainer = $("#studentList");
  studentListContainer.empty();

  students.forEach((student, index) => {
    const statusText = student.status !== "Pending"
      ? `<div class="status text-sm mt-2 font-semibold">${student.status}</div>`
      : "";
    const showButtons = student.status === "Pending";

    const card = $(`
      <div class="student-card bg-white rounded shadow p-4 mb-4" data-index="${index}">
        <p class="text-lg font-semibold"><strong>Name:</strong> ${student.name}</p>
        <p class="text-sm text-gray-600"><strong>Email:</strong> ${student.email}</p>
        <div class="mt-3 flex flex-col sm:flex-row sm:space-x-4 space-y-2 sm:space-y-0">
          <button class="accept-btn bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700 sm:w-auto w-full" ${!showButtons ? 'style="display:none;"' : ''}>Accept</button>
          <button class="decline-btn bg-red-600 text-white px-4 py-2 rounded hover:bg-red-700 sm:w-auto w-full" ${!showButtons ? 'style="display:none;"' : ''}>Decline</button>
        </div>
        ${statusText}
      </div>
    `);

    studentListContainer.append(card);
  });

  // Accept Handler
  $(document).on("click", ".accept-btn", function () {
    const card = $(this).closest(".student-card");
    const index = card.data("index");
    updateStatus(index, "✅ Accepted", card);
  });

  // Decline Handler
  $(document).on("click", ".decline-btn", function () {
    const card = $(this).closest(".student-card");
    const index = card.data("index");
    updateStatus(index, "❌ Declined", card);
  });

  // Update Status Function
  function updateStatus(index, newStatus, card) {
    let students = JSON.parse(localStorage.getItem("students")) || [];
    students[index].status = newStatus;
    localStorage.setItem("students", JSON.stringify(students));

    card.find(".status").remove();
    card.append(`<div class="status text-sm mt-2 font-semibold">${newStatus}</div>`);
    card.find(".accept-btn, .decline-btn").hide();
  }
});
