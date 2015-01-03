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
    #output-list .send-phone-number {
        font-family: monospace;
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
    <form method="post" action="/submit" class="form">
        <div class="row">
            <div class="col-xs-6 col-md-5 col-md-offset-1">
                <div class="form-group">
                    <label for="to">Your Phone Number</label>
                    <input class="form-control" id="to" name="to" type="text" placeholder="5108952660">
                </div>
            </div>
            <div class="col-xs-6 col-md-5">
                <div class="form-group">
                    <p>Send in...</p>
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
                </div>
            </div>
        </div> 
        <div class="row"> 
            <div class="col-xs-12 col-md-10 col-md-offset-1">
                <div class="form-group">
                    <label for="body">Your Message</label>
                    <textarea class="form-control" id="body" name="body"></textarea>
                </div>
                <p class="js-date-output"> &nbsp; </p>
                <div class="form-group">
                    <button type="submit" class="btn btn-default btn-primary">Submit</button>
                </div>
            </div>
        </div>
    </form>
    <div class="row">
        <div class="col-xs-12 col-md-10 col-md-offset-1">
            <h3>Enqueued Messages</h3>
            <div id="output-list"></div>
        </div>
    </div>
</div>
</#macro>

<#macro js_tags>
<@js_tags_common/>

<script src="/public/frontend.js"></script>
<script type="text/template" id="tpl-row">
    <li>Send to <span class="send-phone-number"><%- phoneNumber %></span> on <%- sendTime %></li>
</script>
</#macro>

<@display_page/>
