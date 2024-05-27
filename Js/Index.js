// $(document).ready(function() {
//     var currentIndex = 0;
//     var items = $('.carousel-item');
//     var itemAmt = items.length;

//     function cycleItems() {
//         var item = $('.carousel-item').eq(currentIndex);
//         items.hide();
//         item.css('display', 'block');
//     }

//     $('.carousel-control-next').click(function() {
//         currentIndex += 1;
//         if (currentIndex > itemAmt - 1) {
//             currentIndex = 0;
//         }
//         cycleItems();
//     });

//     $('.carousel-control-prev').click(function() {
//         currentIndex -= 1;
//         if (currentIndex < 0) {
//             currentIndex = itemAmt - 1;
//         }
//         cycleItems();
//     });

//     cycleItems();
// });