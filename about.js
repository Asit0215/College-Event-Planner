// about.js
$(document).ready(function () {
    // Fade in the section on load
    $('section').hide().fadeIn(1000);

    // Hover animation for image
    $('img').hover(
        function () {
            $(this).css({
                transform: 'scale(1.05)',
                transition: 'transform 0.3s ease-in-out'
            });
        },
        function () {
            $(this).css({
                transform: 'scale(1)',
                transition: 'transform 0.3s ease-in-out'
            });
        }
    );

    // Highlight mission and why-use-us headings on scroll
    const highlightOnScroll = () => {
        $('h3').each(function () {
            const top = $(this).offset().top;
            const scroll = $(window).scrollTop();
            const windowHeight = $(window).height();

            if (top < scroll + windowHeight - 100) {
                $(this).addClass('text-blue-800 transition-colors duration-500');
            }
        });
    };

    $(window).on('scroll', highlightOnScroll);
    highlightOnScroll(); // initial check
});
