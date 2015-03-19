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
                <div class="alert alert-success" role="alert">ACCOUNT SIGNUP SUCCESSFULL.</div>
            </c:if>

            <c:if test="${!empty param.error}">
                <c:if test="${param.error eq 1}">
                    <div class="alert alert-danger" role="alert">ACCOUNT SIGNUP FAILED.</div>
                </c:if>
            </c:if>

            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title text-center">Signup</h3>
                </div>
                <div class="panel-body">

                    <form name="signup" action="" method="POST" enctype="multipart/form-data">

                        <input type="text" name="username" class="form-control" placeholder="Username" required/> <br>
                        <input type="text" name="firstname" class="form-control" placeholder="Firstname" required/> <br>
                        <input type="text" name="lastname" class="form-control" placeholder="Lastname" required/><br>
                        <input type="text" class="form-control" name="dob" placeholder="Date Of Birth"
                               onfocus="this.type='date'"
                               onblur="this.type='text'" required/><br>
                        <input type="email" name="email" class="form-control" placeholder="Email" required/><br>
                        <input type="password" name="password" class="form-control" placeholder="Password"
                               required/><br>
                        <input type="file" name="profilePicture" /><br>
                        <input type="submit" class="btn btn-default form-control" name="register"
                               value="Signup"/><br><br>
                        <a href="login" class="btn btn-default form-control">Login</a><br><br>

                    </form>

                </div>
            </div>


        </div>

    </div>


    <%@include file="footer.jsp" %>
