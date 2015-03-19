<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/12/15
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="panel panel-info " style="clear: both">

    <div class="panel-heading">
        <h3>Add Friends</h3>
    </div>

    <div class="panel-body">

            <c:forEach items="${usersNotFriends}" var="user">

                <div class="friend-panel">
                    <div class="picture-div">
                        <img src="views/resources/uploads/photoes/${user.profilePicture}" width="150px" height="150px">
                    </div>

                    <div class="info-div">
                        <p>Username: ${user.username} <p>
                        <p>FullName: ${user.firstName} ${user.lastName} <p>
                        <p>Date Of Birth: ${user.DOB} <p>
                        <form action="addFriend" method="post">
                            <input type="hidden" name="userId" value="${user.id}"/>
                            <input class="btn btn-default" type="submit" name="addFriendSubmit" value="ADD FRIEND"/>
                        </form>
                    </div>
                </div>

            </c:forEach>


    </div>

</div>