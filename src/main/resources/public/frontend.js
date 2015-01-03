/**
 * Front-end code for dwsms
 *
 * http://github.com/nickfun/dwsms
 * 2015-01-03
 */


function showSelectedTime() {
    var $output = $('.js-date-output');
    var now = new moment();
    var amount = $('select[name=amount]').val();
    var unit = $('select[name=unit]').val();
    now.add(amount * unit, 'seconds');
    $output.empty();
    $output.css('visibility', 'visible');
    $output.text("Message will be sent at: " + now.format("LLLL"));

//    console.log("showSelectedTime()");
//    console.log("Now is: " + (new moment().format("LLLL")));
//    console.log("Will send in: " + now.format("LLLL"));
//    console.log("=====");
}

$(document).ready(function () {
    $('select').change(showSelectedTime).change();
    window.setInterval(showSelectedTime, 1 * 1000);
    $('input[name=to]').focus();
    app.init();
});

var app = {};

app.Message = Backbone.Model.extend({
    initialize: function () {
        console.log("New Message!");
    }
});

app.MessageList = Backbone.Collection.extend({
    model: app.Message,
    url: '/sms',
    parse: function (response, options) {
        _.each(response, function (sms) {
            sms.send = new moment(sms.send);
        });
        return response;
    }
});

app.View = Backbone.View.extend({
    tagName: 'ul',
    className: 'messages-in-queue',
    initialize: function () {
        console.log("new view!");
        var tplString = $('#tpl-row').text();
        this.template = _.template(tplString);
    },
    render: function () {
        var that = this;
        this.$el.empty();
        this.collection.each(function (msg) {
            var data = {};
            data.sendTime = msg.get('send').format("LLLL");
            data.phoneNumber = msg.get('to');
            var li = that.template(data);
            that.$el.append($(li));
        });
        if (this.collection.length === 0) {
            this.$el.append("<li>No Messages!</li>");
        }
        return this;
    }
});

app.init = function () {
    app.messages = new app.MessageList();
    app.showEnqueuedMessages();
};

app.showEnqueuedMessages = function () {
    app.messages.fetch({
        success: function () {
            var $target = $('#output-list');
            var view = new app.View({
                collection: app.messages
            });
            view.render();
            $target.empty().append(view.$el);
        }
    });
};

