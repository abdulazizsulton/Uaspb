package com.example.uaspb.api;

import com.example.uaspb.response.Comment;
import com.example.uaspb.response.Pet;
import com.example.uaspb.response.User;
import com.example.uaspb.response.login.Login;
import com.example.uaspb.response.login.LoginData;
import com.example.uaspb.response.register.Like;
import com.example.uaspb.response.register.Register;
import com.example.uaspb.response.selectPost.Post;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @FormUrlEncoded
    @POST("login.php")
    Call<Login> login(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("register.php") // Endpoint untuk registrasi
    Call<Register> register(
            @Field("username") String username,
            @Field("name") String name,
            @Field("password") String password
    );

    @GET("users.php")
    Call<List<User>> getUsers();

    @FormUrlEncoded
    @POST("users.php")
    Call<Void> createUser(
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("full_name") String fullName
    );

    @PUT("users.php")
    Call<Void> updateUser(@Body User user);

    @DELETE("users.php")
    Call<Void> deleteUser(@Query("user_id") int userId);

    @GET("pets.php")
    Call<List<Pet>> getPets();

    @FormUrlEncoded
    @POST("pets.php")
    Call<Void> createPet(
            @Field("user_id") int userId,
            @Field("name") String name,
            @Field("species") String species,
            @Field("breed") String breed,
            @Field("age") int age,
            @Field("profile_picture") String profilePicture
    );

    @PUT("pets.php")
    Call<Void> updatePet(@Body Pet pet);

    @DELETE("pets.php")
    Call<Void> deletePet(@Query("pet_id") int petId);

    @GET("posts.php")
    Call<List<Post>> getPosts();

    @FormUrlEncoded
    @POST("posts.php")
    Call<Void> createPost(
            @Field("user_id") int userId,
            @Field("pet_id") int petId,
            @Field("content") String content,
            @Field("image") String image
    );

    @PUT("posts.php")
    Call<Void> updatePost(@Body Post post);

    @DELETE("posts.php")
    Call<Void> deletePost(@Query("post_id") int postId);

    @GET("comments.php")
    Call<List<Comment>> getComments();

    @FormUrlEncoded
    @POST("comments.php")
    Call<Void> createComment(
            @Field("post_id") int postId,
            @Field("user_id") int userId,
            @Field("content") String content
    );

    @PUT("comments.php")
    Call<Void> updateComment(@Body Comment comment);

    @DELETE("comments.php")
    Call<Void> deleteComment(@Query("comment_id") int commentId);

    @GET("likes.php")
    Call<List<Like>> getLikes();

    @FormUrlEncoded
    @POST("likes.php")
    Call<Void> createLike(
            @Field("post_id") int postId,
            @Field("user_id") int userId
    );

    @DELETE("likes.php")
    Call<Void> deleteLike(@Query("like_id") int likeId);

    @GET("selectPost.php")
    Call<Post> getPostData();

}
