<#include "layout.ftl">

<#macro page_head>
<@page_head_common/>
<title>Submit New</title>
<style>
    label,
    p {
        font-size: 1.5em;
    }
    .js-date-output {
        visibility: hidden;
    }
    select, option {
        text-transform: capitalize;
    }
</style>
</#macro>

<#macro page_body>
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12 col-md-10 col-md-offset-1">
            <h1>SMS To The Future</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12 col-md-10 col-md-offset-1">
            <p>
                Hey this place is like 
                <a href="http://www.futureme.org/" target="_blank">future me</a>
                but for txt messages. Fill out the details below and we will 
                txt you in the future.
            </p>

        </div>
    </div>
    <div class="row">
        <div class="col-xs-12 col-md-10 col-md-offset-1">
            <form method="post" action="/submit" class="form">

                <div class="form-group">
                    <label for="to">Your Phone Number</label>
                    <input class="form-control" id="to" name="to" type="text" placeholder="5108952660">
                </div>

                <div class="form-group">
                    <p>When to send?
                        <!--<br>Current server time is <mark>${currentTime}</mark>-->
                    </p>
                    <select name="amount" class="form-control">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>10</option>
                        <option>15</option>
                    </select>
                    <select name="unit" class="form-control">
                        <option value="60">minutes</option>
                        <option value="3600">hours</option>
                        <option value="86400">days</option>
                        <option value="604800">weeks</option>
                    </select>
                    <p>... from now</p>
                    <p class="js-date-output"> &nbsp; </p>
                </div>

                <div class="form-group">
                    <label for="body">Your Message</label>
                    <textarea class="form-control" id="body" name="body"></textarea>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-default btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>
</#macro>

<#macro js_tags>
<@js_tags_common/>

<script>
    function showSelectedTime() {
        var $output = $('.js-date-output');
        var now = new moment();
        var amount = $('select[name=amount]').val();
        var unit = $('select[name=unit]').val();
        now.add(amount * unit, 'seconds');
        $output.empty();
        $output.css('visibility', 'visible');
        $output.text("Message will be sent at: " + now.format("LLLL"));
        console.log("showSelectedTime()");
        console.log("Now is: " + (new moment().format("LLLL")));
        console.log("Will send in: " + now.format("LLLL"));
        console.log("=====");
    }

    $(document).ready(function() {
        $('select').change(showSelectedTime).change();
        window.setInterval(showSelectedTime, 10 * 1000);
        $('input[name=to]').focus();
    });
</script>

</#macro>

<@display_page/>
