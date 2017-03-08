<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Select dates</title>
		
		<!-- loads jquery and jquery ui -->
		<!-- -->
		<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.11.1.js"></script>
		<!-->
		<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.11.1.js"></script>
		<!-- -->
		<script type="text/javascript" src="jquery-ui.multidatespicker.js"></script>
		<script type="text/javascript">
		<!--
			var latestMDPver = $.ui.multiDatesPicker.version;
			var lastMDPupdate = '2014-09-19';
			
			$(function() {
				// Version //
				//$('title').append(' v' + latestMDPver);
				$('.mdp-version').text('v' + latestMDPver);
				$('#mdp-title').attr('title', 'last update: ' + lastMDPupdate);
				
				// Documentation //
				$('i:contains(type)').attr('title', '[Optional] accepted values are: "allowed" [default]; "disabled".');
				$('i:contains(format)').attr('title', '[Optional] accepted values are: "string" [default]; "object".');
				$('#how-to h4').each(function () {
					var a = $(this).closest('li').attr('id');
					$(this).wrap('<'+'a href="#'+a+'"></'+'a>');
				});
				$('#demos .demo').each(function () {
					var id = $(this).find('.box').attr('id') + '-demo';
					$(this).attr('id', id)
						.find('h3').wrapInner('<'+'a href="#'+id+'"></'+'a>');
				});
				
				// Run Demos
				$('.demo .code').each(function() {
					eval($(this).attr('title','NEW: edit this code and test it!').text());
					this.contentEditable = true;
				}).focus(function() {
					if(!$(this).next().hasClass('test'))
						$(this)
							.after('<button class="test">test</button>')
							.next('.test').click(function() {
								$(this).closest('.demo').find('.hasDatepicker').multiDatesPicker('destroy');
								eval($(this).prev().text());
								$(this).remove();
							});
				});
			});
		// -->
		</script>
		
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
				<h2>Step 2: Select the event dates</h2>
					<ul id="demos-list">
						<li class="demo first">
						<form action="DatePickerServlet" id="datepickerform">
							<div id="simpliest-usage" class="box"></div>
							<p class="description">
								You can select multiple dates.
							</p>
							<div class="code-box">
								<pre class="code prettyprint">
								</pre>
								</div>
								<input type="submit" value="Select Dates" />
						</form>
						</li>			
					</ul>
				<div class="clear"></div>
			</div>

		</div>
		
		<!-- -----------------------------------  -->
		
		<jsp:include page="dates_panel.jsp"/>
		
		<!-- -----------------------------------  -->
		
	</body>
</html>