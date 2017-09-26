package rafaelgoncalves.resource;

import rafaelgoncalves.application.command.AddUser;
import rafaelgoncalves.application.command.AddUserService;
import rafaelgoncalves.application.command.RemoveUser;
import rafaelgoncalves.application.command.RemoveUserService;
import rafaelgoncalves.application.command.base.CommandConfirmation;
import rafaelgoncalves.application.query.FindAllUsersService;
import rafaelgoncalves.application.query.FindUser;
import rafaelgoncalves.application.query.FindUserService;
import rafaelgoncalves.application.query.UserDto;
import rafaelgoncalves.application.query.base.EmptyQuery;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
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
