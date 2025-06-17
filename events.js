$(document).ready(function () {
  // Highlight upcoming events
  $(".event-card").each(function () {
    const dateText = $(this).find(".event-date").text().trim();
    const eventDate = new Date(dateText.replace("📅 Date: ", ""));
    const today = new Date();

    if (eventDate > today) {
      $(this).addClass("border border-green-400");
    }
  });

  // Search/Filter Events
  $("#searchEvent").on("keyup", function () {
    const keyword = $(this).val().toLowerCase();
    $(".event-card").each(function () {
      const text = $(this).text().toLowerCase();
      $(this).toggle(text.includes(keyword));
    });
  });

  // Register button opens payment page
  $(".register-btn").on("click", function () {
    const eventTitle = $(this).closest(".event-card").find("h3").text();
    const paymentUrl = `payment.html?event=${encodeURIComponent(eventTitle)}`;
    window.open(paymentUrl, "PaymentWindow", "width=600,height=600");
  });
});
