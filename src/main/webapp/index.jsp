<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" />
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
	<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen" />
        <title>Tic Tac Toe - MULLER Bruno</title>
    </head>
    <body>
        <h1>Tic Tac Toe</h1>
        <form method="POST" action="entry-servlet">
            <ul>
                <li><input type="submit" name="user" value="Je commence !" /></li>
                <li><input type="submit" name="computer" value="L'ordinateur commence..." /></li>
            </ul>
        </form>
    </body>
</html>
