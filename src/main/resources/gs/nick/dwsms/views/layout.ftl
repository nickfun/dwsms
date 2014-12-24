<#macro page_head_common>
<style>
    label {
        display: block;
    }
    label > input {
        margin-left: 20px;
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
<script src="/public/vendor.min.js"></script>
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
        <@page_head/>
    </head>
    <body>
        <@page_body/>
        <@js_tags/>
    </body>
</html>
</#macro>