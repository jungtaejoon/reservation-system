import {BuildDetail} from './buildDetail';
import {NaverMap} from './naverMap';
import {Slider} from '../slider';
import {SliderPanel} from './sliderPanel';
import {Flicker} from '../flicker';
import {ThumbnailSlider} from './thumbnailSlider';
import jQuery from "jquery";

window.$ = jQuery;

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





