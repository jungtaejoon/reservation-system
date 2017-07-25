const HOST = "http://localhost:8080";

class ProductInfo extends eg.Component {
	
	constructor() {
		super();
		this.imageAjax = {};
		this.infoAjax = {};
		
		this.info = {
			id: {},
			categoryId: {},
			name: {},
			description: {},
			salesStart: {},
			salesEnd: {},
			salesFlag: {},
			event: {},
			createDate: {},
			modifyDate: {},
			content: {},
			observationTime: {},
			displayStart: {},
			displayEnd: {},
			placeName: {},
			placeLot: {},
			placeStreet: {},
			tel: {},
			homepage: {},
			email: {},
			avgScore: {},
			commentCount: {},
		};
		
		this.image = {
			id: {},
			saveFileName: {},
			fileLength: {}
		};
		
	}
	
	init(productId) {
		//console.log("init called. productId: " + productId);
		this.getInfo(productId);
		this.getImage(productId);
		
		$.when(this.infoAjax ,this.imageAjax).then(
				this.showInfo.bind(this)
		);
	}
	
	
	getInfo(productId) {
		//console.log("getInfo called. productId: " + productId);
		var url = HOST + "/api/detail/info/" + productId;
		this.infoAjax = $.ajax({
			url: url,
			type: "GET",
			dataType: "json"
		})
		.done((function(response) {
			this.info = response;	
			//console.log(this);
		}).bind(this))
		.fail(function() {
			console.log("getInfo failed.");
		});
	}
	
	getImage(productId) {
		//console.log("getImage called. productId: " + productId);
		var url = HOST + "/api/detail/main-image/" + productId;
		this.imageAjax = $.ajax({
			url: url,
			type: "GET",
			dataType: "json"
		})
		.done((function(response) {
			this.image = response;
		}).bind(this))
		.fail(function() {
			console.log("getImage failed.");
		});
	}
	
	
	
	showInfo() {
		//console.log(this);
		var source = $("#product_info_template").html();
		var template = Handlebars.compile(source);
		
		this.info.displayStart = Time.toYYYYMMDD(this.info.displayStart);
		this.info.displayEnd = Time.toYYYYMMDD(this.info.displayEnd);

		
		var data = {
				info: this.info,
				image: this.image
			};
		//console.log(data);
		var html = template(data);
		
		$(".ct_wrap").prepend(html);
	}
	
}






class Price extends eg.Component {
	constructor() {
		super();
		this.priceAjax = {};
		this.prices = {};
		
		this.length = {};
		
		this.counts = new Array();
		
		this.discountPrices = new Array();
		
		this.types = ["", "성인(만 19~64세)", "청소년(만 13~18세)", "어린이(만 4~12세)"];
	}
	
	init(productId) {
		//console.log("init called. productId: " + productId);
		this.getPrice(productId);
		
	}
	
	getPrice(productId) {
		var url = HOST + "/api/price/" + productId;
		this.priceAjax = $.ajax({
			url: url,
			type: "GET",
			dataType: "json"
		})
		.done(
			this.showPrice.bind(this)
		)
		.fail(function() {
			console.log("getImage failed.");
		});
	}
	
	showPrice(response) {
		this.prices = response;
		this.length = response.length;
		
		var source = $("#price_info_template").html();
		var template = Handlebars.compile(source);
		
		var array = new Array();
		
		
		this.prices.forEach(function(element, index){
			var price = element.price;
			var discountRate = element.discountRate;
			var discountPrice = price * (1 - discountRate);

			var ob = {
				priceTypeString: this.types[element.priceType],
				price: price,
				discountRate: discountRate,
				discountPrice: discountPrice,
				discountRateString: (discountRate == 0)? "": "(" + discountRate * 100 + "% 할인가)",
				};
			array.push(ob);
			this.counts.push(0);
			this.discountPrices.push(discountPrice);
		}.bind(this));
		
		var data = {prices: array};
		var html = template(data);
		$(".store_details p:last-child").append(html);
		
		
		source = $("#price_control_template").html();
		template = Handlebars.compile(source);
		html = template(data);
		$(".ticket_body").append(html);	

	}
	setTriggerAdd(index) {
		addCount
	}
	
}




class Time extends eg.Component {
	static week(day) {
		return Array("일","월","화","수","목","금","토")[day];
	}
 
	static toYYYYMMDD(time) {
		var t = new Date(time);
		return t.getFullYear() + "." + (t.getMonth()+1) + "." + t.getDate() + ".(" + this.week(t.getDay()) + ")";
	}
}



(function(window){
	var productInfo = new ProductInfo();
	productInfo.init(productId);
	var priceInfo = new Price();

	
	$.when(productInfo.infoAjax , productInfo.imageAjax).done(function(){
		priceInfo.init(productId);
	}).then(priceBtnSet);
	
	
	
	function priceBtnSet() {
		$.when(productInfo.infoAjax, productInfo.imageAjax , priceInfo.priceAjax).done(function(){
			priceInfo.on("addCount", function(event, index) {
		
				const max = 10;
				var $root = $(".qty:nth-of-type("+index+")");
				
				var count = ++this.counts[index-1];
				
				if(count > max) {
					alert(max + "매 이상 구매할 수 없습니다.");
					this.counts[index]--;
					return;
				} else if( count == max){
					$root.find(".ico_plus3").addClass("disabled");
				} else if(count == 1) {
					$root.find(".count_control_input").removeClass("disabled");
					$root.find(".ico_minus3").removeClass("disabled");
					$root.find(".individual_price").addClass("on_color");
				}
				
				$root.find(".count_control_input").val(count);
				$root.find(".total_price").html(count * this.discountPrices[index-1]);
				
			});
			
			priceInfo.on("subCount", function(event, index) {
				
				
				const max = 100;
				var $root = $(".qty:nth-of-type("+index+")");
				
				var count = --this.counts[index-1];
				
				if(count <0) {
					this.counts[index]++;
					return;
				} else if(count == max-1) {
					$().find(".ico_plus3").removeClass("disabled");
				} else if(count == 0) {
					$root.find(".count_control_input").addClass("disabled");
					$root.find(".ico_minus3").addClass("disabled");
					$root.find(".individual_price").removeClass("on_color");
				}
				
				$root.find(".count_control_input").val(count);
				$root.find(".total_price").html(count * this.discountPrices[index-1]);
				
			});
			
			console.log(priceInfo);
			
			for(var index=1; index <= priceInfo.length; index++) {
				
				//var $root = $(".qty:nth-of-type("+index+")");
				var $root = $(".qty:nth-of-type("+index+")");
				$root.find(".ico_plus3").on("click", function(index, event) {
					event.preventDefault(); 
					event.stopPropagation();
					priceInfo.trigger("addCount", {}, index);
				}.bind(this,index));
				
				$root.find(".ico_minus3").on("click", function(index, event) {
					event.preventDefault(); 
					event.stopPropagation();
					priceInfo.trigger("subCount", {}, index);
				}.bind(this,index));
			}
		});
	
	}
	
	
	
})();
