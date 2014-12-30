package io.github.willis7.blogger

import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.ContentType.XML
import groovyx.net.http.RESTClient

/**
 * Created by willis7 on 30/12/14.
 */
class Blogger {
    static final KEY = '...'
    static final URL = "https://www.googleapis.com"
    static final API_NAME = 'blogger'
    static final API_VERSION = 'v3'
    static final BASE_PATH = "/${API_NAME}/${API_VERSION}"

    def printBlogPosts(blogId) {
        def bloggerClient = new RESTClient(URL)
        def path = "/blogs/${blogId}/posts"
        def response = bloggerClient.get(
                            path: "${BASE_PATH}${path}",
                            query: [key: KEY]
                        )

        assert response.status == 200
        assert response.contentType == JSON.toString()
    }
}
