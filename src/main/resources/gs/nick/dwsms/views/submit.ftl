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
    <div>
      <label>Your Phone number<br><input type="text" name="to"></label>
    </div>
    <div>
      When to send?<br>
      <label>Minutes 
        <select name="time-minutes">
          <option>0</option>
          <option>1</option>
          <option>5</option>
          <option>15</option>
          <option>30</option>
          <option>45</option>
        </select>
      </label>
    </div>
    <div>
      <label>Days
        <select name="time-days">
          <option>0</option>
          <option>1</option>
          <option>5</option>
          <option>15</option>
          <option>30</option>
          <option>45</option>
        </select>
      </label>
    </div>
    <div>
      <label>Weeks
        <select name="time-weeks">
          <option>0</option>
          <option>1</option>
          <option>5</option>
          <option>15</option>
          <option>30</option>
          <option>45</option>
        </select>
      </label>
    </div>    
    <label>Your Message<br><textarea name="body"></textarea></label>
    <button type="submit">Enque into the system!</button>
  </form>
</#macro>
 
<@display_page/>
