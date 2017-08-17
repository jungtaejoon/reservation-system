import {Reserver} from "./reserver";
import {Ticket} from "./ticket";
import jQuery from "jquery";

window.$ = jQuery;

$(function () {
    var tickets = []
    $(".qty").each(function(i, e){
        tickets.push(new Ticket($(e).attr('id')));
    });
    Reserver.init(tickets);
});