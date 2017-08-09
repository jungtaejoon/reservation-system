var CashedAjax = (function() {
	var cashedData = {};
	var returnObj;
	function ajax(url) {
		if(cashedData[url]) {
			returnObj = Promise.resolve(cashedData[url]);
		} else {
			returnObj = $.ajax(url);
			returnObj.then(function(res) {
				cashedData[url] = res;
			});
		}
		return returnObj;
	}
	return {
		ajax: ajax
	}
})();

