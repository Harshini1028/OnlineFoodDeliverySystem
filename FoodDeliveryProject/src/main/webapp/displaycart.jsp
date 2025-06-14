<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE HTML>
<html lang="eng">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>online food delivery</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            min-height: 100vh;
            padding-top: 150px;
            transition: background-image 0.5s ease;
        }

        .welcome-bar {
            position: fixed;
            top: 0;
            width: 100%;
            text-align: center;
            padding: 15px 0;
            font-size: 24px;
            font-weight: bold;
            color: #db469b;
            z-index: 1000;
        }
        .welcome-bar:hover{
            text-decoration: none;
            color: #8f2873;
        }

        nav {
            position: fixed;
            top: 55px;
            width: 100%;
            display: flex;
            justify-content: center;
            gap: 30px;
            padding: 15px 0;
            z-index: 999;
            background-color: transparent;
        }

        nav a {
            color: #db469b;
            text-decoration: none;
            font-weight: bold;
            font-size: 18px;
            cursor: pointer;
        }

        nav a:hover {
            text-decoration: underline;
            color: #8f2873;
        }
        .container,
        .section-content,
        .home-content {
            max-width: 600px;
            margin: 30px auto;
            background: #e8b7d3;
            padding: 30px;
            border-radius: 25px;
            border: 2px solid #444;
            display: none;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
        }
        .home-content:hover{
            text-decoration: none;
            color: black;
        }


        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-top: 12px;
            font-weight: bold;
        }

        input,
        select,
        textarea {
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #aaa;
            border-radius: 5px;
        }

        .gender {
            display: flex;
            justify-content: space-around;
            margin-top: 5px;
        }

        .gender label {
            font-weight: normal;
        }

        button {
            margin-top: 20px;
            padding: 12px;
            background-color: lightpink;
            color: white;
            border: none;
            border-radius: 25px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #db469b;
        }

        .home-content {
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            color: darkslategray;
        }
       
    </style>
</head>

<body>
    <div class="welcome-bar" >
        <h2>WELCOME TO KAVA CAFE </h2>
    </div>

    <nav>
        <a href="viewcustomer.jsp">MyProfile</a>
        <a href="customermenu">ViewMenu</a>
        <a href="displaycart.jsp">My Eatlist</a>
        <a href="logout">Logout</a>
    </nav>
	
    <div id="home" class="container">
    <center><h2>Your Cart</h2></center>

    <c:set var="list" value="${sessionScope.cart}" />

    <c:choose>
        <c:when test="${not empty list}">
        <center>
            <table border="1">
            <%! int sum=0; %>
            
                <tr>
                    <th>SNo</th>
                    <th>Item Name</th>
                    <th>Price</th>
                    <th>Delete</th>
                </tr>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <td>${item.sno}</td>
                        <td>${item.itemName}</td>
                        <td>${item.price}</td>
                        <td><a href='deletebyid?sno=${item.sno}'>delete</a></td>
                    </tr>
                </c:forEach>
            </table>
            </center>
            <div>
	            <c:set var="total" value="0" />
		        <c:forEach var="item" items="${sessionScope.cart}">
		        <c:set var="total" value="${total + item.price}" />
	 </c:forEach>

     </div>
            
            <center><p><strong>Total Price:</strong> ₹${total}</p></center>
        </c:when>
        <c:otherwise>
            <p>Your cart is empty.</p>
        </c:otherwise>
    </c:choose>
	<form action="payment.jsp" method="get">
	    <button>Confirm Order</button>
	</form>
    </div>
    
    <div id="registration" class="container">
    	
    </div>
    <div id="login" class="container">
        
    </div>

    <div id="admin" class="section-content">
        
    </div>

    <div id="about" class="section-content">
        
    </div>

    <div id="contact" class="section-content">
        
    </div>

    <script>
        function showSection(sectionId) {
            const sections = ['home', 'registration', 'login', 'admin', 'about', 'contact'];
            const backgrounds = {
            		home: 'url(https://png.pngtree.com/thumb_back/fh260/back_our/20190621/ourmid/pngtree-light-fresh-and-fresh-literary-food-banner-background-image_184091.jpg)',
                    registration: 'url(https://png.pngtree.com/thumb_back/fh260/back_our/20190621/ourmid/pngtree-light-fresh-and-fresh-literary-food-banner-background-image_184091.jpg)',
                    login: 'url(https://png.pngtree.com/thumb_back/fh260/back_our/20190621/ourmid/pngtree-light-fresh-and-fresh-literary-food-banner-background-image_184091.jpg)',
                    admin: 'url(https://png.pngtree.com/thumb_back/fh260/back_our/20190621/ourmid/pngtree-light-fresh-and-fresh-literary-food-banner-background-image_184091.jpg)',
                    about: 'url(https://png.pngtree.com/thumb_back/fh260/back_our/20190621/ourmid/pngtree-light-fresh-and-fresh-literary-food-banner-background-image_184091.jpg)',
                    contact: 'url(https://png.pngtree.com/thumb_back/fh260/back_our/20190621/ourmid/pngtree-light-fresh-and-fresh-literary-food-banner-background-image_184091.jpg)',
            };

            sections.forEach(id => {
                document.getElementById(id).style.display = (id === sectionId) ? 'block' : 'none';
            });

            document.body.style.backgroundImage = backgrounds[sectionId] || '';
        }

        
        showSection('home');
    </script>

</body>

</html>
