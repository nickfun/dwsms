/**
 * Front-end code for dwsms
 *
 * http://github.com/nickfun/dwsms
 * 2015-01-03
 */

$(document).ready(function () {
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
    comparator: function (a, b) {
        dateA = a.get('send');
        dateB = b.get('send');
        if (dateA.isBefore(dateB)) {
            return -1;
        }
        if (dateA.isSame(dateB)) {
            return 0;
        }
        return 1;
    },
    parse: function (response, options) {
        _.each(response, function (sms) {
            sms.send = new moment(sms.send);
        });
        return response;
    }
});

app.View = Backbone.View.extend({
    tagName: 'ol',
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
            data.sendTime = msg.get('send').format("LLL");
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
    var fnUpdate = function () {
        app.showSelectedTime();
    };
    // deal with updating the send time preview
    $('select').change(fnUpdate).change();
    window.setInterval(fnUpdate, 1 * 1000);
    //$('input[name=to]').focus();
    $('form').submit(function (e) {
        e.preventDefault();
        // amount, unit, to, body
        var data = {
            amount: $('select[name=amount]').val(),
            unit: $('select[name=unit]').val(),
            to: $('input[name=to]').val(),
            body: $('textarea[name=body]').val()
        };
        $.ajax({
            type: "POST",
            url: "/submit",
            data: data,
            dataType: "json",
            success: function () {
                console.log("it was submitted!");
                app.showEnqueuedMessages();
            }
        });
        $('form')[0].reset();
        return false;
    });
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

app.showSelectedTime = function () {
    var $output = $('.js-date-output');
    var now = new moment();
    var amount = $('select[name=amount]').val();
    var unit = $('select[name=unit]').val();
    now.add(amount * unit, 'seconds');
    $output.empty();
    $output.css('visibility', 'visible');
    $output.text("Message will be sent at: " + now.format("LLLL"));
};
