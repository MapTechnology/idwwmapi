<%

if(request.getRemoteAddr().toString().equals("0:0:0:0:0:0:0:1")){
	out.print("localhost");
}
else {
out.print( request.getRemoteAddr() );
System.out.println("retornando para ihmWeb " + request.getRemoteAddr());
}

%>
