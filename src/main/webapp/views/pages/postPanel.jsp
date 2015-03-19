<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/11/15
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="panel panel-info" style="clear: both">

    <div class="panel-heading">
        Posted by <a href="/FacebookWebServlet/profile?userId=${post.user.id}">${post.user.username}</a>
        at ${post.dateTime}
        <c:if test="${post.user.id == user.id}">

            <a onclick="return confirmAction()" href="/FacebookWebServlet/removePost?postId=${post.id}"><span
                    class="glyphicon glyphicon-trash pull-right"></span></a>
        </c:if>
    </div>
    <div class="panel-body">
        <p><c:out value="${post.content}"/></p>
    </div>

</div>


