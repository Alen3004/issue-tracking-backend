package nu.jixa.its.web.endpoint;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import nu.jixa.its.web.Values;

/**
 * Common utility class for REST endpoints.
 */
final class Util {

  /**
   * Returns false if the argument is null or an empty String, otherwise returns true.
   */
  public static <T> boolean queryEntered(T query) {
    if (query == null) {
      return false;
    }
    if (query instanceof String) {
      return !((String) query).isEmpty();
    }
    return true;
  }


  public static Response badRequestResponse() {
    return badRequestResponse(Values.BAD_REQUEST_NULL_OR_INVALID_MESSAGE);
  }

  public static Response badRequestResponse(Exception e) {
    return badRequestResponse(e.getMessage());
  }

  public static Response badRequestResponse(String message) {
    return response(Response.Status.BAD_REQUEST, message);
  }

  public static Response response(Response.Status status, String message) {
    return Response.status(status).entity(message).build();
  }

  /** TODO REMOVE
   * @return The Authorization Token
   * @throws NotAuthorizedException If the header doesn't start with substr "Bearer "
   */
  public static String extractAuthorizationToken(HttpHeaders httpHeaders) throws NotAuthorizedException {
    String authorizationHeader = httpHeaders.getHeaderString(Values.HEADER_NAME_AUTH_TOKEN);

    // Check if the HTTP Authorization header is present and formatted correctly
    if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
      throw new NotAuthorizedException("Authorization header must be provided");
    }

    return authorizationHeader.substring("Bearer".length()).trim();
  }

}
