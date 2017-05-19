/*
 * finAPI RESTful Services
 * finAPI RESTful Services
 *
 * OpenAPI spec version: v1.20.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.Body10;
import io.swagger.client.model.InlineResponse20014;
import io.swagger.client.model.InlineResponse20015;
import io.swagger.client.model.InlineResponse403;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MandatorAdministrationApi {
    private ApiClient apiClient;

    public MandatorAdministrationApi() {
        this(Configuration.getDefaultApiClient());
    }

    public MandatorAdministrationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for deleteUsers */
    private com.squareup.okhttp.Call deleteUsersCall(Body10 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/api/v1/mandatorAdmin/deleteUsers".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "finapi_auth" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteUsersValidateBeforeCall(Body10 body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling deleteUsers(Async)");
        }
        
        
        com.squareup.okhttp.Call call = deleteUsersCall(body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete users
     * Delete one or several users, which are specified by a given list of identifiers. Must pass the &lt;a href&#x3D;&#39;https://finapi.zendesk.com/hc/en-us/articles/115003661827-Difference-between-app-clients-and-mandator-admin-client&#39;&gt;mandator admin client&lt;/a&gt;&#39;s access_token. &lt;br/&gt;&lt;br/&gt;&lt;b&gt;NOTE&lt;/b&gt;: finAPI may fail to delete one (or several, or all) of the specified users. A user cannot get deleted when his data is currently locked by an internal process (for instance, update of a bank connection or transactions categorization). The response contains the identifiers of all users that could not get deleted, and all users that could get deleted, separated in two lists. The mandator admin client can retry the request at a later time for the users who could not get deleted.
     * @param body List of user identifiers (required)
     * @return InlineResponse20014
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse20014 deleteUsers(Body10 body) throws ApiException {
        ApiResponse<InlineResponse20014> resp = deleteUsersWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Delete users
     * Delete one or several users, which are specified by a given list of identifiers. Must pass the &lt;a href&#x3D;&#39;https://finapi.zendesk.com/hc/en-us/articles/115003661827-Difference-between-app-clients-and-mandator-admin-client&#39;&gt;mandator admin client&lt;/a&gt;&#39;s access_token. &lt;br/&gt;&lt;br/&gt;&lt;b&gt;NOTE&lt;/b&gt;: finAPI may fail to delete one (or several, or all) of the specified users. A user cannot get deleted when his data is currently locked by an internal process (for instance, update of a bank connection or transactions categorization). The response contains the identifiers of all users that could not get deleted, and all users that could get deleted, separated in two lists. The mandator admin client can retry the request at a later time for the users who could not get deleted.
     * @param body List of user identifiers (required)
     * @return ApiResponse&lt;InlineResponse20014&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse20014> deleteUsersWithHttpInfo(Body10 body) throws ApiException {
        com.squareup.okhttp.Call call = deleteUsersValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse20014>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete users (asynchronously)
     * Delete one or several users, which are specified by a given list of identifiers. Must pass the &lt;a href&#x3D;&#39;https://finapi.zendesk.com/hc/en-us/articles/115003661827-Difference-between-app-clients-and-mandator-admin-client&#39;&gt;mandator admin client&lt;/a&gt;&#39;s access_token. &lt;br/&gt;&lt;br/&gt;&lt;b&gt;NOTE&lt;/b&gt;: finAPI may fail to delete one (or several, or all) of the specified users. A user cannot get deleted when his data is currently locked by an internal process (for instance, update of a bank connection or transactions categorization). The response contains the identifiers of all users that could not get deleted, and all users that could get deleted, separated in two lists. The mandator admin client can retry the request at a later time for the users who could not get deleted.
     * @param body List of user identifiers (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteUsersAsync(Body10 body, final ApiCallback<InlineResponse20014> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteUsersValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse20014>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for getUserList */
    private com.squareup.okhttp.Call getUserListCall(String minRegistrationDate, String maxRegistrationDate, String minDeletionDate, String maxDeletionDate, String minLastActiveDate, String maxLastActiveDate, Boolean isDeleted, Integer page, Integer perPage, List<String> order, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v1/mandatorAdmin/getUserList".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (minRegistrationDate != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "minRegistrationDate", minRegistrationDate));
        if (maxRegistrationDate != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "maxRegistrationDate", maxRegistrationDate));
        if (minDeletionDate != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "minDeletionDate", minDeletionDate));
        if (maxDeletionDate != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "maxDeletionDate", maxDeletionDate));
        if (minLastActiveDate != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "minLastActiveDate", minLastActiveDate));
        if (maxLastActiveDate != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "maxLastActiveDate", maxLastActiveDate));
        if (isDeleted != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "isDeleted", isDeleted));
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page", page));
        if (perPage != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "perPage", perPage));
        if (order != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("multi", "order", order));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "finapi_auth" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getUserListValidateBeforeCall(String minRegistrationDate, String maxRegistrationDate, String minDeletionDate, String maxDeletionDate, String minLastActiveDate, String maxLastActiveDate, Boolean isDeleted, Integer page, Integer perPage, List<String> order, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        
        com.squareup.okhttp.Call call = getUserListCall(minRegistrationDate, maxRegistrationDate, minDeletionDate, maxDeletionDate, minLastActiveDate, maxLastActiveDate, isDeleted, page, perPage, order, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get user list
     * &lt;p&gt;Get a list of the users of the mandator that is authorized by the access_token. Must pass the &lt;a href&#x3D;&#39;https://finapi.zendesk.com/hc/en-us/articles/115003661827-Difference-between-app-clients-and-mandator-admin-client&#39;&gt;mandator admin client&lt;/a&gt;&#39;s access_token. You can set optional search criteria to get only those users that you are interested in. If you do not specify any search criteria, then this service functions as a &#39;get all&#39; service.&lt;/p&gt;&lt;p&gt;Note that the original user id is longer available in finAPI once a user has been deleted. Because of this, the userId of deleted users will be a distorted version of the original userId. For example, if the deleted user&#39;s id was originally &#39;user&#39;, then this service will return &#39;uXXr&#39; as the userId.&lt;/p&gt;
     * @param minRegistrationDate Lower bound for a user&#39;s registration date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;registrationDate&#39; is equal to or later than the given date will be regarded. (optional)
     * @param maxRegistrationDate Upper bound for a user&#39;s registration date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;registrationDate&#39; is equal to or earlier than the given date will be regarded. (optional)
     * @param minDeletionDate Lower bound for a user&#39;s deletion date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;deletionDate&#39; is not null, and is equal to or later than the given date will be regarded. (optional)
     * @param maxDeletionDate Upper bound for a user&#39;s deletion date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;deletionDate&#39; is null, or is equal to or earlier than the given date will be regarded. (optional)
     * @param minLastActiveDate Lower bound for a user&#39;s last active date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;lastActiveDate&#39; is not null, and is equal to or later than the given date will be regarded. (optional)
     * @param maxLastActiveDate Upper bound for a user&#39;s last active date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;lastActiveDate&#39; is null, or is equal to or earlier than the given date will be regarded. (optional)
     * @param isDeleted If NOT specified, then the service will regard both active and deleted users in the search. If set to &#39;true&#39;, then ONLY deleted users will be regarded. If set to &#39;false&#39;, then ONLY active users will be regarded. (optional)
     * @param page Result page that you want to retrieve (optional, default to 1)
     * @param perPage Maximum number of records per page. Can be at most 500. NOTE: Due to its validation and visualization, the swagger frontend might show very low performance, or even crashes, when a service responds with a lot of data. It is recommended to use a HTTP client like Postman or DHC instead of our swagger frontend for service calls with large page sizes. (optional, default to 20)
     * @param order Determines the order of the results. You can order the results by userId. The default order for this service is &#39;userId,asc&#39;. The general format is: &#39;property[,asc|desc]&#39;, with &#39;asc&#39; being the default value.  (optional)
     * @return InlineResponse20015
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse20015 getUserList(String minRegistrationDate, String maxRegistrationDate, String minDeletionDate, String maxDeletionDate, String minLastActiveDate, String maxLastActiveDate, Boolean isDeleted, Integer page, Integer perPage, List<String> order) throws ApiException {
        ApiResponse<InlineResponse20015> resp = getUserListWithHttpInfo(minRegistrationDate, maxRegistrationDate, minDeletionDate, maxDeletionDate, minLastActiveDate, maxLastActiveDate, isDeleted, page, perPage, order);
        return resp.getData();
    }

    /**
     * Get user list
     * &lt;p&gt;Get a list of the users of the mandator that is authorized by the access_token. Must pass the &lt;a href&#x3D;&#39;https://finapi.zendesk.com/hc/en-us/articles/115003661827-Difference-between-app-clients-and-mandator-admin-client&#39;&gt;mandator admin client&lt;/a&gt;&#39;s access_token. You can set optional search criteria to get only those users that you are interested in. If you do not specify any search criteria, then this service functions as a &#39;get all&#39; service.&lt;/p&gt;&lt;p&gt;Note that the original user id is longer available in finAPI once a user has been deleted. Because of this, the userId of deleted users will be a distorted version of the original userId. For example, if the deleted user&#39;s id was originally &#39;user&#39;, then this service will return &#39;uXXr&#39; as the userId.&lt;/p&gt;
     * @param minRegistrationDate Lower bound for a user&#39;s registration date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;registrationDate&#39; is equal to or later than the given date will be regarded. (optional)
     * @param maxRegistrationDate Upper bound for a user&#39;s registration date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;registrationDate&#39; is equal to or earlier than the given date will be regarded. (optional)
     * @param minDeletionDate Lower bound for a user&#39;s deletion date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;deletionDate&#39; is not null, and is equal to or later than the given date will be regarded. (optional)
     * @param maxDeletionDate Upper bound for a user&#39;s deletion date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;deletionDate&#39; is null, or is equal to or earlier than the given date will be regarded. (optional)
     * @param minLastActiveDate Lower bound for a user&#39;s last active date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;lastActiveDate&#39; is not null, and is equal to or later than the given date will be regarded. (optional)
     * @param maxLastActiveDate Upper bound for a user&#39;s last active date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;lastActiveDate&#39; is null, or is equal to or earlier than the given date will be regarded. (optional)
     * @param isDeleted If NOT specified, then the service will regard both active and deleted users in the search. If set to &#39;true&#39;, then ONLY deleted users will be regarded. If set to &#39;false&#39;, then ONLY active users will be regarded. (optional)
     * @param page Result page that you want to retrieve (optional, default to 1)
     * @param perPage Maximum number of records per page. Can be at most 500. NOTE: Due to its validation and visualization, the swagger frontend might show very low performance, or even crashes, when a service responds with a lot of data. It is recommended to use a HTTP client like Postman or DHC instead of our swagger frontend for service calls with large page sizes. (optional, default to 20)
     * @param order Determines the order of the results. You can order the results by userId. The default order for this service is &#39;userId,asc&#39;. The general format is: &#39;property[,asc|desc]&#39;, with &#39;asc&#39; being the default value.  (optional)
     * @return ApiResponse&lt;InlineResponse20015&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse20015> getUserListWithHttpInfo(String minRegistrationDate, String maxRegistrationDate, String minDeletionDate, String maxDeletionDate, String minLastActiveDate, String maxLastActiveDate, Boolean isDeleted, Integer page, Integer perPage, List<String> order) throws ApiException {
        com.squareup.okhttp.Call call = getUserListValidateBeforeCall(minRegistrationDate, maxRegistrationDate, minDeletionDate, maxDeletionDate, minLastActiveDate, maxLastActiveDate, isDeleted, page, perPage, order, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse20015>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get user list (asynchronously)
     * &lt;p&gt;Get a list of the users of the mandator that is authorized by the access_token. Must pass the &lt;a href&#x3D;&#39;https://finapi.zendesk.com/hc/en-us/articles/115003661827-Difference-between-app-clients-and-mandator-admin-client&#39;&gt;mandator admin client&lt;/a&gt;&#39;s access_token. You can set optional search criteria to get only those users that you are interested in. If you do not specify any search criteria, then this service functions as a &#39;get all&#39; service.&lt;/p&gt;&lt;p&gt;Note that the original user id is longer available in finAPI once a user has been deleted. Because of this, the userId of deleted users will be a distorted version of the original userId. For example, if the deleted user&#39;s id was originally &#39;user&#39;, then this service will return &#39;uXXr&#39; as the userId.&lt;/p&gt;
     * @param minRegistrationDate Lower bound for a user&#39;s registration date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;registrationDate&#39; is equal to or later than the given date will be regarded. (optional)
     * @param maxRegistrationDate Upper bound for a user&#39;s registration date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;registrationDate&#39; is equal to or earlier than the given date will be regarded. (optional)
     * @param minDeletionDate Lower bound for a user&#39;s deletion date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;deletionDate&#39; is not null, and is equal to or later than the given date will be regarded. (optional)
     * @param maxDeletionDate Upper bound for a user&#39;s deletion date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;deletionDate&#39; is null, or is equal to or earlier than the given date will be regarded. (optional)
     * @param minLastActiveDate Lower bound for a user&#39;s last active date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;lastActiveDate&#39; is not null, and is equal to or later than the given date will be regarded. (optional)
     * @param maxLastActiveDate Upper bound for a user&#39;s last active date, in the format &#39;YYYY-MM-DD&#39; (e.g. &#39;2016-01-01&#39;). If specified, then only users whose &#39;lastActiveDate&#39; is null, or is equal to or earlier than the given date will be regarded. (optional)
     * @param isDeleted If NOT specified, then the service will regard both active and deleted users in the search. If set to &#39;true&#39;, then ONLY deleted users will be regarded. If set to &#39;false&#39;, then ONLY active users will be regarded. (optional)
     * @param page Result page that you want to retrieve (optional, default to 1)
     * @param perPage Maximum number of records per page. Can be at most 500. NOTE: Due to its validation and visualization, the swagger frontend might show very low performance, or even crashes, when a service responds with a lot of data. It is recommended to use a HTTP client like Postman or DHC instead of our swagger frontend for service calls with large page sizes. (optional, default to 20)
     * @param order Determines the order of the results. You can order the results by userId. The default order for this service is &#39;userId,asc&#39;. The general format is: &#39;property[,asc|desc]&#39;, with &#39;asc&#39; being the default value.  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getUserListAsync(String minRegistrationDate, String maxRegistrationDate, String minDeletionDate, String maxDeletionDate, String minLastActiveDate, String maxLastActiveDate, Boolean isDeleted, Integer page, Integer perPage, List<String> order, final ApiCallback<InlineResponse20015> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getUserListValidateBeforeCall(minRegistrationDate, maxRegistrationDate, minDeletionDate, maxDeletionDate, minLastActiveDate, maxLastActiveDate, isDeleted, page, perPage, order, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse20015>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
