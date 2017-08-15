$(function () {
    var childrenLength = $('ul.visual_img').children().length;
    var childWidth = $('ul.visual_img').children().outerWidth();
    var slider = new Slider('#detail_slider', {
        max: childrenLength,
        prevButton: '.btn_prev',
        nextButton: '.btn_nxt',
        moveRange: childWidth,
        stopOption: true
    });
    new SliderPanel('span.num:not(.off)', slider);
    new Flicker(slider);

    var thumbnailSlider = new ThumbnailSlider();
    new Flicker(thumbnailSlider);

    BuildDetail.init();
    NaverMap.init();
});





