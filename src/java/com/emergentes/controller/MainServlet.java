
package com.emergentes.controller;

import com.emergentes.modelo.Agenda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       String opcion = request.getParameter("op");
       Agenda objage =new Agenda();
       int id, pos;
       HttpSession ses= request.getSession();
       List<Agenda> lista =(List<Agenda>) ses.getAttribute("listaage");
       
       switch(opcion)
       {
           case "nuevo":
               //enviar objeto a editar
               request.setAttribute("miobjage", objage);
               request.getRequestDispatcher("editar.jsp").forward(request, response);
               break;
               
           case "editar":
               id= Integer.parseInt(request.getParameter("id"));
               //Obtener la posicion del elemento en la coleccion
               pos= buscarPorIndice(request, id);
               //Obtener el objeto
               objage=lista.get(pos);
               //Enviar para edicion
               request.setAttribute("miobjage", objage);
               request.getRequestDispatcher("editar.jsp").forward(request, response);
               break;
               
           case "eliminar":
               //Obtener la posicion del elemento en la coleccion
               id = Integer.parseInt(request.getParameter("id"));
               pos=buscarPorIndice(request, id);
               if(pos >=0)
               {
                   lista.remove(pos);
               }
               //Actulizamos la lista debido a la eliminacion
               request.setAttribute("listaage", lista);
               response.sendRedirect("index.jsp");
               break;
               
           default:
               request.setAttribute("listaage", lista);
               response.sendRedirect("index.jsp");
       }
       

       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        int id=Integer.parseInt(request.getParameter("id"));
        HttpSession ses=request.getSession();
        ArrayList<Agenda> lista=(ArrayList<Agenda>)ses.getAttribute("listaage");
        Agenda objage=new Agenda();
        objage.setId(id);
        objage.setHora(request.getParameter("hora"));
        objage.setActividad(request.getParameter("actividad"));
        objage.setCompletado(request.getParameter("completado"));
        System.out.println("El ED es "+id);
        if(id==0)
        {
            //Colocar el ID
            int idNuevo=obtenerId(request);
            objage.setId(idNuevo);
            
            lista.add(objage);
            System.out.println(objage.toString());
        }
        else
        {
            //edicion
            int pos= buscarPorIndice(request, id);
            lista.set(pos, objage);
            System.out.println(objage.toString()); 
        }
        System.out.println("Envian as index");
        request.setAttribute("listaage", lista);
        response.sendRedirect("index.jsp");
        
        
     
    }
    
    public int buscarPorIndice(HttpServletRequest request, int id)
    {
        HttpSession ses = request.getSession();
        List<Agenda> lista =(List<Agenda>) ses.getAttribute("listaage");
        
        int pos=-1;
        
        if(lista !=null)
        {
            for (Agenda ele : lista)
            {
                ++pos;
                if(ele.getId()==id)
                {
                    break;
                }
            }
        }
        return pos;

    }
    
    public int obtenerId(HttpServletRequest request)
    {
        HttpSession ses = request.getSession();
        List<Agenda> lista =(List<Agenda>) ses.getAttribute("listaage");
        //Conteo de Id desde 0
        int idn=0;
        
        for (Agenda ele : lista)
        {
            idn=ele.getId();
        }
        
        return idn+1;

    }

}
