import {SlideTimer} from "./slideTimer";
import {Flicker} from "../flicker";
import {CategoryList} from "./categoryList";
import {Slider} from "../slider";
import jQuery from "jquery";

window.$ = jQuery;

$(function () {
    var slider = new Slider('#main_slider', {
        max: 3,
        prevButton: '.prev_e',
        nextButton: '.nxt_e',
        moveRange: 338
    });
    new SlideTimer(slider);
    new Flicker(slider);

    CategoryList.init();
});
