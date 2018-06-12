package api;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aya
 */
@Path("/image")
public class ImageApi {
    
    
    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFile(
            @FormParam("urlImage") String image) {

       Connection connection=null;

        PreparedStatement ps = null;
        String myQuery = "insert into image(image) values(?)";
        int return_flage1 = 0;
        
            try {  
          connection = DBConnection.getConnection();
                ps = connection.prepareStatement(myQuery);
             ps.setString(1,image);
           
            return_flage1 = ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ImageApi.class.getName()).log(Level.SEVERE, null, ex);
            } 
return Response.status(200).entity(true).build();
}
    


@DELETE
@Path("delete/{myId}")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public Response delete(@PathParam("myId") int id){
    
      Connection connection=null;
        try {
   
            connection = DBConnection.getConnection();
            ResultSet rs = null;
            PreparedStatement ps = null;
            String myQuery = "delete from image where id = ?";
            ps = connection.prepareStatement(myQuery);
            ps.setInt(1, id);
            ps.executeUpdate();

          
        } catch (SQLException ex) {
            Logger.getLogger(ImageApi.class.getName()).log(Level.SEVERE, null, ex);
        }
      return Response.status(200).entity(true).build();

    }

@POST
@Path("/add")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public void addImage(image i){


 Connection connection=null;

        PreparedStatement ps = null;
        String myQuery = "insert into image(image) values(?)";
        
            try {  
          connection = DBConnection.getConnection();
                ps = connection.prepareStatement(myQuery);
             ps.setString(1,i.getImage());
            ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(ImageApi.class.getName()).log(Level.SEVERE, null, ex);
            } 
}
    
    
    


}
