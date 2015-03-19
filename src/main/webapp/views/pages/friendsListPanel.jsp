<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/12/15
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="panel panel-info " style="clear: both">

    <div class="panel-heading">
        <h3>List Of Friends</h3>
    </div>

    <div class="panel-body">

            <c:forEach items="${friends}" var="friend">

                <div class="friend-panel">
                    <div class="picture-div" >
                        <img src="views/resources/uploads/photoes/${friend.profilePicture}" width="150px" height="150px">
                    </div>

                    <div class="info-div">
                        <p>Username: ${friend.username} <p>
                        <p>FullName: ${friend.firstName} ${friend.lastName} <p>
                        <p>Date Of Birth: ${friend.DOB} <p>
                        <form action="removeFriend" method="post">
                            <input type="hidden" name="userId" value="${friend.id}"/>
                            <input class="btn btn-default" type="submit" name="removeFriendSubmit" value="REMOVE FRIEND"/>
                        </form>
                    </div>

                </div>

            </c:forEach>

        <a href="/FacebookWebServlet/addFriend" class="btn btn-default">add New Friend</a>

    </div>

</div>