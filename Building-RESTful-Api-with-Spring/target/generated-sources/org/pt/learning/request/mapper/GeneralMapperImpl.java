package org.pt.learning.request.mapper;

import javax.annotation.Generated;
import org.pt.learning.entity.Blog;
import org.pt.learning.rest.request.BlogRequest;
import org.pt.learning.rest.request.BlogUpdateRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2016-04-03T16:51:03+0530",
    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_66 (Oracle Corporation)"
)
public class GeneralMapperImpl implements GeneralMapper {

    @Override
    public Blog requestToEntity(BlogRequest blogRequest) {
        if ( blogRequest == null ) {
            return null;
        }

        Blog blog = new Blog();

        blog.setTitle( blogRequest.getTitle() );
        blog.setStatus( blogRequest.getStatus() );
        blog.setAuthor( blogRequest.getAuthor() );
        blog.setEmail( blogRequest.getEmail() );

        return blog;
    }

    @Override
    public void updateBlogUpdateResponseToBlogEntity(BlogUpdateRequest updateRequest, Blog blog) {
        if ( updateRequest == null ) {
            return;
        }

        blog.setId( updateRequest.getId() );
        blog.setTitle( updateRequest.getTitle() );
        blog.setStatus( updateRequest.getStatus() );
        blog.setAuthor( updateRequest.getAuthor() );
        blog.setEmail( updateRequest.getEmail() );
    }
}
