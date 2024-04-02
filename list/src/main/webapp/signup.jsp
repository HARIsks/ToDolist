<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="saveuser" method="post" enctype="multipart/form-data">
   
   Id:<input type="text" name="id"> <br>
    Name:<input type="text" name="name"> <br>
     Email:<input type="text" name="email"> <br>
      Contact:<input type="text" name="contact"> <br>
       Password:<input type="text" name="password"> <br>
        Image:<input type="file" name="image"> <br>
    <input type="submit">
   
   </form>
</body>
</html>