import {Reserver} from "./reserver";
import {Ticket} from "./ticket";
import jQuery from "jquery";

window.$ = jQuery;

$(function () {
    Reserver.init();
    $(".qty").each(function(i, e){    	
    	new Ticket($(e).attr('id'));
    });
});