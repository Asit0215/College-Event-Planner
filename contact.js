// contact.js
$(document).ready(function () {
    $('form').on('submit', function (e) {
        e.preventDefault(); // Prevent form submission

        const name = $('input[type="text"]').val().trim();
        const email = $('input[type="email"]').val().trim();
        const message = $('textarea').val().trim();
        const emailPattern = /^[^@\s]+@[^@\s]+\.[^@\s]+$/;

        if (name.length < 2) {
            alert("Please enter a valid name (min 2 characters).");
            return;
        }

        if (!emailPattern.test(email)) {
            alert("Please enter a valid email address.");
            return;
        }

        if (message.length < 10) {
            alert("Message should be at least 10 characters long.");
            return;
        }

        // If valid, show success and update button
        const button = $('form button[type="submit"]');
        button.text("Sent ✓").prop('disabled', true).addClass("bg-green-500 hover:bg-green-600");

        // Optional: Clear the form after a second
        setTimeout(() => {
            $('form')[0].reset();
        }, 1000);
    });
});
