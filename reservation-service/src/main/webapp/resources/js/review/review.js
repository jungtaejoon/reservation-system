import jQuery from 'jquery';
import {Flicker} from '../flicker';
import {ThumbnailSlider} from '../thumbnailSlider';
import {ReviewList} from "./reviewList";

window.$ = jQuery;

$(function () {
    var thumbnailSlider = new ThumbnailSlider('ul.list_short_review');
    new Flicker(thumbnailSlider);

    ReviewList.init();
});