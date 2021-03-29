
<%@page import="com.emergentes.modelo.Agenda"%>
<%
    Agenda reg = (Agenda) request.getAttribute("miobjage");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de agenda</h1>
        <form action="MainServlet" method="post">
            <table>
                <%
                if(reg.getId()!=0)
                {
                %>
                <tr>

                    <td>ID</td>
                    <td>
                        <input type="text" name="id" value="<%= reg.getId()%>" size="2" readonly>
                    </td>
                </tr>                
                <%
                }
                else
                {
                %>
                <tr>
                    <td>ID</td>
                    <td><input type=hidden name="id" value="<%= reg.getId()%>"></td>
                </tr> 
                
                <%
                }
                %>    
                <tr>
                    <td>Hora</td>
                    <td><input type="time" name="hora"   value="<%= reg.getHora() %>" autofocus></td>
                </tr>
                <tr>
                    <td>Actividad</td>
                    <td><input type="text" name="actividad" value="<%= reg.getActividad() %>"></td>
                </tr>        
                <tr>
                    <td>Completado</td>
                    <td><select name="completado">
                    <%
                        if(reg.getCompletado().equals("No") || reg.getId()==0)
                        {
                    %> 
                    <option value="Si">Si</option>
                    <option value="No"  selected>No</option>
                    <%                  
                        }
                        else
                        {
                    %>
                    <option value="Si" selected>Si</option>                          
                    <option value="No" >No</option>
                    <%
                        }

					
                    %>
                    </select>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"> </td>                  
                </tr>
                
                
            </table>
        </form>
    </body>
</html>
