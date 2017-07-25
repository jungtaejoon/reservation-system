	var etcData = (function() {
		var firstIndex = 0;
		var categoryId = 0;
		var counts = 0;
		
		return {
			increaseFirstIndex: function(value) {
				firstIndex += value;
			},
			resetFirstIndex: function() {
				firstIndex = 0;
			},
			getFirstIndex: function() {
				return firstIndex;
			},
			setCategoryId: function(value) {
				categoryId = value;
			},
			getCategoryId: function() {
				return categoryId;
			},
			setCounts: function(value) {
				counts = value;
			},
			getCounts: function() {
				return counts;
			},
			getGap: function() {
				return counts - firstIndex;
			}
		};
	})();
