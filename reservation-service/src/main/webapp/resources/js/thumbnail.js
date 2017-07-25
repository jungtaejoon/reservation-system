		var ThumbApp = (function() {
			var	x = 0;
			var point = 0;
			var imgCount = 0;
			var template;
			var moveGapX;
			var touchStartPointX;
			function init() {
				template = Handlebars.compile($('#popup_layer_template').html());
				bindEvents();
			}
			function bindEvents() {
				$('.thumb').on('click', popupViewer.bind(this));
				$('#layer')
					.on('click', '.com_img_btn.close', hideViewer.bind(this))
					.on('click', '.com_img_btn.nxt', clickNext.bind(this))
					.on('click', '.com_img_btn.prev', clickPrev.bind(this));
				$('#photoviewer')
					.on('click', toggleBtnVisible.bind(this))
					.on('touchstart', '.wrapper img', viewerTouchStart.bind(this))
					.on('touchmove', '.wrapper img', viewerTouchMove.bind(this))
					.on('touchend', '.wrapper img', viewerTouchEnd.bind(this));
			}
			function hideViewer(e) {
				e.stopPropagation();
				$(e.target).parents('#photoviewer').hide();
			}
			function clickNext(e) {
				e.stopPropagation();
				$('.sub_layer').removeClass('touch');
				next();
			}
			function clickPrev(e) {
				e.stopPropagation();
				$('.sub_layer').removeClass('touch');
				prev();
			}
			function next() {
				if(point >= imgCount - 1) { return; }
				x = ++point;
				translateLayer(x);
			}
			function prev() {
				if(point <= 0) { return; }
				x = --point;
				translateLayer(x);
			}
			function translateLayer(x) {
				$.each($('.sub_layer'), function() {
					var t = 100 * x--;
					$(this).css('transform', 'translatex(' + (-t) + '%)');
				});
			}
			function toggleBtnVisible() {
				$('.btn_wrapper').toggleClass('invisible');
			} 
			$(window).resize(function() {
				$.each($('.wrapper img'), function() {
					$(this).css({
						'max-height': $(window).height(),
						'max-width': $(window).width()
					});
					$(this).parent().css({
						'height': $(window).height(),
						'width': $(window).width(),
						'margin-top': -this.height / 2,
						'margin-left': -this.width / 2
					});
				});
				imgCount = $('.sub_layer').length;
			});
			function popupViewer(e){
				e.preventDefault();
				point = 0;
				$.ajax({
				    method : 'get',
				    url : '/comments/' + $(e.target).data('comment-id') + '/images',
				    success : function(res) {
				    	var arr = res.map(function(v, i) {
				    		return {
				    			fileId: v,
				    			tranx: i * 100
				    		}
				    	});
				    	var data = {items: arr}
				    	$('#layer').html(template(data));
				    	$('.wrapper img').on('load', function(){
				    		$(window).resize();
				    	});
				    },
				    error : function(request, status, error ) {   // 오류가 발생했을 때 호출된다. 
				    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    	}
				});
		        $('#photoviewer').fadeTo("fast",1);    
			}
			function viewerTouchStart(e) {
				toggleBtnVisible();
				$('.sub_layer').addClass('touch');
				var event = e.originalEvent;
				moveGapX = 0;
				touchStartPointX = event.touches[0].screenX;
				e.preventDefault();	//	이벤트취소
			}
			function viewerTouchMove(e) {
				var event = e.originalEvent;
				$(e.target).css('transform', 'translatex(' + -moveGapX + 'px)');
				moveGapX = touchStartPointX - event.touches[0].screenX;
				e.preventDefault();
			}
			function viewerTouchEnd(e) {
				if(moveGapX < -50) {
					$('.com_img_btn').hide();
					prev();
				}
				if(moveGapX > 50) {
					$('.com_img_btn').hide();
					next();
				}
				if(moveGapX == 0) {
					$('.com_img_btn').show();
				}
				$(e.target).css('transform', 'translatex(0px)');
				e.preventDefault();
			}
			$('#layer').on('click', function(e) {
				$('.com_img_btn').show();
			});
			return {
				init: init
			}
		})();
