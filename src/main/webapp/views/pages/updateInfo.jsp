<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/10/15
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>

<div class="container">

    <div class="row">


        <div class="col-md-6 col-md-offset-3">

            <c:if test="${!empty param.success}">
                <div class="alert alert-success" role="alert">INFO UPDATED SUCCESSFULLY.</div>
            </c:if>

            <c:if test="${!empty param.error}">
                <c:if test="${param.error eq 1}">
                    <div class="alert alert-danger" role="alert">INFO UPDATE FAILED.</div>
                </c:if>
            </c:if>

            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title text-center">Update Info</h3>
                </div>
                <div class="panel-body">

                    <form name="updateInfo" action="" method="POST">

                        <label>Username </label> <br>
                        <input type="text" name="username" class="form-control" placeholder="Username"
                               value="${user.username}" required/> <br>
                        <label>First Name </label> <br>
                        <input type="text" name="firstname" class="form-control" placeholder="Firstname"
                               value="${user.firstName}" required/> <br>
                        <label>Last Name </label> <br>
                        <input type="text" name="lastname" class="form-control" placeholder="Lastname"
                               value="${user.lastName}" required/><br>
                        <label>Date Of Birth </label> <br>
                        <input type="text" class="form-control" name="dob" placeholder="Date Of Birth"
                               onfocus="this.type='date'"
                               onblur="this.type='text'" value="${user.DOB}" required/><br>
                        <label>Email </label> <br>
                        <input type="email" name="email" class="form-control" placeholder="Email" value="${user.email}"
                               required/><br>
                        <label>Password </label> <br>
                        <input type="password" name="password" class="form-control" placeholder="Password"
                               value="${user.password}"
                               required/><br>
                        <input type="submit" class="btn btn-default form-control" name="updateInfoSubmit"
                               value="update"/><br><br>

                    </form>

                </div>
            </div>


        </div>

    </div>


    <%@include file="footer.jsp" %>
