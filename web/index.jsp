<%@page import="com.emergentes.modelo.Agenda"%>
<%@page import="java.util.ArrayList"%>
<%
    if (session.getAttribute("listaage")== null)
    {
        ArrayList<Agenda> la=new ArrayList<Agenda>();
        session.setAttribute("listaage", la);   
    }
    ArrayList<Agenda> lista = (ArrayList<Agenda>)session.getAttribute("listaage");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de agenda</h1>
        <a href="MainServlet?op=nuevo">Nuevo registro</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Hora</th>
                <th>Actividad</th>
                <th>Completado</th>
                <th></th>
                <th></th>
            </tr>
            <%
                if(lista !=null)
                {
                    for(Agenda item : lista)
                    {
                
            %>
            <tr>
                <th><%= item.getId() %></th>
                <th><%= item.getHora() %></th>
                <th><%= item.getActividad() %></th>
                <th><%= item.getCompletado() %></th>
                <th><a href="MainServlet?op=editar&id=<%=item.getId() %>">Editar</a></th>
                <th><a href="MainServlet?op=eliminar&id=<%=item.getId() %>" onclick="return(confirm('Esta seguro de eliminar??'))">Eliminar</a></th>
            </tr>
            
            <%
                    }
                }
            %>
        </table>
