$(document).ready(function () {
  // Smooth scroll to sections (like #events)
  $("nav a[href^='#']").on("click", function (e) {
    const target = $(this).attr("href");

    if (target !== "#" && $(target).length) {
      e.preventDefault();
      $("html, body").animate(
        {
          scrollTop: $(target).offset().top,
        },
        600 // duration in ms
      );
    }
  });

  // Hover effects
  $(".event-card").on("mouseenter", function () {
    $(this).addClass("ring-2 ring-blue-300");
  }).on("mouseleave", function () {
    $(this).removeClass("ring-2 ring-blue-300");
  });

  // Set user role to localStorage for access control
  localStorage.setItem("userRole", "student");
});
