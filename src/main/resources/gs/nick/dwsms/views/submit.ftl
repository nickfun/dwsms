<#include "layout.ftl">

<#macro page_head>
<@page_head_common/>
<title>Submit New</title>
<style>
    .date-format-example {
        color: #aaa;
    }
</style>
</#macro>

<#macro page_body>
<h1>Submit</h1>
<div class="pure-g">
    <div class="pure-u-1 pure-u-md-1-2">
        Hey this place is like 
        <a href="http://www.futureme.org/" target="_blank">future me</a>
        but for txt messages. Fill out the details below and we will 
        txt you in the future.
    </div>
</div>

<form class="pure-form pure-form-stacked" method="post" action="/submit">
    <fieldset>
        <legend>A Stacked Form</legend>
        <label for="to">Your phone number</label>
        <input id="to" name="to" type="text" placeholder="+15108952660">

        <label for="date">When to send<br>
            <span class="date-format-example">Ex: ${dateFormat}</span></label>
        <input type="text" name="date" id="date">

        <label for="body">Your Message</label>
        <textarea id="body" name="body"></textarea>
        <button type="submit" class="pure-button pure-button-primary">Submit</button>
    </fieldset>
</form>
</#macro>

<@display_page/>
