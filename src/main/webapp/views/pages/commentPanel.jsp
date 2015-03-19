<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/11/15
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>

<div class="panel panel-info col-md-offset-1" style="clear: both">

    <div class="panel-body">

        Commented by <a href="/FacebookWebServlet/profile?userId=${comment.user.id}">${comment.user.username}</a>
        on ${comment.dateTime}
        <c:if test="${comment.user.id == user.id}">

            <a onclick="return confirmAction()" href="/FacebookWebServlet/removeComment?commentId=${comment.id}"><span
                    class="glyphicon glyphicon-trash pull-right"></span></a>
        </c:if>
        <p><c:out value="${comment.content}"/></p>
    </div>

</div>


