var CachedAjax = (function() {
	var cachedData = {};
	var returnObj;
	function get(url) {
		if(cachedData[url]) {
			returnObj = Promise.resolve(cachedData[url]);
		} else {
			returnObj = $.ajax(url);
			returnObj.then(function(res) {
				cachedData[url] = res;
			});
		}
		return returnObj;
	}
	return {
		get: get
	}
})();

