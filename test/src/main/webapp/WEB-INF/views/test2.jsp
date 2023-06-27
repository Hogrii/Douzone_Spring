<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("utf-8");
String name = request.getParameter("no");
String host = "http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnMesureSidoLIst?serviceKey=0MrHSfELmiM%2FCSfmxvpQ1XR4o2%2B%2Fy0qsXMvyuYVsapMD2%2FYg1wDHPXoCcYqy9l2KR6%2BD9Cy5xkbMTa1Hkb6rtg%3D%3D&numOfRows=10&pageNo=1&sidoName="+name+"&searchCondition=DAILY&_returnType=json";
URL url = new URL(host); 
URLConnection connection = url.openConnection();
connection.setRequestProperty("CONTENT-TYPE","text/html");
BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
String inputLine;
String buffer = "";
while ((inputLine = in.readLine()) != null){
buffer += inputLine.trim();
}
in.close();
%>
<%=buffer%>