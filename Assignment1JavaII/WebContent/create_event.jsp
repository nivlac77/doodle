<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create your event</title>
<!-- loads some utilities (not needed for your developments) -->
		<link rel="stylesheet" type="text/css" href="css/mdp.css">
		<link rel="stylesheet" type="text/css" href="css/prettify.css">
		<script type="text/javascript" src="js/prettify.js"></script>
		<script type="text/javascript" src="js/lang-css.js"></script>
		<script type="text/javascript" src="js/myjs.js"></script>
</head>
<body>
	<div id="page">			
			<div id="demos">
				<h2>Step 1: Give your event a description</h2>
				<form action="CreateEvent">
					<ul id="demos-list">
						<li class="demo full-row">
							<p class="description">
								<label>Event Name:</label> <input type="text" name="eventName"/>
							</p>
							<p class="description">
								<label>Event Description:</label><br><textarea name="description" rows="10" cols="90">test</textarea>
							</p>
						</li>	
					</ul>
					<input type="submit" value="NEXT">
				</form>
				<div class="clear"></div>
				
			</div>
		</div>
</body>
</html>