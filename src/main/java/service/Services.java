package service;

import datetime.DateServer;
import exceptions.ParseServeException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Path( "/server" )
public class Services  {
    @POST
    @Path( "/date" )
    @Produces(MediaType.APPLICATION_JSON)
    public Response setDate(@QueryParam("time") String dateTime,@QueryParam("timezone") String format)
    {
        String DATE_FORMAT = "HH:mm:ss";
        DateServer dateServer = new DateServer(dateTime,format);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

        try {
            dateServer.changeDate(sdf);
        } catch (ParseException e){
            throw new WebApplicationException( Response.status( Response.Status.NOT_ACCEPTABLE ).entity( e ).build() );
        } catch (ParseServeException e){
            throw new WebApplicationException( Response.status( Response.Status.NOT_ACCEPTABLE ).entity( e ).build() );
        } catch (Exception e){
            throw new WebApplicationException( Response.status( Response.Status.INTERNAL_SERVER_ERROR ).entity( e ).build() );
        }


        return Response.ok( dateServer ).build() ;
    }
}
