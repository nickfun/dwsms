<#include "layout.ftl">

<#macro page_head>
<@page_head_common/>
<title>Submit New</title>
<style>
    label,
    p {
        font-size: 1.5em;
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
            <form method="post" action="/submit">
                <div class="form-group">
                    <label for="to">Your Phone Number</label>
                    <input class="form-control" id="to" name="to" type="text" placeholder="5108952660">
                </div>
                <div class="form-group">
                    <label for="date">When to send<br>
                        Server time is: <mark>${currentTime}</mark><br>
                        <span class="date-format-example">Ex: ${dateFormat}</span></label>
                    <input class="form-control" type="text" name="date" id="date">
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

<@display_page/>
