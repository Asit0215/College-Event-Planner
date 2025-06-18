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
        600
      );
    }
  });

  $(".event-card").hover(
    function () {
      $(this).addClass("ring-2 ring-blue-300");
    },
    function () {
      $(this).removeClass("ring-2 ring-blue-300");
    }
  );

  // Show username from localStorage
  const username = localStorage.getItem("username") || "Guest";
  $("#usernameDisplay").text("Welcome, " + username);

  $("#profileBtn").click(function () {
    $("#profileDropdown").toggle();
  });

  $("#logoutBtn").click(function () {
    localStorage.clear();
    alert("You have been logged out.");
    window.location.href = "login.html";
  });
});
