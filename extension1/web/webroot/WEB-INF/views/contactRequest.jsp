<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact Request</title>
</head>
<body>
<form method="post">
    Sender:
    <input type="text" name="newSender" value="${contactRequest.sender}"/>
    <br/>
    Message:
    <textarea name="newMessage">${contactRequest.message}</textarea>
    <br/>
    <input type="submit" value="Send"/>
</form>
</body>
</html>
