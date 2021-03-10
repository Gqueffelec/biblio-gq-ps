<%@ page language="java" contentType="text/html;
charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<c:url value="/" var="accueil"></c:url>
		<a class="navbar-brand" href="${accueil }">Bibliothèque</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<c:if test="${sessionScope.admin }">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navBarDropdownLivre"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gestion
							des Livres </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<button class="btn btn-outline-success ml-5 my-2 my-sm-0"
								type="button" data-toggle="modal" data-target="#newLivre"
								id="newLivreButton">Ajouter un livre</button>
							<button class="btn btn-outline-success ml-5 my-2 my-sm-0"
								type="button" data-toggle="modal" data-target="#updateLivre"
								id="updateLivreButton">Modifier un livre</button>
							<button class="btn btn-outline-success ml-5 my-2 my-sm-0"
								type="button" data-toggle="modal" data-target="#removeLivre"
								id="removeLivreButton">Supprimer un livre</button>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navBarDropdownCategorie" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">Gestion des
							Catégories </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<button class="btn btn-outline-success ml-5 my-2 my-sm-0"
								type="button" data-toggle="modal" data-target="#newCategorie"
								id="newCategorieButton">Ajouter une catégorie</button>
							<button class="btn btn-outline-success ml-5 my-2 my-sm-0"
								type="button" data-toggle="modal" data-target="#updateCategorie"
								id="updateCategorieButton">Modifier une catégorie</button>
							<button class="btn btn-outline-success ml-5 my-2 my-sm-0"
								type="button" data-toggle="modal" data-target="#removeCategorie"
								id="removeCategorieButton">Supprimer une catégorie</button>
						</div></li>
				</c:if>
			</ul>
		</div>
		<div class="flex-lg-column">
			<ul class="navbar-nav">
				<c:choose>
					<c:when test="${sessionScope.connect }">
						<c:url value="signOut" var="signOut">
						</c:url>
						<li class="nav-item"><a class="nav-link disabled"
							href="${signOut }">Deconnexion</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><c:url value="signIn" var="signIn">
							</c:url> <a class="nav-link disabled" href="${signIn }">Inscription</a></li>
						<li class="nav-item"><c:url value="login" var="login">
							</c:url> <a class="nav-link" href="${login }">Login</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>
	<c:if test="${sessionScope.connect }">
		<div>Je suis connecté</div>
		<c:if test="${sessionScope.admin }">
			<div>je suis un admin</div>
		</c:if>
	</c:if>
	<div class="modal fade" id="newCategorie" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Nouvelle
						Catégorie</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div id="createCategorieData">
						<label for="nom">Nom</label> <input type="text" name="nom"
							class="nom"><br> <label for="label">Label</label> <input
							type="text" name="label" class="label"><br> <label
							for="info">Information Technique</label> <input type="text"
							name="info" class="info"><br>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fermer</button>
					<button type="button" class="btn btn-primary" id="createCategorie">Ajouter</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="updateCategorie" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modifier une
						Catégorie</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div id="updateSelectId">
						<label for="id">Name</label> <select class="categorieId"></select>
						<button type="button" class="btn btn-primary" id="selectIdUpdate">Select</button>
					</div>
					<div class="categorieData" id="updateCategorieData">
						<label for="nom">Nom</label> <input type="text" name="nom"
							class="nom"><br> <label for="label">Label</label> <input
							type="text" name="label" class="label"><br> <label
							for="info">Information Technique</label> <input type="text"
							name="info" class="info"><br>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fermer</button>
					<button type="button" class="btn btn-primary" id="MAJCategorie">Mettre
						à jour</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="removeCategorie" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Supprimer une
						Catégorie</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div>
						<label for="id">Name</label> <select class="categorieId"></select>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fermer</button>
					<button type="button" class="btn btn-primary" id="deleteCategorie">Supprimer</button>
				</div>
			</div>
		</div>
	</div>
	<!-- ajout livre -->
	<div class="modal fade" id="newLivre" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Nouveau Livre</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="addLivre" method="post">
						<div id="createLivreData">
							<div>
								<label for="categorie">Categorie : </label> <select
									name="categorie">
									<c:forEach items="${listeCategorie }" var="categorie">
										<option value="${categorie.id}">${categorie.nom}</option>
									</c:forEach>
								</select> <br>
							</div>
							<table class="table">
								<tr>
									<td><label for="nom">Titre : </label></td>
									<td><input type="text" name="titre" class="titre">
									</td>
								</tr>
								<tr>
									<td><label for="dateEdition">Date d'édition : </label></td>
									<td><input type="date" name="dateEdition"
										class="dateEdition"></td>
								</tr>
								<tr>
									<td><label for="prix">Prix : </label></td>
									<td><input type="number" step="0.01" name="prix">
									</td>
								</tr>
								<tr>
									<td><label for="label">Label : </label></td>
									<td><input type="text" name="label" class="label">
									</td>
								</tr>
								<tr>
									<td><label for="stock">Stock : </label></td>
									<td><input type="number" name="stock"></td>
								</tr>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Fermer</button>
							<button type="submit" class="btn btn-primary"
								id="createCategorie">Ajouter</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- modif livre -->
	<div class="modal fade" id="updateLivre" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modifier un
						livre</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="updateLivre" method="post">
						<div id="updateLivreData">
							<div>
								<select name="livre">
									<c:forEach items="${listeLivre }" var="livre">
										<option value="${livre.id}">${livre.titre}</option>
									</c:forEach>
								</select>
							</div>
							<br>
							<table class="table">
								<tr>
									<td><label for="prix">Prix : </label></td>
									<td><input type="number" step="0.01" name="prix">
									</td>
								</tr>
								<tr>
									<td><label for="stock">Stock : </label></td>
									<td><input type="number" name="stock"></td>
								</tr>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Fermer</button>
							<button type="submit" class="btn btn-primary" id="MAJCategorie">Mettre
								à jour</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 	remove livre -->
	<div class="modal fade" id="removeLivre" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Supprimer un
						Livre</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="removeLivre" method="post">
						<div id="removeLivreData">
							<div>
								<select name="livre">
									<c:forEach items="${listeLivre }" var="livre">
										<option value="${livre.id}">${livre.titre}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Fermer</button>
							<button type="submit" class="btn btn-primary"
								id="deleteCategorie">Supprimer</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>