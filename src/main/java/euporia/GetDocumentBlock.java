package euporia;

import euporia.database.documents.Blocks;
import euporia.json.DocumentBlock;
import euporia.utils.DbUtils;
import euporia.utils.ShareDBHelper;
import org.hibernate.HibernateException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("GetDocumentBlock")
public class GetDocumentBlock {

    @Context
    private UriInfo uriInfo;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(DocumentBlock data) {
        try {
            DbUtils dbUtils = DbUtils.getInstance();
            Blocks block = dbUtils.getSession().get(Blocks.class, data.getId());
            if (ShareDBHelper.sendBlock(block)) {
                return Response.ok(
                        String.format("{\"success\": \"block was sent to sharedb\", \"url\": \"%s\"}",
                                ShareDBHelper.SHAREDB_URL)
                ).build();
            }
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"could not send data to sharedb\"}")
                    .build();
        } catch (HibernateException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"something went wrong with the database, does the object exist?\"}")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"something went wrong server side, check logs\"}")
                    .build();
        }
    }
}
