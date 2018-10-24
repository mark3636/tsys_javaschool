<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visit</title>
</head>
<body>
    Hello, this is your first visit!
    <div id="slider"></div>
    <script src="resources/oujquery.js"></script>
    <script src="resources/jQDateSlider.js"></script>
    <script>
        //<!--
        $("#slider").rangeSlider();
        //-->
    </script>
    <form action="/new-visit" method="post">
        <input type="submit" value="Add visit">
    </form>
</body>
</html>
