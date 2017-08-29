package rafaelgoncalves.resource;

import rafaelgoncalves.applicationservice.command.AddUser;
import rafaelgoncalves.applicationservice.command.AddUserService;
import rafaelgoncalves.applicationservice.command.RemoveUser;
import rafaelgoncalves.applicationservice.command.RemoveUserService;
import rafaelgoncalves.applicationservice.command.base.CommandConfirmation;
import rafaelgoncalves.applicationservice.query.FindAllUsersService;
import rafaelgoncalves.applicationservice.query.FindUser;
import rafaelgoncalves.applicationservice.query.FindUserService;
import rafaelgoncalves.applicationservice.query.UserDto;
import rafaelgoncalves.applicationservice.query.base.EmptyQuery;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private final FindAllUsersService findAllUsersService;
    private final FindUserService findUserService;
    private final AddUserService addUserService;
    private final RemoveUserService removeUserService;

    @Inject
	public UserResource(FindAllUsersService findAllUsersService,
                        FindUserService findUserService,
                        AddUserService addUserService,
                        RemoveUserService removeUserService) {
        this.findAllUsersService = findAllUsersService;
        this.findUserService = findUserService;
        this.addUserService = addUserService;
        this.removeUserService = removeUserService;
    }

	@GET
	public List<UserDto> getAll() {
		return findAllUsersService.execute(EmptyQuery.create());
	}

	@POST
    public Response add(AddUserHttp addUserHttp) {
	    AddUser addUser = new AddUser(addUserHttp.getName());
        CommandConfirmation commandConfirmation = addUserService.execute(addUser);
        return Response.created(URI.create("user/" + commandConfirmation.value())).entity(addUserHttp).build();
    }

    @GET
    @Path("{userId}")
    public UserDto get(@PathParam("userId") Long userId) {
        FindUser findUser = new FindUser(userId);
        return findUserService.execute(findUser);
    }

    @DELETE
    @Path("{userId}")
    public Response delete(@PathParam("userId") Long userId) {
        RemoveUser removeUser = new RemoveUser(userId);
        removeUserService.execute(removeUser);
        return Response.ok().build();
    }
}
