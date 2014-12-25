<#include "layout.ftl">

<#macro page_head>
<@page_head_common/>
  <title>Submit New</title>
</#macro>

<#macro page_body>
  <h1>Submit</h1>
  <p>Hey this place is like <a href="http://www.futureme.org/" target="_blank">future me</a>
    but for txt messages. Fill out the details below and we will txt you in the future.</p>
  <form method="post" action="/submit">
    <label>Your Phone number <input type="text" name="to"></label>
    <label>When to send<input type="datetime" name="date"></label>
    <label>Your Message<br><textarea name="body"></textarea></label>
    <button type="submit">Enque into the system!</button>
  </form>
</#macro>

<@display_page/>
