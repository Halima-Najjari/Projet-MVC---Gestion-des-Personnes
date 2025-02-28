<%@ page import="java.util.List , models.Personne,models.Metier.PeronneMetier"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="style.css">

	<head>
	<style>
        /* Styles généraux */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            padding: 20px;
        }

        h1 {
            color: #333;
        }

        /* Formulaire */
        form {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            display: inline-block;
            text-align: left;
        }

        label {
            font-weight: bold;
        }

        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }

        /* Tableau */
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background: white;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        /* Bouton Supprimer */
        a {
            text-decoration: none;
            background-color: #dc3545;
            color: white;
            padding: 6px 10px;
            border-radius: 5px;
        }

        a:hover {
            background-color: #c82333;
        }
    </style>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
<body>


	<h1>Personne</h1>
	<form method="post" action="PersonneControler">
		<label for="nom">Nom:</label> 
		<input id="nom" type="text" name="nom" /><br>
		<label for="prenom">Prenom:</label> 
		<input id="prenom" type="text" name="prenom" /><br>
		<label for="age">Age:</label> 
		<input id="age" type="number" name="age"/><br>
		<input type="submit" value="envoyer">
	</form>

	<div>
		<table border="1">
			<thead>
			<tr>
				<th>id</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Age</th>
				<th>Action</th>
			</tr>
			</thead>
			<tbody>
						<%
List<Personne> list = (List<Personne>) request.getAttribute("ListPersonnes");
if (list != null) {
    for (Personne p : list) {
%>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getNom() %></td>
            <td><%= p.getPrenom() %></td>
            <td><%= p.getAge() %></td>
             <td><a href="PersonneControler?id=<%= p.getId() %>">supprimer</a></td>
        </tr>
<%
    }
} else {
%>
    <tr>
        <td colspan="4">Aucune personne trouvée.</td>
    </tr>
<%
}
%>

			</tbody>
			
		</table>
	</div>
</body>
</html>