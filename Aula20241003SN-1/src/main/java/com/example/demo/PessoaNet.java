package com.example.demo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PessoaNet {
    
    @GET("pessoa/{codigo}")
    Call<Pessoa> obter(@Path(value = "codigo") Integer codigo);
    
    @GET("login/{nome}/{senha}")
    Call<Pessoa> login(@Path(value = "nome") String nome, @Path(value = "senha") String senha);
    
    @GET("pessoa")
    Call<List<Pessoa>> obterTodos();
    
    @POST("pessoa")
    Call<Void> incluir(@Body Pessoa p);
    
}
