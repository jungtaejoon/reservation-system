class ThumbnailSlider extends eg.Component {
    constructor() {
        super();
        this.THUMBNAIL = '.thumb';
        this.PHOTO_VIEWER = '#photoviewer';
        this.LAYER = '#layer';
        this.SUB_LAYER = '.sub_layer';
        this.IMG_WRAPPER = '.wrapper img';
        this.BUTTON_WRAPPER = '.btn_wrapper';
        this.CLOSE_BUTTON = '.com_img_btn.close';
        this.PREV_BUTTON = '.com_img_btn.prev';
        this.NEXT_BUTTON = '.com_img_btn.nxt';
        this.x = 0;
        this.point = 0;
        this.imgCount = 0;
        this.template = Handlebars.compile($('#popup_layer_template').html());
        this.rootDOM = this.PHOTO_VIEWER;
        this.toBeMovedDOM = this.IMG_WRAPPER;
        this.bindEvents();
    }

    bindEvents() {
        $(this.THUMBNAIL).on('click', this.popupViewer.bind(this));
        $(this.LAYER)
            .on('click', this.CLOSE_BUTTON, this.hideViewer.bind(this))
            .on('click', this.PREV_BUTTON, this.clickPrev.bind(this))
            .on('click', this.NEXT_BUTTON, this.clickNext.bind(this));
        $(this.PHOTO_VIEWER).on('click', this.toggleBtnVisible.bind(this));
        $(window).resize(this.resizeImg.bind(this));
    }

    hideViewer(e) {
        e.stopPropagation();
        $(e.target).closest(this.PHOTO_VIEWER).addClass('invisible');
    }

    clickNext(e) {
        e.stopPropagation();
        $(this.SUB_LAYER).removeClass('touch');
        this.next();
    }

    clickPrev(e) {
        e.stopPropagation();
        $(this.SUB_LAYER).removeClass('touch');
        this.prev();
    }

    next() {
        if (this.point >= this.imgCount - 1) {
            return;
        }
        this.x = ++this.point;
        this.translateLayer();
    }

    prev() {
        if (this.point <= 0) {
            return;
        }
        this.x = --this.point;
        this.translateLayer();
    }

    translateLayer() {
        $.each($(this.SUB_LAYER), function (i, v) {
            var t = 100 * this.x--;
            $(v).css('transform', 'translateX(' + (-t) + '%)');
        }.bind(this));
    }

    toggleBtnVisible() {
        $(this.BUTTON_WRAPPER).toggleClass('invisible');
    }

    resizeImg() {
        var winHeight = $(window).height();
        var winWidth = $(window).width();
        $.each($(this.IMG_WRAPPER), function () {
            $(this).css({
                'max-height': winHeight,
                'max-width': winWidth
            });
            $(this).parent().css({
                'height': winHeight,
                'width': winWidth,
                'margin-top': -this.height / 2,
                'margin-left': -this.width / 2
            });
        });
        this.imgCount = $(this.SUB_LAYER).length;
    }

    popupViewer(e) {
        e.preventDefault();
        this.point = 0;
        var url = '/comments/' + $(e.target).data('comment-id') + '/images';
        CachedAjax.get(url).then(this.imgLoad.bind(this));
        $(this.PHOTO_VIEWER).removeClass('invisible');
    }

    imgLoad(res) {
        var arr = res.map(function (v, i) {
            return {
                fileId: v,
                tranx: i * 100
            }
        });
        var data = {items: arr}
        $(this.LAYER).html(this.template(data));
        $(this.IMG_WRAPPER).on('load', this.resizeImg.bind(this));
    }
}