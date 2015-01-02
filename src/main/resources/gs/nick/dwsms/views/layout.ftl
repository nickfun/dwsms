<#macro page_head_common>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootswatch/3.3.1/superhero/bootstrap.min.css">
<style>
    a {
        text-decoration: underline;
    }
</style>
</#macro>

<#macro page_head>
<@page_head_common/>
</#macro>

<#macro js_tags>
<@js_tags_common/>
</#macro>

<#macro js_tags_common>
<script src="//cdnjs.cloudflare.com/ajax/libs/lodash.js/2.4.1/lodash.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/backbone.js/1.1.2/backbone-min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/backbone.marionette/2.3.0/backbone.marionette.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.4/moment.min.js"></script>
</#macro>

<#macro page_body_common>
<h1>page body</h1>
</#macro>

<#macro page_body>
<@page_body_common/>
</#macro>

<#macro display_page>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <@page_head/>
    </head>
    <body>
        <@page_body/>
        <@js_tags/>
    </body>
</html>
</#macro>