package kalah.bol.client.api;

import kalah.bol.client.ApiException;
import kalah.bol.client.ApiClient;
import kalah.bol.client.ApiResponse;
import kalah.bol.client.Configuration;
import kalah.bol.client.Pair;

import javax.ws.rs.core.GenericType;

import kalah.bol.client.domain.Action;
import kalah.bol.client.domain.GameState;
import kalah.bol.client.domain.NewGameCommand;
import kalah.bol.client.domain.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DefaultApi {
  private ApiClient apiClient;

  public DefaultApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DefaultApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Find a Kalah game by the session
   * Find an ongoin kalah game
   * @param sessionId  (required)
   * @return Session
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the found session </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid session supplied </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No game with this session was found </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> There was an failure while searching the game </td><td>  -  </td></tr>
     </table>
   */
  public Session findGameBySession(String sessionId) throws ApiException {
    return findGameBySessionWithHttpInfo(sessionId).getData();
      }

  /**
   * Find a Kalah game by the session
   * Find an ongoin kalah game
   * @param sessionId  (required)
   * @return ApiResponse&lt;Session&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the found session </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid session supplied </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No game with this session was found </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> There was an failure while searching the game </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Session> findGameBySessionWithHttpInfo(String sessionId) throws ApiException {
    Object localVarPostBody = new Object();
    
    // verify the required parameter 'sessionId' is set
    if (sessionId == null) {
      throw new ApiException(400, "Missing the required parameter 'sessionId' when calling findGameBySession");
    }
    
    // create path and map variables
    String localVarPath = "/api/game/{sessionId}"
      .replaceAll("\\{" + "sessionId" + "\\}", apiClient.escapeString(sessionId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Session> localVarReturnType = new GenericType<Session>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Make an game movement
   * Makes an game movement and returns the new game state
   * @param sessionId  (required)
   * @param action  (required)
   * @return GameState
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the new GameState </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No game with this session was found </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> There was an failure while executing the movement </td><td>  -  </td></tr>
     </table>
   */
  public GameState makePlay(String sessionId, Action action) throws ApiException {
    return makePlayWithHttpInfo(sessionId, action).getData();
      }

  /**
   * Make an game movement
   * Makes an game movement and returns the new game state
   * @param sessionId  (required)
   * @param action  (required)
   * @return ApiResponse&lt;GameState&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Returns the new GameState </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid request </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> No game with this session was found </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> There was an failure while executing the movement </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<GameState> makePlayWithHttpInfo(String sessionId, Action action) throws ApiException {
    Object localVarPostBody = action;
    
    // verify the required parameter 'sessionId' is set
    if (sessionId == null) {
      throw new ApiException(400, "Missing the required parameter 'sessionId' when calling makePlay");
    }
    
    // verify the required parameter 'action' is set
    if (action == null) {
      throw new ApiException(400, "Missing the required parameter 'action' when calling makePlay");
    }
    
    // create path and map variables
    String localVarPath = "/api/game/{sessionId}/play"
      .replaceAll("\\{" + "sessionId" + "\\}", apiClient.escapeString(sessionId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<GameState> localVarReturnType = new GenericType<GameState>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Creates a new Kalah Game
   * A new Kalah Game with the informed players is created
   * @param newGameCommand  (required)
   * @return Session
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Returns the new game </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid command supplied </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> There was an failure at the creation of the game </td><td>  -  </td></tr>
     </table>
   */
  public Session newGame(NewGameCommand newGameCommand) throws ApiException {
    return newGameWithHttpInfo(newGameCommand).getData();
      }

  /**
   * Creates a new Kalah Game
   * A new Kalah Game with the informed players is created
   * @param newGameCommand  (required)
   * @return ApiResponse&lt;Session&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Returns the new game </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Invalid command supplied </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> There was an failure at the creation of the game </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Session> newGameWithHttpInfo(NewGameCommand newGameCommand) throws ApiException {
    Object localVarPostBody = newGameCommand;
    
    // verify the required parameter 'newGameCommand' is set
    if (newGameCommand == null) {
      throw new ApiException(400, "Missing the required parameter 'newGameCommand' when calling newGame");
    }
    
    // create path and map variables
    String localVarPath = "/api/game";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Session> localVarReturnType = new GenericType<Session>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
