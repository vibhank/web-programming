<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL Introduction</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>

<table class= "table">
		<tr>
		<th class=active><p>Arithmetic Operators</p>
		<table class= "table table-bordered">
		<tr><th>Expression</th><th>Result</th></tr>
		
		<tr class=active>
		<td><p  class=text-center><strong>$</strong><strong>{3+2-1}</strong></p></td><td class=text-center>${ 3+2-1 }</td>
		</tr>
		<tr><td><p class=text-center><strong>$</strong><strong>{"1" +2}</strong></p></td><td class=text-center>${"1" +2 }</td></tr>
		<tr class=active><td><p class=text-center><strong>$</strong><strong>{1+2*3+3/4}</strong></p></td><td class=text-center>${ 1+2*3+3/4 }</td></tr>
		<tr><td><p class=text-center><strong>$</strong><strong>{3%2}</strong></p></td><td class=text-center>${ 3%2 }</td></tr>
		<tr class=active><td><p class=text-center><strong>$</strong><strong>{(8 div 2)mod 3}</strong></p></td><td class=text-center>${(8 / 2) % 3}</td></tr>
		</tr>
		
		
		 </table> 
		</th>
		
		<th class=active><p>Relational Operators</p>
		 <table class= "table table-bordered">
		<tr><th>Expression</th><th>Result</th></tr>
		
		<tr class=active>
		<td><p class=text-center><strong>$</strong><strong>{ 1<2 }</strong></p></td><td class=text-center>${ 1<2 }</td>
		</tr>
		<tr><td><p class=text-center><strong>$</strong><strong>{"a"<"b"}</strong></p></td><td class=text-center>${"a" < "b"}</td></tr>
		<tr class=active><td><p class=text-center><strong>$</strong><strong>{2/3>=3/2}</strong></p></td><td class=text-center>${ 2/3 >= 3/2 }</td></tr>
		<tr><td><p class=text-center><strong>$</strong><strong>{3/4==0.75}</strong></p></td><td class=text-center>${ 3/4 == 0.75 }</td></tr>
		<tr class=active><td><p class=text-center><strong>$</strong><strong>{null=="test"}</strong></p></td><td class=text-center>${null=="test"}</td></tr>
		</tr>
		
		
		
		</table>
		
		
		</th>
		</tr>
		
		  <div class="page-header bg-warning text-primary">
		
		
		</div> 
		<!--  </table>
		
	<table class= "table table-bordered">  -->
		<tr>
		<th><p>Logical Operators</p>
		<table class= "table table-bordered">
		<tr class=active><th>Expression</th><th>Result</th></tr>
		
		<tr>
		<td><p class=text-center><strong>$</strong><strong>{(1<2) && (4<3)}</strong></p></td><td class=text-center>${ (1<2) && (4<3) }</td>
		</tr>
		<tr class=active><td><p class=text-center><strong>$</strong><strong>{(1<2) || (4<3)}</strong></p></td><td class=text-center>${ (1 < 2) || (4 < 3) }</td></tr>
		
		<tr><td><p class=text-center><strong>$</strong><strong>{!(1<2)}</strong></p></td><td class=text-center>${ !(1<2) }</td></tr>
		
		</tr>
		
		
		</table>
		</th>
		
		<th ><p><strong class=text-danger>empty</strong> Operator</p>
		<table class= "table table-bordered">
		<tr class=active><th>Expression</th><th>Result</th></tr>
		
		<tr>
		<td><p class=text-center><strong>$</strong><strong>{ empty"" }</strong></p></td><td class=text-center>${ empty""  }</td>
		</tr>
		<tr class=active><td><p class=text-center><strong>$</strong><strong>{empty null}</strong></p></td><td class=text-center>${empty null}</td></tr>
		<tr><td><p class=text-center><strong>$</strong><strong>{empty param.blah}</strong></p></td><td class=text-center>${empty param.blah}</td></tr>
		</tr>
		
		
		
		</table>
		
		
		</th>
		</tr>
		
	</table>
</body>
</html>