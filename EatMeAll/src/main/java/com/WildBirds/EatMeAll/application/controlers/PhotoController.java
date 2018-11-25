package com.WildBirds.EatMeAll.application.controlers;


import com.WildBirds.RepositoryJPA.application.RepositoryFacade;
import com.WildBirds.RepositoryJPA.domain.model.Photo;
import com.WildBirds.RepositoryJPA.domain.model.User;
import com.sun.jersey.multipart.FormDataParam;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.File;

@Path("photo")
@Stateless
@LocalBean
public class PhotoController {

    @EJB
    RepositoryFacade repo;

    @GET
    @Path("{idPhoto}")
    public Response getFile(@Context UriInfo info, @PathParam("idPhoto") Integer idPhoto) {
        Photo photo = repo.PHOTO().get(idPhoto);
        return Response.ok(photo.getPhoto()).type(photo.getFiletype()).build();
    }

    @Path("")
    @POST
    @Consumes("multipart/form-data")
    public Response uploadFile(
            @Encoded @FormDataParam("file") File file) {
        {

//            File dbFile = new File("dbFile");
//            try {
//                FileUtils.copyInputStreamToFile(uploadedInputStream, dbFile);

                Photo photo = repo.PHOTO().insert(new Photo());
                // TODO: 25.11.2018 GET USER FROM COOKIE
                User user = repo.USER().get(1);
                photo.setPhotoOwner(user);
                photo.setPhoto(file);
//                photo.setFilename(fileDetail.getName());
//                photo.setFiletype(fileDetail.getType());
                repo.PHOTO().update(photo);

//            } catch (IOException e) {
//                e.printStackTrace();
//            }




            return Response.status(Response.Status.CREATED).build();
        }

    }

    private String getExtension(@HeaderParam("Content-Type") String fileType) {
        if (fileType.equals("image/jpeg")) {
            return ".jpg";
        } else {
            return ".png";
        }
    }

//    @Path("/files")
//    public class FileUploadService {
//        @POST
//        @Path("/upload")
//        @Consumes(MediaType.MULTIPART_FORM_DATA)
//        public Response uploadFile(
//                @FormDataParam("file") InputStream uploadedInputStream,
//                @FormDataParam("file") FormDataContentDisposition fileDetail) {
//            String fileLocation = "e://" + fileDetail.getFileName();
//            //saving file
//            try {
//                FileOutputStream out = new FileOutputStream(new File(fileLocation));
//                int read = 0;
//                byte[] bytes = new byte[1024];
//                out = new FileOutputStream(new File(fileLocation));
//                while ((read = uploadedInputStream.read(bytes)) != -1) {
//                    out.write(bytes, 0, read);
//                }
//                out.flush();
//                out.close();
//            } catch (IOException e) {e.printStackTrace();}
//            String output = "File successfully uploaded to : " + fileLocation;
//            return Response.status(200).entity(output).build();
//        }
//    }


}
