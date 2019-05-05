<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- meta tag -->
        <meta charset="utf-8">

        <!-- style sheets -->
        <link rel="stylesheet" type="text/css" href="css/styles.css">

        <!-- tab details -->
        <link rel="icon" type="image/png" href="img/cinema.png">
        <title>Theater</title>
        <style>

        body
        {
         background-color: black;
         color: white;
        }

        .register
        {
          text-align: center;
          padding-top: 30px;
        }

        .form
        {
          border-style: solid;
          border-width: 3px;
          border-color: white;
          border-radius: 10px;
          padding-top: 10px;
          padding-bottom: 20px;
          width: 40%;
          margin: auto;
          margin-top: 30px;
        }

        button
        {
          background-color: black;
          font-size: 20px;
          border: 1px solid white;
          border-radius: 10px;
          width: 30%;
          color: white;
          margin-bottom: 10px;
        }

        button:hover
        {
          background-color: white;
          color: black;
        }

        .i
        {
          width: 60%;
          margin-bottom: 10px;
          text-align: center;
          font-size: 16px;
          border: 1px solid white;
          border-radius: 10px;
          color: black;
          padding-left: 2px;
        }

        a
        {
          font-size: 12px;
          color: white;
        }

        .p
        {
            text-align: center;
            margin: auto;
        }

        </style>
    </head>
    <body>
        <jsp:useBean id = "userBean" class = "User" scope ="request"></jsp:useBean>
        <jsp:setProperty name = "userBean" property = "firstName" />
        <jsp:setProperty name = "userBean" property = "lastName" />
        <jsp:setProperty name = "userBean" property = "email" />
        <jsp:setProperty name = "userBean" property = "promos" />
        <jsp:setProperty name = "userBean" property = "password" />
        <jsp:setProperty name = "userBean" property = "passConfirm" />
        
        <div class="nav-placeholder">
          <ul class="nav">
              <div class="logo">
                  <a href="index.html">Theater</a>
              </div>
              <li>
                  <form action="/action_page.php">
                      <input type="text" placeholder="Search.." name="search">
                  </form>
              </li>
              <li><a href="#Booking">Book Tickets</a></li>
              <li>
                  <a href="#Cart">
                      <img class="navPic" alt="profile" src="img/cart.png">
                  </a>
              </li>
              <li>
                  <a href="#profile">
                      <img class="navPic" alt="profile" src="img/user.png">
                  </a>
              </li>
          </ul>
          <br>
          <br>

        </div>

        <div class="register">
            <form class="form" action="accountConfirmation.html" method="GET">
                <h1>Register</h1>
                <input class ="i" type="text" placeholder="First Name" name="firstName"><br>
                <input class ="i" type="text" placeholder="Last Name" name="lastName"><br>
                <input class ="i" type="text" placeholder="Email" name="email"><br>
                <input class ="i" type="text" placeholder="Password" name="password"><br>
                <input class ="i" type="text" placeholder="Confirm Password" name="passConfirm"><br><br>
                <p class = "p">Receive Promo Codes <input type="checkbox" name = "promos"></p><br>
                <button type="submit">Register</button><br>
            </form>

        </div>
    </body>
</html>
