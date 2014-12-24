<#macro page_head_common>
<title>TEST</title>
</#macro>

<#macro page_head>
<@page_head_common/>
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
    </body>
</html>
</#macro>