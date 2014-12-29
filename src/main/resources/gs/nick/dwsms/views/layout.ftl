<#macro page_head_common>
<style>
    label {
        display: block;
    }
    label > input {
        margin-left: 20px;
    }
</style>
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">
<!--[if lte IE 8]>
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/grids-responsive-old-ie-min.css">
<![endif]-->
<!--[if gt IE 8]><!-->
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/grids-responsive-min.css">
<!--<![endif]-->
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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <@page_head/>
    </head>
    <body>
        <@page_body/>
        <@js_tags/>
    </body>
</html>
</#macro>