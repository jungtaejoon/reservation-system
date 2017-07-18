function changeCounts(res) {
	etcData.setCounts(res);
	$('#product_counts').html(res + '개');
	if(etcData.getGap() > 10) $('.more .btn').removeClass('invisible');
}
function refreshProducts(res) {
	$('#display_info_box ul').html('');
	appendProducts(res);
}
function appendProducts(res) {
	var source = $("#display_info_box_template").html();
    var template = Handlebars.compile(source);
    var left = [];
    var right = [];
	for(var i = 0; i < res.length; i++) {
		var data;
		if(i % 2 == 0) {
			left.push(res[i]);
		} else {
			right.push(res[i]);
		}
	}
	left = {
			items : left
	}
	right = {
			items : right
	}
	$('#left_column').append(template(left));
	$('#right_column').append(template(right));
	if(etcData.getGap() <= 10) $('.more .btn').addClass('invisible');
}