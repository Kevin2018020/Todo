/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpConnections;

import httpConnections.Usuario;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
/**
 *
 * @author Axel
 */
public interface IhttpRequests {
    @GET("usuarios/guardarUsuario/{Usename}/{Password}/{role}/{Activo}/{Idempleado}")
    Call<String> guardarUsuario(@Path("username") String username,
                            @Path("password") String password,
                            @Path("role") String role,
                            @Path("Activo") String Activo,
                            @Path("Idempleado") String Idempleado);
    
     @GET("usuarios/guardarUsuario/{Usename}/{Password}/{role}/{Activo}/{Idempleado}")
    Call<String> loginUser(@Path("username") String username,
                            @Path("password") String password,
                            @Path("role") String role,
                            @Path("Activo") String Activo,
                            @Path("Idempleado") String Idempleado);;


}
