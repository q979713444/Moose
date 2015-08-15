package moose.com.ac.retrofit;


import com.squareup.okhttp.Response;

import moose.com.ac.retrofit.article.ArticleBody;
import moose.com.ac.retrofit.article.ArticleList;
import moose.com.ac.retrofit.search.SearchBody;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Farble on 2015/8/14 22.
 * ac request
 */
public interface Api {
    /*http://api.acfun.tv/apiserver/content/channel?orderBy=0&channelId=110&pageSize=20&pageNo=1*/
    @GET("/apiserver/content/channel")
    Observable<ArticleList> getArticleList(@Query("orderBy") int orderBy, @Query("channelId") int channelId
            , @Query("pageNo") int pageNo, @Query("pageSize") int pageSize);

    @GET("/comment_list_json.aspx")
    Observable<Response> getCommentList(@Query("contentId") int contentId, @Query("currentPage") int currentPage);

    @GET("/apiserver/content/article")
    Observable<ArticleBody> getArticleBody(@Query("contentId") int contentId);

    @GET("/search?type=2&field=title&sortField=releaseDate&parentChannelId=63")
    Observable<SearchBody> getSearch(@Query("q") String q, @Query("pageNo") int pageNo, @Query("pageSize") int pageSize);

    @GET("/apiserver/content/rank")/*?channelIds=110,73,74,75*/
    Observable<ArticleList> getSortList(@Query("channelIds")String channelIds,@Query("pageSize") int pageSize);
}
