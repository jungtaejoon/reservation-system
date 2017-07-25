var CommonModule = (function(){
	
	var imgMove = function(container, direction, width, animationSpeed, action){
		container.filter(":not(:animated)").animate({'margin-left': direction+width}, animationSpeed, action);
	};
	
	return {
		imgMove : imgMove
	}
})();
